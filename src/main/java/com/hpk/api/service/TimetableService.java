package com.hpk.api.service;

import com.hpk.api.component.dao.TimetableTeacherDao;
import com.hpk.api.component.model.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TimetableService {
    public final static Map<String, String> timetableTime = new HashMap<>();

    @Autowired
    private TimetableTeacherDao timetableTeacherDao;

    @PostConstruct
    public void init(){
        timetableTime.put("1", "8:30 − 9:50");
        timetableTime.put("2", "10:00 − 11:20");
        timetableTime.put("3", "11:50 − 13:10");
        timetableTime.put("4", "13:20 − 14:40");
    }

    public List<Timetable> getTeacherTimetableById(int teacherId, String position, DayOfWeek dayOfWeek){
        return timetableTeacherDao.getTeacherTimetableById(teacherId, position, dayOfWeek);
    }

    public List<Timetable> getGroupTimetableById(int teacherId, String position, DayOfWeek dayOfWeek){
        return timetableTeacherDao.getGroupTimetableById(teacherId, position, dayOfWeek);
    }
}
