package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
@SuppressWarnings("deprecation")
public class Util {
	private static SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory(){
		/*Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();*/
		sessionFactory= ((AnnotationConfiguration) new AnnotationConfiguration().configure("hibernate.cfg.xml")).buildSessionFactory();
		return sessionFactory;
	}
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
