package com.hpk.api.component.model;

import io.swagger.annotations.ApiModelProperty;

public class Teacher {
	@ApiModelProperty(notes = "The database generated teacher ID")
	private int id;
	@ApiModelProperty(notes = "The database generated department ID. Department")
	private int departmentId;
	@ApiModelProperty(notes = "The teacher surname (last name)")
	private String surname;
	@ApiModelProperty(notes = "The teacher name (first name)")
	private String name;
	@ApiModelProperty(notes = "The teacher middlename (father name)")
	private String middleName;
	@ApiModelProperty(notes = "The description (additional info)")
	private String description;
	@ApiModelProperty(notes = "The info (additional info)")
	private String info;

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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
