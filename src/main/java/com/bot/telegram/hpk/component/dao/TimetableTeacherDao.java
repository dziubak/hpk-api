package com.bot.telegram.hpk.component.dao;

import com.bot.telegram.hpk.component.entities.Teacher;
import com.bot.telegram.hpk.component.entities.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.List;

@Repository
public class TimetableTeacherDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static String SQL_GET_ALL_TEACHERS = "SELECT id, surname, name, middle_name, info FROM hpk_bot.teacher";

    private final static String SQL_GET_TIMETABLE_GENERAL_FOR_TEACHER = "SELECT tt.day_of_week, tt.number_of_couple, tt.position, g.name, " +
            "t1.surname, t1.name, t1.middle_name, s.name, c1.number, tt.classroom FROM hpk_bot.timetable tt " +
            "LEFT JOIN `group` g ON tt.group_id = g.id " +
            "LEFT JOIN teacher t1 ON tt.teacher_id = t1.id " +
            "LEFT JOIN classroom c1 ON tt.classroom_id = c1.id " +
            "LEFT JOIN subject s ON tt.subject_id = s.id " +
            "WHERE (t1.surname=?) " +
            "UNION " +
            "SELECT tt.day_of_week, tt.number_of_couple, tt.position, g.name, t2.surname, t2.name, t2.middle_name, s.name, " +
            "c2.number, tt.classroom FROM hpk_bot.timetable tt " +
            "LEFT JOIN `group` g ON tt.group_id = g.id " +
            "LEFT JOIN teacher t2 ON tt.teacher_second_id = t2.id " +
            "LEFT JOIN classroom c2 ON tt.classroom_second_id = c2.id " +
            "LEFT JOIN subject s ON tt.subject_id = s.id " +
            "WHERE (t2.surname=?)";

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

    public List<Timetable> getTimetableGeneralForTeacher(String surnameTeacher) {
        return jdbcTemplate.query(SQL_GET_TIMETABLE_GENERAL_FOR_TEACHER, new TimetableForTeacherRowMapper(), surnameTeacher, surnameTeacher);
    }

//    public List<Timetable> getTimetableTodayForGroup(String nameGroup) {
//        return jdbcTemplate.query(SQL_GET_TIMETABLE_TODAY_FOR_GROUP, new TimetableGroupDao.TimetableRowMapper(), nameGroup);
//    }
//
//    public List<Timetable> getTimetableTomorrowForGroup(String nameGroup) {
//        return jdbcTemplate.query(SQL_GET_TIMETABLE_TOMORROW_FOR_GROUP, new TimetableGroupDao.TimetableRowMapper(), nameGroup);
//    }

    public List<Teacher> getAllTeachersList() {
        List<Teacher> teachersList = jdbcTemplate.query(SQL_GET_ALL_TEACHERS, (rs, arg1) -> {
            Teacher teacher = new Teacher();
            teacher.setId(rs.getInt(1));
            teacher.setSurname(rs.getString(2));
            teacher.setName(rs.getString(3));
            teacher.setMiddleName(rs.getString(4));
            teacher.setInfo(rs.getString(5));

            return teacher;
        });

        return teachersList;
    }
}
