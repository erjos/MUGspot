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
import org.hibernate.criterion.Restrictions;
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
			String picture1 = api.get(3);

			
			shop.put("id", shops1.getId());
			shop.put("name", name);
			shop.put("description", shops1.getDescription());
			shop.put("description2", shops1.getDescription2());
			shop.put("menu", shops1.getMenu());
			shop.put("outlets", shops1.getOutlets()+"");
			shop.put("capacity", shops1.getCapacity()+"");
			shop.put("budget", shops1.getBudget()+"");
			shop.put("phone", phone);
			shop.put("address", address);
			shop.put("picture1", picture1);

			
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
		session.close();
	}

	public static Map getInfoById(String id) throws ClientProtocolException, IOException, ParseException {
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
		 String[] pictures = {"picture1", "picture2", "picture3", "picture4", "picture5", "picture6", "picture7", "picture8", "picture9", "picture10"};
			for (int i = 3; i <= api.size()-1; i++){
			if (!api.isEmpty())
				pictures[i-3] = api.get(i);
				 }

		shopMap.put("id", shop.getId());
		shopMap.put("name", name);
		shopMap.put("description", shop.getDescription());
		shopMap.put("description2", shop.getDescription2());
		shopMap.put("menu", shop.getMenu());
		shopMap.put("outlets", shop.getOutlets()+"");
		shopMap.put("capacity", shop.getCapacity()+"");
		shopMap.put("budget", shop.getBudget()+"");
		shopMap.put("phone", phone);
		shopMap.put("address", address);
		
		shopMap.put("picture1", pictures[0]);
		shopMap.put("picture2", pictures[1]);
		shopMap.put("picture3", pictures[2]);
		shopMap.put("pictue4", pictures[3]);
		shopMap.put("picture5", pictures[4]);
		shopMap.put("picture6", pictures[5]);
		shopMap.put("picture7", pictures[6]);
		shopMap.put("picture8", pictures[7]);
		shopMap.put("picture9", pictures[8]);
		shopMap.put("picture10", pictures[9]);

		session.getTransaction().commit();
		session.close();
		
		return shopMap;
	}

	
	//method that checks if a searched City already exists in the database
	public static boolean doesCityExist(String placeID){
		boolean exists = false;
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(City.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Criteria crit = session.createCriteria(City.class);
		crit.add( Restrictions.eq("place_id", placeID));
		
		List city = crit.list();
		if (city.size() > 0){
			exists = true;
		}
		
		session.getTransaction().commit();
		session.close();
		
		return exists;
	}
	
	public static boolean getCity(String placeID) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(City.class)
				.buildSessionFactory();
		
		boolean exists = false;

		Session session = factory.getCurrentSession();
		session.beginTransaction();

		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(City.class);
		criteria.add( Restrictions.eq("place_id", placeID));

		@SuppressWarnings("unchecked")
		List<City> cities = criteria.list();
		
		if (cities.size() > 0){
			exists = true;
		}

		session.getTransaction().commit();
		session.close();
		
		return exists;
	}
}
