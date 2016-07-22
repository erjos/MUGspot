package com.group.mugspot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LocationController {

	@RequestMapping("/location")
	public ModelAndView showMessage(){
		
		ModelAndView mv = new ModelAndView("location");
		return mv;
	}
	
	@RequestMapping("/createLocation")
	public ModelAndView createLocation(@RequestParam("city")String city){
		ModelAndView mv = new ModelAndView("createLocation", "city", city);
		return mv;
	}
	
}
