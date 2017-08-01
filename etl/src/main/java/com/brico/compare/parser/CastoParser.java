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
public class CastoParser extends AbstractParser {

	private static final String DESCRIPTION_ATTR = "description";
	private static final String CONTENT_ATTR = "content";
	private static final String PRICE_CLASS = "price";
	private static final String CONTENT_CLASS = "productContent";
	private static final String MARKER_CLASS = "slPrdMarker";
	private static final String DETAILS_CLASS = "productDetailsRightColumn";
	private static final String NEW_PRICE_CLASS = "newprice";
	private static final String PRODUCT_CLASS = "featuredProduct";
	private static final String CARD_PRICE_CLASS = "cardPrice";

	private static final List ORDERS = new ArrayList<>();

	static {
		ORDERS.add(ExecutionMethod.SHORT_DESCRIPTION);
		ORDERS.add(ExecutionMethod.URL);
		ORDERS.add(ExecutionMethod.TITLE);
		ORDERS.add(ExecutionMethod.IMAGE);
		ORDERS.add(ExecutionMethod.DESCRIPTION);
		ORDERS.add(ExecutionMethod.PRICE);
		ORDERS.add(ExecutionMethod.OLD_PRICE);
		ORDERS.add(ExecutionMethod.UNIT);
		ORDERS.add(ExecutionMethod.CATEGORIES);
		ORDERS.add(ExecutionMethod.RATE);
	}

	public CastoParser(String directory, String path, String host) {
		super(directory, path, host);
	}

	@Override
	public List<ExecutionMethod> getOrders() {
		return ORDERS;
	}

	@Override
	public boolean isEmptyProduct(Element doc) {
		Element element = doc.getElementsByClass("featuredProduct").first();
		return !(element != null ||  (doc.getElementsByClass(CONTENT_CLASS) != null && doc.getElementsByClass(CONTENT_CLASS).first() != null) );
	}

	@Override
	public boolean buildUnit(Element doc, Product product) {
		product.setUnit(Constants.UNIT);
		if (doc.getElementsByClass(CONTENT_CLASS) != null && doc.getElementsByClass(CONTENT_CLASS).first() != null) {
			if (doc.getElementById(CARD_PRICE_CLASS) == null) {
				if (doc.getElementsByClass(DETAILS_CLASS) != null && doc.getElementsByClass(DETAILS_CLASS).first() != null) {
					Element rightColumn = doc.getElementsByClass(DETAILS_CLASS).first();
					if (rightColumn.getElementsByClass(PRICE_CLASS) != null && rightColumn.getElementsByClass(PRICE_CLASS).first() != null) {
						if (rightColumn.getElementsByClass(PRICE_CLASS).first().getElementsByClass("m2") != null && !rightColumn.getElementsByClass(PRICE_CLASS)
							.first().getElementsByClass("m2").isEmpty()) {
							product.setUnit("le m²");
						}
					} else {
						if (rightColumn.getElementsByClass(NEW_PRICE_CLASS).first().getElementsByClass("m2") != null && !rightColumn
							.getElementsByClass(NEW_PRICE_CLASS).first().getElementsByClass("m2").isEmpty()) {
							product.setUnit("le m²");
						}
					}
				}
			}
		}
		return true;
	}

	@Override
	public boolean buildTitle(Element doc, Product product) {
		Element element = doc.getElementsByClass(PRODUCT_CLASS).first();
		if (element != null) {
			Element ill = element.getElementsByClass("fIllustration").first();
			product.setTitle(ill.select("a").attr("title"));
		} else if (doc.getElementsByClass(CONTENT_CLASS) != null && doc.getElementsByClass(CONTENT_CLASS).first() != null) {
			Element productContent = doc.getElementsByClass(CONTENT_CLASS).first();
			if (productContent.select("h1") == null || productContent.select("h1").first() == null) {
				return false;
			}
			product.setTitle(productContent.select("h1").first().text());
		}
		return true;
	}

	@Override
	public boolean buildDescription(Element doc, Product product) {
		Element element = doc.getElementsByClass(PRODUCT_CLASS).first();
		if (element != null) {
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
		} else if (doc.getElementsByClass(CONTENT_CLASS) != null && doc.getElementsByClass(CONTENT_CLASS).first() != null) {
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
		}
		return true;
	}

