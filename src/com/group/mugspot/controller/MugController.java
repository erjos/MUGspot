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
<<<<<<< HEAD
		String phone = info.get(1);
		String address = info.get(2);
		String icon = info.get(3);

=======
		String description = info.get(1);
		String menu = info.get(2);
		String outlets = info.get(3);
		String capacity = info.get(4);
		String tables = info.get(5);
		String phone = info.get(6);
		String address = info.get(7);
>>>>>>> a7c896c773d3f6b8dcc3f9e4cffc96ef2039d8eb
		
		//is there a way to iterate through an arraylist in spring - to reflect dynamic amounts of information being passed from the controller
		ModelAndView mv = new ModelAndView("shops");
		mv.addObject("name", name);
		mv.addObject("description", description);
		mv.addObject("menu", menu);
		mv.addObject("outlets", outlets);
		mv.addObject("capacity", capacity);
		mv.addObject("tables", tables);
		mv.addObject("phone", phone);
		mv.addObject("address", address);
		mv.addObject("icon", icon);

		
		
		return mv;
	}

}
