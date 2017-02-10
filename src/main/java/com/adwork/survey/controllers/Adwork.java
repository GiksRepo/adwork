package com.adwork.survey.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adwork.survey.serviceInterfaces.UserServiceIn;
import com.adwork.survey.viewobject.UserRegistration;

@Controller
public class Adwork 
{
	private static final Logger logger = LoggerFactory.getLogger(Adwork.class);
			
	@Autowired
	private UserServiceIn userServiceImpl;
	
	@RequestMapping(value = "/registartionForm", method = RequestMethod.GET)
	public String getRegistartionForm(ModelMap model)
	{
		UserRegistration userRegistration = new UserRegistration();
		model.addAttribute("userRegistration", userRegistration);
		return "RegistrationForm";
	}
	
	@RequestMapping(value = "/logins", method = RequestMethod.GET)
	public String getLoginPage()
	{
		return "login";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String getSuccess()
	{
		return "success";
	}
	
	@RequestMapping(value = "/saveRegistartionDetails", method = RequestMethod.POST)
	public String saveRegistrationDetails(@Valid UserRegistration userRegistration,BindingResult result,ModelMap model)
	{
		logger.info("Controller Layer saveRegistrationDetails:");
		try{
			userServiceImpl.saveUserRegistration(userRegistration);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		model.addAttribute("userRegistration", userRegistration);
		if(result.hasErrors())
			//return "redirect:/registartionForm" request redirect all message will be removed from request attribute;
			return "RegistrationForm";
		else
		{
			model.addAttribute("success", "Dear "+userRegistration.getFirstName()+" DOB "+userRegistration.getDateOfBirth());
			boolean flag = userServiceImpl.saveUserRegistration(userRegistration);
			return "success";
		}
		
	}
}
