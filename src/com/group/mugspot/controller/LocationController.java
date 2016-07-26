package com.group.mugspot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
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
		String searchCity = city.replaceAll(" ", "+");
		String searchState = state.replaceAll(" ", "+");
		
		//retrieving the placeID of the search from Google
		String placeID = GooglePlaces.getCityPlaceID(searchCity, searchState);
		
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
			//first creating a newCity object based on the name and placeID
			City newCity = new City(city, placeID);
			//Calling the DAO to try to add the new city into the database
			DAO.addCity(newCity);
			mv = new ModelAndView("shopLocationSearch");
			ArrayList<Map> shops = GooglePlaces.getShopsByCityID(searchCity, searchState);
			int city_id = DAO.getCityID(placeID);
			mv.addObject("shops", shops);
			mv.addObject("city_id", city_id);
		}
		return mv;
	}
	
	@RequestMapping("/newShop")
	public ModelAndView shopProfileForm(@RequestParam("name")String name, @RequestParam("place_id")String placeID, @RequestParam("city_id")int city_id){
		ModelAndView mv = new ModelAndView("newShop");
		mv.addObject("name", name);
		mv.addObject("place_id", placeID);
		mv.addObject("city_id", city_id);
		return mv;
	}
	
	@RequestMapping("/shopLocationSearch")
	public ModelAndView createNewShop(@RequestParam("cityID")Integer city_id, @CookieValue(value = "userID", defaultValue = "null") String loggedIn){
		if (!(loggedIn.equals("null"))){
		Map cityInfo = new HashMap();
		cityInfo = DAO.getCurrentCity(city_id);
		String city = (String) cityInfo.get("name");
		//String placeID = (String) cityInfo.get("placeID"); -- Dont need this unless we modify the search from text
		//This search requires the state - hardcoding Michigan in for now
		String state = "MI";
		ModelAndView mv = new ModelAndView("shopLocationSearch");
		String searchCity = city.replaceAll(" ", "+");
		String searchState = state.replaceAll(" ", "+");
		ArrayList<Map> shops = GooglePlaces.getShopsByCityID(searchCity, searchState);
		
		mv.addObject("shops", shops);
		mv.addObject("city_id", city_id);
		return mv;
		}

        return new ModelAndView("adminLogin", "command", new Users());
	}
	
}