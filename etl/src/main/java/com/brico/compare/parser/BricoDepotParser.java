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
public class BricoDepotParser implements Parser {

	private static Logger LOGGER = Logger.getLogger("BricoDepotParser");

	private String host;
	private String directory;
	private String path;

	public BricoDepotParser(String directory, String path, String host) {
		this.host = host;
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
		Document doc;
		try {
			doc = Jsoup.parse(new File(path), Charset.forName("UTF-8").name());
		} catch (IllegalArgumentException exc) {
			return null;
		}
		Product product = new Product();
		product.setSeller(Seller.BD.name());
		product.setPath(path);
		//pas d'avis
		product.setRate(0);
		Elements elements = doc.select("link");
		for (Element link : elements) {
			if (link.attr("rel").equals("canonical")) {
				product.setUrl(link.attr("href"));
			}
		}
		if (product.getUrl() == null) {
			return null;
		}
		Elements metas = doc.select("meta");
		for (Element link : metas) {
			if (link.attr("property").equals("og:description")) {
				product.setShortDescription(link.attr("content"));
			} else if (link.attr("property").equals("og:image")) {
				product.setImage(host + link.attr("content"));
			}
		}

		Element fDescription = doc.getElementsByClass("prodDescr").first();
		if (fDescription == null || fDescription.getElementsByClass("prodTitle") == null || fDescription.getElementsByClass("prodTitle").first() == null) {
			return null;
		}
		product.setTitle(fDescription.getElementsByClass("prodTitle").first().text());
		if (fDescription.getElementsByClass("prodInfo") != null && fDescription.getElementsByClass("prodInfo").first() != null && StringUtils
			.isNotEmpty(fDescription.getElementsByClass("prodInfo").first().text())) {
			product.setDescription(fDescription.getElementsByClass("prodInfo").first().text());
		} else {
			product.setDescription(product.getShortDescription());
		}

		if (doc.getElementsByClass("rightCol") != null && doc.getElementsByClass("rightCol").first() != null) {
			Element rightColumn = doc.getElementsByClass("rightCol").first();
			product.setPrice(getPrice(rightColumn.getElementsByClass("curentPrice").first()));
			if (rightColumn.getElementsByClass("oldPrice") != null && rightColumn.getElementsByClass("oldPrice").first() != null) {
				product.setOldPrice(getOldPrice(rightColumn.getElementsByClass("oldPrice").first().select("span").first().text()));
			}
			product.setUnit("la pièce".equals(getUnit(rightColumn.getElementsByClass("curentPrice").first())) ?
				Constants.UNIT :
				getUnit(rightColumn.getElementsByClass("curentPrice").first()));
		}
		if (doc.getElementsByClass("breadcrumbs").first() != null) {
			String categories = "";
			String splitCategories = " - ";
			Element breadcrumbs = doc.getElementsByClass("breadcrumbs").first();
			for (int index = 1; index < breadcrumbs.text().split(">").length - 1; index++) {
				categories += breadcrumbs.text().split(">")[index].replace(String.valueOf((char) 160), " ").trim() + splitCategories;
			}
			if (categories.endsWith(splitCategories)) {
				categories = categories.substring(0, categories.length() - splitCategories.length());
			}
			product.setCategorieSeller(categories);
		}
		Utils.checkProduct(product);
		return product;
	}

	protected String getUnit(Element priceElement) {
		String unit = priceElement.getElementsByClass("units").first().text()
			.substring("TTC / ".length(), priceElement.getElementsByClass("units").first().text().length() - 1);
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
