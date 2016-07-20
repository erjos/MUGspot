package com.group.mugspot.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
<<<<<<< HEAD
@Table(name = "ShopInfo")
=======
@Table(name = "shopinfo")
>>>>>>> 8c9fd2e98ef1d5a4d1b41f28cf9fae78b777c0ac
public class Shops {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ID")
		private int id;
<<<<<<< HEAD

=======
		
>>>>>>> 8c9fd2e98ef1d5a4d1b41f28cf9fae78b777c0ac
		@Column(name = "Shop_Name")
		private String shop_name;
		
		@Column(name = "Description")
		private String description;
		
<<<<<<< HEAD
		@Column(name = "Menu")		
=======
		@Column(name = "Menu")
>>>>>>> 8c9fd2e98ef1d5a4d1b41f28cf9fae78b777c0ac
		private String menu;
		
		@Column(name = "Outlets")
		private int outlets;
		
		@Column(name = "Capacity")
		private int capacity;
		
<<<<<<< HEAD
		@Column(name = "Budget")
		private int budget;
		
		@Column(name = "place_id")
=======
		@Column(name = "Place_ID")
>>>>>>> 8c9fd2e98ef1d5a4d1b41f28cf9fae78b777c0ac
		private String place_id;
		
		@Column(name = "Budget")
		private int budget;

		public Shops (){}

<<<<<<< HEAD
		public Shops(int id, String shop_name, String description, String menu, int outlets, int capacity, String place_id, int budget) {
=======
		public Shops(int id, String shop_name, String description, String menu, int outlets, int capacity, int budget) {
>>>>>>> 8c9fd2e98ef1d5a4d1b41f28cf9fae78b777c0ac
			super();
			this.id = id;
			this.shop_name = shop_name;
			this.description = description;
			this.menu = menu;
			this.outlets = outlets;
			this.capacity = capacity;
<<<<<<< HEAD
			this.place_id = place_id;
=======
>>>>>>> 8c9fd2e98ef1d5a4d1b41f28cf9fae78b777c0ac
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

<<<<<<< HEAD
		public String getPlaceid() {
			return place_id;
=======
		public int getBudget() {
			return budget;
>>>>>>> 8c9fd2e98ef1d5a4d1b41f28cf9fae78b777c0ac
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

<<<<<<< HEAD
		public void setplaceid(String place_id) {
			this.place_id = place_id;
		}
		
		public int getBudget() {
			return budget;
		}

=======
>>>>>>> 8c9fd2e98ef1d5a4d1b41f28cf9fae78b777c0ac
		public void setBudget(int budget) {
			this.budget = budget;
		}
		
		
		@Override
		public String toString() {
			return "Shops [id=" + id + ", shop_name=" + shop_name + ", description=" + description + ", menu=" + menu
<<<<<<< HEAD
					+ ", outlets=" + outlets + ", capacity=" + capacity + ", place_id=" + place_id + "]";
=======
					+ ", outlets=" + outlets + ", capacity=" + capacity + ", budget=" + budget + "]";
>>>>>>> 8c9fd2e98ef1d5a4d1b41f28cf9fae78b777c0ac
		}
}