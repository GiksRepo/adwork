package com.adwork.survey.daos;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;



@Component
public class WalletDao
{

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void display()
	{
		System.out.println("got it!");
	}

}
