package com.brico.compare.controller;

import java.net.UnknownHostException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.brico.compare.exception.ProductNotFoundException;
import com.brico.compare.repository.ProductRepository;
import com.brico.compare.service.ProductService;

import static org.junit.Assert.assertNotNull;

/**
 * Created by edeltil on 25/07/2017.
 */
public class ProductControllerTest {

	private ProductController controller;

	@Before
	public void init() throws UnknownHostException {

		controller = new ProductController();
		ProductService service = new ProductService();
		ProductRepository repository = new ProductRepository();
		ReflectionTestUtils.setField(controller, "productService", service);
		ReflectionTestUtils.setField(service, "repository", repository);
	}

	@Test
	public void test_OK() throws ProductNotFoundException {
		assertNotNull(controller.findOne("d25849a4-d9c5-489e-89fd-3ab26709fb0f"));
	}

	@Test(expected = ProductNotFoundException.class)
	public void test_not_exist() throws ProductNotFoundException {
		assertNotNull(controller.findOne("00"));
	}

}