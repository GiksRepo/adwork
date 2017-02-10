package com.adwork.survey.domainobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_roles")
public class UserRoles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "user_id")
	private Users user;
	
	@Column(name = "role")
	private String role;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		/*this.id = id;*/
	}
	
	public Users getUser() {
		return user;
	}

	public UserRoles() {
		// TODO Auto-generated constructor stub
	}
	
	public UserRoles(Users user, String role) {
		super();
		this.user = user;
		this.role = role;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
