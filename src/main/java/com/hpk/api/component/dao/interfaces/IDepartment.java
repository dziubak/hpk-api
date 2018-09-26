package com.hpk.api.component.dao.interfaces;

import com.hpk.api.component.entities.Department;

import java.util.List;

public interface IDepartment {
    boolean create(Department department);

    Department getById(int id);

    List<Department> getAll();

    boolean updateById(Department department);

    boolean deleteById(int id);
}
