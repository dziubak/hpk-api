package com.hpk.api.component.dao.rowmapper;

import com.hpk.api.component.model.Department;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentRowMapper implements RowMapper<Department> {

    @Override
    public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
        Department department = new Department();
        department.setId(rs.getInt("id"));
        department.setName(rs.getString("name"));
        department.setAbbreviation(rs.getString("abbreviation"));
        department.setDescription(rs.getString("description"));

        return department;
    }
}
