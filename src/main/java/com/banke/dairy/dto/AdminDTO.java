package com.banke.dairy.dto;

import com.banke.dairy.entity.Admin;

public class AdminDTO {
	private Integer adminId;
	private String name;
	private String emailId;
	private String phone;
	private String password;
	
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static Admin createAdminEntity(AdminDTO adminDTO) {
		Admin admin = new Admin();
		admin.setAdminId(adminDTO.getAdminId());
		admin.setName(adminDTO.getName());
		admin.setEmailId(adminDTO.getEmailId());
		admin.setPassword(adminDTO.getPassword());
		admin.setPhone(adminDTO.getPhone());
		return admin;
	}
	
}
