package com.brico.compare.entity;

import java.util.Date;
import java.util.UUID;

/**
 * Created by edeltil on 23/01/2017.
 */
public class Product extends SimpleProduct{
	private String description;
	private String url;
	private String unit;
	private String categorieSeller;
	private Date date;
	private String path;

	public Product() {
		super();
		date = new Date();
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCategorieSeller() {
		return categorieSeller;
	}

	public void setCategorieSeller(String categorieSeller) {
		this.categorieSeller = categorieSeller;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return super.toString() + "\nProduct{" + "description='" + description + '\'' + ", url='" + url + '\'' + ", unit='" + unit + '\'' + ", categorieSeller='" + categorieSeller
			+ '\'' + ", date=" + date + ", path='" + path + '\'' + '}';
	}
}
