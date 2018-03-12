package com.uru.app.model;

public class EcomEmailTemplateModel {
	
	private Long id;
	
	private String emailName;
	 
	private String emailDescription;
	 
	private int isActive;

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
