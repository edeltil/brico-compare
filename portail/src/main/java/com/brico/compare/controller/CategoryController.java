package com.brico.compare.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brico.compare.entity.Categories;
import com.brico.compare.entity.Category;
import com.brico.compare.entity.Seller;

/**
 * Created by edeltil on 15/03/2017.
 */
@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private Categories categories;

	@RequestMapping("/categories")
	public List<String> getCategories(@RequestParam(value = "root") final List<String> root) {
		List<Category> allCategories = categories.getCategories();
		List<String> searchs = new ArrayList<>();
		for (Category category : allCategories) {
			String[] cat = category.getLabel().split(" - ");
			if (root.isEmpty()) {
				if (!searchs.contains(cat[0])) {
					searchs.add(cat[0]);
				}
			} else {
				boolean found = false;
				for (int index = 0; index < root.size(); index++) {
					if (index + 1 < cat.length && root.get(index).equals(cat[index]) && !searchs.contains(cat[index + 1])) {
						found = true;
					} else {
						found = false;
					}
				}
				if (found) {
					searchs.add(cat[root.size()]);
				}
			}
		}

		return searchs;
	}

	@RequestMapping("/sellers")
	public List<String> getSellers() {
		List<String> sellers = new ArrayList<>();
		for (Seller seller : Seller.values()) {
			sellers.add(seller.getLabel());
		}
		return sellers;
	}
}
