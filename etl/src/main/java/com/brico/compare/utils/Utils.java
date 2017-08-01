package com.brico.compare.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;

import com.brico.compare.entity.Product;

/**
 * Created by edeltil on 23/03/2017.
 */
public class Utils {
	private Utils() {
	}

	private static final Logger LOGGER = Logger.getLogger("Utils");

	public static void checkProduct(Product product) {
		/**/
		if (StringUtils.isEmpty(product.getDescription())) {
			LOGGER.log(Level.FINE,"Error on description parsing : " + product.getPath());
		}
		if (StringUtils.isEmpty(product.getCategorieSeller())) {
			LOGGER.log(Level.FINE,"Error on CategorieSeller parsing : " + product.getPath());
		}
		if (StringUtils.isEmpty(product.getImage())) {
			LOGGER.log(Level.FINE,"Error on image parsing : " + product.getPath());
		}
		if (StringUtils.isEmpty(product.getSeller())) {
			LOGGER.log(Level.FINE,"Error on seller parsing : " + product.getPath());
		}
		if (StringUtils.isEmpty(product.getShortDescription())) {
			LOGGER.log(Level.FINE,"Error on short description parsing : " + product.getPath());
		}
		if (StringUtils.isEmpty(product.getTitle())) {
			LOGGER.log(Level.FINE,"Error on title parsing : " + product.getPath());
		}
		if (StringUtils.isEmpty(product.getUnit())) {
			LOGGER.log(Level.FINE,"Error on unit parsing : " + product.getPath());
		}
		if (StringUtils.isEmpty(product.getUrl())) {
			LOGGER.log(Level.FINE,"Error on url parsing : " + product.getPath());
		}
		if (product.getOldPrice() == null) {
			LOGGER.log(Level.FINE,"Error on old price parsing : " + product.getPath());
		}
		if (product.getPrice() == null) {
			LOGGER.log(Level.FINE,"Error on price parsing : " + product.getPath());
		}
	}
}
