package com.uru.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import com.uru.app.constants.UruAppConstants;

@Entity
@Table(name="ecom_email_template")
@NamedQuery(name="EcomEmailTemplate.findById", query="SELECT e from EcomEmailTemplate e where e.id=:n",hints = { @QueryHint(name = UruAppConstants.ORG_HIBERNATE_CACHEABLE, value = "true")})
public class EcomEmailTemplate implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Email_ID")
	private Long id;
	
	@Column(name="EMAIL_NAME")
	private String emailName;
	
	@Column(name="EMAIL_DESCRIPTON")
	private String emailDescription;
	
	@Column(name="IS_ACTIVE")
	private int isActive;
	
	public EcomEmailTemplate(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmailName() {
		return emailName;
	}

	public void setEmailName(String emailName) {
		this.emailName = emailName;
	}

	public String getEmailDescription() {
		return emailDescription;
	}

	public void setEmailDescription(String emailDescription) {
		this.emailDescription = emailDescription;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
	
	
}
