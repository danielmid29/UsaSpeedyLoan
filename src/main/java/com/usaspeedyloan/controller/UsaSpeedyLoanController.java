package com.usaspeedyloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.usaspeedyloan.model.UserDetails;
import com.usaspeedyloan.repository.Repository;
import com.usaspeedyloan.service.Service;

@Controller

public class UsaSpeedyLoanController {
	
	@Autowired
	Repository repo;
	
	@Autowired
	Service service;

	@RequestMapping("/")
	public String homeController(UserDetails userDetails) {
		return service.home(userDetails);
	}
	
	@RequestMapping("/verification")
	public String applyNow(UserDetails userDetails, Model model) {
		return service.applyNow(userDetails, model);	
	}
	
	@RequestMapping("/thirdPartyWebsites")
	public String verify(UserDetails userDetails, Model model) {
		return service.verify(userDetails, model);	
	}
	
	@RequestMapping("/faq")
	public ModelAndView faq(UserDetails userDetails) {
		return service.faq(userDetails);	
	}
	
	@RequestMapping("/fees")
	public ModelAndView fees(UserDetails userDetails) {
		return service.fees(userDetails);	
	}
	
	@RequestMapping("/terms")
	public ModelAndView terms(UserDetails userDetails) {
		return service.terms(userDetails);	
	}
	
	@RequestMapping("/privacy")
	public ModelAndView privacy(UserDetails userDetails) {
		return service.privacy(userDetails);	
	}
	
	@RequestMapping("/creditpass")
	public ModelAndView creditpass(UserDetails userDetails) {
		return service.creditpass(userDetails);	
	}
	
	@RequestMapping("/lenderspass")
	public ModelAndView lenderspass(UserDetails userDetails) {
		return service.lenderspass(userDetails);	
	}
	
	@RequestMapping("/lenders")
	public String lenders(UserDetails userDetails,Model model) {
		return service.lenders(userDetails, model);	
	}
	
}
