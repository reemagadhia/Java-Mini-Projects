package com.dao_impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.UserDao;
import com.pojo.Address;
import com.pojo.User;
import com.pojo.UserDetails;
import com.util.Util;

public class UserDaoImpl implements UserDao{
	Transaction tx = null;
	public int checkUser(User user) {
		int id = 0;
		user.setUserId(id);
		int status = 0;
		Session session = Util.getSessionFactory().openSession();
		try{
			tx = session.beginTransaction();
			Query qry = session.createQuery("from com.pojo.User where userName =:userName AND password=:password");
			qry.setString("userName", user.getUserName());
			qry.setString("password", user.getPassword());
			user.setRole(user.getRole());
			user = (User)qry.uniqueResult();
			id = user.getUserId();
			if(!user.equals(null)){
				status = 1;
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
		return id;
	}
	public void addUser(User user) {
		Session session = Util.getSessionFactory().openSession();
		try{
			tx = session.beginTransaction();
			session.save(user);
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
	}
	public List<User> getUsers() {
		Session session = Util.getSessionFactory().openSession();
		List<User> users = new ArrayList<User>();
		try{
			tx = session.beginTransaction();
			users = session.createQuery("from com.pojo.User").list();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return users;
	}
	public User getUsersById(int id) {
		Session session = Util.getSessionFactory().openSession();
		User user = new User(id);
		try{
			tx = session.beginTransaction();
			Query qry = session.createQuery("from com.pojo.User where id =:id");
			qry.setInteger("id", id);
			user = (User) qry.uniqueResult();
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
		return user;
	}
	public List<Address> getAddresses(int userDetailsId) {
		Session session = Util.getSessionFactory().openSession();
		List<Address> addresses = new ArrayList<Address>();
		try{
			tx = session.beginTransaction();
			Query qry = session.createQuery("from com.pojo.Address where userDetailsId =:userDetailsId");
			qry.setInteger("userDetailsId", userDetailsId);
			addresses = (List<Address>)qry.list();
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
		return addresses;
	}
	public void addAddress(Address address) {
		Session session = Util.getSessionFactory().openSession();
		try{
			tx = session.beginTransaction();
			session.save(address);
			session.getTransaction().commit();
		}
		catch(Exception e){
			
		}
		finally{
		}
	}

 	public void deleteUser(int id) {
		Session session = Util.getSessionFactory().openSession();
		User user = new User(id);
		try{
			tx = session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
		}
		catch(Exception e){
			if(tx!= null){
				tx.rollback();
				System.out.println("\nYou cannot delete record that doesn't exist.\n"+e);
			}
		}
		finally{
			session.flush();
			session.close();
		}
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
		Session session = Util.getSessionFactory().openSession();
		try{
			tx = session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
		}
		catch(Exception e){
			if(tx!= null){
				tx.rollback();
				System.out.println("\nYou cannot update record that doesn't exist.\n");
			}
		}
		finally{
			session.close();
		}
	}
	public UserDetails getUserDetails(int id) {
		Session session = Util.getSessionFactory().openSession();
		User user = new User(id);
		try{
			tx = session.beginTransaction();
			Query qry = session.createQuery("from com.pojo.User where id =:id");
			qry.setInteger("id", id);
			user = (User) qry.uniqueResult();
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
		return user.getUserDetails();
	}
	public void deleteAddress(int id) {
		Session session = Util.getSessionFactory().openSession();
		Address address = new Address(id);
		try{
			tx = session.beginTransaction();
			session.delete(address);
			session.getTransaction().commit();
		}
		catch(Exception e){
			if(tx!= null){
				tx.rollback();
				System.out.println("\nYou cannot delete record that doesn't exist.\n"+e);
			}
		}
		finally{
			session.flush();
			session.close();
		}
	}
	public Address getAddressById(int id) {
		Session session = Util.getSessionFactory().openSession();
		Address address = new Address(id);
		try{
			tx = session.beginTransaction();
			Query qry = session.createQuery("from com.pojo.Address where addressId =:addressId");
			qry.setInteger("addressId", id);
			address = (Address) qry.uniqueResult();
			session.getTransaction().commit();
		}
		catch(Exception e){
			if(tx!= null){
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally{
			session.flush();
			session.close();
		}
		return address;
	}
	public void updateAddress(Address address) {
		Session session = Util.getSessionFactory().openSession();
		
		try{
			tx = session.beginTransaction();
			session.update(address);
			session.getTransaction().commit();
		}
		catch(Exception e){
			if(tx!= null){
				tx.rollback();
				System.out.println("\nYou cannot update record that doesn't exist.\n");
			}
		}
		finally{
			session.close();
		}
	}
}
