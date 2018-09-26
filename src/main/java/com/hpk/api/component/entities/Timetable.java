package com.hpk.api.component.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.DayOfWeek;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Timetable {
	private int id;
	private DayOfWeek dayOfWeek;
	private String numberOfCouple;
	private String position;
	private int groupId;
	private int teacherId;
	private int teacherSecondId;
	private int subjectId;
	private int classroomId;
	private int classroomSecondId;
	private String description;
	private boolean status;
}
