package com.hpk.api.controllers;

import com.hpk.api.component.model.Department;
import com.hpk.api.component.model.Group;
import com.hpk.api.service.DepartmentService;
import com.hpk.api.service.GroupService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/department")
@Api(value="Department", description="Department. Methods to get department info")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private GroupService groupService;

    @ApiOperation(value = "Get all departments", response = ArrayList.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully") } )
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @ApiOperation(value = "Get groups by departmentId and number of course", response = ArrayList.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully") } )
    @RequestMapping(value = "/{departmentId}/groups", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Group> getGroupsByDepartmentIdAndCourse(@ApiParam(value = "Department id generated by database", required = true) @PathVariable int departmentId,
                                                        @ApiParam(value = "Course number of groups", required = true) int courseNumber) {
        return groupService.getGroupsByDepartmentIdAndCourse(departmentId, courseNumber);
    }

}
