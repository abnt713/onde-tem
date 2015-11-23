package org.ondetem.entities;

import java.io.Serializable;

public class Marker implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double latitude, longitude;
	private String label;
	
	public Marker() {
		this(0,0, "");
	}
	public Marker(double latitude, double longitude, String label) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.label = label;
	}
	
	public Marker(Marker marker) {
		this(marker.getLatitude(), marker.getLongitude(), marker.getLabel());
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
