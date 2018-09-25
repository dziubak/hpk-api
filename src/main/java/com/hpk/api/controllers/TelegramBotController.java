package com.hpk.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bot")
public class TelegramBotController {

	@RequestMapping(value = "/run", method = RequestMethod.GET)
	public String runBot() {
		return "Telegram bot start.";
	}

}
