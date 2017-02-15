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
@Table(name = "geo")
public class Geo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "geo_id")
	private Long geoId;
	
	@Column(name = "description",nullable = false)
	private String description;
	
	@Column(name ="parent_id")
	private Long parentId;
	
	public Geo() {
		// TODO Auto-generated constructor stub
	}

	public Long getGeoId() {
		return geoId;
	}

	public void setGeoId(Long geoId) {
		this.geoId = geoId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Geo getParentId() {
		return parentId;
	}

	public void setParentId(Geo parentId) {
		this.parentId = parentId;
	}
	
}
