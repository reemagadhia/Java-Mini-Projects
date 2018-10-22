package com.dao_impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.pojo.Address;
import com.pojo.User;
import com.pojo.UserDetails;

@Repository
public class UserDaoImpl implements UserDao{
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	Transaction tx = null;
	public int checkUser(User user) {
		int id = 0;
		user.setUserId(id);
		int status = 0;
		Session session = this.sessionFactory.getCurrentSession();
		Query qry = session.createQuery("from com.pojo.User where userName =:userName AND password=:password");
		qry.setString("userName", user.getUserName());
		qry.setString("password", user.getPassword());
		user.setRole(user.getRole());
		user = (User)qry.uniqueResult();
		id = user.getUserId();
		if(!user.equals(null)){
			status = 1;
		}
	
		return id;
	}
	public void addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
			session.save(user);
	}
	public List<User> getUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> users = new ArrayList<User>();
		users = session.createQuery("from com.pojo.User").list();
		System.out.print(users);
		return users;
	}
	public User getUsersById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = new User(id);
			Query qry = session.createQuery("from com.pojo.User where id =:id");
			qry.setInteger("id", id);
			user = (User) qry.uniqueResult();
		return user;
	}
	public List<Address> getAddresses(int userDetailsId) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Address> addresses = new ArrayList<Address>();
			Query qry = session.createQuery("from com.pojo.Address where userDetailsId =:userDetailsId");
			qry.setInteger("userDetailsId", userDetailsId);
			addresses = (List<Address>)qry.list();
		return addresses;
	}
	public void addAddress(Address address) {
		Session session = this.sessionFactory.getCurrentSession();
			session.save(address);
	}

 	public void deleteUser(int id) {
 		Session session = this.sessionFactory.getCurrentSession();
		User user = new User(id);
		session.delete(user);
	}
/*		
	public boolean checkUser(User user) {
		boolean status = false;
		Session session = Util.getSessionFactory().openSession();
		try{
			tx = session.beginTransaction();
			Query qry = session.createQuery("from com.tatva.pojo.User where userName =:userName AND password=:password");
			qry.setString("userName", user.getUserName());
			qry.setString("password", user.getPassword());
			user.setRole(user.getRole());
			user = (User)qry.uniqueResult();
			if(!user.equals(null)){
				status = true;
			}
			session.getTransaction().commit();
		}
		catch(Exception e){
			if(tx!= null){
				tx.rollback();
			}
		}
		finally{
			session.flush();
			session.close();
		}
		return status;
	}

	public List<UserDetails> getUsers() {
		Session session = Util.getSessionFactory().openSession();
		List<UserDetails> users = new ArrayList<UserDetails>();
		try{
			tx = session.beginTransaction();
			users = session.createQuery("from com.tatva.pojo.UserDetails").list();
		}
		catch(Exception e){
			
		}
		return users;
	}
	*/
	public void updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
	}
	public UserDetails getUserDetails(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = new User(id);
		Query qry = session.createQuery("from com.pojo.User where id =:id");
		qry.setInteger("id", id);
		user = (User) qry.uniqueResult();
		return user.getUserDetails();
	}
	public void deleteAddress(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Address address = new Address(id);
		session.delete(address);
	}
	public Address getAddressById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Address address = new Address(id);
		Query qry = session.createQuery("from com.pojo.Address where addressId =:addressId");
		qry.setInteger("addressId", id);
		address = (Address) qry.uniqueResult();
		return address;
	}
	public void updateAddress(Address address) {
		Session session = this.sessionFactory.getCurrentSession();
			session.update(address);
	}
}
