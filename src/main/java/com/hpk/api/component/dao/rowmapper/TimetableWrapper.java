package com.hpk.api.component.dao.rowmapper;

import com.hpk.api.component.model.Classroom;
import com.hpk.api.component.model.Group;
import com.hpk.api.component.model.Subject;
import com.hpk.api.component.model.Teacher;
import com.hpk.api.component.model.Timetable;

public class TimetableWrapper {
	private Timetable timetable;
	private Group group;
	private Teacher teacherMain;
	private Teacher teacherAdditional;
	private Subject subject;
	private Classroom classroomMain;
	private Classroom classroomAdditional;
}
