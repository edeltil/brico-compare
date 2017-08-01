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
public class LapeyreParser implements Parser {

	private static Logger LOGGER = Logger.getLogger("LapeyreParser");

	private String directory;
	private String path;

	public LapeyreParser(String directory, String path) {
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
		product.setSeller(Seller.Lapeyre.name());
		product.setUnit(Constants.UNIT);
		product.setPath(path);
		Elements elements = doc.select("link");
		for (Element link : elements) {
			if (link.attr("rel").equals("canonical")) {
				product.setUrl(link.attr("href"));
			}
		}
		if (product.getUrl() == null || product.getUrl().contains("/c/") || product.getUrl().equals("https://www.lapeyre.fr/")) {
			return null;
		}
		Elements metas = doc.select("meta");
		for (Element link : metas) {
			if (link.attr("name").equals("description")) {
				product.setShortDescription(link.attr("content"));
			} else if (link.attr("property").equals("og:image")) {
				product.setImage(link.attr("content"));
			} else if (link.attr("property").equals("og:title")) {
				product.setTitle(link.attr("content"));
			}
		}
		if (StringUtils.isEmpty(product.getShortDescription())) {
			return null;
		}

		Element fDescription = doc.getElementById("detailedDescriptionSection");
		//		if (fDescription == null || fDescription.getElementsByClass("descriptionDetailleeText") == null
		//			|| fDescription.getElementsByClass("descriptionDetailleeText").first() == null) {
		//			return null;
		//		}
		String description = "";
		if (fDescription != null) {
			Element descriptionDetaillee = fDescription.getElementsByClass("descriptionDetailleeText").first();

			for (Element p : descriptionDetaillee.select("p")) {
				description += p.text();
			}
		}
		product.setDescription(description);

		if (doc.getElementsByClass("fichePrix") != null && doc.getElementsByClass("fichePrix").first() != null) {
			Element rightColumn = doc.getElementsByClass("fichePrix").first();
			if (rightColumn != null && rightColumn.getElementsByClass("price") != null && rightColumn.getElementsByClass("price").first() != null
				&& rightColumn.getElementsByClass("price").first().select("span") != null
				&& rightColumn.getElementsByClass("price").first().select("span").first() != null) {
				product.setPrice(getPrice(rightColumn.getElementsByClass("price").first().select("span").first().text()));
				product.setOldPrice(getOldPrice(rightColumn.getElementsByClass("old_price_value").first().select("span").first().text()));
			}
			if (rightColumn != null && rightColumn.getElementsByClass("uniteVenteLabel") != null
				&& rightColumn.getElementsByClass("uniteVenteLabel").first() != null && rightColumn.getElementsByClass("uniteVenteLabel").first().text()
				.equals("le m²")) {
				product.setUnit(Constants.M2);
			}
		}
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
		Utils.checkProduct(product);
		return product;
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
