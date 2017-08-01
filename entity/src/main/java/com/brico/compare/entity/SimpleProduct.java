package com.brico.compare.entity;

import java.util.UUID;

/**
 * Created by edeltil on 25/07/2017.
 */
public class SimpleProduct {
	private String id;
	private String title;
	private Double price;
	private Double oldPrice;
	private String image;
	private String shortDescription;
	private String seller;
	private int rate;

	public SimpleProduct() {
		id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(Double oldPrice) {
		this.oldPrice = oldPrice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "SimpleProduct{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", price=" + price + ", oldPrice=" + oldPrice + ", image='" + image + '\''
			+ ", shortDescription='" + shortDescription + '\'' + ", seller='" + seller + '\'' + ", rate=" + rate + '}';
	}
}
