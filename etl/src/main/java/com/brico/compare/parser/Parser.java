package com.brico.compare.parser;

import com.brico.compare.entity.Product;

import java.io.IOException;
import java.util.List;

/**
 * Created by edeltil on 25/01/2017.
 */
public interface Parser {

	List<Product> parseDirectory() throws IOException;

	Product parseHTML(String path) throws IOException;
}
