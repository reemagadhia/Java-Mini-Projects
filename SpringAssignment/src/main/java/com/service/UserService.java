package com.service;


import java.util.List;

import com.pojo.Address;
import com.pojo.User;
import com.pojo.UserDetails;

public interface UserService {
	
	public void addUser(User user);
	public int checkUser(User user);
	/*	
	public boolean checkUser(User user);
	public User getUsersById(int id);*/
	public void updateUser(User user);
	public List<User> getUsers();
	public User getUsersById(int id);
	public Address getAddressById(int id);
	public List<Address> getAddresses(int id);
	public void addAddress(Address address);
	public void updateAddress(Address address);
	public void deleteUser(int id);
	public void deleteAddress(int id);
	public UserDetails getUserDetails(int id);
}
