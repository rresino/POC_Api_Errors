package com.rresino.genoma.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rresino.genoma.api.log.AsyncLogger;
import com.rresino.genoma.api.log.AsyncScheduleLogger;

@Controller
public class HelloController {

	@Autowired
	AsyncLogger logger;
	
	@Autowired
	AsyncScheduleLogger loggerSchedule;
	
	@RequestMapping("/hello")
	public String getWelcome(ModelAndView model) {
		System.out.println("getWelcome before logger call");
		//logger.logItem("This a async log");
		loggerSchedule.logItem("This a async log");
		System.out.println("getWelcome after logger call");
		
		return "hello";
	}
	
}
