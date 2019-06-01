package com.hpk.api.controllers;

import com.hpk.api.component.dao.TeacherDao;
import com.hpk.api.component.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherDao teacherDao;

    @PostMapping("/get")
    public List<Teacher> getListTeachersBySurname(@RequestBody Teacher teacher){
        return teacherDao.getListTeachersBySurname(teacher);
    }

}
