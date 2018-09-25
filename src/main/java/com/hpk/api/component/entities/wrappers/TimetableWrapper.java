package com.hpk.api.component.entities.wrappers;

import com.hpk.api.component.entities.Classroom;
import com.hpk.api.component.entities.Groupment;
import com.hpk.api.component.entities.Subject;
import com.hpk.api.component.entities.Teacher;
import com.hpk.api.component.entities.Timetable;
import lombok.Data;

@Data
public class TimetableWrapper {
	private final Timetable timetable;
	private final Groupment groupment;
	private final Teacher teacherMain;
	private final Teacher teacherAdditional;
	private final Subject subject;
	private final Classroom classroomMain;
	private final Classroom classroomAdditional;
}
