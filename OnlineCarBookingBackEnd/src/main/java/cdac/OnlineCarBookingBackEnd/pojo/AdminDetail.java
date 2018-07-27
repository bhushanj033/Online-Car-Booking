package com.app.pojo;

import javax.persistence.*;


@Entity
@Table(name="admin")
public class AdminDetail {
	@Id
	@Column(name="admin_user_name")
	private String adminUser;
	
	@Column(name="password")
	private String password;
	
	@Column(name="name")
	private String name;

	
	public AdminDetail() {
	}

	public AdminDetail(String adminUser, String name) {
		super();
		this.adminUser = adminUser;
		this.name = name;
	}

	public String getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}