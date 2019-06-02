package com.hpk.api.controllers;

import com.hpk.api.component.model.Teacher;
import com.hpk.api.service.TeacherService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@Api(value="Teacher", description="Teacher. Method to get teacher info")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "Get a list of teachers in which the surname begins with the characters specified in the request", response = ArrayList.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully") } )
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Teacher> getListTeachersBySurname(@ApiParam(value = "Begin surname (characters working with mysql 'LIKE'). If field is empty - get all teachers")@RequestParam(required = false) String teacherSurname){
        return teacherService.getListTeachersBySurname(teacherSurname);
    }

    @ApiOperation(value = "Get teacher object by id", response = ArrayList.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully") } )
    @RequestMapping(value = "/{teacherId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Teacher getTeacherById(@PathVariable int teacherId){
        return teacherService.getTeacherById(teacherId);
    }

}
