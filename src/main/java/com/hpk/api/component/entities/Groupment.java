package com.hpk.api.component.entities;

import lombok.Data;

@Data
public class Groupment {
	private int id;
	private int departmentId;
	private int teacherId;
	private String name;
	private int course;
	private String description;
}
