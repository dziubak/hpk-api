package com.hpk.api.service;

import com.hpk.api.component.dao.GroupDao;
import com.hpk.api.component.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupDao groupDao;

    public List<Group> getGroupsByDepartmentIdAndCourse(int departmentId, int courseNumber){
        return groupDao.getGroupsByDepartmentIdAndCourse(departmentId, courseNumber);
    }

    public List<Group> getListGroupsByName(String groupName) {
        return groupDao.getListGroupsByName(groupName);
    }

    public Group getGroupById(int groupId){
        return groupDao.getGroupById(groupId);
    }


}
