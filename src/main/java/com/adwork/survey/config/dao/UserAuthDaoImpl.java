package com.adwork.survey.config.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.adwork.survey.commandobject.ContactCO;
import com.adwork.survey.commandobject.PersonCO;
import com.adwork.survey.config.ApplicationStartUp;
import com.adwork.survey.domainobject.Contact;
import com.adwork.survey.domainobject.Person;
import com.adwork.survey.domainobject.UserRoles;
import com.adwork.survey.domainobject.Users;

interface UserAuthDao
{
	public boolean saveUserProfile(PersonCO personCo);
	public boolean saveUserContact(ContactCO contactCo);
	public Users getUserCredentials(String loginId);
	public List <UserRoles> getUserRoles(Users user);
}


public class UserAuthDaoImpl implements UserAuthDao
{
	private static final Logger logger = LoggerFactory.getLogger(UserAuthDaoImpl.class);
			
	@Autowired
	private ApplicationStartUp applicationStartUp;
	
	public UserAuthDaoImpl() 
	{
		logger.info("UserAuthDaoImpl constructor");
	}

	@Override
	public boolean saveUserProfile(PersonCO personCo) 
	{
		logger.info("Dao Layer for person");
		
		Person personDO = new Person();
		personDO.setFirstName(personCo.getFirstName());
		personDO.setMiddleName(personCo.getMiddleName());
		personDO.setLastName(personCo.getLastName());
		personDO.setGender(personCo.getGender());
		//personDO.setAge(personCo.getAge());
		//personDO.setDateOfBirth(personCo.getDateOfBirth());
		logger.info("First Name :"+personDO.getFirstName()+" MiddleName :"+personDO.getMiddleName()+" LastName : "+personDO.getLastName()+" Gender : "+personDO.getGender());
		return false;
	}

	@Override
	public boolean saveUserContact(ContactCO contactCo) 
	{
		logger.info("Dao Layer for contact");
		Contact contactDO = new Contact();
		contactDO.setCity(contactCo.getCity());
		contactDO.setCountry(contactCo.getCountry());
		contactDO.setState(contactCo.getState());
		contactDO.setEmailId(contactCo.getEmailId());
		contactDO.setIsEmailValid(contactCo.isEmailValid());
		contactDO.setPhoneNo(contactCo.getPhoneNo());
		contactDO.setIsPhonenoValid(contactCo.isPhonenoValid());
		logger.info("City :"+contactDO.getCity()+" state :"+contactDO.getState()+" country:"+contactDO.getCountry()+" email:"+contactDO.getEmailId()+" phone no"+contactDO.getPhoneNo());
		return false;
	}

	@Override
	public Users getUserCredentials(String loginId) 
	{
		Users user = null;
		Session session = null;
		if(applicationStartUp == null)
			logger.info("applicationStartUp is null");
		try
		{
			SessionFactory sessionFactory = applicationStartUp.getSessionFactory();
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Users.class);
			criteria.add(Restrictions.eq("loginId", loginId));
			user = (Users)criteria.uniqueResult();
		}
		catch(Exception e)
		{
			logger.info("Error occured getUserCredentials "+e.getMessage());
		}
		finally 
		{
			if(session != null)
			{
				session.flush();
				session.close();
			}
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List <UserRoles> getUserRoles(Users user) {
		List <UserRoles> userRoles = null;
		Session session = null;
		try
		{
			SessionFactory sessionFactory = applicationStartUp.getSessionFactory();
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Users.class);
			criteria = session.createCriteria(UserRoles.class);
			criteria.add(Restrictions.eq("user", user));
			userRoles = (List<UserRoles>)criteria.list();
		}
		catch(Exception e)
		{
			logger.info("Error occured getUserRoles :"+e.getMessage());
		}
		finally
		{
			if(session != null)
			{
				session.flush();
				session.close();
			}
		}
		
		return userRoles;
	}
}
