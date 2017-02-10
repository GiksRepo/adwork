package com.adwork.survey.config.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.adwork.survey.config.dao.UserAuthDaoImpl;
import com.adwork.survey.domainobject.UserRoles;
import com.adwork.survey.domainobject.Users;


public class AuthenticationService implements UserDetailsService
{	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
	
	@Autowired
	private UserAuthDaoImpl userAuthDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		logger.info("Authentication of user... username : "+username);
		Users user = null;
		List <UserRoles> userRoles = null;
		User springUser = null;
		try 
		{
			user = userAuthDao.getUserCredentials(username);
			userRoles = userAuthDao.getUserRoles(user);
			//String userAuthorities = null;
			List<String> roleArr = new ArrayList<String>();
			if(userRoles !=null && !userRoles.isEmpty())
			{
				
				for(UserRoles userRoleTemp:userRoles)
					roleArr.add(userRoleTemp.getRole());
				//userAuthorities = StringUtils.arrayToCommaDelimitedString(roleArr.toArray());
			}
			if (user == null) 
			{
				logger.info("Authentication Fail username : "+username);
		        throw new UsernameNotFoundException("Invalid username/password.");
		    }
		    Collection<? extends GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roleArr.get(0));
		    		springUser = new User(user.getLoginId(), user.getPassword(), authorities);
			
		    logger.info("user_id : "+user.getLoginId());
		    logger.info("Role : "+user.getPassword());			
		} 
		catch (Exception e) 
		{
			logger.error("UserAuthDaoImpl is Null :"+e.getMessage());
		}	
		
	    return springUser;
	}

}
