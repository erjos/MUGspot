package com.group.mugspot.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shopinfo")
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "city_name")
	private String cityName;
	
	@Column(name = "place_id")
	private String placeId;

	public int getId() {
		return id;
	}

	public String getCityName() {
		return cityName;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

}
