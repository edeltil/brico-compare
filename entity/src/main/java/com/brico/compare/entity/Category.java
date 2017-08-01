package com.brico.compare.entity;

import java.util.Arrays;
import java.util.List;

/**
 * Created by edeltil on 14/03/2017.
 */
public class Category {

	private String label;
	private List<String> searchs;

	public Category(String label, String[] searchs) {
		this.label = label;
		this.searchs = Arrays.asList(searchs);
	}

	public String getLabel() {
		return label;
	}

	public List<String> getSearchs() {
		return searchs;
	}

}
