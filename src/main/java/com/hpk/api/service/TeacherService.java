package com.hpk.api.service;

import com.hpk.api.component.dao.TeacherDao;
import com.hpk.api.component.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    public List<Teacher> getListTeachersBySurname(String teacherSurname) {
        return teacherDao.getListTeachersBySurname(teacherSurname);
    }

    public Teacher getTeacherById(int teacherId){
        return teacherDao.getTeacherById(teacherId);
    }

}
