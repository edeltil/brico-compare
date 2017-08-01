package com.brico.compare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brico.compare.entity.Product;
import com.brico.compare.repository.ProductRepository;

/**
 * Created by edeltil on 25/07/2017.
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public Optional<Product> findOne(final String id) {
		return repository.findOne(id);
	}
}
