package com.hpk.api.component.dao;

import com.hpk.api.component.dao.rowmapper.TimetableGroupRowMapper;
import com.hpk.api.component.dao.rowmapper.TimetableTeacherRowMapper;
import com.hpk.api.component.model.TimetableGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TimetableGroupDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<TimetableGroup> getGroupTimetableById(int groupId, String position, DayOfWeek dayOfWeek) {
		String dayOfWeekCondition = dayOfWeek != null ? " AND day_of_week=':dayOfWeek'" : "";
		String positionCondition = " AND tt.position='повний'";
		String positionFullContidion = position != null ? " AND (tt.position=:position OR  tt.position='повний')" : positionCondition;

		String sql = "SELECT tt.day_of_week as dayOfWeek, tt.number_of_couple as numberOfCouple, " +
				"tt.position as position, g.name as groupName, " +
				"t1.surname as teacherFirstSurname, t1.name as teacherFirstName, t1.middle_name as teacherFirstMiddleName, " +
				"t2.surname as teacherSecondSurname, t2.name as teacherSecondName, t2.middle_name teacherSecondMiddleName, " +
				"s.name as subjectName, s.abbreviation as subjectAbbreviation, " +
				"c1.number as classroomFirst, c2.number as classroomSecond FROM timetable tt " +
				"LEFT JOIN team g ON tt.group_id = g.id " +
				"LEFT JOIN teacher t1 ON tt.teacher_id = t1.id " +
				"LEFT JOIN teacher t2 ON tt.teacher_second_id = t2.id " +
				"LEFT JOIN classroom c1 ON tt.classroom_id = c1.id " +
				"LEFT JOIN classroom c2 ON tt.classroom_second_id = c2.id " +
				"LEFT JOIN subject s ON tt.subject_id = s.id " +
				"WHERE (g.id=:groupId) " + positionFullContidion
				+ dayOfWeekCondition.replace(":dayOfWeek", dayOfWeek.toString());

		Map<String, Object> params = new HashMap<>();
		params.put("groupId", groupId);
		params.put("position", position);

		return namedParameterJdbcTemplate.query(sql, params, new TimetableGroupRowMapper());
	}

}
