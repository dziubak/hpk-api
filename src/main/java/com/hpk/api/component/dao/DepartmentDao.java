package com.hpk.api.component.dao;

import com.hpk.api.component.dao.rowmapper.DepartmentRowMapper;
import com.hpk.api.component.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Department> getAllDepartments(){
        String sql = "SELECT id, name, abbreviation, description FROM department";

        return namedParameterJdbcTemplate.query(sql, new DepartmentRowMapper());
    }

}
