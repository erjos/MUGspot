package com.group.mugspot.controller;

import java.util.List;

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
	//first creating the model and view method with 2 arguments using the requestParam arguments from the jsp
	public ModelAndView createLocation(@RequestParam("city")String city, @RequestParam("state")String state){
		//taking the strings for city and state and replacing spaces with a + so that when plugged into google the URL doesnt break
		city = city.replaceAll(" ", "+");
		state = state.replaceAll(" ", "+");
		
		//retrieving the placeID of the search from Google
		String placeID = GooglePlaces.getCityPlaceID(city, state);
		
		//checking if the cityID already exists in the database
		//boolean cityExist = DAO.doesCityExist(placeID);
		
		boolean cities = DAO.getCity(placeID);
		
		ModelAndView mv = new ModelAndView("createLocation", "city", city);
		mv.addObject("state", state);
		mv.addObject("placeID", placeID);
		mv.addObject("exists", cities);
		return mv;
	}
	
}
