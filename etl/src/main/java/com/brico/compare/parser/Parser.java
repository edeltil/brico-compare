package com.brico.compare.parser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.brico.compare.entity.Product;
import com.brico.compare.utils.Utils;

/**
 * Created by edeltil on 25/01/2017.
 */
public abstract class Parser {
	private static final Logger LOGGER = Logger.getLogger("Parser");

	private String directory;
	private String path;

	public Parser(String directory, String path) {
		this.directory = directory;
		this.path = path;
	}

	public List<Product> parseDirectory() throws IOException {
		List<Product> products = new ArrayList<>();
		Collection<File> files = FileUtils.listFiles(new File(directory + File.separator + path), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
		files.forEach(file -> {
			LOGGER.finest(file.getPath());
			try {
				parseHTML(file.getPath()).ifPresent(p -> products.add(p));
			} catch (IOException e) {
				LOGGER.severe("Error while reading : " + file.getPath() + " : " + e);
			}
		});
		return products;
	}

	private Optional<Document> readFile(final String path) throws IOException {
		Document doc;
		try {
			doc = Jsoup.parse(new File(path), Charset.forName("UTF-8").name());
		} catch (IllegalArgumentException exc) {
			LOGGER.fine("File not readable : " + path + " : " + exc);
			return Optional.empty();
		}
		return Optional.of(doc);
	}

	protected Optional<Product> returnValue(final Product product) {
		if (StringUtils.isEmpty(product.getSeller())) {
			return Optional.empty();
		} else {
			return Optional.of(product);
		}
	}

	public Optional<Product> parseHTML(String path) throws IOException {
		Product product = new Product();
		readFile(path).ifPresent(doc -> {
			product.setPath(path);
			if (isEmptyProduct(doc)) {
				return;
			}
			for (ExecutionMethod method : getOrders()) {
				switch (method) {
					case TITLE:
						if (!buildTitle(doc, product)) {
							return;
						}
						break;
					case DESCRIPTION:
						if (!buildDescription(doc, product)) {
							return;
						}
						break;
					case SHORT_DESCRIPTION:
						if (!buildShortDescription(doc, product)) {
							return;
						}
						break;
					case URL:
						if (!buildUrl(doc, product)) {
							return;
						}
						break;
					case OLD_PRICE:
						if (!buildOldPrice(doc, product)) {
							return;
						}
						break;
					case PRICE:
						if (!buildPrice(doc, product)) {
							return;
						}
						break;
					case UNIT:
						if (!buildUnit(doc, product)) {
							return;
						}
						break;
					case IMAGE:
						if (!buildImage(doc, product)) {
							return;
						}
						break;
					case CATEGORIES:
						if (!buildCategories(doc, product)) {
							return;
						}
						break;
					case RATE:
						if (!buildRate(doc, product)) {
							return;
						}
						break;
				}
			}
			if (!buildSeller(product)) {
				return;
			}
			Utils.checkProduct(product);

		});
		return returnValue(product);
	}

	public abstract List<ExecutionMethod> getOrders();

	public abstract boolean isEmptyProduct(final Element doc);

	public abstract boolean buildUnit(final Element doc, Product product);

	public abstract boolean buildTitle(final Element doc, Product product);

	public abstract boolean buildDescription(final Element doc, Product product);

	public abstract boolean buildShortDescription(final Element doc, Product product);

	public abstract boolean buildUrl(final Element doc, Product product);

	public abstract boolean buildOldPrice(final Element doc, Product product);

	public abstract boolean buildPrice(final Element doc, Product product);

	public abstract boolean buildImage(final Element doc, Product product);

	public abstract boolean buildCategories(final Element doc, Product product);

	public boolean buildRate(final Element doc, Product product) {
		product.setRate(0);
		return true;
	}

	public abstract boolean buildSeller(Product product);
}
