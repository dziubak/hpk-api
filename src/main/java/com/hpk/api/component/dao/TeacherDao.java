package com.hpk.api.component.dao;

import com.hpk.api.component.dao.rowmapper.TeacherRowMapper;
import com.hpk.api.component.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Teacher> getListTeachersBySurname(String teacherSurname){
        String sql = "SELECT id, surname, name, middle_name, info FROM teacher";
        String like = " WHERE surname LIKE '" + teacherSurname + "%'";

        sql = teacherSurname != null ? sql.concat(like) : sql;

        return namedParameterJdbcTemplate.query(sql, new TeacherRowMapper());
    }
}
