package com.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	@Id
	@Column(name="roleId")
	@GeneratedValue
	private int roleId;
	@Column(name="role")
	private String role;
	
	public Role() {
		super();
	}
	public Role(int roleId) {
		super();
		this.roleId = roleId;
	}
	public Role(String role) {
		super();
		this.role = role;
	}
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
