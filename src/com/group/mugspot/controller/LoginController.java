package com.group.mugspot.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("/createLogin")
    public ModelAndView createLogin(@CookieValue(value = "userID", defaultValue = "null") String loggedIn, HttpServletResponse response) {
		
		if (!(loggedIn.equals("null"))){
			return new ModelAndView("memberArea");
		}
        return new ModelAndView("adminLogin", "command", new Users());
    }

	@RequestMapping("/submitLogin")
		public String submitLogin(@ModelAttribute("command") Users user, Model model,
				 HttpServletResponse response) {

		if (DAO.checkLogin(user)) {
			String userID = DAO.getUserID(user)+"";
			Cookie uID = new Cookie("userID" , userID);
			//cookie.setMaxAge(60);
			//uID.setMaxAge(0);
			
			response.addCookie(uID);
			/*model.addAttribute("cookie", cookie);
			model.addAttribute("userID", uID);
*/
			return "memberArea";

		} else {
			if (DAO.containsUser(user))
				model.addAttribute("passError", "Password is incorrect.");
			else
				model.addAttribute("userError", "User doesn't exist.");

			return "adminLogin";
		}	
	}
	//the "command" keyword is particular to spring, which populates the paramters based on an object bean
	
	@RequestMapping("/logout")
	public ModelAndView accessLogout(@CookieValue("userID") Cookie userID, HttpServletResponse response){
		
		if(!(userID.getValue().equals("null"))){
			userID.setMaxAge(0);
			//loggedIn.setValue("false");
			response.addCookie(userID);
	}
		return new ModelAndView("logout");
	}
	
	@RequestMapping("/userSignUp")
	public ModelAndView userSignUp(){
		ModelAndView mv = new ModelAndView("userSignUp");
		return mv;
	}
	
	@RequestMapping("/addUser")
	public ModelAndView newUser(@RequestParam("fullname")String fullname, @RequestParam("password")String password, @RequestParam("email")String email, HttpServletResponse response){
		Users p = new Users(fullname,password,email);
		DAO.addUser(p);
		String userID = DAO.getUserID(p)+"";
		Cookie uID = new Cookie("userID" , userID);
		response.addCookie(uID);
		
		ModelAndView mv = new ModelAndView("memberArea");
		String message= "You created an account";
		mv.addObject("userConfirmation",message);
		return mv;
		
	}
	
}