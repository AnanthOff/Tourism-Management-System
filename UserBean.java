package com.tourism.mgt.bean;

import java.util.Date;

public class UserBean extends BaseBean {

	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String confirmPassword;
	private Date dob;
	private String mobileNo;
	private String gender;
	private long roleId;
	
	
	
	
	public String toString() {
		return "UserBean [firstName=" + firstName + ", lastName=" + lastName + ", login=" + login + ", password="
				+ password + ", confirmPassword=" + confirmPassword + ", dob=" + dob + ", mobileNo=" + mobileNo
				+ ", gender=" + gender + ", roleId=" + roleId + "]";
	}
	
	
	public UserBean() {
	}
	
	


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}


	public String getKey() {
		return null;
	}


	public String getValue() {
		return null;
	}
	
	
	
	
	
	
}
