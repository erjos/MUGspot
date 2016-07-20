package com.group.mugspot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.simple.parser.ParseException;
import javax.persistence.criteria.CriteriaQuery;

import com.group.mugspot.controller.*;


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

		@SuppressWarnings("unchecked")
		List<Shops> shops = criteria.list();

		session.getTransaction().commit();
		session.close();
		
		return shops;
	}  

	public static ArrayList<Map> getInfo() throws ClientProtocolException, IOException, ParseException {
		List<Shops> shops = getShops();
		ArrayList<Map> shopInfo = new ArrayList<Map>();
		for (Shops shops1 : shops) {
		    
			Map shop = new HashMap();
		    
			ArrayList<String> api = GooglePlaces.getAPI(shops1.getPlace_id());
		    String name = api.get(0);
		    String phone = api.get(1);
			String address = api.get(2);

			String icon = api.get(3);
			String photo = api.get(4);
			


			shop.put("id", shops1.getId());
			shop.put("name", name);
			shop.put("description", shops1.getDescription());
			shop.put("menu", shops1.getMenu());
			shop.put("outlets", shops1.getOutlets()+"");
			shop.put("capacity", shops1.getCapacity()+"");
			shop.put("budget", shops1.getBudget()+"");
			shop.put("phone", phone);
			shop.put("address", address);
			shop.put("pic", photo);
			
			shopInfo.add(shop);
			
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
	public static void deleteShop(int id){
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Shops.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();
		Shops shop = new Shops();
		shop.setId(id);
		session.delete(shop);
		session.getTransaction().commit();
	}
	/*public static String getInfo() {
		String DAO = "<table border=\"1\">";
				//+ "<tr><th>Username</th><th>Email</th><th>Full Name</th><th>Delete User</th></tr>";//include start table tag
		List<Shops> shops = getShops();
		for (Shops shops1 : shops) {
			// DAO = shops1.getShop_name();
			DAO += "<tr><td>" + "<tr><td>" +  shops1.getShop_name() + "</td><td>" + shops1.getDescription() + "</td><td>" 
		     + shops1.getMenu() + "</td><td>" + shops1.getOutlets() + "</td><td>"  + shops1.getCapacity() 
		     + "</td><td>" + shops1.getPlaceId()+ shops1.getBudget();
		}
		DAO += "</table>";
		return DAO;
	}*/
}
