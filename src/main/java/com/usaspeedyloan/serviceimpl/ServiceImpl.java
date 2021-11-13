package com.usaspeedyloan.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

import com.usaspeedyloan.model.CodeList;
import com.usaspeedyloan.model.ErrorMessage;
import com.usaspeedyloan.model.LenderWebsite;
import com.usaspeedyloan.model.ThirdPartyWebsites;
import com.usaspeedyloan.model.UserDetails;
import com.usaspeedyloan.model.WebSiteResponse;
import com.usaspeedyloan.repository.CodeRepository;
import com.usaspeedyloan.repository.LendersRepository;
import com.usaspeedyloan.repository.Repository;
import com.usaspeedyloan.repository.ThirdWebRepository;
import com.usaspeedyloan.service.Service;

@Component
public class ServiceImpl implements  Service{
	
	@Autowired
	protected Repository repo;
	
	@Autowired
	ThirdWebRepository thirdWebRepo;
	
	@Autowired
	LendersRepository lendersRepo;
	
	@Autowired
	CodeRepository codeRepo;

	protected ErrorMessage error = new ErrorMessage();
	

	protected ModelAndView mv = new ModelAndView();

	
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
	Date date = new Date();  
	
	@Override
	public String home(UserDetails userDetails) {
		
		return "home";
	}
	
	@Override
	public String applyNow(UserDetails userDetails, Model model) {
	
	Long count = repo.count();	
	System.out.println(count);
	String fullName = userDetails.getFullName();
	String email = userDetails.getEmailAddress();
	String phone = userDetails.getPhoneNumber();
	String loan = userDetails.getLoanAmount();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
	Date date = new Date();  
	UserDetails userDetails1 = repo.findByEmail(email);
	
	if(fullName==null || email==null || phone==null || loan==null )
	{
		error.setErrorMessage("Please fill all the fields");
		model.addAttribute("error",error);
		model.addAttribute("userDetails",userDetails);
		return "home";
	}else {
		if(userDetails1==null) 
		{
			userDetails.setCaseId(Long.toString(count+1));
			userDetails.setAppliedDate((String)formatter.format(date));
			userDetails.setStatus("Pending");
			repo.save(userDetails);
			model.addAttribute(userDetails);
			return "registered";
		}else{
			userDetails = userDetails1;
			model.addAttribute("userDetails",userDetails);
			return "registeredUser";
		}
	}
	}
	@Override
	public String verify(UserDetails userDetails, Model model) {
		List<UserDetails> userInfo = repo.findByAuthorizationCode(userDetails.getAuthorizationCode());
		error.setErrorMessage(null);
		if(userInfo.isEmpty())
		{
			error.setErrorMessage("Invalid Auithorization Code");
			model.addAttribute(error);
			return "creditpass";
		}else 
		{
			List<CodeList> codeUsageUpdate = codeRepo.findByauthorizationCode(userDetails.getAuthorizationCode());
			for(CodeList a : codeUsageUpdate)
			{for(int i=0;i<=0;i++)
				{
				if(i==1) {
					break;
					}
				a.setUsages(a.getUsages()+1);
				a.setAppliedDate((String)formatter.format(date));
				codeRepo.save(a);
				}
			}
			List<ThirdPartyWebsites> activeWebsites = thirdWebRepo.findByStatus("Active");
			model.addAttribute("active",baseToImage(activeWebsites));
			return "website";
		}
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

	@Override
	public ModelAndView faq(UserDetails userDetails) {
		mv.setViewName("faq");
		return mv;
	}

	@Override
	public ModelAndView fees(UserDetails userDetails) {
		mv.setViewName("fees");
		return mv;
	}

	@Override
	public ModelAndView terms(UserDetails userDetails) {
		mv.setViewName("terms");
		return mv;
	}

	@Override
	public ModelAndView privacy(UserDetails userDetails) {
		mv.setViewName("privacy");
		return mv;
	}

	@Override
	public ModelAndView creditpass(UserDetails userDetails) {
		mv.setViewName("creditpass");
		return mv;
	}
	
	@Override
	public String lenders(UserDetails userDetails,Model model) {
		
		List<UserDetails> userInfo = repo.findByAuthorizationCode(userDetails.getAuthorizationCode());
		error.setErrorMessage(null);
		if(userInfo.isEmpty())
		{
			error.setErrorMessage("Invalid Auithorization Code");
			model.addAttribute(error);
			return "lenderspass";
		}else 
		{
			List<CodeList> codeUsageUpdate = codeRepo.findByauthorizationCode(userDetails.getAuthorizationCode());
			for(CodeList a : codeUsageUpdate)
			{for(int i=0;i<=0;i++)
				{
				if(i==1) {
					break;
					}
				a.setUsages(a.getUsages()+1);
				a.setAppliedDate((String)formatter.format(date));
				codeRepo.save(a);
				}
			}
			List<LenderWebsite> activeWebsites = lendersRepo.findByStatus("Active");
			model.addAttribute("active",baseToImageLender(activeWebsites));
			return "lenders";
		}
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

	@Override
	public ModelAndView thirdpartywebsites(UserDetails userDetails) {
		mv.setViewName("website");
		return mv;
	}

	@Override
	public ModelAndView lenderspass(UserDetails userDetails) {
		mv.setViewName("lenderspass");
		return mv;
	}
	
}
