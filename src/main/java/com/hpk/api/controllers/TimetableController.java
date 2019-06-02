package com.hpk.api.controllers;

import com.hpk.api.component.model.TimetableGroup;
import com.hpk.api.component.model.TimetableTeacher;
import com.hpk.api.service.TimetableService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/timetable")
@Api(value="Timetable", description="Timetable. Methods to get timetable info")
public class TimetableController {

	@Autowired
	private TimetableService timetableService;

	@ApiOperation(value = "Get timetable time", response = HashMap.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully") } )
	@RequestMapping(value = "/time", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> getTimetableTime(){
		return TimetableService.timetableTime;
	}

	@ApiOperation(value = "Get timetable for teacher by teacherId", response = ArrayList.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully") } )
	@RequestMapping(value =  "/teacher/{teacherId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TimetableTeacher> getTeacherTimetable(@ApiParam(value = "Teacher id generated by database", required = true) @PathVariable int teacherId,
													  @ApiParam(value = "Possible values: чисельник, знаменник") @RequestParam(required = false) String position,
													  @RequestParam(required = false) DayOfWeek dayOfWeek){
		return timetableService.getTeacherTimetableById(teacherId, position, dayOfWeek);
	}

	@ApiOperation(value = "Get timetable for group by groupId", response = ArrayList.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully") } )
	@RequestMapping(value =  "/group/{groupId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TimetableGroup> getGroupTimetable(@ApiParam(value = "Group id generated by database", required = true) @PathVariable int groupId,
												  @ApiParam(value = "Possible values: чисельник, знаменник") @RequestParam(required = false) String position,
                                                  @RequestParam(required = false) DayOfWeek dayOfWeek){
		return timetableService.getGroupTimetableById(groupId, position, dayOfWeek);
	}

}
