package com.hpk.api.component.dao.rowmapper;

import com.hpk.api.component.model.TimetableGroup;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;

public class TimetableGroupRowMapper implements RowMapper<TimetableGroup> {
    @Override
    public TimetableGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
        TimetableGroup timetableGroup = new TimetableGroup();

        timetableGroup.setDayOfWeek(DayOfWeek.valueOf(rs.getString("dayOfWeek")));
        timetableGroup.setNumberOfCouple(rs.getString("numberOfCouple"));
        timetableGroup.setPosition(rs.getString("position"));
        timetableGroup.setGroupName(rs.getString("groupName"));

        String firstTeacherSurname = rs.getString("teacherFirstSurname") != null ? rs.getString("teacherFirstSurname") : "";
        String firstTeacherName = rs.getString("teacherFirstName") != null ? rs.getString("teacherFirstName").substring(0,1).concat(".") : "";
        String firstTeacherMiddleName = rs.getString("teacherFirstMiddleName") != null ? rs.getString("teacherFirstMiddleName").substring(0,1).concat(".") : "";

        String firstTeacher = firstTeacherSurname + " " + firstTeacherName + firstTeacherMiddleName;

        timetableGroup.setTeacher(firstTeacher);

        String secondTeacherSurname = rs.getString("teacherSecondSurname") != null ? rs.getString("teacherSecondSurname") : "";
        String secondTeacherName = rs.getString("teacherSecondName") != null ? rs.getString("teacherSecondName").substring(0,1).concat(".") : "";
        String secondTeacherMiddleName = rs.getString("teacherSecondMiddleName") != null ? rs.getString("teacherSecondMiddleName").substring(0,1).concat(".") : "";

        String secondTeacher = secondTeacherSurname + " " + secondTeacherName + secondTeacherMiddleName;

        timetableGroup.setTeacherSecond(secondTeacher);

        timetableGroup.setSubjectName(rs.getString("subjectName"));
        timetableGroup.setSubjectAbbreviation(rs.getString("subjectAbbreviation"));
        timetableGroup.setClassroom(rs.getString("classroomFirst"));
        timetableGroup.setClassroomSecond(rs.getString("classroomSecond"));

        return timetableGroup;
    }
}
