package com.adwork.survey.services;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UtilityService 
{
	private static final Logger logger = LoggerFactory.getLogger(UtilityService.class);
	
	public Map<String, String> getCountryList()
	{
		logger.info("getCountryList");
		Map<String,String> country = new LinkedHashMap<String,String>();
		country.put("INDIA", "India");
		country.put("NEPAL", "Nepal");
		country.put("BHUTAN", "Bhutan");
		
		return country;
	}
	
	public Map<String, String> getStateList()
	{
		logger.info("getStateList");
		Map<String,String> state = new LinkedHashMap<String,String>();
		state.put("UTTARAKHAND", "Uttarakhand");
		state.put("UTTARPRADESH", "Uttar Pradesh");
		
		return state;
	}
	
	public Map<String, String> getCityList()
	{
		logger.info("getCityList");
		Map<String,String> city = new LinkedHashMap<String,String>();
		city.put("DEHRADUN", "Dehra Dun");
		city.put("HARIDWAR", "Haridwar");
		
		return city;
	}
}
