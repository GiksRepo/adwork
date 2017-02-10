package com.adwork.survey.commandobject;

public class ContactCO 
{
	private Long userId;
	private String emailId;
	private Long phoneNo;
	private String city;
	private String state;
	private String country;
	private boolean isEmailValid;
	private boolean isPhonenoValid;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public boolean isEmailValid() {
		return isEmailValid;
	}
	public void setEmailValid(boolean isEmailValid) {
		this.isEmailValid = isEmailValid;
	}
	public boolean isPhonenoValid() {
		return isPhonenoValid;
	}
	public void setPhonenoValid(boolean isPhonenoValid) {
		this.isPhonenoValid = isPhonenoValid;
	}
}
