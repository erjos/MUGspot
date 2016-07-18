package com.group.mugspot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//cannot name this "controller"
public class MugController{
	String message = "Thank you for visiting";
	String order = "44672";
	 
	@RequestMapping("/welcome")
	public ModelAndView showMessage(){
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("message", message);
		
		return mv;
	}

	@RequestMapping("/receipt")
	public ModelAndView showReceipt(){
 
		ModelAndView mv = new ModelAndView("receipt");
		mv.addObject("order", order);
		return mv;
	}

}
