package com.tatva.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="credit")
public class Credit {
	@Id
	@Column(name="creditId")
	@GeneratedValue
	private int creditId;
	@Column(name="tandc")
	private String tandc;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="sId", unique=true)
	private User user;

	
	public Credit(String tandc, User user) {
		super();
		this.tandc = tandc;
		this.user = user;
	}

	public Credit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Credit(int creditId) {
		super();
		this.creditId = creditId;
	}

	public int getCreditId() {
		return creditId;
	}

	public void setCreditId(int creditId) {
		this.creditId = creditId;
	}

	public String getTandc() {
		return tandc;
	}

	public void setTandc(String tandc) {
		this.tandc = tandc;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
