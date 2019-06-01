package com.hpk.api.component.model;

import lombok.Data;

@Data
public class Group {
	private int id;
	private int departmentId;
	private int teacherId;
	private String name;
	private int course;
	private String description;
}
