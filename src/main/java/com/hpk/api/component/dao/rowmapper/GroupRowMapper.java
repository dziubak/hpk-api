package com.hpk.api.component.dao.rowmapper;

import com.hpk.api.component.model.Group;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupRowMapper implements RowMapper<Group> {
    @Override
    public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
        Group group = new Group();
        group.setId(rs.getInt("id"));
        group.setTeacherId(rs.getInt("teacher_id"));
        group.setName(rs.getString("name"));
        group.setCourse(rs.getInt("course"));
        group.setDepartmentId(rs.getInt("department_id"));

        return group;
    }
}
