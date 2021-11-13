package com.usaspeedyloan.admin.seviceimpl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.usaspeedyloan.admin.service.AdminService;
import com.usaspeedyloan.model.CodeList;
import com.usaspeedyloan.model.Extras;
import com.usaspeedyloan.model.ErrorMessage;
import com.usaspeedyloan.model.LenderWebsite;
import com.usaspeedyloan.model.ThirdPartyWebsites;
import com.usaspeedyloan.model.UserCreds;
import com.usaspeedyloan.model.WebSiteResponse;
import com.usaspeedyloan.model.UserDetails;
import com.usaspeedyloan.model.WebSiteRequest;
import com.usaspeedyloan.repository.CodeRepository;
import com.usaspeedyloan.repository.LendersRepository;
import com.usaspeedyloan.repository.Repository;
import com.usaspeedyloan.repository.ThirdWebRepository;

@Component
public class AdminServiceImpl implements AdminService {

	ModelAndView mv = new ModelAndView();
	
	@Autowired
	Repository userRepo;
	
	@Autowired
	CodeRepository codeRepo;
	
	@Autowired
	ThirdWebRepository thirdWebRepo;
	
	@Autowired
	LendersRepository lendersRepo;
	
	ErrorMessage error = new ErrorMessage();
	
	@Override
	public ModelAndView home(UserDetails userDetails) {
		
		return null;
	}

	@Override
	public String users(Model model) {
		model.addAttribute("inactive", userRepo.findByStatus("Pending"));
		model.addAttribute("active", userRepo.findByStatus("Approved"));
		model.addAttribute("cactive", codeRepo.findByStatus("Active"));
		return "users";
	}
	
	@Override
	public String updateUsers(Model model, UserDetails userDetails) {
		List<UserDetails> userByMail = userRepo.findByCaseId(userDetails.getCaseId());
		
		for(UserDetails a : userByMail)
			{for(int i=0;i<=0;i++)
				{
				if(i==1) {
					break;
					}			
				if(userDetails.getStatus()!=null) {
				a.setStatus(userDetails.getStatus());
				}
				
				a.setAuthorizationCode(userDetails.getAuthorizationCode());
				userRepo.save(a);
				}
			}		return "redirect:/crm-admin/users";
	}
	
	@Override
	public String deleteUsers(Model model, UserDetails userDetails) {
		userRepo.deleteAll(userRepo.findByCaseId(userDetails.getCaseId()));
		return "redirect:/crm-admin/users";
	}

	@Override
	public String codeList(Model model) {
		model.addAttribute("active", codeRepo.findByStatus("Active"));
		model.addAttribute("inactive", codeRepo.findByStatus("In-active"));
		return "codelist";
	}

	@Override
	public String addCode(Model model, CodeList codeList) {
		codeList.setStatus("Active");
		codeList.setUsages(0);
		List<CodeList> codePresent = codeRepo.findByauthorizationCode(codeList.getAuthorizationCode());
		if(codePresent.isEmpty())
		{
		codeRepo.save(codeList);		
		}else
		{
			error.setErrorMessage("Code Already Existing");
			model.addAttribute("error",error);
		}
		model.addAttribute("active", codeRepo.findByStatus("Active"));
		model.addAttribute("inactive", codeRepo.findByStatus("In-active"));
		return "codelist";
	}

	@Override
	public String deactivateCode(Model model, CodeList codeList) {
		List<CodeList> codeList1 = codeRepo.findByauthorizationCode(codeList.getAuthorizationCode());
		for(CodeList a : codeList1)
			{for(int i=0;i<=0;i++)
				{
				if(i==1) {
					break;
					}				
				a.setStatus("In-active");
				codeRepo.save(a);
				}
			}
	   
		model.addAttribute("active", codeRepo.findByStatus("Active"));
		model.addAttribute("inactive", codeRepo.findByStatus("In-active"));
		return "codelist";
	}
	
	@Override
	public String usagehistory(Model model) {
		model.addAttribute("active", codeRepo.findByNotZero(0));
		
		return "usagehistory";
	}

