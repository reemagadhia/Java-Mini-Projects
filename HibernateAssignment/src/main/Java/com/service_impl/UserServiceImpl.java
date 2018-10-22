package com.service_impl;

import java.util.List;
import com.dao.UserDao;
import com.dao_impl.UserDaoImpl;
import com.pojo.Address;
import com.pojo.User;
import com.pojo.UserDetails;
import com.service.UserService;

public class UserServiceImpl implements UserService{
	UserDao dao = new UserDaoImpl();
	public int checkUser(User user) {
		return dao.checkUser(user);
	}
	public void addUser(User user) {
		dao.addUser(user);
	}
	public List<User> getUsers() {
		return dao.getUsers();
	}
	public User getUsersById(int id) {
		return dao.getUsersById(id);
	}
	public List<Address> getAddresses(int id) {
		return dao.getAddresses(id);
	}
	public void addAddress(Address address) {
		dao.addAddress(address);
	}
	public void deleteUser(int id) {
		dao.deleteUser(id);
	}
	public UserDetails getUserDetails(int id) {
		return dao.getUserDetails(id);
	}
	public void deleteAddress(int id) {
		dao.deleteAddress(id);
	}
	public Address getAddressById(int id) {
		return dao.getAddressById(id);
	}
	public void updateAddress(Address address){
		dao.updateAddress(address);
	}
	public void updateUser(User user) {
		dao.updateUser(user);
	}
}
