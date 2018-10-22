package com.tatva.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="uid")
	@GeneratedValue
	private int uid;
	@Column(name="userName")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="appliedFor")
	private String appliedFor;
	@Column(name="regDate")
	private Date regDate;
	@Column(name="status")
	private String status;
	@Column(name="firstName", unique=true)
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="company")
	private String company;
	@Column(name="contact")
	private String contact;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
	private Credit credit;

	/*@OneToMany(mappedBy = "user", cascade=CascadeType.PERSIST)
	private List<Product> product = new ArrayList<Product>();*/
	
	public User() {
		super();
	}

	public User(String userName, String password, String appliedFor, Date regDate, String status, String firstName,
			String lastName, String company, String contact) {
		super();
		this.userName = userName;
		this.password = password;
		this.appliedFor = appliedFor;
		this.regDate = regDate;
		this.status = status;
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.contact = contact;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public User(int uid) {
		super();
		this.uid = uid;
	}

	public User(String userName, String password, String appliedFor) {
		super();
		this.userName = userName;
		this.password = password;
		this.appliedFor = appliedFor;
	}
	
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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

	public String getAppliedFor() {
		return appliedFor;
	}

	public void setAppliedFor(String appliedFor) {
		this.appliedFor = appliedFor;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

/*	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public Credit getCredit() {
		return credit;
	}
	public void setCredit(Credit credit) {
		this.credit = credit;
	}*/
}
