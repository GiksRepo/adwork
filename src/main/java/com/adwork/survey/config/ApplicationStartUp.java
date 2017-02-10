package com.adwork.survey.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adwork.survey.domainobject.UserRoles;
import com.adwork.survey.domainobject.Users;


public class ApplicationStartUp 
{
	private EntityManagerFactory entityManagerFactory;
	private SessionFactory sessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(ApplicationStartUp.class);
	
	public void initIt() throws Exception
	{
		logger.info("Intializing Start");
		if(entityManagerFactory == null)
		{
			entityManagerFactory = Persistence.createEntityManagerFactory("com.adwork");
			sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
			
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			transaction.begin();
			
			Users user = new Users();
			user.setLoginId("Dpun");
			user.setPassword("123");
			session.persist(user);
			
			UserRoles userRole = new UserRoles();
			userRole.setUser(user);
			userRole.setRole("ROLE_USER");
			session.persist(userRole);
			
			Users user2 = new Users();
			user2.setLoginId("Aman");
			user2.setPassword("123");
			session.persist(user2);
			
			UserRoles userRole2 = new UserRoles();
			userRole2.setUser(user2);
			userRole2.setRole("ROLE_ADMIN");
			session.persist(userRole2);
			
			/*UserRoles userRole2 = new UserRoles();
			userRole2.setUser(user);
			userRole2.setRole("ROLE_ADMIN");
			session.persist(userRole2);*/
			
			transaction.commit();
			session.close();
		}
	}
	
	
	public SessionFactory getSessionFactory() throws Exception
	{
		logger.info("Creating Hibernate Session Factory");
		
		if(entityManagerFactory == null)
			entityManagerFactory = Persistence.createEntityManagerFactory("com.adwork");
		if(sessionFactory == null)
			sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		
		return sessionFactory;
	}
	
	public void cleanUp() throws Exception
	{
		logger.info("Clean up start");
		if(entityManagerFactory != null)
			entityManagerFactory.close();
		if(sessionFactory != null)
			sessionFactory.close();
	}
}
