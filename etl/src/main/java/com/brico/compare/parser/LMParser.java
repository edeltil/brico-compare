package com.brico.compare.parser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.brico.compare.entity.Constants;
import com.brico.compare.entity.Product;
import com.brico.compare.entity.Seller;
import com.brico.compare.utils.Utils;

/**
 * Created by edeltil on 23/01/2017.
 */
public class LMParser implements Parser {

	private static Logger LOGGER = Logger.getLogger("LMParser");

	private String directory;
	private String path;

	public LMParser(String directory, String path) {
		this.directory = directory;
		this.path = path;
	}

	public List<Product> parseDirectory() throws IOException {
		List<Product> products = new ArrayList<>();
		Collection<File> files = FileUtils.listFiles(new File(directory + File.separator + path), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
		for (File file : files) {
			LOGGER.log(Level.FINEST, file.getPath());
			Product product = parseHTML(file.getPath());
			if (product != null) {
				products.add(product);
			}
		}
		return products;
	}

	public Product parseHTML(String path) throws IOException {
		Document doc = Jsoup.parse(new File(path), Charset.forName("UTF-8").name());
		Elements elements = doc.select("meta");
		Product product = new Product();
		product.setSeller(Seller.LM.name());
		product.setPath(path);
		for (Element element : elements) {
			if ("twitter:title".equals(element.attr("name"))) {
				product.setTitle(element.attr("content"));
			} else if ("twitter:image".equals(element.attr("name"))) {
				if ("http://www.leroymerlin.fr".equals(element.attr("content"))) {
					return null;
				}
				product.setImage(element.attr("content"));
			} else if ("og:url".equals(element.attr("property"))) {
				if (element.attr("content").equals("http://www.leroymerlin.fr/")) {
					return null;
				}
				product.setUrl(element.attr("content"));
			} else if ("twitter:description".equals(element.attr("name"))) {
				String shortDescription = element.attr("content").trim();
				shortDescription = shortDescription.replaceAll("(\\s\\s)+", ",");
				product.setShortDescription(shortDescription);
			}
		}
		Element allDescription = doc.getElementsByClass("tech-desc").first();
		if (allDescription != null) {
			String descriptionHTML = allDescription.outerHtml();
			Document descriptionDoc = Jsoup.parse(descriptionHTML);
			Elements titles = descriptionDoc.select("th");
			Elements values = descriptionDoc.select("td");
			String description = "";
			for (int i = 0; i < titles.size(); i++) {
				description += titles.get(i).text() + " : " + values.get(i).text();
				if (i != titles.size() - 1) {
					description += ", ";
				}
			}
			product.setDescription(description);
		} else {
			Element caracteristiques_tech = doc.getElementsByClass("caracteristiques-techniques-table").first();
			if (caracteristiques_tech != null) {
				String descriptionHTML = caracteristiques_tech.outerHtml();
				Document descriptionDoc = Jsoup.parse(descriptionHTML);
				Elements titles = descriptionDoc.select("th");
				Elements values = descriptionDoc.select("td");
				String description = "";
				for (int i = 0; i < titles.size(); i++) {
					description += titles.get(i).text() + " : " + values.get(i).text();
					if (i != titles.size() - 1) {
						description += ", ";
					}
				}
				product.setDescription(description);
			} else {
				Element techDescription = doc.getElementsByClass("desc-product").first();
				if (techDescription != null) {
					String descriptionHTML = allDescription.outerHtml();
					Document descriptionDoc = Jsoup.parse(descriptionHTML);
					Elements titles = descriptionDoc.select("th");
					Elements values = descriptionDoc.select("td");
					String description = "";
					for (int i = 0; i < titles.size(); i++) {
						description += titles.get(i).text() + " : " + values.get(i).text();
						if (i != titles.size() - 1) {
							description += ", ";
						}
					}
					product.setDescription(description);
				}
			}
		}
		Element price = doc.getElementsByClass("price").first().select("strong").first();
		try {
			product.setPrice(getPrice(price.text()));
		} catch (NumberFormatException nfe) {
		}
		Element unit = doc.getElementsByClass("price").first().select("span").first();
		if (unit.text().contains("m²")) {
			product.setUnit(Constants.M2);
		} else {
			product.setUnit(Constants.UNIT);
		}
		if (doc.getElementsByClass("barred") != null && doc.getElementsByClass("barred").first() != null
			&& doc.getElementsByClass("barred").first().select("em") != null) {
			Element oldprice = doc.getElementsByClass("barred").first().select("em").last();
			if (StringUtils.isNotEmpty(oldprice.text().substring(0, oldprice.text().lastIndexOf("0") + 1))) {
				product.setOldPrice(getPrice(oldprice.text()));
			}
		} else {
		}
		Element elementCategories = doc.getElementsByClass("breadcrumb").first();
		if (elementCategories != null) {
			Elements elementsCategories = elementCategories.select("li");
			String categories = "";
			String splitCategories = " - ";
			for (int i = 0; i < elementsCategories.size(); i++) {
				if (elementsCategories.get(i).select("i") != null && !elementsCategories.get(i).select("i").isEmpty()) {
					Element cat = elementsCategories.get(i).select("i").first();
					if (!cat.text().equals("Produits")) {
						categories += cat.text() + splitCategories;
					}
				}
			}
			if (categories.endsWith(splitCategories)) {
				categories = categories.substring(0, categories.length() - splitCategories.length());
			}
			product.setCategorieSeller(categories);
		}
		Utils.checkProduct(product);
		return product;
	}

	private Double getPrice(String text) {
		Pattern p = Pattern.compile("(\\d+[.,]\\d+)");
		Matcher m = p.matcher(text);
		if (m.find()) {
			String price = m.group();
			return new Double(price.replaceAll(",", ".").replaceAll(" ", ""));
		}
		return null;
	}

}
