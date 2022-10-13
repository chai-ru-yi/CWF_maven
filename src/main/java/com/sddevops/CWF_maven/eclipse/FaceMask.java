package com.sddevops.CWF_maven.eclipse;

import java.util.Comparator;
import java.util.Objects;

public class FaceMask {
	
	private String id;
	private String product_name;
	private String description;
	private double price;
	private String mask_type;
	private String face_type;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getMask_type() {
		return mask_type;
	}
	public void setMask_type(String mask_type) {
		this.mask_type = mask_type;
	}
	public String getFace_type() {
		return face_type;
	}
	public void setFace_type(String face_type) {
		this.face_type = face_type;
	}
	public FaceMask(String id, String product_name, String description, double price, String mask_type,
			String face_type) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.description = description;
		this.price = price;
		this.mask_type = mask_type;
		this.face_type = face_type;
	}
	
	
	
	
}
