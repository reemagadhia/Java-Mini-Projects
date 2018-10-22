package com.tatva.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.tatva.dao.UserDao;
import com.tatva.model.Category;
import com.tatva.model.Credit;
import com.tatva.model.Product;
import com.tatva.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	Transaction tx = null;
	
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> users = new ArrayList<User>();
		users = session.createQuery("from com.tatva.model.User").list();
		return users;
	}

	public void addUser(User user) {
		Session  session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}	
	
	public int checkUser(User user) {
		int id = 0;
		boolean status = false;
		Session session = this.sessionFactory.getCurrentSession();
		Query qry = session.createQuery("from com.tatva.model.User where userName =:userName AND password=:password");
		qry.setString("userName", user.getUserName());
		qry.setString("password", user.getPassword());
		user = (User)qry.uniqueResult();
		user.setAppliedFor(user.getAppliedFor());
		id = user.getUid();
		if(!user.equals(null)){
			return id;
		}
		else{
			return 0;
		}
	}
	
	public void deleteUser(int id) {
		Session  session = this.sessionFactory.getCurrentSession();
		User user = new User(id);
		session.delete(user);
	}

	
	public User getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = new User(id);
		Query qry = session.createQuery("from com.tatva.model.User where id =:id");
		qry.setInteger("id", id);
		user = (User) qry.uniqueResult();
		return user;
	}

	public User getUserByName(String firstName) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = new User();
		user.setFirstName(firstName);
		user.setUid(user.getUid());
		Query qry = session.createQuery("from com.tatva.model.User where firstName =:firstName");
		qry.setString("firstName",firstName);
		user = (User) qry.uniqueResult();
		return user;
	}

	
	@SuppressWarnings("unchecked")
	public List<Category> getCategories() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> categories = new ArrayList<Category>();
		categories = session.createQuery("from com.tatva.model.Category").list();
		return categories;
	}
	
	public void addCategory(Category category) {
		Session  session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(category);
	}

	public Category getCategoryByName(String category) {
		Session  session = this.sessionFactory.getCurrentSession();
		Category ctgy = new Category();
		ctgy.setCategory(category);
		ctgy.setCid(ctgy.getCid());
		Query qry = session.createQuery("from com.tatva.model.Category where category =:category");
		qry.setString("category",category);
		ctgy = (Category) qry.uniqueResult();
		return ctgy;
	}

	public Category getCategoryById(int cid) {
		Session  session = this.sessionFactory.getCurrentSession();
		Category category = new Category(cid);
		Query query = session.createQuery("from com.tatva.model.Category where cid= :cid");
		query.setInteger("cid", cid);
		category = (Category) query.uniqueResult();
		return category;
	}

	public void deleteCategory(int id) {
		Session  session = this.sessionFactory.getCurrentSession();
		Category category = new Category(id);
		session.delete(category);
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> product = new ArrayList<Product>();
		product = session.createQuery("from com.tatva.model.Product").list();
		return product;
	}

	public void deleteProduct(int id) {
		Session  session = this.sessionFactory.getCurrentSession();
		Product product = new Product(id);
		session.delete(product);
	}

	public void addProduct(Product product) {
		Session  session = this.sessionFactory.getCurrentSession();	
		session.saveOrUpdate(product);
	}

	public void addCredit(Credit credit) {
		Session  session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(credit);
	}

	public Credit getCreditById(int id) {
		Session  session = this.sessionFactory.getCurrentSession();
		Credit credit = new Credit();
		User user = new User(id);
		credit.setUser(user);
		Query query = session.createQuery("from com.tatva.model.Credit where id= :id");
		query.setInteger("id", id);
		credit = (Credit) query.uniqueResult();
		return credit;
	}
}
