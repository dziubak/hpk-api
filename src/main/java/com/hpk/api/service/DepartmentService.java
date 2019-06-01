package com.hpk.api.service;

import com.hpk.api.component.dao.DepartmentDao;
import com.hpk.api.component.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public List<Department> getAllDepartments(){
        return departmentDao.getAllDepartments();
    }

}
