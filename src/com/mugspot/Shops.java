package com.mugspot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coffee_shops")
public class Shops {
	
		

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ID")
		private int id;
		
		@Column(name = "shop_name")
		private String shop_name;
		
		@Column(name = "description")
		private String description;
		
		@Column(name = "menu")
		private String menu;
		
		@Column(name = "outlets")
		private int outlets;
		
		@Column(name = "capacity")
		private int capacity;
		
		@Column(name = "tables")
		private int tables;
		
		public Shops (){}

		public Shops(int id, String shop_name, String description, String menu, int outlets, int capacity, int tables) {
			super();
			this.id = id;
			this.shop_name = shop_name;
			this.description = description;
			this.menu = menu;
			this.outlets = outlets;
			this.capacity = capacity;
			this.tables = tables;
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

		public int getTables() {
			return tables;
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

		public void setMenu(String menu) {
			this.menu = menu;
		}

		public void setOutlets(int outlets) {
			this.outlets = outlets;
		}

		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}

		public void setTables(int tables) {
			this.tables = tables;
		}
		
		@Override
		public String toString() {
			return "Shops [id=" + id + ", shop_name=" + shop_name + ", description=" + description + ", menu=" + menu
					+ ", outlets=" + outlets + ", capacity=" + capacity + ", tables=" + tables + "]";
		}
}