	@Override
	public boolean buildShortDescription(Element doc, Product product) {
		for (Element meta : doc.select("meta")) {
			if (DESCRIPTION_ATTR.equals(meta.attr("name"))) {
				product.setShortDescription(meta.attr(CONTENT_ATTR));
			}
		}
		if (StringUtils.isEmpty(product.getShortDescription())) {
			for (Element meta : doc.select("META")) {
				if (DESCRIPTION_ATTR.equals(meta.attr("name"))) {
					product.setShortDescription(meta.attr(CONTENT_ATTR));
				}
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
		if (product.getUrl() == null || product.getUrl().contains("cat_id")) {
			return false;
		}
		return true;
	}

	@Override
	public boolean buildOldPrice(Element doc, Product product) {
		if (doc.getElementsByClass(CONTENT_CLASS) != null && doc.getElementsByClass(CONTENT_CLASS).first() != null) {
			if (doc.getElementById(CARD_PRICE_CLASS) == null) {
				if (doc.getElementsByClass(DETAILS_CLASS) != null && doc.getElementsByClass(DETAILS_CLASS).first() != null) {
					Element rightColumn = doc.getElementsByClass(DETAILS_CLASS).first();
					if (rightColumn.getElementsByClass(PRICE_CLASS) == null || rightColumn.getElementsByClass(PRICE_CLASS).first() == null) {
						product.setOldPrice(getPrice(rightColumn.getElementsByClass("oldprice").first().text()));
					}
				}
			}
		}
		return true;
	}

	@Override
	public boolean buildPrice(Element doc, Product product) {
		Element element = doc.getElementsByClass(PRODUCT_CLASS).first();
		if (element != null) {
			product.setPrice(new Double(
				element.getElementsByClass(PRICE_CLASS).first().text().substring(0, element.getElementsByClass(PRICE_CLASS).first().text().length() - 2)
					.replaceAll(",", ".")));
		} else if (doc.getElementsByClass(CONTENT_CLASS) != null && doc.getElementsByClass(CONTENT_CLASS).first() != null) {
			if (doc.getElementById(CARD_PRICE_CLASS) != null) {
				product.setPrice(new Double(doc.getElementById(CARD_PRICE_CLASS).text()));
			} else {
				if (doc.getElementsByClass(DETAILS_CLASS) != null && doc.getElementsByClass(DETAILS_CLASS).first() != null) {
					Element rightColumn = doc.getElementsByClass(DETAILS_CLASS).first();
					if (rightColumn.getElementsByClass(PRICE_CLASS) != null && rightColumn.getElementsByClass(PRICE_CLASS).first() != null) {
						product.setPrice(getPrice(rightColumn.getElementsByClass(PRICE_CLASS).first().text()));
					} else {
						product.setPrice(getPrice(rightColumn.getElementsByClass(NEW_PRICE_CLASS).first().text()));
					}
				}
			}
		}
		return true;
	}

	@Override
	public boolean buildImage(Element doc, Product product) {
		Element element = doc.getElementsByClass(PRODUCT_CLASS).first();
		if (element != null) {
			Element ill = element.getElementsByClass("fIllustration").first();
			product.setImage(host + ill.select("a").select("img").attr("src"));
		} else if (doc.getElementsByClass(CONTENT_CLASS) != null && doc.getElementsByClass(CONTENT_CLASS).first() != null) {
			Element imgContent = doc.getElementsByClass("productImage").first();
			if (imgContent.getElementsByClass(MARKER_CLASS) != null && imgContent.getElementsByClass(MARKER_CLASS).first() != null
				&& imgContent.getElementsByClass(MARKER_CLASS).first().attr("src") != null) {
				product.setImage(host + imgContent.getElementsByClass(MARKER_CLASS).first().attr("src"));
			} else {
				product.setImage(host + imgContent.getElementById("lrgImg").attr("src"));
			}
		}
		return true;
	}

	@Override
	public boolean buildCategories(Element doc, Product product) {
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
							.getElementsContainingOwnText(a.text().substring(0, a.text().contains(" ") ? a.text().indexOf(' ') : a.text().length()));
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
		return true;
	}

	@Override
	public boolean buildRate(Element doc, Product product) {
		if (doc.getElementById("BVRRRatingOverall_") != null) {
			Element rating = doc.getElementById("BVRRRatingOverall_").getElementsByClass("BVImgOrSprite").first();
			String rate = rating.attr("title");
			product.setRate(Integer.parseInt(rate.substring(0, rate.indexOf(','))));
		}
		return true;
	}

	@Override
	public boolean buildSeller(Product product) {
		product.setSeller(Seller.CASTO.name());
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
}
