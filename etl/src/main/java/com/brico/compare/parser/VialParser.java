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
 * Created by edeltil on 23/01/2017.
 */
public class VialParser extends AbstractParser {

	private static final String PRIX_CLASS = "produit-prix";

	private static final List ORDERS = new ArrayList<>();
	static{
		ORDERS.add(ExecutionMethod.UNIT);
		ORDERS.add(ExecutionMethod.IMAGE);
		ORDERS.add(ExecutionMethod.TITLE);
		ORDERS.add(ExecutionMethod.SHORT_DESCRIPTION);
		ORDERS.add(ExecutionMethod.DESCRIPTION);
		ORDERS.add(ExecutionMethod.URL);
		ORDERS.add(ExecutionMethod.PRICE);
		ORDERS.add(ExecutionMethod.OLD_PRICE);
		ORDERS.add(ExecutionMethod.CATEGORIES);
		ORDERS.add(ExecutionMethod.RATE);
	}

	public VialParser(String directory, String path, String host) {
		super(directory, path, host);
	}

	@Override
	public List<ExecutionMethod> getOrders() {
		return ORDERS;
	}

	@Override
	public boolean isEmptyProduct(Element doc) {
		Element image = doc.getElementById("lien-zoom");
		if (image == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean buildUnit(Element doc, Product product) {
		//TODO
		product.setUnit(Constants.UNIT);
		return true;
	}

	@Override
	public boolean buildTitle(Element doc, Product product) {
		product.setTitle(doc.getElementsByClass("titre-produit").first().text());
		return true;
	}

	@Override
	public boolean buildDescription(Element doc, Product product) {
		Element fDescription = doc.getElementById("description-produit");
		String description = "";
		if (fDescription != null) {

			for (Element p : fDescription.select("li")) {
				description += p.text();
			}
		}
		product.setDescription(description);
		return true;
	}

	@Override
	public boolean buildShortDescription(Element doc, Product product) {
		product.setShortDescription(doc.getElementsByClass("titre-produit").first().text());
		return true;
	}

	@Override
	public boolean buildUrl(Element doc, Product product) {
		product.setUrl(host + doc.getElementById("ajout-panier").attr("action"));
		return true;
	}

	@Override
	public boolean buildOldPrice(Element doc, Product product) {
		if (doc.getElementsByClass(PRIX_CLASS) != null && doc.getElementsByClass(PRIX_CLASS).first() != null) {
			product.setOldPrice(getOldPrice(doc.getElementsByClass("produit-prix-barre").first().text()));
		}
		return true;
	}

	@Override
	public boolean buildPrice(Element doc, Product product) {
		if (doc.getElementsByClass(PRIX_CLASS) != null && doc.getElementsByClass(PRIX_CLASS).first() != null) {
			product.setPrice(getPrice(doc.getElementsByClass(PRIX_CLASS).first().text()));
		}
		return true;
	}

	@Override
	public boolean buildImage(Element doc, Product product) {
		Element image = doc.getElementById("lien-zoom");
		product.setImage(host + image.attr("href"));
		return true;
	}

	@Override
	public boolean buildCategories(Element doc, Product product) {
		if (doc.getElementsByClass("fil-d-ariane") != null) {
			String categories = "";
			String splitCategories = " - ";
			Elements breadcrumbs = doc.getElementsByClass("fil-d-ariane");
			for (int index = 1; index < breadcrumbs.select("a").size(); index++) {
				categories += breadcrumbs.select("a").get(index).text().replace("�", "é") + splitCategories;
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
		product.setSeller(Seller.VIAL.name());
		return true;
	}

	protected Double getPrice(String text) {
		if (StringUtils.isNotEmpty(text)) {
			Pattern p = Pattern.compile("(\\d*[.,]*\\d*)");
			Matcher m = p.matcher(text);
			if (m.find()) {
				String priceStr = m.group();
				if (StringUtils.isNotEmpty(priceStr)) {
					return new Double(priceStr.replaceAll(",", "."));
				}
			}
		}
		return null;
	}

	protected Double getOldPrice(String text) {
		if (StringUtils.isNotEmpty(text)) {
			Pattern p = Pattern.compile("(\\d*[.,]*\\d*)");
			Matcher m = p.matcher(text);
			if (m.find()) {
				String price = m.group();
				return new Double(price.replaceAll(",", "."));
			}
		}
		return null;
	}
}
