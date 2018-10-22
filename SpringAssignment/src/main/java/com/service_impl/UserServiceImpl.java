package com.service_impl;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.pojo.Address;
import com.pojo.User;
import com.pojo.UserDetails;
import com.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Transactional
	public int checkUser(User user) {
		return this.userDao.checkUser(user);
	}
	@Transactional
	public void addUser(User user) {
		this.userDao.addUser(user);
	}
	@Transactional
	public List<User> getUsers() {
		return this.userDao.getUsers();
	}
	@Transactional
	public User getUsersById(int id) {
		return this.userDao.getUsersById(id);
	}
	@Transactional
	public List<Address> getAddresses(int id) {
		return this.userDao.getAddresses(id);
	}
	@Transactional
	public void addAddress(Address address) {
		this.userDao.addAddress(address);
	}
	@Transactional
	public void deleteUser(int id) {
		this.userDao.deleteUser(id);
	}
	@Transactional
	public UserDetails getUserDetails(int id) {
		return this.userDao.getUserDetails(id);
	}
	@Transactional
	public void deleteAddress(int id) {
		this.userDao.deleteAddress(id);
	}
	@Transactional
	public Address getAddressById(int id) {
		return this.userDao.getAddressById(id);
	}
	@Transactional
	public void updateAddress(Address address){
		this.userDao.updateAddress(address);
	}
	@Transactional
	public void updateUser(User user) {
		this.userDao.updateUser(user);
	}
}

