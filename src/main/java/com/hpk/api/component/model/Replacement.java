package com.hpk.api.component.model;

public class Replacement {
	private int id;
	private int replacementGeneralId;
	private String nameGroup;
	private String numberOfCouple;
	private String teacherReplacement;
	private String subject;
	private String teacher;
	private String classroom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReplacementGeneralId() {
		return replacementGeneralId;
	}

	public void setReplacementGeneralId(int replacementGeneralId) {
		this.replacementGeneralId = replacementGeneralId;
	}

	public String getNameGroup() {
		return nameGroup;
	}

	public void setNameGroup(String nameGroup) {
		this.nameGroup = nameGroup;
	}

	public String getNumberOfCouple() {
		return numberOfCouple;
	}

	public void setNumberOfCouple(String numberOfCouple) {
		this.numberOfCouple = numberOfCouple;
	}

	public String getTeacherReplacement() {
		return teacherReplacement;
	}

	public void setTeacherReplacement(String teacherReplacement) {
		this.teacherReplacement = teacherReplacement;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
}
