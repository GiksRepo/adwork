package com.adwork.survey.serviceInterfaces;

import org.springframework.security.access.prepost.PreAuthorize;

import com.adwork.survey.viewobject.UserRegistration;

public interface UserServiceIn 
{
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public boolean saveUserRegistration(UserRegistration userRegistration);
}
