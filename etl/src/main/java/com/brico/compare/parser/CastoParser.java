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
public class CastoParser implements Parser {

	private static Logger LOGGER = Logger.getLogger("CastoParser");

	private String host;
	private String directory;
	private String path;

	public CastoParser(String directory, String path, String host) {
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
		Document doc = Jsoup.parse(new File(path), Charset.forName("UTF-8").name());
		Element element = doc.getElementsByClass("featuredProduct").first();
		Product product = new Product();
		product.setPath(path);
		product.setSeller(Seller.Casto.name());
		product.setUnit(Constants.UNIT);
		for (Element meta : doc.select("meta")) {
			if (meta.attr("name").equals("description")) {
				product.setShortDescription(meta.attr("content"));
			}
		}
		if (StringUtils.isEmpty(product.getShortDescription())) {
			for (Element meta : doc.select("META")) {
				if (meta.attr("name").equals("description")) {
					product.setShortDescription(meta.attr("content"));
				}
			}
		}
		Elements elements = doc.select("link");
		for (Element link : elements) {
			if (link.attr("rel").equals("canonical")) {
				product.setUrl(link.attr("href"));
			}
		}
		if (product.getUrl() == null || product.getUrl().contains("cat_id")) {
			return null;
		}
		if (element != null) {
			Element ill = element.getElementsByClass("fIllustration").first();
			product.setTitle(ill.select("a").attr("title"));
			product.setImage(host + ill.select("a").select("img").attr("src"));

			Element fDescription = element.getElementsByClass("fDescription").first();
			String description = "";
			for (Element desc : fDescription.select("ul")) {
				description += desc.text();
				Elements descriptionElements = desc.select("li");
				for (Element element1 : descriptionElements) {
					description += element1.text() + " ";
				}
			}
			product.setDescription(description);
			product.setPrice(new Double(
				element.getElementsByClass("price").first().text().substring(0, element.getElementsByClass("price").first().text().length() - 2)
					.replaceAll(",", ".")));
		} else if (doc.getElementsByClass("productContent") != null && doc.getElementsByClass("productContent").first() != null) {
			Element productContent = doc.getElementsByClass("productContent").first();
			if (productContent.select("h1") == null || productContent.select("h1").first() == null) {
				return null;
			}
			product.setTitle(productContent.select("h1").first().text());
			Element imgContent = doc.getElementsByClass("productImage").first();
			//			String productId = imgContent.attr("productId");
			if (imgContent.getElementsByClass("slPrdMarker") != null && imgContent.getElementsByClass("slPrdMarker").first() != null
				&& imgContent.getElementsByClass("slPrdMarker").first().attr("src") != null) {
				product.setImage(host + imgContent.getElementsByClass("slPrdMarker").first().attr("src"));
			} else {
				product.setImage(host + imgContent.getElementById("lrgImg").attr("src"));
			}

			String description = "";
			Element descTech = doc.getElementById("tabs_pd_pagetechnicTab");
			if (descTech != null) {
				for (Element desc : descTech.select("ul")) {
					description += desc.text();
					Elements descriptionElements = desc.select("li");
					for (Element element1 : descriptionElements) {
						description += element1.text() + " ";
					}
				}
			}
			product.setDescription(description);
			for (Element meta : doc.select("meta")) {
				if (meta.attr("name").equals("description")) {
					product.setShortDescription(meta.attr("content"));
				}
			}
			if (StringUtils.isEmpty(product.getShortDescription())) {
				for (Element meta : doc.select("META")) {
					if (meta.attr("name").equals("description")) {
						product.setShortDescription(meta.attr("content"));
					}
				}
			}
			if (doc.getElementById("cardPrice") != null) {
				product.setPrice(new Double(doc.getElementById("cardPrice").text()));
			} else {
				if (doc.getElementsByClass("productDetailsRightColumn") != null && doc.getElementsByClass("productDetailsRightColumn").first() != null) {
					Element rightColumn = doc.getElementsByClass("productDetailsRightColumn").first();
					if (rightColumn.getElementsByClass("price") != null && rightColumn.getElementsByClass("price").first() != null) {
						product.setPrice(getPrice(rightColumn.getElementsByClass("price").first().text()));
						if (rightColumn.getElementsByClass("price").first().getElementsByClass("m2") != null && !rightColumn.getElementsByClass("price").first()
							.getElementsByClass("m2").isEmpty()) {
							product.setUnit("le m²");
						}
					} else {
						product.setOldPrice(getPrice(rightColumn.getElementsByClass("oldprice").first().text()));
						product.setPrice(getPrice(rightColumn.getElementsByClass("newprice").first().text()));
						if (rightColumn.getElementsByClass("newprice").first().getElementsByClass("m2") != null && !rightColumn.getElementsByClass("newprice")
							.first().getElementsByClass("m2").isEmpty()) {
							product.setUnit("le m²");
						}
					}
				}
			}
		} else {
			LOGGER.log(Level.FINE, "Error : " + path);
			return null;
		}
		if (doc.getElementsByClass("breadcrumbs").first() != null) {
			String categories = "";
			String splitCategories = " - ";
			Element breadcrumbs = doc.getElementsByClass("breadcrumbs").first();
			Elements as = breadcrumbs.select("a");
			for (int index = 0; index < as.size(); index++) {
				Element a = as.get(index);
				if (StringUtils.isNotEmpty(a.text())) {
					if (index == 1) {
						Element nav = doc.getElementById("navPane");
						Elements menus = nav
							.getElementsContainingOwnText(a.text().substring(0, a.text().contains(" ") ? a.text().indexOf(" ") : a.text().length()));
						//menuContainer
						Element navCategorie = menus.first();
						if (navCategorie != null) {
							while (!navCategorie.classNames().contains("menuContainer") && navCategorie.parent() != null) {
								navCategorie = navCategorie.parent();
							}
							if (navCategorie.parent() != null) {
								categories += navCategorie.getElementsByClass("mm_t01_lnk").first().text() + splitCategories;
							}
						}
					}
					categories += a.text() + splitCategories;
				}
			}
			if (categories.endsWith(splitCategories)) {
				categories = categories.substring(0, categories.length() - splitCategories.length());
			}
			product.setCategorieSeller(categories);
		}
		if (doc.getElementById("BVRRRatingOverall_") != null) {
			Element rating = doc.getElementById("BVRRRatingOverall_").getElementsByClass("BVImgOrSprite").first();
			String rate = rating.attr("title");
			product.setRate(Integer.parseInt(rate.substring(0, rate.indexOf(","))));
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
