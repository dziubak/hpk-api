package com.hpk.api.component.model;

import io.swagger.annotations.ApiModelProperty;

public class Group {
	@ApiModelProperty(notes = "The database generated group ID")
	private int id;
	@ApiModelProperty(notes = "The database generated department ID. Department")
	private int departmentId;
	@ApiModelProperty(notes = "The database generated teacher ID. Curator")
	private int teacherId;
	@ApiModelProperty(notes = "The group name (full name)")
	private String name;
	@ApiModelProperty(notes = "The number of course (Value: 1, 2, 3, 4)")
	private int course;
	@ApiModelProperty(notes = "The description for group (additional info)")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
