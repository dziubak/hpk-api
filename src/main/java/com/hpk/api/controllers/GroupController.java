package com.hpk.api.controllers;

import com.hpk.api.component.model.Group;
import com.hpk.api.service.GroupService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/group")
@Api(value="Group", description="Group. Method to get group info")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @ApiOperation(value = "Get a list of groups in which the name begins with the characters specified in the request", response = ArrayList.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully") } )
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Group> getListTeachersBySurname(@ApiParam(value = "Begin name (characters working with mysql 'LIKE'). If field is empty - get all groups")@RequestParam(required = false) String groupName){
        return groupService.getListGroupsByName(groupName);
    }

    @ApiOperation(value = "Get group object by id", response = ArrayList.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully") } )
    @RequestMapping(value = "/{groupId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Group getTeacherById(@PathVariable int groupId){
        return groupService.getGroupById(groupId);
    }

}
