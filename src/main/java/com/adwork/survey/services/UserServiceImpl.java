package com.adwork.survey.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adwork.survey.commandobject.ContactCO;
import com.adwork.survey.commandobject.PersonCO;
import com.adwork.survey.config.dao.UserAuthDaoImpl;
import com.adwork.survey.daos.WalletDao;
import com.adwork.survey.serviceInterfaces.UserServiceIn;
import com.adwork.survey.viewobject.UserRegistration;


@Service
public class UserServiceImpl implements UserServiceIn
{
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserAuthDaoImpl UserAuthDaoImpl;
	
	@Autowired
	private WalletDao walletDao;
	
	@Override
	public boolean saveUserRegistration(UserRegistration userRegistration) 
	{
		logger.info("Service Layer");
		walletDao.display();
		boolean flag = false;
		
		PersonCO personCO = new PersonCO();
		personCO.setFirstName(userRegistration.getFirstName());
		personCO.setMiddleName(userRegistration.getMiddleName());
		personCO.setLastName(userRegistration.getLastName());
		personCO.setGender(userRegistration.getGender());
		//personCO.setDateOfBirth(java.sql.Date.valueOf(userRegistration.getDateOfBirth()));
		//personCO.setAge(userRegistration.getAge().byteValue());
		try 
		{
			flag = UserAuthDaoImpl.saveUserProfile(personCO);
		} catch (Exception e) 
		{
			logger.info("Error Occured while calling dao saveUserRegistration() :"+e.getMessage());
			return flag;
		}
		
		ContactCO contactCO = new ContactCO();
		contactCO.setCity(userRegistration.getCity());
		contactCO.setState(userRegistration.getState());
		contactCO.setCountry(userRegistration.getCountry());
		contactCO.setEmailId(userRegistration.getEmailId());
		contactCO.setPhoneNo(userRegistration.getPhoneNo());
		contactCO.setEmailValid(false);
		contactCO.setPhonenoValid(false);
		
		try 
		{
			flag = UserAuthDaoImpl.saveUserContact(contactCO);		
		} catch (Exception e) 
		{
			logger.info("Error Occured while calling dao saveUserContact :"+e.getMessage());
			return flag;
		}
		
		
		return flag;
	}

}
