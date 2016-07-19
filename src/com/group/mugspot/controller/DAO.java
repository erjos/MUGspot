package com.group.mugspot.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DAO {

	// public static void main(String[] args) {
	public List<Shops> getShops() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Shops.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		// try {

		// adding objects to the database
		//System.out.println("Create new friend object");
		Shops friend = new Shops();
		session.beginTransaction();

		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Shops.class);
		
		//criteria.setMaxResults(3);

		@SuppressWarnings("unchecked")
		List<Shops> shops = criteria.list();

		//System.out.println("started query");

		for (Shops array : shops) {
			System.out.println(array);
		}

		session.getTransaction().commit();
		session.close();
		return shops;

	}

	public String getInfo() {
		String DAO = "<table border=\"1\">";
				//+ "<tr><th>Username</th><th>Email</th><th>Full Name</th><th>Delete User</th></tr>";//include start table tag
		List<Shops> shops = getShops();
		for (Shops shops1 : shops) {
			// DAO = shops1.getShop_name();
			DAO += "<tr><td>" + shops1.getShop_name() + "</td><td>" + shops1.getDescription() + "</td><td>" 
		     + shops1.getMenu() + "</td><td>" + shops1.getOutlets() + "</td><td>"  + shops1.getCapacity() 
		     + "</td><td>" + shops1.getPlaceid()
			+ "</td><td>" + shops1.getBudget();
		}
		DAO += "</table>";
		return DAO;
	}
}