package com.mugspot;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DAO {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Shops.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		//try {

			// adding objects to the database
			System.out.println("Create new friend object");
			Shops friend = new Shops();
			session.beginTransaction();
			
			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(Shops.class);

			@SuppressWarnings("unchecked")
			List<Shops> shops = criteria.list();

			System.out.println("started query");

			for (Shops array: shops) {
				System.out.println(array);
			}
			
			session.getTransaction().commit();   
			session.close();
		
		
	}

}
