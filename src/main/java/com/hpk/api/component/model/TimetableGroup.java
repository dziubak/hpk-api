package com.hpk.api.component.model;

import io.swagger.annotations.ApiModelProperty;

import java.time.DayOfWeek;

public class TimetableGroup {
	@ApiModelProperty(notes = "Day of week (Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)")
	private DayOfWeek dayOfWeek;
	@ApiModelProperty(notes = "Number of couple (Values: 1, 2, 3, 4 OR 1-2, 3-4, 5-6, 7-8)")
	private String numberOfCouple;
	@ApiModelProperty(notes = "Position ((eng: numerator, ua: чисельник), (eng: denominator, ua: знаменник)). Use ua.")
	private String position;
	@ApiModelProperty(notes = "The group name (full name)")
	private String groupName;
	@ApiModelProperty(notes = "The subject name")
	private String subjectName;
	@ApiModelProperty(notes = "The subject abbreviation")
	private String subjectAbbreviation;
	@ApiModelProperty(notes = "Main teacher of subject. The teacher surname (last name) with initials. For example: Koval S.O.")
	private String teacher;
	@ApiModelProperty(notes = "Teacher of second subgroup. The teacher surname (last name) with initials. For example: Koval S.O.")
	private String teacherSecond;
	@ApiModelProperty(notes = "The number of classroom for first subgroup with main teacher.")
	private String classroom;
	@ApiModelProperty(notes = "The number of classroom for second subgroup.")
	private String classroomSecond;

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getNumberOfCouple() {
		return numberOfCouple;
	}

	public void setNumberOfCouple(String numberOfCouple) {
		this.numberOfCouple = numberOfCouple;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectAbbreviation() {
		return subjectAbbreviation;
	}

	public void setSubjectAbbreviation(String subjectAbbreviation) {
		this.subjectAbbreviation = subjectAbbreviation;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getTeacherSecond() {
		return teacherSecond;
	}

	public void setTeacherSecond(String teacherSecond) {
		this.teacherSecond = teacherSecond;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getClassroomSecond() {
		return classroomSecond;
	}

	public void setClassroomSecond(String classroomSecond) {
		this.classroomSecond = classroomSecond;
	}
}
