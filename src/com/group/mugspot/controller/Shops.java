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

		public Shops (){}

		public Shops(int id, String shop_name, String description, String menu, int outlets, int capacity, int budget) {
			super();
			this.id = id;
			this.shop_name = shop_name;
			this.description = description;
			this.menu = menu;
			this.outlets = outlets;
			this.capacity = capacity;
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

		public String getMenu() {
			return menu;
		}

		public int getOutlets() {
			return outlets;
		}

		public int getCapacity() {
			return capacity;
		}

		public int getBudget() {
			return budget;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		public String getPlace_id() {
			return place_id;
		}

		public void setPlace_id(String place_id) {
			this.place_id = place_id;
		}


		public void setShop_name(String shop_name) {
			this.shop_name = shop_name;
		}

		public void setDescription(String description) {
			this.description = description;
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

		public void setBudget(int budget) {
			this.budget = budget;
		}
		
		
		@Override
		public String toString() {
			return "Shops [id=" + id + ", shop_name=" + shop_name + ", description=" + description + ", menu=" + menu
					+ ", outlets=" + outlets + ", capacity=" + capacity + ", budget=" + budget + "]";
		}
}