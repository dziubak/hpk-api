package com.hpk.api.component.dao.rowmapper;

import com.hpk.api.component.model.TimetableTeacher;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;

public class TimetableTeacherRowMapper implements RowMapper<TimetableTeacher> {
    @Override
    public TimetableTeacher mapRow(ResultSet rs, int rowNum) throws SQLException {
        TimetableTeacher timetableTeacher = new TimetableTeacher();

        timetableTeacher.setDayOfWeek(DayOfWeek.valueOf(rs.getString("dayOfWeek")));
        timetableTeacher.setNumberOfCouple(rs.getString("numberOfCouple"));
        timetableTeacher.setPosition(rs.getString("position"));
        timetableTeacher.setGroupName(rs.getString("groupName"));
        timetableTeacher.setTeacher(rs.getString("teacherSurname")
                + " " + rs.getString("teacherName").substring(0, 1)
                + " " + rs.getString("teacherMiddleName").substring(0, 1));
        timetableTeacher.setSubjectAbbreviation(rs.getString("subjectAbbreviation"));
        timetableTeacher.setSubjectName(rs.getString("subjectName"));
        timetableTeacher.setClassroom(rs.getString("classroomNumber"));

        return timetableTeacher;
    }

}