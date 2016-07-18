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
	
	String message = "Thank you for visiting";
	String order = "44672";
	
	
	 
	@RequestMapping("/shops")
	public ModelAndView showMessage() throws ClientProtocolException, IOException, ParseException{
		
		
		ArrayList<String> info = GooglePlaces.getInfo("ChIJtzwfLTItO4gRxwpKgcgFomE");
		String name = info.get(0);
		String phone = info.get(1);
		String address = info.get(2);
		
		ModelAndView mv = new ModelAndView("shops");
		mv.addObject("name", name);
		mv.addObject("phone", phone);
		mv.addObject("address", address);
		
		return mv;
	}

}
