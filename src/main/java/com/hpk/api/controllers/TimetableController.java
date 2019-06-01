package com.hpk.api.controllers;

import com.hpk.api.component.dao.TimetableGroupDao;
import com.hpk.api.component.model.Timetable;
import com.hpk.api.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/timetable")
public class TimetableController {

	@Autowired
	private TimetableGroupDao timetableDao;

	@Autowired
	private TimetableService timetableService;

	@RequestMapping(method = RequestMethod.GET, value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	List<Timetable> getListWithTimetable() {
		List<Timetable> u = timetableDao.getTimetableGeneralForGroup("ПР-151");
		return u;
	}

	@RequestMapping(value = "/time", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> getTimetableTime(){
		return TimetableService.timetableTime;
	}

	@RequestMapping(value =  "/teacher/{teacherId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Timetable> getTeacherTimetable(@PathVariable int teacherId,
											   @RequestParam(required = false) String position,
											   @RequestParam(required = false) DayOfWeek dayOfWeek){
		return timetableService.getTeacherTimetableById(teacherId, position, dayOfWeek);
	}

	@RequestMapping(value =  "/group/{groupId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Timetable> getGroupTimetable(@PathVariable int groupId,
											   @RequestParam(required = false) String position,
											   @RequestParam(required = false) DayOfWeek dayOfWeek){
		return timetableService.getGroupTimetableById(groupId, position, dayOfWeek);
	}

}
