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
		    
			System.out.println("Shop ID: " + shops1.getPlace_id());
			
			ArrayList<String> api = GooglePlaces.getAPI(shops1.getPlace_id());
		    String name = api.get(0);
		    String phone = api.get(1);
			String address = api.get(2);
//			String picture1;
//			String picture2;
//			String picture3;
//			
//			
//			 picture1 = api.get(3);
//			 picture2 = api.get(4);
//			 picture3 = api.get(5);
			 
			 
			 
			 String[] pictures = {"picture1", "picture2", "picture3", "picture4", "picture5", "picture6", "picture7", "picture8", "picture9", "picture10"};
			for (int i = 3; i <= api.size()-1; i++){
			if (!api.isEmpty())
				pictures[i-3] = api.get(i);
				 }
			

			shop.put("id", shops1.getId());
			shop.put("name", name);
			shop.put("description", shops1.getDescription());
			shop.put("menu", shops1.getMenu());
			shop.put("outlets", shops1.getOutlets()+"");
			shop.put("capacity", shops1.getCapacity()+"");
			shop.put("budget", shops1.getBudget()+"");
			shop.put("phone", phone);
			shop.put("address", address);
			shop.put("picture1", pictures[0]);
			shop.put("picture2", pictures[1]);
			shop.put("picture3", pictures[2]);
			shop.put("pictue4", pictures[3]);
			shop.put("picture5", pictures[4]);
			shop.put("picture6", pictures[5]);
			shop.put("picture7", pictures[6]);
			shop.put("picture8", pictures[7]);
			shop.put("picture9", pictures[8]);
			shop.put("picture10", pictures[9]);
			
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

	public static Map getInfoById(String id) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Shops.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();

		Shops shop = session.get(Shops.class, Integer.parseInt(id));
		
		Map shopMap = new HashMap();
	    
		ArrayList<String> api = null;
		try {
			api = GooglePlaces.getAPI(shop.getPlace_id());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String name = api.get(0);
	    String phone = api.get(1);
		String address = api.get(2);

		shopMap.put("id", shop.getId());
		shopMap.put("name", name);
		shopMap.put("description", shop.getDescription());
		shopMap.put("menu", shop.getMenu());
		shopMap.put("outlets", shop.getOutlets()+"");
		shopMap.put("capacity", shop.getCapacity()+"");
		shopMap.put("budget", shop.getBudget()+"");
		shopMap.put("phone", phone);
		shopMap.put("address", address);
		

		session.getTransaction().commit();
		session.close();
		
		return shopMap;
	}
}
