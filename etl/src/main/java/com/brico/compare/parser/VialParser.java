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
public class VialParser implements Parser {

	private static Logger LOGGER = Logger.getLogger("VialParser");

	private String host;
	private String directory;
	private String path;

	public VialParser(String directory, String path, String host) {
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
		product.setSeller(Seller.Vial.name());
		product.setPath(path);
		//TODO
		product.setUnit(Constants.UNIT);
		Element image = doc.getElementById("lien-zoom");
		if (image == null) {
			return null;
		}
		product.setImage(host + image.attr("href"));
		product.setTitle(doc.getElementsByClass("titre-produit").first().text());
		product.setShortDescription(doc.getElementsByClass("titre-produit").first().text());

		Element fDescription = doc.getElementById("description-produit");
		String description = "";
		if (fDescription != null) {

			for (Element p : fDescription.select("li")) {
				description += p.text();
			}
		}
		product.setDescription(description);
		product.setUrl(host + doc.getElementById("ajout-panier").attr("action"));

		if (doc.getElementsByClass("produit-prix") != null && doc.getElementsByClass("produit-prix").first() != null) {
			product.setPrice(getPrice(doc.getElementsByClass("produit-prix").first().text()));
			product.setOldPrice(getOldPrice(doc.getElementsByClass("produit-prix-barre").first().text()));
		}
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
		Utils.checkProduct(product);
		return product;
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
