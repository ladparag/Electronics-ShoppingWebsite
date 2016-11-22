package com.electronicshop.pojo;

public class Customer {
	
	private int custId;
	private String custName;
	private String addr;
	private String city;
	private String email;
	private String mobile;
	private String userName;
	private String password;
	private int adminId;
	
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", addr=" + addr + ", city=" + city
				+ ", email=" + email + ", mobile=" + mobile + ", userName=" + userName + ", password=" + password
				+ ", adminId=" + adminId + "]";
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	
	
	

}
