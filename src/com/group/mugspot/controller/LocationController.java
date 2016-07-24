package com.group.mugspot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		
		boolean cities = DAO.doesCityExist(placeID);
		
		String message = null;
		ModelAndView mv = null;
		
		if (cities == true){
			message = "Sorry, this location already exists on MUGspot!";
			mv = new ModelAndView("createLocation");
			mv.addObject("exists", message);
			return mv;
		} else{
			//Before all this - need to call a method that adds the new city into the database
			//will need to include city name and place_ID
			mv = new ModelAndView("shopLocationSearch");
			ArrayList<Map> shops = GooglePlaces.getShopsByCityID(city, state);
			mv.addObject("shops", shops);
		}
		return mv;
	}
	
	@RequestMapping("/newShop")
	public ModelAndView createNewShopProfile(@RequestParam("name")String name, @RequestParam("place_id")String placeID){
		ModelAndView mv = new ModelAndView("newShop");
		mv.addObject("name", name);
		mv.addObject("place_id", placeID);
		return mv;
	}
}
