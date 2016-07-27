package com.group.mugspot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import antlr.collections.List;

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
	public ModelAndView test(@RequestParam("id") String id)
			throws ClientProtocolException, IOException, ParseException {
		System.out.println("shop profile id=" + id);
		Map info = DAO.getInfoById(id);
		ModelAndView mv = new ModelAndView("shopProfile");
		mv.addObject("shopProfile", info);
		return mv;
	}


	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ModelAndView addReview(@ModelAttribute("reviews") Reviews reviews, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView model = new ModelAndView("reviews");
			return model;
		} 
		    
		    DAO.addReview(reviews);
			return new ModelAndView("success", "message", "Thank you! Your review has been recorded!");

		}


	@RequestMapping(value="/Review", method = RequestMethod.GET)
    public ModelAndView reviews(@RequestParam("shopid") int shop_id){
		/*@RequestParam("see") int shop_id*/
        ModelAndView rv = new ModelAndView("Review");    
        
        rv.addObject("reviews", DAO.getReviews(shop_id));
       
        return rv;
        
    }
	
	@RequestMapping(value="/reviews")
	public ModelAndView reviewForm(@CookieValue("userID") String usID, HttpServletResponse response, @RequestParam("shopid") int shop_id){
		if (!(usID.equals("null"))){
			ModelAndView mv = new ModelAndView("reviews");
			mv.addObject("user_id", usID);
			mv.addObject("shop_id", shop_id);
			return mv;
		}
        return new ModelAndView("adminLogin", "command", new Users());
	}

}

