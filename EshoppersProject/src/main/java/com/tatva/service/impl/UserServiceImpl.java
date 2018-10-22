package com.tatva.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tatva.dao.UserDao;
import com.tatva.model.Category;
import com.tatva.model.Credit;
import com.tatva.model.Product;
import com.tatva.model.User;
import com.tatva.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional
	public List<User> getUsers() {
		return this.userDao.getUsers();
	}
	
	@Transactional
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	@Transactional
	public int checkUser(User user) {
		return this.userDao.checkUser(user);
	}

	@Transactional
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}
	
	@Transactional
	public User getUserById(int id) {
		return this.userDao.getUserById(id);
	}
	
	@Transactional
	public User getUserByName(String name) {
		return this.userDao.getUserByName(name);
	}
	
	@Transactional
	public List<Category> getCategories() {
		return this.userDao.getCategories();
	}

	@Transactional
	public void addCategory(Category category) {
		userDao.addCategory(category);
	}
	
	@Transactional
	public Category getCategoryByName(String name) {
		return this.userDao.getCategoryByName(name);
	}

	@Transactional
	public Category getCategoryById(int id) {
		return this.userDao.getCategoryById(id);
	}
	
	@Transactional
	public void deleteCategory(int id) {
		userDao.deleteCategory(id);
	}
	
	@Transactional
	public List<Product> getProducts() {
		return this.userDao.getProducts();
	}

	@Transactional
	public void deleteProduct(int id) {
		userDao.deleteProduct(id);
	}
	
	@Transactional
	public void addProduct(Product product) {
		userDao.addProduct(product);
	}

	@Transactional
	public void addCredit(Credit credit) {
		userDao.addCredit(credit);
	}

	@Transactional
	public Credit getCreditById(int id) {
		return this.userDao.getCreditById(id);
	}
}
