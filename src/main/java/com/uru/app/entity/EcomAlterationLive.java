package com.uru.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="ecom_alternation_live")
@NamedQuery(name="EcomAlterationLive.findAll", query="SELECT alt from EcomAlterationLive alt")
public class EcomAlterationLive implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Long Id;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="Mobile_No")
	private long mobileNo;
	
	@Column(name="EMAIL_ID")
	private String emailId;
	
	@Column(name="JSON_DATA",length=4000)
	private String jsonData;

	public EcomAlterationLive(){}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	
	
	
	
}
