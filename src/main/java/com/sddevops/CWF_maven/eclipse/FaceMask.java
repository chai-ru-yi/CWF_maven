package com.sddevops.CWF_maven.eclipse;

import java.util.Comparator;
import java.util.Objects;

public class FaceMask {
	private String id;
	private String name;
	private String maskType;
	private String faceType;
	private double price;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMaskType() {
		return maskType;
	}
	public void setMaskType(String maskType) {
		this.maskType = maskType;
	}
	public String getFaceType() {
		return faceType;
	}
	public void setFaceType(String faceType) {
		this.faceType = faceType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public FaceMask(String id, String name, String maskType, String faceType, double price) {
		super();
		this.id = id;
		this.name = name;
		this.maskType = maskType;
		this.faceType = faceType;
		this.price = price;
	}
	
	
}
