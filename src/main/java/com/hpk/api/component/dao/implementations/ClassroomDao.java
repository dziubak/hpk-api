package com.hpk.api.component.dao.implementations;

import com.hpk.api.component.dao.interfaces.IClassroom;
import com.hpk.api.component.entities.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ClassroomDao implements IClassroom {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static String SQL_CREATE_CLASSROOM = "INSERT INTO classroom (number, description) VALUES (:number, :description)";
    private final static String SQL_GET_CLASSROOM = "SELECT id, number, description, status FROM classroom WHERE id=:id";
    private final static String SQL_GET_ALL_CLASSROOMS = "SELECT id, number, description, status FROM classroom";
    private final static String SQL_DELETE_CLASSROOM = "DELETE FROM classroom WHERE id=:id";


    private RowMapper<Classroom> classroomRowMapper() {
        return (resultSet, i) -> {
            Classroom classroom = new Classroom();
            classroom.setId(resultSet.getInt("id"));
            classroom.setNumber(resultSet.getString("number"));
            classroom.setDescription(resultSet.getString("description"));
            classroom.setStatus(resultSet.getBoolean("status"));
            return classroom;
        };
    }

    public boolean create(Classroom classroom){
        HashMap<String, String> params = new HashMap<>();
        params.put("number", classroom.getNumber());
        params.put("description", classroom.getDescription());
        return namedParameterJdbcTemplate.update(SQL_CREATE_CLASSROOM, params) > 0;
    }

    public Classroom getById(int id){
        Map<String, Integer> params = Collections.singletonMap("id", id);
        return namedParameterJdbcTemplate.queryForObject(SQL_GET_CLASSROOM, params, classroomRowMapper());
    }

    public List<Classroom> getAll(){
        return namedParameterJdbcTemplate.query(SQL_GET_ALL_CLASSROOMS, classroomRowMapper());
    }

    public boolean updateById(Classroom classroom){
        String SQL_UPDATE_CLASSROOM = "UPDATE classroom SET";
        StringBuilder fieldsStr = new StringBuilder(" ");
        if(classroom.getDescription()!=null && !classroom.getDescription().isEmpty()){
            fieldsStr.append("number = " + classroom.getNumber()).append(",");
        }
        if(classroom.getDescription()!=null && !classroom.getDescription().isEmpty()){
            fieldsStr.append("description = " + classroom.getDescription()).append(",");
        }
        fieldsStr.append("status = " + classroom.isStatus()).append(",");
        SQL_UPDATE_CLASSROOM = SQL_UPDATE_CLASSROOM + fieldsStr.toString().replaceAll(",$", " ") + "WHERE id = :id";
        Map<String, Integer> params = Collections.singletonMap("id",  classroom.getId());
        return namedParameterJdbcTemplate.update(SQL_UPDATE_CLASSROOM, params)>0;
    }

    public boolean deleteById(int id){
        Map<String, Integer> params = Collections.singletonMap("id", id);
        return namedParameterJdbcTemplate.update(SQL_DELETE_CLASSROOM, params)>0;
    }

}
