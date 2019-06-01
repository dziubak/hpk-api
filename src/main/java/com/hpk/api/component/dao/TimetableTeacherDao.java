package com.hpk.api.component.dao;

import com.hpk.api.component.model.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TimetableTeacherDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static String SQL_GET_ALL_TEACHERS = "SELECT id, surname, name, middle_name, info FROM hpk_bot.teacher";

    public class TimetableForTeacherRowMapper implements RowMapper<Timetable> {
        @Override
        public Timetable mapRow(ResultSet rs, int rowNum) throws SQLException {
            Timetable timetable = new Timetable();
            timetable.setDayOfWeek(DayOfWeek.valueOf(rs.getString(1)));
            timetable.setNumberOfCouple(rs.getString(2));
            timetable.setPosition(rs.getString(3));
            timetable.setGroup(rs.getString(4));
            timetable.setTeacher(rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7));
            timetable.setSubject(rs.getString(8));
            timetable.setClassroom(rs.getString(9));
            timetable.setClassroomSecond(rs.getString(10));

            return timetable;
        }
    }

    public List<Timetable> getTeacherTimetableById(int teacherId, String position, DayOfWeek dayOfWeek) {
        String dayOfWeekCondition = dayOfWeek != null ? " AND day_of_week=:dayOfWeek" : "";

        String SQL_GET_TEACHER_TIMETABLE_BY_DAY_AND_POSITION = "SELECT tt.day_of_week, tt.number_of_couple, tt.position, g.name, " +
                "t1.surname, t1.name, t1.middle_name, s.name, c1.number, tt.classroom FROM timetable tt " +
                "LEFT JOIN `group` g ON tt.group_id = g.id " +
                "LEFT JOIN teacher t1 ON tt.teacher_id = t1.id " +
                "LEFT JOIN classroom c1 ON tt.classroom_id = c1.id " +
                "LEFT JOIN subject s ON tt.subject_id = s.id " +
                "WHERE (t1.id=:teacherId) AND tt.position=:position " + dayOfWeekCondition + " " +
                "UNION " +
                "SELECT tt.day_of_week, tt.number_of_couple, tt.position, g.name, t2.surname, t2.name, t2.middle_name, s.name, " +
                "c2.number, tt.classroom FROM timetable tt " +
                "LEFT JOIN `group` g ON tt.group_id = g.id " +
                "LEFT JOIN teacher t2 ON tt.teacher_second_id = t2.id " +
                "LEFT JOIN classroom c2 ON tt.classroom_second_id = c2.id " +
                "LEFT JOIN subject s ON tt.subject_id = s.id " +
                "WHERE (t2.id=:teacherId) AND tt.position=:position " + dayOfWeekCondition;

        Map<String, Object> params = new HashMap<>();
        params.put("teacherId", teacherId);
        params.put("position", position);
        params.put("dayOfWeek", dayOfWeek);

        return namedParameterJdbcTemplate.query(SQL_GET_TEACHER_TIMETABLE_BY_DAY_AND_POSITION, params,
                new TimetableForTeacherRowMapper());
    }

    public List<Timetable> getGroupTimetableById(int groupId, String position, DayOfWeek dayOfWeek) {
        String dayOfWeekCondition = dayOfWeek != null ? " AND day_of_week=:dayOfWeek" : "";

        String SQL_GET_TEACHER_TIMETABLE_BY_DAY_AND_POSITION = "SELECT tt.day_of_week, tt.number_of_couple, tt.position, g.name, " +
                "t1.surname, t1.name, t1.middle_name, s.name, c1.number, tt.classroom FROM timetable tt " +
                "LEFT JOIN `group` g ON tt.group_id = g.id " +
                "LEFT JOIN teacher t1 ON tt.teacher_id = t1.id " +
                "LEFT JOIN classroom c1 ON tt.classroom_id = c1.id " +
                "LEFT JOIN subject s ON tt.subject_id = s.id " +
                "WHERE (g.id=:groupId) AND tt.position=:position " + dayOfWeekCondition;

        Map<String, Object> params = new HashMap<>();
        params.put("groupId", groupId);
        params.put("position", position);
        params.put("dayOfWeek", dayOfWeek);

        return namedParameterJdbcTemplate.query(SQL_GET_TEACHER_TIMETABLE_BY_DAY_AND_POSITION, params,
                new TimetableForTeacherRowMapper());
    }
}
