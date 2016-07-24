package com.group.mugspot.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shopinfo")
public class Shops {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;


	@Column(name = "Shop_Name")
	private String shop_name;

	@Column(name = "Description")
	private String description;
	
	@Column(name = "Description2")
	private String description2;

	@Column(name = "Menu")
	private String menu;

	@Column(name = "Outlets")
	private int outlets;

	@Column(name = "Capacity")
	private int capacity;

	@Column(name = "Place_ID")
	private String place_id;

	@Column(name = "Budget")
	private int budget;
	
	@Column(name = "city_id")
	private int city_id;

	
	public Shops (){
		
	}
	public Shops(int id, String shop_name, String description, String description2, String menu, int outlets, int capacity, String place_id,
			int budget) {
		super();
		this.id = id;
		this.shop_name = shop_name;
		this.description = description;
		this.description2 = description2;
		this.menu = menu;
		this.outlets = outlets;
		this.capacity = capacity;
		this.place_id = place_id;
		this.budget = budget;
	}

	public int getId() {
		return id;
	}

	public String getShop_name() {
		return shop_name;
	}

	public String getDescription() {
		return description;
	}

	public String getDescription2() {
		return description2;
	}
	public String getMenu() {
		return menu;
	}

	public int getOutlets() {
		return outlets;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getPlace_id() {
		return place_id;
	}
	
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setDescription2(String description2) {
		this.description2 = description2;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public void setOutlets(int outlets) {
		this.outlets = outlets;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "Shops [id=" + id + ", Shop_Name=" + shop_name + ", Description=" + description +", Description2=" + description2 + ", Menu=" + menu
				+ ", Outlets=" + outlets + ", Capacity=" + capacity + ", Place_ID=" + place_id + ", Budget=" + budget
				+ "]";
	}

}


