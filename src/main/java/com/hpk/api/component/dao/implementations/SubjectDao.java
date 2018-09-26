package com.hpk.api.component.dao.implementations;

import com.hpk.api.component.dao.interfaces.ISubject;
import com.hpk.api.component.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SubjectDao implements ISubject {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static String SQL_CREATE_SUBJECT = "INSERT INTO subject (teacher_id, name, abbreviation, description) VALUES (:teacher_id, :name, :abbreviation, :description)";
    private final static String SQL_GET_SUBJECT = "SELECT id, teacher_id, name, abbreviation, description, status FROM subject WHERE id=:id";
    private final static String SQL_GET_ALL_SUBJECTS = "SELECT id, teacher_id, name, abbreviation, description, status FROM subject";
    private final static String SQL_DELETE_SUBJECT = "DELETE FROM subject WHERE id=:id";


    private RowMapper<Subject> subjectRowMapper() {
        return (resultSet, i) -> {
            Subject subject = new Subject();
            subject.setId(resultSet.getInt("id"));
            subject.setTeacherId(resultSet.getInt("teacher_id"));
            subject.setName(resultSet.getString("name"));
            subject.setAbbreviation(resultSet.getString("abbreviation"));
            subject.setDescription(resultSet.getString("description"));
            subject.setStatus(resultSet.getBoolean("status"));
            return subject;
        };
    }

    public boolean create(Subject subject){
        HashMap<String, String> params = new HashMap<>();
        params.put("teacher_id", String.valueOf(subject.getTeacherId()));
        params.put("name", subject.getName());
        params.put("abbreviation", subject.getAbbreviation());
        params.put("description", subject.getDescription());
        return namedParameterJdbcTemplate.update(SQL_CREATE_SUBJECT, params) > 0;
    }

    public Subject getById(int id){
        Map<String, Integer> params = Collections.singletonMap("id", id);
        return namedParameterJdbcTemplate.queryForObject(SQL_GET_SUBJECT, params, subjectRowMapper());
    }

    public List<Subject> getAll(){
        return namedParameterJdbcTemplate.query(SQL_GET_ALL_SUBJECTS, subjectRowMapper());
    }

    public boolean updateById(Subject subject){
        String SQL_UPDATE_CLASSROOM = "UPDATE subject SET";
        StringBuilder fieldsStr = new StringBuilder(" ");
        if(subject.getTeacherId()!=0){
            fieldsStr.append("teacher_id = " + subject.getTeacherId()).append(",");
        }
        if(subject.getName()!=null && !subject.getName().isEmpty()){
            fieldsStr.append("name = " + subject.getName()).append(",");
        }
        if(subject.getAbbreviation()!=null && !subject.getAbbreviation().isEmpty()){
            fieldsStr.append("abbreviation = " + subject.getAbbreviation()).append(",");
        }
        if(subject.getDescription()!=null && !subject.getDescription().isEmpty()){
            fieldsStr.append("description = " + subject.getDescription()).append(",");
        }
        fieldsStr.append("status = " + subject.isStatus()).append(",");
        SQL_UPDATE_CLASSROOM = SQL_UPDATE_CLASSROOM + fieldsStr.toString().replaceAll(",$", " ") + "WHERE id = :id";
        Map<String, Integer> params = Collections.singletonMap("id",  subject.getId());
        return namedParameterJdbcTemplate.update(SQL_UPDATE_CLASSROOM, params)>0;
    }

    public boolean deleteById(int id){
        Map<String, Integer> params = Collections.singletonMap("id", id);
        return namedParameterJdbcTemplate.update(SQL_DELETE_SUBJECT, params)>0;
    }

}
