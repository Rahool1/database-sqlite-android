package com.example.model;

import java.text.NumberFormat;
import java.util.Locale;

public class Tour {
	private long id;
	private String title;
	private String description;
	private double price;
	private String image;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		NumberFormat IndiaNF = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
		
		return title + "\n(" + IndiaNF.format(price) + ")";
	}
}
