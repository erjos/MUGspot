package com.group.mugspot.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cities")
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "city_name")
	private String city_name;
	
	@Column(name = "place_id")
	private String place_id;

	public int getId() {
		return id;
	}

	public String getCityName() {
		return city_name;
	}

	public String getPlaceId() {
		return place_id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCityName(String city_name) {
		this.city_name = city_name;
	}

	public void setPlaceId(String place_id) {
		this.place_id = place_id;
	}

}
