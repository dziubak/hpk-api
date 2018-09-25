package com.hpk.api.component.entities;

import lombok.Data;

@Data
public class Replacement {
	private int id;
	private int replacementGeneralId;
	private String nameGroup;
	private String numberOfCouple;
	private String teacherReplacement;
	private String subject;
	private String teacher;
	private String classroom;
}
