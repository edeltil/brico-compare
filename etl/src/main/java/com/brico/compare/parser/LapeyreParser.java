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
public class LapeyreParser extends Parser {

	private static final String FICHE_PRIX_CLASS = "fichePrix";
	private static final String PRICE_CLASS = "price";
	private static final String UNITE_CLASS = "uniteVenteLabel";
	private static final String CONTENT_ATTR= "content";
	private static final String SPAN_ATTR= "span";

	private static final List ORDERS = new ArrayList<>();
	static{
		ORDERS.add(ExecutionMethod.URL);
		ORDERS.add(ExecutionMethod.SHORT_DESCRIPTION);
		ORDERS.add(ExecutionMethod.IMAGE);
		ORDERS.add(ExecutionMethod.TITLE);
		ORDERS.add(ExecutionMethod.DESCRIPTION);
		ORDERS.add(ExecutionMethod.PRICE);
		ORDERS.add(ExecutionMethod.OLD_PRICE);
		ORDERS.add(ExecutionMethod.UNIT);
		ORDERS.add(ExecutionMethod.CATEGORIES);
		ORDERS.add(ExecutionMethod.RATE);
	}

	public LapeyreParser(String directory, String path) {
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
		product.setUnit(Constants.UNIT);
		if (doc.getElementsByClass(FICHE_PRIX_CLASS) != null && doc.getElementsByClass(FICHE_PRIX_CLASS).first() != null) {
			Element rightColumn = doc.getElementsByClass(FICHE_PRIX_CLASS).first();
			if (rightColumn != null && rightColumn.getElementsByClass(UNITE_CLASS) != null && rightColumn.getElementsByClass(UNITE_CLASS).first() != null
				&& "le m²".equals(rightColumn.getElementsByClass(UNITE_CLASS).first().text())) {
				product.setUnit(Constants.M2);
			}
		}
		return true;
	}

	@Override
	public boolean buildTitle(Element doc, Product product) {
		Elements metas = doc.select("meta");
		for (Element link : metas) {
			if ("og:title".equals(link.attr("property"))) {
				product.setTitle(link.attr(CONTENT_ATTR));
			}
		}
		return true;
	}

	@Override
	public boolean buildDescription(Element doc, Product product) {
		Element fDescription = doc.getElementById("detailedDescriptionSection");
		String description = "";
		if (fDescription != null) {
			Element descriptionDetaillee = fDescription.getElementsByClass("descriptionDetailleeText").first();

			for (Element p : descriptionDetaillee.select("p")) {
				description += p.text();
			}
		}
		product.setDescription(description);
		return true;
	}

	@Override
	public boolean buildShortDescription(Element doc, Product product) {
		Elements metas = doc.select("meta");
		for (Element link : metas) {
			if ("description".equals(link.attr("name"))) {
				product.setShortDescription(link.attr(CONTENT_ATTR));
			}
		}
		if (StringUtils.isEmpty(product.getShortDescription())) {
			return false;
		}
		return true;
	}

	@Override
	public boolean buildUrl(Element doc, Product product) {
		Elements elements = doc.select("link");
		for (Element link : elements) {
			if ("canonical".equals(link.attr("rel"))) {
				product.setUrl(link.attr("href"));
			}
		}
		if (product.getUrl() == null || product.getUrl().contains("/c/") || "https://www.lapeyre.fr/".equals(product.getUrl())) {
			return false;
		}
		return true;
	}

	@Override
	public boolean buildOldPrice(Element doc, Product product) {
		if (doc.getElementsByClass(FICHE_PRIX_CLASS) != null && doc.getElementsByClass(FICHE_PRIX_CLASS).first() != null) {
			Element rightColumn = doc.getElementsByClass(FICHE_PRIX_CLASS).first();
			if (rightColumn != null && rightColumn.getElementsByClass(PRICE_CLASS) != null && rightColumn.getElementsByClass(PRICE_CLASS).first() != null
				&& rightColumn.getElementsByClass(PRICE_CLASS).first().select(SPAN_ATTR) != null
				&& rightColumn.getElementsByClass(PRICE_CLASS).first().select(SPAN_ATTR).first() != null) {
				product.setOldPrice(getOldPrice(rightColumn.getElementsByClass("old_price_value").first().select(SPAN_ATTR).first().text()));
			}
		}
		return true;
	}

	@Override
	public boolean buildPrice(Element doc, Product product) {
		if (doc.getElementsByClass(FICHE_PRIX_CLASS) != null && doc.getElementsByClass(FICHE_PRIX_CLASS).first() != null) {
			Element rightColumn = doc.getElementsByClass(FICHE_PRIX_CLASS).first();
			if (rightColumn != null && rightColumn.getElementsByClass(PRICE_CLASS) != null && rightColumn.getElementsByClass(PRICE_CLASS).first() != null
				&& rightColumn.getElementsByClass(PRICE_CLASS).first().select(SPAN_ATTR) != null
				&& rightColumn.getElementsByClass(PRICE_CLASS).first().select(SPAN_ATTR).first() != null) {
				product.setPrice(getPrice(rightColumn.getElementsByClass(PRICE_CLASS).first().select(SPAN_ATTR).first().text()));
			}
		}
		return true;
	}

	@Override
	public boolean buildImage(Element doc, Product product) {
		Elements metas = doc.select("meta");
		for (Element link : metas) {
			if ("og:image".equals(link.attr("property"))) {
				product.setImage(link.attr(CONTENT_ATTR));
			}
		}
		return true;
	}

	@Override
	public boolean buildCategories(Element doc, Product product) {
		if (doc.getElementById("widget_breadcrumb") != null) {
			String categories = "";
			String splitCategories = " - ";
			Element breadcrumbs = doc.getElementById("widget_breadcrumb");
			for (int index = 1; index < breadcrumbs.select("li").size() - 1; index++) {
				categories += breadcrumbs.select("li").get(index).text() + splitCategories;
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
		product.setSeller(Seller.LAPEYRE.name());
		return true;
	}

	protected Double getPrice(String text) {
		Pattern p = Pattern.compile("(\\d*[.,]*\\d*)");
		Matcher m = p.matcher(text);
		if (m.find()) {
			String priceStr = m.group();
			return new Double(priceStr.replaceAll(",", "."));
		}
		return null;
	}

	protected Double getOldPrice(String text) {
		Pattern p = Pattern.compile("(\\d*[.,]*\\d*)");
		Matcher m = p.matcher(text);
		if (m.find()) {
			String price = m.group();
			return new Double(price.replaceAll(",", "."));
		}
		return null;
	}
}
