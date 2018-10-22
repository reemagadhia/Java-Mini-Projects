package com.tatva.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.tatva.pojo.Employee;

public class Util {
	private static SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory(){
		/*Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();*/
		sessionFactory= ((AnnotationConfiguration) new AnnotationConfiguration().configure()).addAnnotatedClass(Employee.class).buildSessionFactory();
		return sessionFactory;
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
