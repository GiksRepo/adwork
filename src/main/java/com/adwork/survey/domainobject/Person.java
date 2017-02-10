package com.adwork.survey.domainobject;


import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5129388836708407722L;

	@Id
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private Users user;
	
	@Column(name = "firstName",nullable = false)
	private String firstName;
	
	@Column(name = "middleName",nullable = false)
	private String middleName;
	
	@Column(name = "lastName",nullable = false)
	private String lastName;
	
	@Column(name = "gender",nullable = false)
	private String gender;
	
	@Column(name = "dateOfBirth",nullable = false)
	private Date dateOfBirth;
	
	@Column(name = "age",nullable = false)
	private Byte age;
	
	@Column(name = "createdDate",nullable = false)
	private Timestamp createdDate;
	
	@Column(name = "lastUpdatedDate",nullable = false)
	private Timestamp lastUpdateDate;
	
	public Person() 
	{
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Byte getAge() {
		return age;
	}

	public void setAge(Byte age) {
		this.age = age;
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
