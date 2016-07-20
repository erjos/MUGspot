package com.group.mugspot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

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
		
<<<<<<< HEAD
		ArrayList<String> info = DAO.getInfo();
		String icon = info.get(0);
//		String phone = info.get(1);
//		String address = info.get(2);
		String name = info.get(1);

		String description = info.get(2);
		String menu = info.get(3);
		String outlets = info.get(4);
		String capacity = info.get(5);
		String phone = info.get(6);
		String address = info.get(7);
		String budget = info.get(8);
		
=======
		//This array is populated with any data in the coffee shop DB, not specific to each coffee shop
		ArrayList<Map> info = DAO.getInfo();
		
		/*String name = info.get(0);
		String description = info.get(1);
		String menu = info.get(2);
		String outlets = info.get(3);
		String capacity = info.get(4);
		String tables = info.get(5);
		String phone = info.get(6);
		String address = info.get(7);*/
>>>>>>> 8c9fd2e98ef1d5a4d1b41f28cf9fae78b777c0ac
		
		ModelAndView mv = new ModelAndView("shops");
<<<<<<< HEAD
		mv.addObject("icon", icon);
		mv.addObject("name", name);
		mv.addObject("description", description);
=======
		mv.addObject("shop", info);
		
		/*mv.addObject("description", description);
>>>>>>> 8c9fd2e98ef1d5a4d1b41f28cf9fae78b777c0ac
		mv.addObject("menu", menu);
		mv.addObject("outlets", outlets);
		mv.addObject("capacity", capacity);
		mv.addObject("phone", phone);
<<<<<<< HEAD
		mv.addObject("address", address);
		mv.addObject("budget", budget);
		

		
=======
		mv.addObject("address", address);*/
>>>>>>> 8c9fd2e98ef1d5a4d1b41f28cf9fae78b777c0ac
		
		return mv;
	}

}
