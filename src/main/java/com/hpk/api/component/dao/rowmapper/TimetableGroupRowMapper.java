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
        timetableGroup.setTeacher(rs.getString("teacherFirstSurname")
                + " " + rs.getString("teacherFirstName").substring(0,1)
                + " " + rs.getString("teacherFirstMiddleName").substring(0, 1));
        timetableGroup.setTeacherSecond(rs.getString("teacherSecondSurname")
                + " " + rs.getString("teacherSecondName").substring(0,1)
                + " " + rs.getString("teacherSecondMiddleName").substring(0, 1));
        timetableGroup.setSubjectName(rs.getString("subjectName"));
        timetableGroup.setSubjectAbbreviation(rs.getString("subjectAbbreviation"));
        timetableGroup.setClassroom(rs.getString("classroomFirst"));
        timetableGroup.setClassroomSecond(rs.getString("classroomSecond"));

        return timetableGroup;
    }
}
