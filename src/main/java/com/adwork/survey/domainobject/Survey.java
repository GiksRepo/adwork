package com.adwork.survey.domainobject;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "survey")
public class Survey implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3793864668313467713L;
	
	@Id
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private Users user;
	

}
