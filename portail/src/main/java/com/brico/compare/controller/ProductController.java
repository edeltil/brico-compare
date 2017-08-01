package com.brico.compare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brico.compare.entity.Product;
import com.brico.compare.exception.ProductNotFoundException;
import com.brico.compare.service.ProductService;

/**
 * Created by edeltil on 25/07/2017.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET, path = "{id:\\S+}")
	public Product findOne(@PathVariable("id") String id) throws ProductNotFoundException {
		return productService.findOne(id)
			.orElseThrow(ProductNotFoundException::new);
	}
}
