package com.mapapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coordinate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Double lat;

	private Double lng;

	public Double getLat() {
		return lat;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Coordinate(Double lat, Double lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}

	public Coordinate() {
		super();
	}

}
