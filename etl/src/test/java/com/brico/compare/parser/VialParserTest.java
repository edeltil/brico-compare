package com.brico.compare.parser;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import com.brico.compare.entity.Constants;
import com.brico.compare.entity.Product;
import com.brico.compare.entity.Seller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by edeltil on 08/02/2017.
 */
public class VialParserTest {

	private Logger LOGGER = Logger.getLogger(this.getClass().getSimpleName());

	@Test
	public void testParserVial() throws IOException {
		VialParser parser = new VialParser("http://www.vial-habitat.com/", "C:/_tmp/perso", "www.vial-habitat.com");
		/*Product 1*/
		Product product1 = parser.parseHTML(getClass().getResource("/Vial/product1.html").getPath());
		LOGGER.log(Level.INFO, product1.toString());
		Assert.assertEquals("1 porte cuisine décor Havane", product1.getTitle());
		Assert.assertEquals("1 porte cuisine décor Havane", product1.getShortDescription());
		Assert.assertEquals("http://www.vial-habitat.com/1-porte-cuisine-decor-havane-p7568.html", product1.getUrl());
		Assert.assertEquals("http://www.vial-habitat.com/images/produits/KCCONTHEV1F070040.jpg", product1.getImage());
		Assert.assertEquals(new Double(19), product1.getPrice());
		Assert.assertNull(product1.getOldPrice());
		Assert.assertEquals("unit", product1.getUnit());
		Assert.assertTrue(product1.getDescription().contains("Support aggloméré 17 5 mm d'épaisseur."));
		Assert.assertTrue(product1.getDescription().contains("Placage sur les deux faces en lamifié «continu»."));
		Assert.assertTrue(product1.getDescription()
			.contains("Façade post-formée sur les deux chants verticaux les chants horizontaux sont plaqués en PVC 1 mm d'épaisseur."));
		Assert.assertEquals("Cuisine tendance décor - Cuisine tendance décor Havane", product1.getCategorieSeller());
		/*Product 2*/
		Assert.assertNull(parser.parseHTML(getClass().getResource("/Vial/product2.html").getPath()));
		/*Product 3*/
		Product product2 = parser.parseHTML(getClass().getResource("/Vial/product3.html").getPath());
		LOGGER.log(Level.INFO, product2.toString());
		Assert.assertEquals("CONCERTO Blanc Pur", product2.getTitle());
		Assert.assertEquals("CONCERTO Blanc Pur", product2.getShortDescription());
		Assert.assertEquals("http://www.vial-habitat.com/cuisine-concerto-blanc-pur-p12539.html", product2.getUrl());
		Assert.assertEquals("http://www.vial-habitat.com/images/produits/concerto-blanc-pur.jpg", product2.getImage());
		Assert.assertNull(product2.getPrice());
		Assert.assertNull(product2.getOldPrice());
		Assert.assertEquals("unit", product2.getUnit());
		Assert.assertTrue(StringUtils.isEmpty(product2.getDescription()));
		Assert.assertEquals("Cuisines - Modéles Cuisine - Concerto", product2.getCategorieSeller());

	}

	@Test
	public void testParser() throws IOException {
		VialParser parser = new VialParser("http://www.vial-habitat.com/", "C:/_tmp/perso", "www.vial-habitat.com");
		List<Product> products = parser.parseDirectory();
		assertNotNull(products);
		for (Product product : products) {
			assertNotNull("Error on rate : " + product.getPath(), product.getRate());
			assertNotNull("Error on path : " + product.getPath(), product.getPath());
			assertNotNull("Error on image : " + product.getPath(), product.getImage());
			assertNotNull("Error on short description : " + product.getPath(), product.getShortDescription());
			assertNotNull("Error on seller : " + product.getPath(), product.getSeller());
			assertTrue("Error on seller : " + product, product.getSeller().equals(Seller.Vial.name()));
			assertNotNull("Error on categorie seller : " + product.getPath(), product.getCategorieSeller());
			assertNotNull("Error on description : " + product.getPath(), product.getDescription());
			assertNotNull("Error on date : " + product.getPath(), product.getDate());
			//			assertNotNull("Error on price : " + product.getPath(), product.getPrice());
			assertNotNull("Error on title : " + product.getPath(), product.getTitle());
			assertNotNull("Error on unit : " + product.getPath(), product.getUnit());
			assertTrue("Error on unit : " + product.getPath(), product.getUnit().equals(Constants.UNIT));
			assertNotNull("Error on url : " + product.getPath(), product.getUrl());
		}
	}
}