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
 * Created by edeltil on 24/01/2017.
 */
public class BMParser implements Parser {

	private String directory;

	private String path;

	private static Logger LOGGER = Logger.getLogger("BMParser");

	public BMParser(String directory, String path) {
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
		Product product = new Product();
		product.setSeller(Seller.BM.name());
		product.setUnit(Constants.UNIT);
		product.setPath(path);
		Document doc = null;
		try {
			doc = Jsoup.parse(new File(path), Charset.forName("UTF-8").name());
		} catch (IllegalArgumentException exc) {
			return null;
		}
		if (doc.getElementsByClass("product-content") != null && doc.getElementsByClass("product-content").first() != null
			&& doc.getElementsByClass("product-content").first().getElementsByClass("note-msg") != null
			&& doc.getElementsByClass("product-content").first().getElementsByClass("note-msg").first() != null) {
			if (doc.getElementsByClass("product-content").first().getElementsByClass("note-msg").first().text()
				.equals("Aucun produit ne correspond à la sélection.")) {
				return null;
			}
		}
		if (doc.getElementsByClass("magento-product-decscription") != null && doc.getElementsByClass("magento-product-decscription").first() != null) {
			Element elementDescription = doc.getElementsByClass("magento-product-decscription").first();
			String description = elementDescription.ownText();
			product.setShortDescription(elementDescription.ownText());
			for (Element element : elementDescription.select("li")) {
				description += " , " + element.text();
			}
			product.setDescription(description);
		} else {
			return null;
		}
		Elements elements = doc.select("link");
		for (Element link : elements) {
			if (link.attr("rel").equals("canonical")) {
				product.setUrl(link.attr("href"));
			}
		}
		//		Element element = doc.getElementsByClass("content-fiche-produit").first();
		product.setTitle(doc.select("h1").first().text());
		if (doc.getElementsByClass("old-price") != null && doc.getElementsByClass("old-price").first() != null) {
			product.setOldPrice(getPrice(doc.getElementsByClass("old-price").first().text()));
		}
		product.setPrice(getPrice(doc.getElementsByClass("new-price").first().text()));

		String strUnit = doc.getElementsByClass("new-price").first().select("small").text();
		Double priceUnit = getPrice(strUnit);
		if (product.getPrice().equals(priceUnit) && strUnit.contains("/m²")) {
			product.setUnit("le m²");
		}

		product.setImage(doc.getElementsByClass("fiche-product-image-container").select("img").attr("src"));
		if (!product.getImage().contains("image")) {
			product.setImage(doc.getElementsByClass("jcarousel-clip jcarousel-clip-vertical").select("li").attr("data-target"));
		}

		Element breadcrumb = doc.getElementById("breadcrumb");
		Elements links = breadcrumb.select("a");
		String categories = "";
		String splitCategories = " - ";
		for (Element link : links) {
			if (link.attr("href") != null && StringUtils.isNotEmpty(link.attr("href"))) {
				categories += link.text() + splitCategories;
			}
		}
		if (categories.endsWith(splitCategories)) {
			categories = categories.substring(0, categories.length() - splitCategories.length());
		}
		product.setCategorieSeller(categories);
		for (Element element : doc.select("a")) {
			if (element.hasClass("bv-rating")) {
				product.setRate(Integer.parseInt(element.text().substring(0, element.text().indexOf("."))));
			}
		}
		Utils.checkProduct(product);

		return product;
	}

	protected Double getPrice(String text) {
		Pattern p = Pattern.compile("((\\d+)\\D(\\d{3}[.,]\\d+))");
		Matcher m = p.matcher(text);
		if (m.find()) {
			String price = m.group(2) + m.group(3);// + "." + m.group(2);
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
