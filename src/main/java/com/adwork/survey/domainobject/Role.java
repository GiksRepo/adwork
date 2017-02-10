package com.adwork.survey.domainobject;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4924493029227869292L;
	
	@Id
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private Users user;
	
	@Column(name = "role_type",nullable = false)
	private String roleType;
	
	@Column(name = "description",nullable = false)
	private String description;
	
	@Column(name = "created_date",nullable = false)
	private Timestamp createdDate;
	
	@Column(name = "last_updated_date",nullable = false)
	private Timestamp lastUpdateDate;
	
	public Role() {
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

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
