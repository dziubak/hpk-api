package com.hpk.api.component.dao.rowmapper;

import com.hpk.api.component.model.Teacher;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherRowMapper implements RowMapper<Teacher> {
    @Override
    public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
        Teacher teacher = new Teacher();
        teacher.setId(rs.getInt("id"));
        teacher.setSurname(rs.getString("surname"));
        teacher.setName(rs.getString("name"));
        teacher.setMiddleName(rs.getString("middle_name"));
        teacher.setInfo(rs.getString("info"));

        return teacher;
    }
}
