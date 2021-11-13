package com.usaspeedyloan.admin.service;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.usaspeedyloan.model.CodeList;
import com.usaspeedyloan.model.ThirdPartyWebsites;
import com.usaspeedyloan.model.UserCreds;
import com.usaspeedyloan.model.WebSiteResponse;
import com.usaspeedyloan.model.UserDetails;
import com.usaspeedyloan.model.WebSiteRequest;

public interface AdminService {

	public ModelAndView home(UserDetails userDetails);
	public String users(Model model);
	public String codeList(Model model);
	public String addCode(Model model,CodeList codeList);
	public String deactivateCode(Model model,CodeList codeList);
	public String addthirdpartyurl(Model model,WebSiteRequest request);
	public String updatethirdpartyurl(Model model,WebSiteRequest request);
	public String deletethirdpartyurl(Model model,WebSiteRequest request);
	public String thirdpartywebsites(Model model);
	public String addlenders(Model model,WebSiteRequest request);
	public String updatelenders(Model model,WebSiteRequest request);
	public String deletelenders(Model model,WebSiteRequest request);
	public String lenderswebsites(Model model);
	public String usagehistory(Model model);
	public String updateUsers(Model model, UserDetails userDetails);
	public String deleteUsers(Model model, UserDetails userDetails);
	public String dashboard(Model model);
	public String login(Model model, UserCreds request);
	public String admin(Model model);
	
}
