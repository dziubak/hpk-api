package com.hpk.api.component.dao.interfaces;

import com.hpk.api.component.entities.Groupment;

import java.util.List;

public interface IGroupment {
    boolean create(Groupment groupment);

    Groupment getById(int id);

    List<Groupment> getAll();

    boolean updateById(Groupment groupment);

    boolean deleteById(int id);
}
