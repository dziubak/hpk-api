package com.hpk.api.component.dao.interfaces;

import com.hpk.api.component.entities.Subject;

import java.util.List;

public interface ISubject {
    boolean create(Subject subject);

    Subject getById(int id);

    List<Subject> getAll();

    boolean updateById(Subject subject);

    boolean deleteById(int id);
}
