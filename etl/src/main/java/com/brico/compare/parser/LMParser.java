package com.brico.compare.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.brico.compare.entity.Constants;
import com.brico.compare.entity.Product;
import com.brico.compare.entity.Seller;

/**
 * Created by edeltil on 23/01/2017.
 */
public class LMParser extends Parser {

	private static final Logger LOGGER = Logger.getLogger("LMParser");

	private static final String CONTENT_ATTR = "content";
	private static final String BARRED_CLASS = "barred";

	private static final List ORDERS = new ArrayList<>();
	static {
		ORDERS.add(ExecutionMethod.TITLE);
		ORDERS.add(ExecutionMethod.IMAGE);
		ORDERS.add(ExecutionMethod.URL);
		ORDERS.add(ExecutionMethod.SHORT_DESCRIPTION);
		ORDERS.add(ExecutionMethod.DESCRIPTION);
		ORDERS.add(ExecutionMethod.PRICE);
		ORDERS.add(ExecutionMethod.UNIT);
		ORDERS.add(ExecutionMethod.OLD_PRICE);
		ORDERS.add(ExecutionMethod.CATEGORIES);
		ORDERS.add(ExecutionMethod.RATE);
	}

	public LMParser(String directory, String path) {
		super(directory, path);
	}

	@Override
	public List<ExecutionMethod> getOrders() {
		return ORDERS;
	}

	@Override
	public boolean isEmptyProduct(Element doc) {
		return false;
	}

	@Override
	public boolean buildUnit(Element doc, Product product) {
		Element unit = doc.getElementsByClass("price").first().select("span").first();
		if (unit.text().contains("m²")) {
			product.setUnit(Constants.M2);
		} else {
			product.setUnit(Constants.UNIT);
		}
		return true;
	}

	@Override
	public boolean buildTitle(Element doc, Product product) {
		Elements elements = doc.select("meta");
		for (Element element : elements) {
			if ("twitter:title".equals(element.attr("name"))) {
				product.setTitle(element.attr(CONTENT_ATTR));
			}
		}
		return true;
	}

	@Override
	public boolean buildDescription(Element doc, Product product) {
		Element allDescription = doc.getElementsByClass("tech-desc").first();
		if (allDescription != null) {
			setDescription(product, allDescription);
		} else {
			Element caracteristiquesTech = doc.getElementsByClass("caracteristiques-techniques-table").first();
			if (caracteristiquesTech != null) {
				setDescription(product, caracteristiquesTech);
			} else {
				Element techDescription = doc.getElementsByClass("desc-product").first();
				if (techDescription != null) {
					setDescription(product, techDescription);
				}
			}
		}
		return true;
	}

	@Override
	public boolean buildShortDescription(Element doc, Product product) {
		Elements elements = doc.select("meta");
		for (Element element : elements) {
			if ("twitter:description".equals(element.attr("name"))) {
				String shortDescription = element.attr(CONTENT_ATTR).trim();
				shortDescription = shortDescription.replaceAll("(\\s\\s)+", ",");
				product.setShortDescription(shortDescription);
			}
		}
		return true;
	}

	@Override
	public boolean buildUrl(Element doc, Product product) {
		Elements elements = doc.select("meta");
		for (Element element : elements) {
			if ("og:url".equals(element.attr("property"))) {
				if ("http://www.leroymerlin.fr/".equals(element.attr(CONTENT_ATTR))) {
					return false;
				}
				product.setUrl(element.attr(CONTENT_ATTR));
			}
		}
		return true;
	}

	@Override
	public boolean buildOldPrice(Element doc, Product product) {
		if (doc.getElementsByClass(BARRED_CLASS) != null && doc.getElementsByClass(BARRED_CLASS).first() != null
			&& doc.getElementsByClass(BARRED_CLASS).first().select("em") != null) {
			Element oldprice = doc.getElementsByClass(BARRED_CLASS).first().select("em").last();
			if (StringUtils.isNotEmpty(oldprice.text().substring(0, oldprice.text().lastIndexOf('0') + 1))) {
				product.setOldPrice(getPrice(oldprice.text()));
			}
		}
		return true;
	}

	@Override
	public boolean buildPrice(Element doc, Product product) {
		Element price = doc.getElementsByClass("price").first().select("strong").first();
		try {
			product.setPrice(getPrice(price.text()));
		} catch (NumberFormatException nfe) {
			LOGGER.fine("Price not readable : ");
		}
		return true;
	}

	@Override
	public boolean buildImage(Element doc, Product product) {
		Elements elements = doc.select("meta");
		for (Element element : elements) {
			if ("twitter:image".equals(element.attr("name"))) {
				if ("http://www.leroymerlin.fr".equals(element.attr(CONTENT_ATTR))) {
					return false;
				}
				product.setImage(element.attr(CONTENT_ATTR));
			}
		}
		return true;
	}

	@Override
	public boolean buildCategories(Element doc, Product product) {
		Element elementCategories = doc.getElementsByClass("breadcrumb").first();
		if (elementCategories != null) {
			Elements elementsCategories = elementCategories.select("li");
			String categories = "";
			String splitCategories = " - ";
			for (int i = 0; i < elementsCategories.size(); i++) {
				if (elementsCategories.get(i).select("i") != null && !elementsCategories.get(i).select("i").isEmpty()) {
					Element cat = elementsCategories.get(i).select("i").first();
					if (!"Produits".equals(cat.text())) {
						categories += cat.text() + splitCategories;
					}
				}
			}
			if (categories.endsWith(splitCategories)) {
				categories = categories.substring(0, categories.length() - splitCategories.length());
			}
			product.setCategorieSeller(categories);
		}
		return true;
	}

	@Override
	public boolean buildSeller(Product product) {
		product.setSeller(Seller.LM.name());
		return true;
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

	private void setDescription(final Product product, final Element desc) {
		String descriptionHTML = desc.outerHtml();
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
