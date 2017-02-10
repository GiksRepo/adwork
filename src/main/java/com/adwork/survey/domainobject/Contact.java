package com.adwork.survey.domainobject;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "contact")
public class Contact implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2206850529933514574L;
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private Users user;
	
	@Column(name = "email_id",nullable = false)
	private String emailId;
	
	@Column(name = "phone_no",nullable = false)
	private Long phoneNo;
	
	@Column(name = "city",nullable = false)
	private String city;
	
	@Column(name = "state",nullable = false)
	private String state;
	
	@Column(name = "country",nullable = false)
	private String country;
	
	@Column(name = "is_email_valid",nullable = false)
	private Boolean isEmailValid;
	
	@Column(name = "is_phoneno_valid",nullable = false)
	private Boolean isPhonenoValid;
	
	@Column(name = "created_date",nullable = false)
	private Timestamp createdDate;
	
	@Column(name = "last_updated_date",nullable = false)
	private Timestamp lastUpdateDate;
	
	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Boolean getIsEmailValid() {
		return isEmailValid;
	}

	public void setIsEmailValid(Boolean isEmailValid) {
		this.isEmailValid = isEmailValid;
	}

	public Boolean getIsPhonenoValid() {
		return isPhonenoValid;
	}

	public void setIsPhonenoValid(Boolean isPhonenoValid) {
		this.isPhonenoValid = isPhonenoValid;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
}
