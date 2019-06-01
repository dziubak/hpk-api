package com.hpk.api.component.model;

import lombok.Data;

@Data
public class ReplacementGeneral {
    private int id;
    private String teacherOnDuty;
    private String groupOnDuty;
    private String position;
    private String dateOfReplacement;
    private String dayOfweek;
}
