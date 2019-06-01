package com.hpk.api.controllers;

import com.hpk.api.component.model.Department;
import com.hpk.api.component.model.Group;
import com.hpk.api.service.DepartmentService;
import com.hpk.api.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private GroupService groupService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @RequestMapping(value = "/{departmentId}/groups", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Group> getGroupsByDepartmentIdAndCourse(@PathVariable int departmentId,
                                                        int courseNumber) {
        return groupService.getGroupsByDepartmentIdAndCourse(departmentId, courseNumber);
    }

}
