package com.brico.compare.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.brico.compare.entity.Constants;
import com.brico.compare.entity.Product;
import com.brico.compare.entity.Seller;

/**
 * Created by edeltil on 24/01/2017.
 */
public class BMParser extends Parser {

	private static final String OLD_PRICE_CLASS = "old-price";
	private static final String DESCRIPTION_CLASS = "magento-product-decscription";
	private static final String CONTENT_CLASS = "product-content";
	private static final String MESSAGE_CLASS = "note-msg";
	private static final String NEW_PRICE_CLASS = "new-price";
	private static final String SMALL_CLASS = "small";

	private static final List ORDERS = new ArrayList<>();

	static {
		ORDERS.add(ExecutionMethod.DESCRIPTION);
		ORDERS.add(ExecutionMethod.SHORT_DESCRIPTION);
		ORDERS.add(ExecutionMethod.URL);
		ORDERS.add(ExecutionMethod.TITLE);
		ORDERS.add(ExecutionMethod.OLD_PRICE);
		ORDERS.add(ExecutionMethod.PRICE);
		ORDERS.add(ExecutionMethod.UNIT);
		ORDERS.add(ExecutionMethod.IMAGE);
		ORDERS.add(ExecutionMethod.CATEGORIES);
		ORDERS.add(ExecutionMethod.RATE);
	}

	public BMParser(String directory, String path) {
		super(directory, path);
	}

	@Override
	public List<ExecutionMethod> getOrders() {
		return ORDERS;
	}

	@Override
	public boolean isEmptyProduct(final Element doc) {
		if (doc.getElementsByClass(CONTENT_CLASS) != null && doc.getElementsByClass(CONTENT_CLASS).first() != null
			&& doc.getElementsByClass(CONTENT_CLASS).first().getElementsByClass(MESSAGE_CLASS) != null
			&& doc.getElementsByClass(CONTENT_CLASS).first().getElementsByClass(MESSAGE_CLASS).first() != null && "Aucun produit ne correspond à la sélection."
			.equals(doc.getElementsByClass(CONTENT_CLASS).first().getElementsByClass(MESSAGE_CLASS).first().text())) {
			return true;
		}
		return false;
	}

	@Override
	public boolean buildDescription(final Element doc, Product product) {
		if (doc.getElementsByClass(DESCRIPTION_CLASS) != null && doc.getElementsByClass(DESCRIPTION_CLASS).first() != null) {
			Element elementDescription = doc.getElementsByClass(DESCRIPTION_CLASS).first();
			StringBuilder builderDescription = new StringBuilder();
			builderDescription.append(elementDescription.ownText());
			for (Element element : elementDescription.select("li")) {
				builderDescription.append(" , ").append(element.text());
			}
			product.setDescription(builderDescription.toString());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean buildShortDescription(Element doc, Product product) {
		if (doc.getElementsByClass(DESCRIPTION_CLASS) != null && doc.getElementsByClass(DESCRIPTION_CLASS).first() != null) {
			Element elementDescription = doc.getElementsByClass(DESCRIPTION_CLASS).first();
			product.setShortDescription(elementDescription.ownText());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean buildUnit(final Element doc, Product product) {
		product.setUnit(Constants.UNIT);
		if (doc.getElementsByClass(NEW_PRICE_CLASS) != null && doc.getElementsByClass(NEW_PRICE_CLASS).first() != null
			&& doc.getElementsByClass(NEW_PRICE_CLASS).first().select(SMALL_CLASS) != null) {
			String strUnit = doc.getElementsByClass(NEW_PRICE_CLASS).first().select(SMALL_CLASS).text();
			Double priceUnit = getPrice(strUnit);
			if (priceUnit != null && product.getPrice().equals(priceUnit) && strUnit.contains("/m²")) {
					product.setUnit("le m²");
			}
		}
		return true;
	}

	@Override
	public boolean buildTitle(final Element doc, Product product) {
		product.setTitle(doc.select("h1").first().text());
		return true;
	}

	@Override
	public boolean buildUrl(final Element doc, Product product) {
		Elements elements = doc.select("link");
		for (Element link : elements) {
			if ("canonical".equals(link.attr("rel"))) {
				product.setUrl(link.attr("href"));
			}
		}
		return true;
	}

	@Override
	public boolean buildOldPrice(final Element doc, Product product) {
		if (doc.getElementsByClass(OLD_PRICE_CLASS) != null && doc.getElementsByClass(OLD_PRICE_CLASS).first() != null) {
			product.setOldPrice(getPrice(doc.getElementsByClass(OLD_PRICE_CLASS).first().text()));
		}
		return true;
	}

	@Override
	public boolean buildPrice(final Element doc, Product product) {
		product.setPrice(getPrice(doc.getElementsByClass("new-price").first().text()));
		return true;
	}

	@Override
	public boolean buildImage(final Element doc, Product product) {
		product.setImage(doc.getElementsByClass("fiche-product-image-container").select("img").attr("src"));
		if (!product.getImage().contains("image")) {
			product.setImage(doc.getElementsByClass("jcarousel-clip jcarousel-clip-vertical").select("li").attr("data-target"));
		}
		return true;
	}

	@Override
	public boolean buildRate(final Element doc, Product product) {
		for (Element element : doc.select("a")) {
			if (element.hasClass("bv-rating")) {
				product.setRate(Integer.parseInt(element.text().substring(0, element.text().indexOf('.'))));
			}
		}
		return true;
	}

	@Override
	public boolean buildSeller(Product product) {
		product.setSeller(Seller.BM.name());
		return true;
	}

	@Override
	public boolean buildCategories(final Element doc, Product product) {
		Element breadcrumb = doc.getElementById("breadcrumb");
		Elements links = breadcrumb.select("a");
		String categories;
		StringBuilder builderCategories = new StringBuilder();
		String splitCategories = " - ";
		for (Element link : links) {
			if (link.attr("href") != null && StringUtils.isNotEmpty(link.attr("href"))) {
				builderCategories.append(link.text()).append(splitCategories);
			}
		}
		categories = builderCategories.toString();
		if (categories.endsWith(splitCategories)) {
			categories = categories.substring(0, categories.length() - splitCategories.length());
		}
		product.setCategorieSeller(categories);
		return true;
	}

	protected Double getPrice(String text) {
		Pattern p = Pattern.compile("((\\d+)\\D(\\d{3}[.,]\\d+))");
		Matcher m = p.matcher(text);
		if (m.find()) {
			String price = m.group(2) + m.group(3);
			return new Double(price.replaceAll(",", "."));
		} else {
			p = Pattern.compile("(\\d+[.,]\\d+)");
			m = p.matcher(text);
			if (m.find()) {
				String price = m.group();
				return new Double(price.replaceAll(",", "."));
			} else {
				return null;
			}
		}
	}
}
