package com.hpk.api.component.dao.implementations;

import com.hpk.api.component.dao.interfaces.IGroupment;
import com.hpk.api.component.entities.Groupment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GroupmentDao implements IGroupment {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static String SQL_CREATE_DEPARTMENT = "INSERT INTO groupment (department_id, teacher_id, name, course, description) VALUES (:department_id, :teacher_id, :name, :course, :description)";
    private final static String SQL_GET_DEPARTMENT = "SELECT id, department_id, teacher_id, name, course, description, status FROM groupment WHERE id=:id";
    private final static String SQL_GET_ALL_DEPARTMENTS = "SELECT id, department_id, teacher_id, name, course, description, status FROM groupment";
    private final static String SQL_DELETE_DEPARTMENT = "DELETE FROM groupment WHERE id=:id";


    private RowMapper<Groupment> departmentRowMapper() {
        return (resultSet, i) -> {
            Groupment groupment = new Groupment();
            groupment.setId(resultSet.getInt("id"));
            groupment.setDepartmentId(resultSet.getInt("department_id"));
            groupment.setTeacherId(resultSet.getInt("teacher_id"));
            groupment.setName(resultSet.getString("name"));
            groupment.setCourse(resultSet.getInt("course"));
            groupment.setDescription(resultSet.getString("description"));
            groupment.setStatus(resultSet.getBoolean("status"));
            return groupment;
        };
    }

    public boolean create(Groupment groupment){
        HashMap<String, String> params = new HashMap<>();
        params.put("department_id", String.valueOf(groupment.getDepartmentId()));
        params.put("teacher_id", String.valueOf(groupment.getTeacherId()));
        params.put("name", groupment.getName());
        params.put("course", String.valueOf(groupment.getCourse()));
        params.put("description", groupment.getDescription());
        return namedParameterJdbcTemplate.update(SQL_CREATE_DEPARTMENT, params) > 0;
    }

    public Groupment getById(int id){
        Map<String, Integer> params = Collections.singletonMap("id", id);
        return namedParameterJdbcTemplate.queryForObject(SQL_GET_DEPARTMENT, params, departmentRowMapper());
    }

    public List<Groupment> getAll(){
        return namedParameterJdbcTemplate.query(SQL_GET_ALL_DEPARTMENTS, departmentRowMapper());
    }

    public boolean updateById(Groupment groupment){
        String SQL_UPDATE_CLASSROOM = "UPDATE groupment SET";
        StringBuilder fieldsStr = new StringBuilder(" ");
        if(groupment.getDepartmentId()!=0){
            fieldsStr.append("department_id = " + groupment.getDepartmentId()).append(",");
        }
        if(groupment.getTeacherId()!=0){
            fieldsStr.append("teacher_id = " + groupment.getTeacherId()).append(",");
        }
        if(groupment.getName()!=null && !groupment.getName().isEmpty()){
            fieldsStr.append("name = " + groupment.getName()).append(",");
        }
        if(groupment.getCourse()!=0){
            fieldsStr.append("course = " + groupment.getCourse()).append(",");
        }
        if(groupment.getDescription()!=null && !groupment.getDescription().isEmpty()){
            fieldsStr.append("description = " + groupment.getDescription()).append(",");
        }
        fieldsStr.append("status = " + groupment.isStatus()).append(",");
        SQL_UPDATE_CLASSROOM = SQL_UPDATE_CLASSROOM + fieldsStr.toString().replaceAll(",$", " ") + "WHERE id = :id";
        Map<String, Integer> params = Collections.singletonMap("id",  groupment.getId());
        return namedParameterJdbcTemplate.update(SQL_UPDATE_CLASSROOM, params)>0;
    }

    public boolean deleteById(int id){
        Map<String, Integer> params = Collections.singletonMap("id", id);
        return namedParameterJdbcTemplate.update(SQL_DELETE_DEPARTMENT, params)>0;
    }

}
