package com.hpk.api.component.dao.interfaces;

import com.hpk.api.component.entities.Classroom;

import java.util.List;

public interface IClassroom {
    boolean create(Classroom classroom);

    Classroom getById(int id);

    List<Classroom> getAll();

    boolean updateById(Classroom classroom);

    boolean deleteById(int id);
}
