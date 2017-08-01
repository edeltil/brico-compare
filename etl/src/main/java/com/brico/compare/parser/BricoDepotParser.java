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
public class BricoDepotParser extends AbstractParser {

	private static final String PROD_TITLE_CLASS = "prodTitle";
	private static final String PROD_INFO_CLASS = "prodInfo";
	private static final String RIGHT_COL_CLASS = "rightCol";
	private static final String OLD_PRICE_CLASS = "oldPrice";
	private static final String CURENT_PRICE_CLASS = "curentPrice";
	private static final String BREADCRUMBS_CLASS = "breadcrumbs";
	private static final String UNITS_CLASS = "units";
	private static final String DESCRIPTION_CLASS = "prodDescr";

	private static final List ORDERS = new ArrayList<>();

	static {
		ORDERS.add(ExecutionMethod.RATE);
		ORDERS.add(ExecutionMethod.URL);
		ORDERS.add(ExecutionMethod.SHORT_DESCRIPTION);
		ORDERS.add(ExecutionMethod.IMAGE);
		ORDERS.add(ExecutionMethod.TITLE);
		ORDERS.add(ExecutionMethod.DESCRIPTION);
		ORDERS.add(ExecutionMethod.PRICE);
		ORDERS.add(ExecutionMethod.OLD_PRICE);
		ORDERS.add(ExecutionMethod.UNIT);
		ORDERS.add(ExecutionMethod.CATEGORIES);
	}

	public BricoDepotParser(String directory, String path, String host) {
		super(directory, path, host);
	}

	@Override
	public List<ExecutionMethod> getOrders() {
		return ORDERS;
	}

