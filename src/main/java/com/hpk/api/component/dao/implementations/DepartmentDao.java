package com.hpk.api.component.dao.implementations;

import com.hpk.api.component.dao.interfaces.IDepartment;
import com.hpk.api.component.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DepartmentDao implements IDepartment {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static String SQL_CREATE_DEPARTMENT = "INSERT INTO department (name, abbreviation, description) VALUES (:name, :abbreviation, :description)";
    private final static String SQL_GET_DEPARTMENT = "SELECT id, name, abbreviation, description, status FROM department WHERE id=:id";
    private final static String SQL_GET_ALL_DEPARTMENTS = "SELECT id, name, abbreviation, description, status FROM department";
    private final static String SQL_DELETE_DEPARTMENT = "DELETE FROM department WHERE id=:id";


    private RowMapper<Department> departmentRowMapper() {
        return (resultSet, i) -> {
            Department department = new Department();
            department.setId(resultSet.getInt("id"));
            department.setName(resultSet.getString("name"));
            department.setAbbreviation(resultSet.getString("abbreviation"));
            department.setDescription(resultSet.getString("description"));
            department.setStatus(resultSet.getBoolean("status"));
            return department;
        };
    }

    public boolean create(Department department){
        HashMap<String, String> params = new HashMap<>();
        params.put("name", department.getName());
        params.put("abbreviation", department.getAbbreviation());
        params.put("description", department.getDescription());
        return namedParameterJdbcTemplate.update(SQL_CREATE_DEPARTMENT, params) > 0;
    }

    public Department getById(int id){
        Map<String, Integer> params = Collections.singletonMap("id", id);
        return namedParameterJdbcTemplate.queryForObject(SQL_GET_DEPARTMENT, params, departmentRowMapper());
    }

    public List<Department> getAll(){
        return namedParameterJdbcTemplate.query(SQL_GET_ALL_DEPARTMENTS, departmentRowMapper());
    }

    public boolean updateById(Department department){
        String SQL_UPDATE_DEPARTMENT = "UPDATE department SET";
        StringBuilder fieldsStr = new StringBuilder(" ");
        if(department.getName()!=null && !department.getName().isEmpty()){
            fieldsStr.append("name = " + department.getName()).append(",");
        }
        if(department.getAbbreviation()!=null && !department.getAbbreviation().isEmpty()){
            fieldsStr.append("abbreviation = " + department.getAbbreviation()).append(",");
        }
        if(department.getDescription()!=null && !department.getDescription().isEmpty()){
            fieldsStr.append("description = " + department.getDescription()).append(",");
        }
        fieldsStr.append("status = " + department.isStatus()).append(",");
        SQL_UPDATE_DEPARTMENT = SQL_UPDATE_DEPARTMENT + fieldsStr.toString().replaceAll(",$", " ") + "WHERE id = :id";
        Map<String, Integer> params = Collections.singletonMap("id",  department.getId());
        return namedParameterJdbcTemplate.update(SQL_UPDATE_DEPARTMENT, params)>0;
    }

    public boolean deleteById(int id){
        Map<String, Integer> params = Collections.singletonMap("id", id);
        return namedParameterJdbcTemplate.update(SQL_DELETE_DEPARTMENT, params)>0;
    }

}
