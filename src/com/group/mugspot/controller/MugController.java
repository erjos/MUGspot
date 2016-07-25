package com.group.mugspot.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
// cannot name this "controller"
public class MugController {
	
	@RequestMapping("/shops")
	// need to add try catch for these exceptions -
	public ModelAndView showMessage(@RequestParam("City") Integer City) throws ClientProtocolException, IOException, ParseException {
		//takes the cityID from the form as a Parameter
		ArrayList<Map> info = DAO.getInfo(City);
		ModelAndView mv = new ModelAndView("shops");
		mv.addObject("shop", info);
		mv.addObject("cityID", City);
		//could add an object the reps city ID then call getCityName and drop it into the 
		return mv;
	}
	@RequestMapping("/shopProfile")
	// need to add try catch for these exceptions -
	public ModelAndView test(@RequestParam("id")String id) throws ClientProtocolException, IOException, ParseException {
		System.out.println("shop profile id="+id);
		Map info = DAO.getInfoById(id);
		ModelAndView mv = new ModelAndView("shopProfile");
		mv.addObject("shopProfile", info);
		return mv;
	}
}
