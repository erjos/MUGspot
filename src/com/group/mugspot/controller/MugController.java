package com.group.mugspot.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//cannot name this "controller"
public class MugController{
	
	
	 
	@RequestMapping("/shops")
	//need to add try catch for these exceptions - 
	public ModelAndView showMessage() throws ClientProtocolException, IOException, ParseException{
		
		ArrayList<String> info = DAO.getInfo();
		String name = info.get(0);
		String description = info.get(1);
		String menu = info.get(2);
		String outlets = info.get(3);
		String capacity = info.get(4);
		String phone = info.get(7);
		String address = info.get(8);
		String budget = info.get(6);
		
		//is there a way to iterate through an arraylist in spring - to reflect dynamic amounts of information being passed from the controller
		ModelAndView mv = new ModelAndView("shops");
		mv.addObject("name", name);
		mv.addObject("description", description);
		mv.addObject("menu", menu);
		mv.addObject("outlets", outlets);
		mv.addObject("capacity", capacity);
		mv.addObject("phone", phone);
		mv.addObject("address", address);
		mv.addObject("budget", budget);
		
		
		return mv;
	}

}
