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

public class DAO {
	
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
			
		}
		return shopInfo;
	}

}
