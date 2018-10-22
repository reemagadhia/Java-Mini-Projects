package com.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="address")
public class Address {
	@Id
	@Column(name="addressId")
	@GeneratedValue
	private int addressId;
	@Column(name="streetName")
	private String streetName;
	@Column(name="cityName")
	private String cityName;
	@Column(name="pincode")
	private String pincode;
	
	@ManyToOne
	@JoinColumn(name="userDetailsId")
	private UserDetails userDetails;
	
	public Address() {
		super();
	}
	public Address(int addressId) {
		super();
		this.addressId = addressId;
	}
	public Address(int addressId, UserDetails userDetails) {
		super();
		this.addressId = addressId;
		this.userDetails = userDetails;
	}
	public Address(String streetName, String cityName, String pincode, UserDetails userDetails) {
		super();
		this.streetName = streetName;
		this.cityName = cityName;
		this.pincode = pincode;
		this.userDetails = userDetails;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}
