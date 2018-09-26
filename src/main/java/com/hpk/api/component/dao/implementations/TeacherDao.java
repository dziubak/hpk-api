package com.hpk.api.component.dao.implementations;

import com.hpk.api.component.dao.interfaces.ITeacher;
import com.hpk.api.component.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TeacherDao implements ITeacher {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static String SQL_CREATE_TEACHER = "INSERT INTO teacher (department_id, surname, name, middle_name, description) VALUES (:department_id, , :surname, :name, :middle_name, :description)";
    private final static String SQL_GET_TEACHER = "SELECT id, department_id, surname, name, middle_name, description, status FROM teacher WHERE id=:id";
    private final static String SQL_GET_ALL_TEACHERS = "SELECT id, department_id, surname, name, middle_name, description, status FROM teacher";
    private final static String SQL_DELETE_TEACHER = "DELETE FROM teacher WHERE id=:id";


    private RowMapper<Teacher> teacherRowMapper() {
        return (resultSet, i) -> {
            Teacher teacher = new Teacher();
            teacher.setId(resultSet.getInt("id"));
            teacher.setDepartmentId(resultSet.getInt("department_id"));
            teacher.setSurname(resultSet.getString("surname"));
            teacher.setName(resultSet.getString("name"));
            teacher.setMiddleName(resultSet.getString("middle_name"));
            teacher.setDescription(resultSet.getString("description"));
            teacher.setStatus(resultSet.getBoolean("status"));
            return teacher;
        };
    }

    public boolean create(Teacher teacher){
        HashMap<String, String> params = new HashMap<>();
        params.put("department_id", String.valueOf(teacher.getDepartmentId()));
        params.put("surname", teacher.getSurname());
        params.put("name", teacher.getName());
        params.put("middle_name", teacher.getMiddleName());
        params.put("description", teacher.getDescription());
        return namedParameterJdbcTemplate.update(SQL_CREATE_TEACHER, params) > 0;
    }

    public Teacher getById(int id){
        Map<String, Integer> params = Collections.singletonMap("id", id);
        return namedParameterJdbcTemplate.queryForObject(SQL_GET_TEACHER, params, teacherRowMapper());
    }

    public List<Teacher> getAll(){
        return namedParameterJdbcTemplate.query(SQL_GET_ALL_TEACHERS, teacherRowMapper());
    }

    public boolean updateById(Teacher teacher){
        String SQL_UPDATE_CLASSROOM = "UPDATE teacher SET";
        StringBuilder fieldsStr = new StringBuilder(" ");
        if(teacher.getDepartmentId()!=0){
            fieldsStr.append("department_id = " + teacher.getDepartmentId()).append(",");
        }
        if(teacher.getSurname()!=null && !teacher.getSurname().isEmpty()){
            fieldsStr.append("surname = " + teacher.getSurname()).append(",");
        }
        if(teacher.getName()!=null && !teacher.getName().isEmpty()){
            fieldsStr.append("name = " + teacher.getName()).append(",");
        }
        if(teacher.getMiddleName()!=null && !teacher.getMiddleName().isEmpty()){
            fieldsStr.append("middle_name = " + teacher.getMiddleName()).append(",");
        }
        if(teacher.getDescription()!=null && !teacher.getDescription().isEmpty()){
            fieldsStr.append("description = " + teacher.getDescription()).append(",");
        }
        fieldsStr.append("status = " + teacher.isStatus()).append(",");
        SQL_UPDATE_CLASSROOM = SQL_UPDATE_CLASSROOM + fieldsStr.toString().replaceAll(",$", " ") + "WHERE id = :id";
        Map<String, Integer> params = Collections.singletonMap("id",  teacher.getId());
        return namedParameterJdbcTemplate.update(SQL_UPDATE_CLASSROOM, params)>0;
    }

    public boolean deleteById(int id){
        Map<String, Integer> params = Collections.singletonMap("id", id);
        return namedParameterJdbcTemplate.update(SQL_DELETE_TEACHER, params)>0;
    }

}
