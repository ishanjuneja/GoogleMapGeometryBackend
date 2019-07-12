package com.mapapi.dto;

public class PointInPoygonRequest {

	private Integer shapeId;
	private Double lat;
	private Double lng;

	public Integer getShapeId() {
		return shapeId;
	}

	public void setShapeId(Integer shapeId) {
		this.shapeId = shapeId;
	}

	public Double getLat() {
		return lat;
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

	public PointInPoygonRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

}
