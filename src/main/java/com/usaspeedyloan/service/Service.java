package com.usaspeedyloan.service;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.usaspeedyloan.model.UserDetails;


public interface Service {

	public String home(UserDetails userDetails);
	public String applyNow(UserDetails userDetails, Model model);
	public String verify(UserDetails userDetails, Model model);
	public ModelAndView faq(UserDetails userDetails);
	public ModelAndView fees(UserDetails userDetails);
	public ModelAndView terms(UserDetails userDetails);
	public ModelAndView privacy(UserDetails userDetails);
	public ModelAndView creditpass(UserDetails userDetails);
	public ModelAndView lenderspass(UserDetails userDetails);
	public String lenders(UserDetails userDetails, Model model);
	public ModelAndView thirdpartywebsites(UserDetails userDetails);
	
}
