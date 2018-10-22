package com.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="userdetails")
public class UserDetails {
	@Id
	@Column(name="userDetailsId")
	@GeneratedValue
	private int userDetailsId;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name="mobileNo")
	private String mobileNo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userId")
	private User user;
	
	@OneToMany(mappedBy = "userDetails", cascade=CascadeType.ALL)
	private List<Address> address = new ArrayList<Address>();
	public UserDetails() {
		super();
	}
	public UserDetails(int userDetailsId) {
		super();
		this.userDetailsId = userDetailsId;
	}
	public UserDetails(String firstName, String lastName, String email,
			String mobileNo, User user) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.user = user;
	}
	
	public int getUserDetailsId() {
		return userDetailsId;
	}
	public void setUserDetailsId(int userDetailsId) {
		this.userDetailsId = userDetailsId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
}
