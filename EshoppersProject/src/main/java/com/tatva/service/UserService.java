package com.tatva.service;

import java.util.List;

import com.tatva.model.Category;
import com.tatva.model.Credit;
import com.tatva.model.Product;
import com.tatva.model.User;

public interface UserService {
	public List<User> getUsers();
	public int checkUser(User user);
	public void deleteUser(int id);
	public void addUser(User user);
	public User getUserById(int id);
	public User getUserByName(String name);
	public List<Category> getCategories();
	public void addCategory(Category category);
	public Category getCategoryByName(String name);
	public Category getCategoryById(int id);
	public void deleteCategory(int id);
	public List<Product> getProducts();
	public void deleteProduct(int id);
	public void addProduct(Product product);
	public void addCredit(Credit credit);
	public Credit getCreditById(int id);
}
