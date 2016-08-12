package com.group.mugspot.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
//import org.eclipse.jdt.internal.compiler.batch.Main;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.json.simple.parser.ParseException;
import javax.persistence.criteria.CriteriaQuery;

import com.group.mugspot.controller.*;

import javassist.expr.NewArray;

public class DAO {
	private static SessionFactory factory;
	
	// Shopinfo table methods -------------------
	//This method returns all the shops with our unique data (i.e. outlets, capacity, tables, average cup of coffee)
	//from the shops table. Parameter cityID ensures we only get the info pertaining to the city 
	//selected by the user. It gets called in the getInfo method. 
	public static List<Shops> getShops(Integer cityID) {
		SessionFactory factory = DBFactory.setupFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();

		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Shops.class);
		//adding criteria so the list only returns if the cityID is the same as the parameter
		criteria.add( Restrictions.eq("city_id", cityID));

		@SuppressWarnings("unchecked")
		List<Shops> shops = criteria.list();

		session.getTransaction().commit();
		session.close();
		
		return shops;
	}

	//The purpose of this method is to make an array combining our unique data with Google Places API. 
	//To accomlish this we use the getShops() method to return our unique data. We also use the getAPI() method from Google
	//Places.java to return more info from Google. We combine all this in an ArrayList <Map>. We use Hashmaps to make it 
	//easier to call the indexes from the jsp pages.
	//This method is used to display all the shops on the shop.jsp page
	public static ArrayList<Map> getInfo(Integer cityID) throws ClientProtocolException, IOException, ParseException {
		List<Shops> shops = getShops(cityID);
		ArrayList<Map> shopInfo = new ArrayList<Map>();
		for (Shops shops1 : shops) {

			Map shop = new HashMap();

			//System.out.println("Shop ID: " + shops1.getPlace_id());

			ArrayList<String> api = GooglePlaces.getAPI(shops1.getPlace_id());
			String name = api.get(0);
			String phone = api.get(1);
			String address = api.get(2);
			String lat = api.get(3);
			String lng = api.get(4);
			String picture1 = api.get(5);

			shop.put("id", shops1.getId());
			shop.put("name", name);
			shop.put("description", shops1.getDescription());
			shop.put("description2", shops1.getDescription2());
			shop.put("menu", shops1.getMenu());
			shop.put("outlets", shops1.getOutlets() + "");
			shop.put("capacity", shops1.getCapacity() + "");
			shop.put("budget", shops1.getBudget() + "");
			shop.put("phone", phone);
			shop.put("address", address);
			shop.put("picture1", picture1);
			shop.put("lat", lat);
			shop.put("lng", lng);

			shopInfo.add(shop);

		}
		return shopInfo;
	}

	//This is a simple method that uses Hibernate to add a shop in the Database. It binds the Pojo class of shops
	//to the columns in the table
	public static void addShop(Shops p) {
		SessionFactory factory = DBFactory.setupFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		session.save(p);

		session.getTransaction().commit();
		session.close();
	}

	//Deletes a shop that has selected id
	public static void deleteShop(int id) {
		SessionFactory factory = DBFactory.setupFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();
		Shops shop = new Shops();
		shop.setId(id);
		session.delete(shop);
		session.getTransaction().commit();
		session.close();
	}
	
	//This method is to be used on shopProfile.jsp page to display more detailed information about the shop that the user 
	//selected. In here another Hashmap is created to help get the indexes in the jsp pages. In this map in addtion to 
	//returning the databse data we also return pictures from Google Place API. 
	public static Map getInfoById(String id) throws ClientProtocolException, IOException, ParseException {
		SessionFactory factory = DBFactory.setupFactory();

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
		String[] pictures = { "picture1", "picture2", "picture3", "picture4", "picture5", "picture6", "picture7",
				"picture8", "picture9", "picture10" };
		for (int i = 5; i <= api.size() - 1; i++) {
			if (!api.isEmpty())
				pictures[i - 5] = api.get(i);
		}

		shopMap.put("id", shop.getId());
		shopMap.put("name", name);
		shopMap.put("description", shop.getDescription());
		shopMap.put("description2", shop.getDescription2());
		shopMap.put("menu", shop.getMenu());
		shopMap.put("outlets", shop.getOutlets() + "");
		shopMap.put("capacity", shop.getCapacity() + "");
		shopMap.put("budget", shop.getBudget() + "");
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

	// City table methods -----------------------

	// method that checks if a searched City already exists in the database
	public static boolean doesCityExist(String placeID) {
		boolean exists = false;
		SessionFactory factory = DBFactory.setupFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();

		Criteria crit = session.createCriteria(City.class);
		crit.add(Restrictions.eq("place_id", placeID));

		List city = crit.list();
		if (city.size() > 0) {
			exists = true;
		}

		session.getTransaction().commit();
		session.close();

		return exists;
	}

	// method which creates a new City in the database
	public static void addCity(City c) {
		SessionFactory factory = DBFactory.setupFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		session.save(c);

		session.getTransaction().commit();
		session.close();
	}

	// method which will return an ArrayList of the existing city names in the
	// database (for use on the first menu)
	public static ArrayList<Map> getCityNames() {
		SessionFactory factory = DBFactory.setupFactory();

		boolean exists = false;

		Session session = factory.getCurrentSession();
		session.beginTransaction();

		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(City.class);

		@SuppressWarnings("unchecked")
		List<City> cities = criteria.list();

		ArrayList<Map> cityNames = new ArrayList<Map>();

		for (City city : cities) {
			Map cityMap = new HashMap();
			String name = city.getCityName();
			int id = city.getId();

			cityMap.put("name", name);
			cityMap.put("id", id);

			cityNames.add(cityMap);
		}

		session.getTransaction().commit();
		session.close();

		return cityNames;
	}

	public static int getCityID(String placeID) {
		SessionFactory factory = DBFactory.setupFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();

		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(City.class);
		criteria.add(Restrictions.eq("place_id", placeID));

		@SuppressWarnings("unchecked")
		List<City> cities = criteria.list();
		int id = 0;

		for (City city : cities) {
			id = city.getId();
		}
		return id;
	}

	public static Map getCurrentCity(int cityID) {
		SessionFactory factory = DBFactory.setupFactory();

		boolean exists = false;

		Session session = factory.getCurrentSession();
		session.beginTransaction();

		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(City.class);
		criteria.add(Restrictions.eq("id", cityID));

		@SuppressWarnings("unchecked")
		List<City> cities = criteria.list();

		Map cityMap = new HashMap();

		for (City city : cities) {
			cityMap = new HashMap();
			String name = city.getCityName();
			int id = city.getId();

			cityMap.put("name", name);
			cityMap.put("id", id);

		}

		session.getTransaction().commit();
		session.close();

		return cityMap;
	}

	// Users table Methods-------------------
  
	public static void addUser(Users p) {
		SessionFactory factory = DBFactory.setupFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		session.save(p);

		session.getTransaction().commit();
		session.close();
	}

	public static boolean checkLogin(Users u) {
		SessionFactory factory = DBFactory.setupFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();

		
		String username="'"+u.getEmail()+"'";
		String hql = "SELECT password FROM Users WHERE email = "+username;
		List query = session.createQuery(hql).list();


		session.getTransaction().commit();
		session.close();


		if(!query.isEmpty() && query.get(0).equals(u.getPassword()))
			return true;
		
		//the resetPassword method does not exist yet
		//u.resetPassword();
		return false;
    }

	public static boolean containsUser(Users user) {

		SessionFactory factory = DBFactory.setupFactory();

		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();

		String username = "'" + user.getEmail() + "'";
		String hql = "FROM User WHERE username = " + username;
		Query query = hibernateSession.createQuery(hql);
		List results = query.list();
		
		hibernateSession.getTransaction().commit();
		hibernateSession.close();

		if (results.isEmpty())
			return false;

		return true;
	}
        
      
	
	public static int getUserID(Users user){
		SessionFactory factory = DBFactory.setupFactory();

		Session session = factory.openSession();
		session.getTransaction().begin();
		
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Users.class);
		criteria.add( Restrictions.eq("email", user.getEmail()));
		
		@SuppressWarnings("unchecked")
		List<Users> users = criteria.list();
		int userID = 0;
		for(Users u : users){
			userID= u.getID();
		}
		session.getTransaction().commit();
		session.close();
		return userID;
	}
	
	//putting a hold on using this for now - we dont need to display the username to other users on the revie page
	public static ArrayList<String> getUserName(ArrayList<Integer> userID){
		SessionFactory factory = DBFactory.setupFactory();
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Users.class);
		ArrayList<String> usernames= new ArrayList<String>();
		
		for(Integer id: userID){
		criteria.add( Restrictions.eq("ID", id));
		
		@SuppressWarnings("unchecked")
		List<Users> users = criteria.list();
		
		for(Users us: users){
		String username = us.getEmail();
		usernames.add(username);
		}
		
		}
		session.getTransaction().commit();
		session.close();
		return usernames;
	}
			
	
	public static void addReview(Reviews reviews) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Reviews.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		session.save(reviews);

		session.getTransaction().commit();
		session.close();
	}


	public static List <Reviews> getReviews(int shop_id)
		/*public static void main (String [] args)*/ {
		SessionFactory factory = DBFactory.setupFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		
		@SuppressWarnings("unchecked")
		List<Reviews> review = session.createQuery("from Reviews where shop_id =" + shop_id).getResultList();
		
		System.out.println(review);
		session.getTransaction().commit();
		session.close();

		return review;
	}
}

