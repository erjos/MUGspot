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

public class DAO {

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

	public static ArrayList<Map> getInfo() throws ClientProtocolException, IOException, ParseException {
		List<Shops> shops = getShops();
		ArrayList<Map> shopInfo = new ArrayList<Map>();
		for (Shops shops1 : shops) {
		    
			Map shop = new HashMap();
		    
			ArrayList<String> api = GooglePlaces.getAPI(shops1.getPlace_id());
		    String name = api.get(0);
		    String phone = api.get(1);
			String address = api.get(2);
			
			shop.put("id", shops1.getId());
			shop.put("name", name);
			shop.put("description", shops1.getDescription());
			shop.put("menu", shops1.getMenu());
			shop.put("outlets", shops1.getOutlets()+"");
			shop.put("capacity", shops1.getCapacity()+"");
			shop.put("budget", shops1.getBudget()+"");
			shop.put("phone", phone);
			shop.put("address", address);
			
			shopInfo.add(shop);
			
			/*shopInfo.add(name);
			shopInfo.add(shops1.getDescription());
		    shopInfo.add(shops1.getMenu());
		    shopInfo.add(shops1.getOutlets()+"");
		    shopInfo.add(shops1.getCapacity()+"");
		    shopInfo.add(shops1.getTables()+"");
			
			shopInfo.add(phone);
			shopInfo.add(address);*/
		}
		return shopInfo;
	}
	
/*	public static ArrayList<String> getInfo() throws ClientProtocolException, IOException, ParseException {
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
		    //shopInfo.add(shops1.getTables()+"");
			
			shopInfo.add(name);
			shopInfo.add(phone);
			shopInfo.add(address);
		}
		return shopInfo;
	}   

	}*/
	

	/*public static String getInfo() {
		String DAO = "<table border=\"1\">";
				//+ "<tr><th>Username</th><th>Email</th><th>Full Name</th><th>Delete User</th></tr>";//include start table tag
		List<Shops> shops = getShops();
		for (Shops shops1 : shops) {
			// DAO = shops1.getShop_name();
			DAO += "<tr><td>" + "<tr><td>" +  shops1.getShop_name() + "</td><td>" + shops1.getDescription() + "</td><td>" 
		     + shops1.getMenu() + "</td><td>" + shops1.getOutlets() + "</td><td>"  + shops1.getCapacity() 
		     + "</td><td>" + shops1.getTables();
		}
		DAO += "</table>";
		return DAO;
	}*/
}