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

        String teacherSurname = rs.getString("teacherSurname") != null ? rs.getString("teacherSurname") : "";
        String teacherName = rs.getString("teacherName") != null ? rs.getString("teacherName").substring(0,1).concat(".") : "";
        String teacherMiddleName = rs.getString("teacherMiddleName") != null ? rs.getString("teacherMiddleName").substring(0,1).concat(".") : "";

        String teacher = teacherSurname + " " + teacherName + teacherMiddleName;

        timetableTeacher.setTeacher(teacher);

        timetableTeacher.setSubjectAbbreviation(rs.getString("subjectAbbreviation"));
        timetableTeacher.setSubjectName(rs.getString("subjectName"));
        timetableTeacher.setClassroom(rs.getString("classroomNumber"));

        return timetableTeacher;
    }

}