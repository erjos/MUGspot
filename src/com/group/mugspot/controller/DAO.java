package com.group.mugspot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.simple.parser.ParseException;

import com.group.mugspot.controller.*;;

public class DAO {
	private static SessionFactory factory;

	// public static void main(String[] args) {
	public static List<Shops> getShops() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Shops.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Shops.class);
		
		//criteria.setMaxResults(3);

		@SuppressWarnings("unchecked")
		List<Shops> shops = criteria.list();

		//System.out.println("started query");

		session.getTransaction().commit();
		session.close();
		
		return shops;
	}
	
	
	public static ArrayList<String> getInfo() throws ClientProtocolException, IOException, ParseException {
		List<Shops> shops = getShops();
		ArrayList<String> shopInfo = new ArrayList<String>();
		for (Shops shops1 : shops) {
		    
		    ArrayList<String> api = GooglePlaces.getAPI(shops1.getPlace_id());
			String name = api.get(0);
		    String phone = api.get(1);
			String address = api.get(2);
			
			shopInfo.add(name);
			shopInfo.add(shops1.getDescription());
		    shopInfo.add(shops1.getMenu());
		    shopInfo.add(shops1.getOutlets()+"");
		    shopInfo.add(shops1.getCapacity()+"");
		    shopInfo.add(shops1.getPlace_id()+"");
		    shopInfo.add(shops1.getBudget()+"");
			shopInfo.add(phone);
			shopInfo.add(address);
		}
		return shopInfo;
	}

	public static void addShop(Shops p) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Shops.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		session.save(p);



		session.getTransaction().commit();
		session.close();  
	}
	/*public static String getInfo() {
		String DAO = "<table border=\"1\">";
				//+ "<tr><th>Username</th><th>Email</th><th>Full Name</th><th>Delete User</th></tr>";//include start table tag
		List<Shops> shops = getShops();
		for (Shops shops1 : shops) {
			// DAO = shops1.getShop_name();
			DAO += "<tr><td>" + shops1.getShop_name() + "</td><td>" + shops1.getDescription() + "</td><td>" 
		     + shops1.getMenu() + "</td><td>" + shops1.getOutlets() + "</td><td>"  + shops1.getCapacity() 
		     + "</td><td>" + shops1.getPlaceId()+ shops1.getBudget();
		}
		DAO += "</table>";
		return DAO;
	}*/
}