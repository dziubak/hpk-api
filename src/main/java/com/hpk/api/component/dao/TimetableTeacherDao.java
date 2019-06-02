package com.hpk.api.component.dao;

import com.hpk.api.component.dao.rowmapper.TimetableTeacherRowMapper;
import com.hpk.api.component.model.TimetableGroup;
import com.hpk.api.component.model.TimetableTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TimetableTeacherDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<TimetableTeacher> getTeacherTimetableById(int teacherId, String position, DayOfWeek dayOfWeek) {
        String dayOfWeekCondition = dayOfWeek != null ? " AND day_of_week=':dayOfWeek' " : "";
        String positionCondtition = position != null ? " AND tt.position=:position " : "";

        String sql = "SELECT tt.day_of_week as dayOfWeek, tt.number_of_couple as numberOfCouple, " +
                "tt.position as position, g.name as groupName, t1.surname as teacherSurname, " +
                "t1.name as teacherName, t1.middle_name as teacherMiddleName, " +
                "s.name as subjectName, s.abbreviation as subjectAbbreviation, " +
                "c1.number as classroomNumber FROM timetable tt " +
                "LEFT JOIN team g ON tt.group_id = g.id " +
                "LEFT JOIN teacher t1 ON tt.teacher_id = t1.id " +
                "LEFT JOIN classroom c1 ON tt.classroom_id = c1.id " +
                "LEFT JOIN subject s ON tt.subject_id = s.id " +
                "WHERE (t1.id=:teacherId) " + positionCondtition
                + dayOfWeekCondition.replace(":dayOfWeek", dayOfWeek.toString()) + " " +
                "UNION " +
                "SELECT tt.day_of_week as dayOfWeek, tt.number_of_couple as numberOfCouple, " +
                "tt.position as position, g.name as groupName, t2.surname as teacherSurname, " +
                "t2.name as teacherName, t2.middle_name as teacherMiddleName, " +
                "s.name as subjectName, s.abbreviation as subjectAbbreviation, " +
                "c2.number as classroomNumber FROM timetable tt " +
                "LEFT JOIN team g ON tt.group_id = g.id " +
                "LEFT JOIN teacher t2 ON tt.teacher_second_id = t2.id " +
                "LEFT JOIN classroom c2 ON tt.classroom_second_id = c2.id " +
                "LEFT JOIN subject s ON tt.subject_id = s.id " +
                "WHERE (t2.id=:teacherId) " + positionCondtition
                + dayOfWeekCondition.replace(":dayOfWeek", dayOfWeek.toString());

        Map<String, Object> params = new HashMap<>();
        params.put("teacherId", teacherId);
        params.put("position", position);

        return namedParameterJdbcTemplate.query(sql, params, new TimetableTeacherRowMapper());
    }
}
