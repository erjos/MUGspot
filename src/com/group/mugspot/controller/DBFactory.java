package com.group.mugspot.controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBFactory {
	private static SessionFactory factory;
	public static SessionFactory setupFactory(){
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		/*config.addAnnotatedClass(Shops.class);
		config.addAnnotatedClass(City.class);
		config.addAnnotatedClass(Users.class);
		config.addAnnotatedClass(Reviews.class);*/
		
		 factory = config.buildSessionFactory();
		 return factory;
	}
}
