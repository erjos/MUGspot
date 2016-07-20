package com.mugspot;

public class Shop {
	
	private int ID;
	


	private long placeID;
	private String shop_name;
	private String description;
	private int outlets;
	private int capacity;
	private int tables;
//	private String address;
//	private int lattitude;
//	private int longitude;
	
	
	public Shop(){}


	public String getName() {
		return shop_name;
	}


//	public String getAddress() {
//		return address;
//	}


//	public int getLattitude() {
//		return lattitude;
//	}


//	public int getLongitude() {
//		return longitude;
//	}


	public void setName(String name) {
		this.shop_name = name;
	}


//	public void setAddress(String address) {
//		this.address = address;
//	}


//	public void setLattitude(int lattitude) {
//		this.lattitude = lattitude;
//	}


//	public void setLongitude(int longitude) {
//		this.longitude = longitude;
//	}
//	
	
	public int getID() {
		return ID;
	}


	public long getPlaceID() {
		return placeID;
	}

	public String getDescription() {
		return description;
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


	public void setPlaceID(long placeID) {
		this.placeID = placeID;
	}


	public void setDescription(String description) {
		this.description = description;
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
	
	
}
