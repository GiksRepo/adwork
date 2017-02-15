package com.adwork.survey.controllers;

import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adwork.survey.serviceInterfaces.UserServiceIn;
import com.adwork.survey.services.UtilityService;
import com.adwork.survey.viewobject.UserRegistration;

@Controller
public class AdworkController 
{
	private static final Logger logger = LoggerFactory.getLogger(AdworkController.class);
			
	@Autowired
	private UserServiceIn userServiceImpl;
	
	@Autowired
	private UtilityService utilityService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) 
	{
		/*logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );*/
		model.addAttribute("curl", "home");
		return "Home";
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin(@RequestParam(value = "error", required = false) String error, Model model)
	{
		if(error !=null)
			model.addAttribute("error", "Authentication Failure.Enter correct credential.");
			
		model.addAttribute("curl", "signin");
		return "Signin";
	}
	
	@RequestMapping(value = "/registartion", method = RequestMethod.GET)
	public String getRegistartionForm(ModelMap model)
	{
		Map<String,String> country = utilityService.getCountryList();
		
		/*Map<String,String> city = utilityService.getCityList();*/
		UserRegistration userRegistration = new UserRegistration();
		userRegistration.setCountriesList(country);
		userRegistration.setGender("Male");
		model.addAttribute("userRegistration", userRegistration);
		/*model.addAttribute("country",country);
		model.addAttribute("state",state);
		model.addAttribute("city",city);*/
		model.addAttribute("curl", "signin");
		return "Registration";
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
	
	@RequestMapping(value = "/getStates", method = RequestMethod.POST)
	public @ResponseBody Map<String,String> getStateList(@RequestParam(value ="countryId") String countryId)
	{
		logger.info("country Id :"+countryId);
		Map<String,String> states = utilityService.getStateList();
		return states;
	}
}
