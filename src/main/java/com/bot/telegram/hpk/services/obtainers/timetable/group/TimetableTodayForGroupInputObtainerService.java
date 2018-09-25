package com.bot.telegram.hpk.services.obtainers.timetable.group;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;

import com.bot.telegram.hpk.component.enums.FlagForDay;
import com.bot.telegram.hpk.services.obtainers.IObtainer;
import com.bot.telegram.hpk.services.output.TimetableGroupService;

@Service
public class TimetableTodayForGroupInputObtainerService implements IObtainer {

	@Override
	public String obtainMessage(String command) {
		TimetableGroupService.FLAG = FlagForDay.TODAY.toString();
		command = "Введіть назву групи:";
		return command;
	}

	@Override
	public ReplyKeyboardMarkup obtainReplyKeyboardMarkup() {
		return null;
	}

}