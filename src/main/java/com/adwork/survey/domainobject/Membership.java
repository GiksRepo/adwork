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
@Table(name = "membership")
public class Membership implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "memeber_id")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private Users user;
	
	@Column(name = "parent_user_id",nullable = false)
	private Long parentUserId;
	
	@Column(name = "is_ctive",nullable = false)
	private Boolean isActive;
	
	@Column(name = "from_date",nullable = false)
	private Timestamp fromDate;
	
	@Column(name = "thru_date",nullable = false)
	private Timestamp thruDate;
	
	@Column(name = "position",nullable = false)
	private String position;
	
	@Column(name = "status",nullable = false)
	private String status;
	
	@Column(name = "created_date",nullable = false)
	private Timestamp createdDate;
	
	@Column(name = "last_pdated_date",nullable = false)
	private Timestamp lastUpdateDate;
	
	public Membership() {
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

	public Long getParentUserId() {
		return parentUserId;
	}

	public void setParentUserId(Long parentUserId) {
		this.parentUserId = parentUserId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Timestamp getFromDate() {
		return fromDate;
	}

	public void setFromDate(Timestamp fromDate) {
		this.fromDate = fromDate;
	}

	public Timestamp getThruDate() {
		return thruDate;
	}

	public void setThruDate(Timestamp thruDate) {
		this.thruDate = thruDate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
