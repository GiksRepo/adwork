package com.adwork.survey.domainobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "wallet")
public class Wallet implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6079184846924340434L;
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "walletId")
	private Long id;
	
}
