package com.usaspeedyloan.admin.controller;

import java.io.File;
import java.io.IOException;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.usaspeedyloan.admin.service.AdminService;
import com.usaspeedyloan.model.CodeList;
import com.usaspeedyloan.model.ThirdPartyWebsites;
import com.usaspeedyloan.model.UserCreds;
import com.usaspeedyloan.model.WebSiteResponse;
import com.usaspeedyloan.model.UserDetails;
import com.usaspeedyloan.model.WebSiteRequest;

@Controller
public class AdminController {

	@Autowired
	AdminService service;
	
	
	@RequestMapping("/login")
	public String login(Model model, UserCreds request) {		
		return service.login(model, request);
	}
	
	@RequestMapping("/crm-admin")
	public String admin(Model model) {		
		return service.admin(model);
	}
	
	
	
	@RequestMapping("/crm-admin/dashboard")
	public String dashboard(Model model) {		
		return service.dashboard(model);
	}
	
	@RequestMapping("/admin")
	public ModelAndView homeController(UserDetails userDetails) {
		return service.home(userDetails);
	}
	
	@RequestMapping("/crm-admin/users")
	public String users(Model model, UserDetails userDetails) {
		service.users(model);
		return "users";
	}
	
	@RequestMapping("/crm-admin/updateUsers")
	public String updateUsers(Model model, UserDetails userDetails) {		
		return service.updateUsers(model, userDetails);
	}
	
	@RequestMapping("/crm-admin/deleteUsers")
	public String deleteUsers(Model model, UserDetails userDetails) {		
		return service.deleteUsers(model, userDetails);
	}
	
	@RequestMapping("/crm-admin/authorizecodelist")
	public String codeList(Model model) {
		return service.codeList(model);
	}
	
	@RequestMapping("/crm-admin/addAuthorizationCode")
	public String codeList(Model model, CodeList codeList) {
		return service.addCode(model, codeList);
	}
	
	@RequestMapping("/crm-admin/deactivateCode")
	public String deactivateCode(Model model, CodeList codeList) {
		return service.deactivateCode(model, codeList);
	}
	
	@RequestMapping("crm-admin/usagehistory")
	public String usagehistory(Model model) {
		return service.usagehistory(model);
	}
	
	@RequestMapping("crm-admin/thirdpartywebsites")
	public String thirdpartywebsites(Model model) {
		return service.thirdpartywebsites(model);		
	}
	
	@RequestMapping("crm-admin/addthirdpartyurl")
	public String addthirdpartyurl(Model model,WebSiteRequest request) throws IOException {
		return service.addthirdpartyurl(model, request);
	}
	
	@RequestMapping("crm-admin/updatethirdpartyurl")
	public String updatethirdpartyurl(Model model,WebSiteRequest request) throws IOException {
		return service.updatethirdpartyurl(model, request);
	}
	
	@RequestMapping("crm-admin/deletethirdpartyurl")
	public String deletethirdpartyurl(Model model,WebSiteRequest deleteRequest) throws IOException {
		return service.deletethirdpartyurl(model, deleteRequest);
	}
	
	@RequestMapping("crm-admin/lenderswebsites")
	public String lenderswebsites(Model model) {
		return service.lenderswebsites(model);		
	}
	
	@RequestMapping("crm-admin/addlenders")
	public String addlenders(Model model,WebSiteRequest request) throws IOException {
		return service.addlenders(model, request);
	}
	
	@RequestMapping("crm-admin/updatelenders")
	public String updatelenders(Model model,WebSiteRequest request) throws IOException {
		return service.updatelenders(model, request);
	}
	
	@RequestMapping("crm-admin/deletelenders")
	public String deletelenders(Model model,WebSiteRequest deleteRequest) throws IOException {
		return service.deletelenders(model, deleteRequest);
	}
}
