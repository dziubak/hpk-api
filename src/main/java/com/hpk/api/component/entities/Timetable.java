package com.hpk.api.component.entities;

import lombok.Data;

import java.time.DayOfWeek;

@Data
public class Timetable {
	private int id;
	private DayOfWeek dayOfWeek;
	private String numberOfCouple;
	private String position;
	private String group;
	private String subject;
	private String teacher;
	private String teacherSecond;
	private String classroom;
	private String classroomSecond;
}
