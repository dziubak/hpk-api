package com.hpk.api.component.dao.interfaces;

import com.hpk.api.component.entities.Teacher;

import java.util.List;

public interface ITeacher {
    boolean create(Teacher teacher);

    Teacher getById(int id);

    List<Teacher> getAll();

    boolean updateById(Teacher teacher);

    boolean deleteById(int id);
}