	@Override
	public String addthirdpartyurl(Model model, WebSiteRequest request) {
		if(request.getWebUrl() != null)
		{
		List<ThirdPartyWebsites> webPresent = thirdWebRepo.findByWebUrl(request.getWebUrl());
		ThirdPartyWebsites thirdPartyWebsites = new ThirdPartyWebsites();
		if(webPresent.isEmpty()) {
		thirdPartyWebsites.setWebUrl(request.getWebUrl());
		Long count = thirdWebRepo.count();
		Long websiteId = webIdThirdParty(count);
		thirdPartyWebsites.setWebId(websiteId);
		try {
			thirdPartyWebsites.setWebImage(new Binary(request.getWebImage().getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		thirdPartyWebsites.setStatus("Active");
		thirdWebRepo.save(thirdPartyWebsites);
		return "redirect:/crm-admin/thirdpartywebsites";
		}else {
			error.setErrorMessage("Url Already Existing");
			model.addAttribute("error",error);
			List<ThirdPartyWebsites> activeWebsites = thirdWebRepo.findByStatus("Active");
			List<ThirdPartyWebsites> inActiveWebsites = thirdWebRepo.findByStatus("Inactive");
			model.addAttribute("active",baseToImage(activeWebsites));
			model.addAttribute("inactive",baseToImage(inActiveWebsites));
			return "thirdpartywebsite";
			}
		}else {
			return "redirect:/crm-admin/thirdpartywebsites";
		}
	}

	@Override
	public String thirdpartywebsites(Model model) {
		
		List<ThirdPartyWebsites> activeWebsites = thirdWebRepo.findByStatus("Active");
		List<ThirdPartyWebsites> inActiveWebsites = thirdWebRepo.findByStatus("Inactive");
		model.addAttribute("active",baseToImage(activeWebsites));
		model.addAttribute("inactive",baseToImage(inActiveWebsites));
		return "thirdpartywebsite";
	}
	
	public List<WebSiteResponse> baseToImage(List<ThirdPartyWebsites> websites){
		List<WebSiteResponse> baseToImageResponse = new ArrayList<>();
		for (ThirdPartyWebsites bti : websites) {
			WebSiteResponse baseToImageInLoop = new WebSiteResponse();
			System.out.println(bti.getWebImage().getData());
			baseToImageInLoop.setWebImage(Base64.getEncoder().encodeToString(bti.getWebImage().getData()));
			baseToImageInLoop.setStatus(bti.getStatus());
			baseToImageInLoop.setWebId(bti.getWebId());
			baseToImageInLoop.setWebUrl(bti.getWebUrl());
			baseToImageResponse.add(baseToImageInLoop);
		}
		return baseToImageResponse;		
	}
	
	public Long webIdThirdParty(Long count) {
		{
			
			List<ThirdPartyWebsites> present = thirdWebRepo.findByWebId(count);
			if(present.isEmpty()) {
				return count;
			}else {
			webIdThirdParty(count+1);}
			}
		return null;
		
	}

	@Override
	public String updatethirdpartyurl(Model model, WebSiteRequest request) {
		
		List<ThirdPartyWebsites> thirdPartyWebsites1= thirdWebRepo.findByWebId(request.getWebId());
		for(ThirdPartyWebsites thirdPartyWebsites : thirdPartyWebsites1)
		{for(int i=0;i<=0;i++)
			{
			if(i==1) {
				break;
				}
			}				
			thirdPartyWebsites.setWebUrl(request.getWebUrl());
			if(!request.getWebImage().isEmpty())
			{
			try {
				thirdPartyWebsites.setWebImage(new Binary(request.getWebImage().getBytes()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
			thirdPartyWebsites.setStatus(request.getStatus());
			thirdWebRepo.save(thirdPartyWebsites);
			
	}
		return "redirect:/crm-admin/thirdpartywebsites";
	}

	@Override
	public String deletethirdpartyurl(Model model, WebSiteRequest request) {
		thirdWebRepo.deleteAll(thirdWebRepo.findByWebId(request.getWebId()));
		return "redirect:/crm-admin/thirdpartywebsites";
	}

	@Override
	public String addlenders(Model model, WebSiteRequest request) {
		if(request.getWebUrl() != null)
		{
		List<LenderWebsite> webPresent = lendersRepo.findByWebUrl(request.getWebUrl());
		if(webPresent.isEmpty())
		{
		LenderWebsite lenderWebsite = new LenderWebsite();
		lenderWebsite.setWebUrl(request.getWebUrl());
		Long count = lendersRepo.count();
		Long websiteId = webIdLender(count);
		lenderWebsite.setWebId(websiteId);
		try {
			lenderWebsite.setWebImage(new Binary(request.getWebImage().getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		lenderWebsite.setStatus("Active");
		lendersRepo.save(lenderWebsite);
		}else{
			error.setErrorMessage("Url Already Existing");
			model.addAttribute("error",error);
			List<LenderWebsite> activeWebsites = lendersRepo.findByStatus("Active");
			List<LenderWebsite> inActiveWebsites = lendersRepo.findByStatus("Inactive");
			model.addAttribute("active",baseToImageLender(activeWebsites));
			model.addAttribute("inactive",baseToImageLender(inActiveWebsites));
			return "adminlenders";
		}}else {
		return "redirect:/crm-admin/lenderswebsites";}
		return "redirect:/crm-admin/lenderswebsites";
	}

	@Override
	public String updatelenders(Model model, WebSiteRequest request) {
		
		List<LenderWebsite> lenderWebsiteList= lendersRepo.findByWebId(request.getWebId());
		for(LenderWebsite lenderwebsite : lenderWebsiteList)
		{for(int i=0;i<=0;i++)
			{
			if(i==1) {
				break;
				}
			}				
			lenderwebsite.setWebUrl(request.getWebUrl());
			if(!request.getWebImage().isEmpty())
			{
			try {
				lenderwebsite.setWebImage(new Binary(request.getWebImage().getBytes()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
			lenderwebsite.setStatus(request.getStatus());
			lendersRepo.save(lenderwebsite);
			
	}
		return "redirect:/crm-admin/lenderswebsites";
	}

	@Override
	public String deletelenders(Model model, WebSiteRequest request) {
		lendersRepo.deleteAll(lendersRepo.findByWebId(request.getWebId()));
		return "redirect:/crm-admin/lenderswebsites";
	}

	@Override
	public String lenderswebsites(Model model) {
		List<LenderWebsite> activeWebsites = lendersRepo.findByStatus("Active");
		List<LenderWebsite> inActiveWebsites = lendersRepo.findByStatus("Inactive");
		model.addAttribute("active",baseToImageLender(activeWebsites));
		model.addAttribute("inactive",baseToImageLender(inActiveWebsites));
		return "adminlenders";
	}
	public List<WebSiteResponse> baseToImageLender(List<LenderWebsite> websites){
		List<WebSiteResponse> baseToImageResponse = new ArrayList<>();
		for (LenderWebsite bti : websites) {
			WebSiteResponse baseToImageInLoop = new WebSiteResponse();
			System.out.println(bti.getWebImage().getData());
			baseToImageInLoop.setWebImage(Base64.getEncoder().encodeToString(bti.getWebImage().getData()));
			baseToImageInLoop.setStatus(bti.getStatus());
			baseToImageInLoop.setWebId(bti.getWebId());
			baseToImageInLoop.setWebUrl(bti.getWebUrl());
			baseToImageResponse.add(baseToImageInLoop);
		}
		return baseToImageResponse;		
	}
	
	public Long webIdLender(Long count) {
		{
			
			List<LenderWebsite> present = lendersRepo.findByWebId(count);
			if(present.isEmpty()) {
				return count;
			}else {
			webIdThirdParty(count+1);}
			}
		return null;
		
	}

	@Override
	public String dashboard(Model model) {
		Extras dashboard = new Extras();
		dashboard.setCodeCount(codeRepo.findByStatus("Active").size());
		dashboard.setUserCount(userRepo.findByStatus("Approved").size());
		dashboard.setWebCount(thirdWebRepo.findAll().size());
		model.addAttribute("dashboard",dashboard);
		return "dashboard";
	}

	@Override
	public String login(Model model, UserCreds request) {
		if(request.getUser().equals("admin")&& request.getPassword().equals("Sunrise@123"))
		{
			return "redirect:/crm-admin/dashboard";
		}else
		{
			error.setErrorMessage("Invalid Username or Password");
			model.addAttribute("error",error);
			return "Login";
		}
	}
	
	@Override
	public String admin(Model model) {
		
			return "Login";
	}

}
