package com.hpk.api.component.model;

public class ReplacementGeneral {
    private int id;
    private String teacherOnDuty;
    private String groupOnDuty;
    private String position;
    private String dateOfReplacement;
    private String dayOfweek;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherOnDuty() {
        return teacherOnDuty;
    }

    public void setTeacherOnDuty(String teacherOnDuty) {
        this.teacherOnDuty = teacherOnDuty;
    }

    public String getGroupOnDuty() {
        return groupOnDuty;
    }

    public void setGroupOnDuty(String groupOnDuty) {
        this.groupOnDuty = groupOnDuty;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDateOfReplacement() {
        return dateOfReplacement;
    }

    public void setDateOfReplacement(String dateOfReplacement) {
        this.dateOfReplacement = dateOfReplacement;
    }

    public String getDayOfweek() {
        return dayOfweek;
    }

    public void setDayOfweek(String dayOfweek) {
        this.dayOfweek = dayOfweek;
    }
}
