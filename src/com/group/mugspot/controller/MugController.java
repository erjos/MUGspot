package com.group.mugspot.controller;

import java.io.IOException;

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
		


		String phone = GooglePlaces.getInfo("ChIJtzwfLTItO4gRxwpKgcgFomE");
		ModelAndView mv = new ModelAndView("shops");
		mv.addObject("message", phone);
		
		return mv;
	}

}
