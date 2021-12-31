package com.tourism.mgt.bean;

public class IssuesBean extends BaseBean {
	
	private String name;
	private String mobileNo;
	private String emailId;
	private String issues;
	private String description;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getIssues() {
		return issues;
	}

	public void setIssues(String issues) {
		this.issues = issues;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getKey() {
		return String.valueOf(id);
	}

	
	public String getValue() {
		return name;
	}

}
