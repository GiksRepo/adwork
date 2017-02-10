package com.adwork.survey.daos;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

interface ConfigurationIn
{
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void addPrint();
}

@Component
public class Configuration implements ConfigurationIn
{
	public void addPrint()
	{
		System.out.println("Admin access only");
	}
}
