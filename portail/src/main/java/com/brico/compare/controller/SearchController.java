package com.brico.compare.controller;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.common.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brico.compare.entity.Categories;
import com.brico.compare.entity.Category;
import com.brico.compare.entity.SimpleProduct;
import com.brico.compare.service.SearchService;

/**
 * Created by edeltil on 15/03/2017.
 */
@RestController
@RequestMapping("/api")
public class SearchController {

	@Autowired
	private Categories categories;

	@Autowired
	private SearchService searchService;

	@RequestMapping("/search")
	public List<SimpleProduct> getProducts(@RequestParam(value = "searchCategories") final List<String> searchCategories,
		@RequestParam(value = "page", required = false) @Nullable Integer page, @RequestParam(value = "size", required = false) @Nullable Integer size) {
		StringBuilder stringBuilder = new StringBuilder();
		String buildCategory;
		String splitCategories = " - ";
		for (String search : searchCategories) {
			stringBuilder.append( search + splitCategories);
		}
		buildCategory = stringBuilder.toString();
		if (stringBuilder.toString().endsWith(splitCategories)) {
			buildCategory = stringBuilder.substring(0, buildCategory.length() - splitCategories.length());
		}
		for (Category category : categories.getCategories()) {
			if (category.getLabel().equalsIgnoreCase(buildCategory)) {
				if (page != null && size != null) {
					List<SimpleProduct> allProducts = searchService.search(category.getSearchs());
					if (allProducts.size() > ((page + 1) * size)) {
						return allProducts.subList(page * size, (page + 1) * size);
					}else{
						return allProducts.subList(page * size, allProducts.size());
					}
				} else {
					return searchService.search(category.getSearchs());
				}
			}
		}
		return new ArrayList<>();
	}
}
