package com.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="userId")
	@GeneratedValue
	private int userId;
	@Column(name="userName")
	private String userName;
	@Column(name="password")
	private String password;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="roleId", unique=true)
	private Role role;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
	private UserDetails userDetails;
	
	public User() {
		super();
	}
	public User(int userId) {
		super();
		this.userId = userId;
	}
	public User(Role role) {
		super();
		this.role = role;
	}
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public User(String userName, String password, Role role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
}