	@Override
	public boolean isEmptyProduct(Element doc) {
		Element fDescription = doc.getElementsByClass(DESCRIPTION_CLASS).first();
		if (fDescription == null || fDescription.getElementsByClass(PROD_TITLE_CLASS) == null
			|| fDescription.getElementsByClass(PROD_TITLE_CLASS).first() == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean buildUnit(Element doc, Product product) {
		if (doc.getElementsByClass(RIGHT_COL_CLASS) != null && doc.getElementsByClass(RIGHT_COL_CLASS).first() != null) {
			Element rightColumn = doc.getElementsByClass(RIGHT_COL_CLASS).first();
			product.setUnit("la pièce".equals(getUnit(rightColumn.getElementsByClass(CURENT_PRICE_CLASS).first())) ?
				Constants.UNIT :
				getUnit(rightColumn.getElementsByClass(CURENT_PRICE_CLASS).first()));
		}
		return true;
	}

	@Override
	public boolean buildTitle(Element doc, Product product) {
		Element fDescription = doc.getElementsByClass(DESCRIPTION_CLASS).first();
		if (fDescription == null || fDescription.getElementsByClass(PROD_TITLE_CLASS) == null
			|| fDescription.getElementsByClass(PROD_TITLE_CLASS).first() == null) {
			return false;
		}
		product.setTitle(fDescription.getElementsByClass(PROD_TITLE_CLASS).first().text());
		return true;
	}

	@Override
	public boolean buildDescription(Element doc, Product product) {
		Element fDescription = doc.getElementsByClass(DESCRIPTION_CLASS).first();
		if (fDescription == null || fDescription.getElementsByClass(PROD_TITLE_CLASS) == null
			|| fDescription.getElementsByClass(PROD_TITLE_CLASS).first() == null) {
			return false;
		}
		if (fDescription.getElementsByClass(PROD_INFO_CLASS) != null && fDescription.getElementsByClass(PROD_INFO_CLASS).first() != null && StringUtils
			.isNotEmpty(fDescription.getElementsByClass(PROD_INFO_CLASS).first().text())) {
			product.setDescription(fDescription.getElementsByClass(PROD_INFO_CLASS).first().text());
		} else {
			product.setDescription(product.getShortDescription());
		}
		return true;
	}

	@Override
	public boolean buildShortDescription(Element doc, Product product) {
		Elements metas = doc.select("meta");
		for (Element link : metas) {
			if ("og:description".equals(link.attr("property"))) {
				product.setShortDescription(link.attr("content"));
			}
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
		if (product.getUrl() == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean buildOldPrice(Element doc, Product product) {
		if (doc.getElementsByClass(RIGHT_COL_CLASS) != null && doc.getElementsByClass(RIGHT_COL_CLASS).first() != null) {
			Element rightColumn = doc.getElementsByClass(RIGHT_COL_CLASS).first();
			if (rightColumn.getElementsByClass(OLD_PRICE_CLASS) != null && rightColumn.getElementsByClass(OLD_PRICE_CLASS).first() != null) {
				product.setOldPrice(getOldPrice(rightColumn.getElementsByClass(OLD_PRICE_CLASS).first().select("span").first().text()));
			}
		}
		return true;
	}

	@Override
	public boolean buildPrice(Element doc, Product product) {
		if (doc.getElementsByClass(RIGHT_COL_CLASS) != null && doc.getElementsByClass(RIGHT_COL_CLASS).first() != null) {
			Element rightColumn = doc.getElementsByClass(RIGHT_COL_CLASS).first();
			product.setPrice(getPrice(rightColumn.getElementsByClass(CURENT_PRICE_CLASS).first()));
		}
		return true;
	}

	@Override
	public boolean buildImage(Element doc, Product product) {
		Elements metas = doc.select("meta");
		for (Element link : metas) {
			if ("og:image".equals(link.attr("property"))) {
				product.setImage(host + link.attr("content"));
			}
		}
		return true;
	}

	@Override
	public boolean buildCategories(Element doc, Product product) {
		if (doc.getElementsByClass(BREADCRUMBS_CLASS).first() != null) {
			String categories;
			StringBuilder bld = new StringBuilder();
			String splitCategories = " - ";
			Element breadcrumbs = doc.getElementsByClass(BREADCRUMBS_CLASS).first();
			for (int index = 1; index < breadcrumbs.text().split(">").length - 1; index++) {
				bld.append(breadcrumbs.text().split(">")[index].replace(String.valueOf((char) 160), " ").trim()).append(splitCategories);
			}
			categories = bld.toString();
			if (categories.endsWith(splitCategories)) {
				categories = categories.substring(0, categories.length() - splitCategories.length());
			}
			product.setCategorieSeller(categories);
		}
		return true;
	}

	@Override
	public boolean buildSeller(Product product) {
		product.setSeller(Seller.BD.name());
		return true;
	}

	protected String getUnit(Element priceElement) {
		String unit = priceElement.getElementsByClass(UNITS_CLASS).first().text()
			.substring("TTC / ".length(), priceElement.getElementsByClass(UNITS_CLASS).first().text().length() - 1);
		if (unit.contains("Soit")) {
			unit = unit.substring(0, unit.indexOf("Soit") - 1);
		}
		return unit;
	}

	protected Double getPrice(Element priceElement) {
		Double price = null;
		Pattern p = Pattern.compile("(\\d*[.,]*\\d*)");
		Matcher m = p.matcher(priceElement.select("span").first().text());
		if (m.find()) {
			String priceStr = m.group();
			price = new Double(priceStr.replaceAll(",", ".").replaceAll(" ", ""));
		}
		m = p.matcher(priceElement.getElementsByClass("cents").first().text());
		if (m.find()) {
			String priceStr = m.group();
			price = price + new Double(priceStr.replaceAll(",", ".").replaceAll(" ", "")) * 0.01;
		}
		return price;
	}

	protected Double getOldPrice(String text) {
		Pattern p = Pattern.compile("(\\d*€\\d*)");
		Matcher m = p.matcher(text);
		if (m.find()) {
			String price = m.group();
			return new Double(price.replaceAll("€", ".").replaceAll(" ", ""));
		}
		return null;
	}
}
