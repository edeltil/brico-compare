package com.brico.compare.parser;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;

import com.brico.compare.entity.Product;
import com.brico.compare.entity.Seller;

import static org.junit.Assert.assertNotNull;

/**
 * Created by edeltil on 06/02/2017.
 */
public class BricoDepotParserTest {

	private Logger LOGGER = Logger.getLogger(this.getClass().getSimpleName());

	@Test
	public void testParserBricoDepot() throws IOException {
		BricoDepotParser parser = new BricoDepotParser("http://www.bricodepot.fr", "C:/_tmp/perso", "www.bricodepot.fr/marseille");
		/*Product 1 C:\DEXXIS\samples\etl\src\test\resources\BricoDepot\product1_BD.html*/
		Product product1 = parser.parseHTML(getClass().getResource("/BricoDepot/product1_BD.html").getPath());
		LOGGER.log(Level.INFO, product1.toString());
		Assert.assertEquals("BROYEUR DE VÉGÉTAUX PROFESSIONNEL 3000 W - SCHEPPACH", product1.getTitle());
		Assert.assertEquals(
			"Puissance Moteur : 3000 W. Bâti métallique. Diamètre de coupe : Branches jusqu'à 45 mm. Capacité : 150 kg/h max. Qualité de coupe : couteaux diamétralement oppo",
			product1.getShortDescription());
		Assert.assertEquals("http://www.bricodepot.fr/catalogue/broyeur-de-vegetaux-professionnel-3000-w/prod47497/", product1.getUrl());
		Assert.assertEquals("http://www.bricodepot.fr/images/page_prod_big/73000/73489.jpg", product1.getImage());
		Assert.assertEquals(new Double(559.20), product1.getPrice());
		Assert.assertEquals(new Double(699.00), product1.getOldPrice());
		Assert.assertEquals("unit", product1.getUnit());
		Assert.assertTrue(product1.getDescription().contains(
			"Puissance Moteur : 3000 W. Bâti métallique. Diamètre de coupe : Branches jusqu'à 45 mm. Capacité : 150 kg/h max. Qualité de coupe : couteaux diamétralement opposés réversibles en acier trempé réaffûtables. Adapté aux grands jardins."));
		Assert.assertEquals("Soldes", product1.getCategorieSeller());
		/*Product 2*/
		Product product2 = parser.parseHTML(getClass().getResource("/BricoDepot/product2_BD.html").getPath());
		LOGGER.log(Level.INFO, product2.toString());
		Assert.assertEquals("100 CAVALIERS GRIS Ø 10 À 14 MM - LEGRAND", product2.getTitle());
		Assert.assertEquals("Boîte de 100 cavaliers gris - Pour Fixation de câbles de 10 à 14 mm de diamètre. Clou en acier : Ø 1,8 mm - Long. 30 mm.",
			product2.getShortDescription());
		Assert.assertEquals("http://www.bricodepot.fr/catalogue/100-cavaliers-gris--10-a-14-mm/prod46775/", product2.getUrl());
		Assert.assertEquals("http://www.bricodepot.fr/images/page_prod_big/70000/70081.jpg", product2.getImage());
		Assert.assertEquals(new Double(9.78), product2.getPrice());
		Assert.assertEquals(new Double(16.30), product2.getOldPrice());
		Assert.assertEquals("unit", product2.getUnit());
		Assert.assertTrue(product2.getDescription()
			.contains("Boîte de 100 cavaliers gris - Pour Fixation de câbles de 10 à 14 mm de diamètre. Clou en acier : Ø 1,8 mm - Long. 30 mm."));
		Assert.assertEquals("Soldes", product2.getCategorieSeller());
		/*Product 3*/
		Product product3 = parser.parseHTML(getClass().getResource("/BricoDepot/product3_BD.html").getPath());
		LOGGER.log(Level.INFO, product3.toString());
		Assert.assertEquals("4M READYCLIM 1/4 1/2 + MISE EN SERVICE", product3.getTitle());
		Assert.assertEquals("4M READYCLIM 1/4 1/2 + MISE EN SERVICE / Magasin de Bricolage Brico Dépôt", product3.getShortDescription());
		Assert.assertEquals("http://www.bricodepot.fr/catalogue/4m-readyclim-14-12-mise-en-service/prod48934/", product3.getUrl());
		Assert.assertNull(product3.getImage());
		Assert.assertEquals(new Double(199), product3.getPrice());
		Assert.assertNull(product3.getOldPrice());
		Assert.assertEquals("unit", product3.getUnit());
		Assert.assertEquals("4M READYCLIM 1/4 1/2 + MISE EN SERVICE / Magasin de Bricolage Brico Dépôt", product3.getDescription());
		Assert.assertEquals("Chauffage - Isolation - Climatisations réversibles - Kits de connexion", product3.getCategorieSeller());
		/*Product 4*/
		Assert.assertNull(parser.parseHTML(getClass().getResource("/BricoDepot/product4_BD.html").getPath()));
		/*Product 5*/
		Product product5 = parser.parseHTML(getClass().getResource("/BricoDepot/product5.html").getPath());
		LOGGER.log(Level.INFO, product5.toString());
		Assert.assertEquals("VOLET ROULANT ALUMINIUM MOTORISÉ GRIS", product5.getTitle());
		Assert.assertEquals(
			"Volet rénovation recoupable. Coffre aluminium à pan coupé à 45°. Tablier en lames aluminium isolées de mousse de polyuréthane à 70 kg/m3. Coulisses et lame fina",
			product5.getShortDescription());
		Assert.assertEquals("http://www.bricodepot.fr/catalogue/volet-roulant-aluminium-motorise-gris/prod48070/", product5.getUrl());
		Assert.assertEquals("http://www.bricodepot.fr/images/page_prod_big/74500/74993.jpg", product5.getImage());
		Assert.assertEquals(new Double(133), product5.getPrice());
		Assert.assertEquals(new Double(190), product5.getOldPrice());
		Assert.assertEquals("unit", product5.getUnit());
		Assert.assertEquals(
			"Volet rénovation recoupable. Coffre aluminium à pan coupé à 45°. Tablier en lames aluminium isolées de mousse de polyuréthane à 70 kg/m3. Coulisses et lame finale en aluminium extrudé. Motorisation filaire. Inverseur filaire inclus. Coloris GRIS RAL 7016. Garantie 2 ans(A). Certifié CE. Les dimensions sont indiquées coffre compris.",
			product5.getDescription());
		Assert.assertEquals("Soldes", product5.getCategorieSeller());
		/*Product 6*/
		Product product6 = parser.parseHTML(getClass().getResource("/BricoDepot/product6.html").getPath());
		LOGGER.log(Level.INFO, product6.toString());
		Assert.assertEquals("POLYSTYRÈNE EXTRUDÉ ÉP. 40 MM", product6.getTitle());
		Assert.assertEquals(
			"Dim. : L. 2,50 x l. 0,60 m, soit 1,5 m². Pour l’isolation des toitures, murs et sols. ACERMI. LAMBDA = 0,036. R = 1,2. ÉTANCHE À L'AIR. IMPUTRESCIBLE.",
			product6.getShortDescription());
		Assert.assertEquals("http://www.bricodepot.fr/catalogue/polystyrene-extrude-ep-40-mm/prod13295/", product6.getUrl());
		Assert.assertEquals("http://www.bricodepot.fr/images/page_prod_big/19000/19132.jpg", product6.getImage());
		Assert.assertEquals(new Double(5.2), product6.getPrice());
		Assert.assertNull(product6.getOldPrice());
		Assert.assertEquals("le m²", product6.getUnit());
		Assert.assertEquals(
			"Dim. : L. 2,50 x l. 0,60 m, soit 1,5 m². Pour l’isolation des toitures, murs et sols. ACERMI. LAMBDA = 0,036. R = 1,2. ÉTANCHE À L'AIR. IMPUTRESCIBLE.",
			product6.getDescription());
		Assert.assertEquals("Arrivages à partir du 03 février 2017", product6.getCategorieSeller());
	}

	@Test
	public void testPriceParser() throws IOException {
		BricoDepotParser parser = new BricoDepotParser("C:/_tmp/perso", "www.bricodepot.fr/marseille", "http://www.bricodepot.fr");
		Document doc = Jsoup.parse("<div class=\"curentPrice clearfix\">\n"
			+ "\t<span>559€</span><sup class=\"cents\">20<span class=\"units\">TTC&nbsp;/&nbsp;la pièce<span class=\"accented_ttc\">&nbsp;</span></span></sup></div>");
		Assert.assertEquals(new Double(559.20), parser.getPrice(doc.getElementsByClass("curentPrice").first()));
		Document doc2 = Jsoup.parse("<div class=\"curentPrice clearfix\">\n"
			+ "\t<span>9€</span><sup class=\"cents\">78<span class=\"units\">TTC&nbsp;/&nbsp;la pièce<span class=\"accented_ttc\">&nbsp;</span></span></sup></div>");
		Assert.assertEquals(new Double(9.78), parser.getPrice(doc2.getElementsByClass("curentPrice").first()));
	}

	@Test
	public void testUnitParser() throws IOException {
		BricoDepotParser parser = new BricoDepotParser("C:/_tmp/perso", "www.bricodepot.fr/marseille", "http://www.bricodepot.fr");
		Document doc = Jsoup.parse("<div class=\"curentPrice clearfix\">\n"
			+ "\t<span>559€</span><sup class=\"cents\">20<span class=\"units\">TTC&nbsp;/&nbsp;la pièce<span class=\"accented_ttc\">&nbsp;</span></span></sup></div>");
		Assert.assertEquals("la pièce", parser.getUnit(doc.getElementsByClass("curentPrice").first()));
		Document doc2 = Jsoup.parse("<div class=\"curentPrice clearfix\">\n"
			+ "\t<span>9€</span><sup class=\"cents\">78<span class=\"units\">TTC&nbsp;/&nbsp;la pièce<span class=\"accented_ttc\">&nbsp;</span></span></sup></div>");
		Assert.assertEquals("la pièce", parser.getUnit(doc2.getElementsByClass("curentPrice").first()));
	}

	@Test
	public void testOldPriceParser() throws IOException {
		BricoDepotParser parser = new BricoDepotParser("C:/_tmp/perso", "www.bricodepot.fr/marseille", "http://www.bricodepot.fr");
		Document doc = Jsoup.parse("<div class=\"oldPrice clearfix\">\n" + "\t<span>699€00TTC&nbsp;/&nbsp;la pièce</span></div>");
		Assert.assertEquals(new Double(699), parser.getOldPrice(doc.getElementsByClass("oldPrice").first().text()));
		Document doc2 = Jsoup.parse("<div class=\"oldPrice clearfix\">\n" + "\t<span>16€30TTC&nbsp;/&nbsp;la pièce</span></div>");
		Assert.assertEquals(new Double(16.30), parser.getOldPrice(doc2.getElementsByClass("oldPrice").first().text()));
	}

	@Test
	public void testParser() throws IOException {
		BricoDepotParser parser = new BricoDepotParser("http://www.bricodepot.fr", "C:/_tmp/perso", "www.bricodepot.fr/marseille");
		List<Product> products = parser.parseDirectory();
		assertNotNull(products);
		for (Product product : products) {
			assertNotNull("Error on rate : " + product.getPath(), product.getRate());
			assertNotNull("Error on path : " + product.getPath(), product.getPath());
			assertNotNull("Error on short description : " + product.getPath(), product.getShortDescription());
			assertNotNull("Error on seller : " + product.getPath(), product.getSeller());
			assertNotNull("Error on seller : " + product.getPath(), product.getSeller().equals(Seller.BD.name()));
			assertNotNull("Error on categorie seller : " + product.getPath(), product.getCategorieSeller());
			assertNotNull("Error on description : " + product.getPath(), product.getDescription());
			assertNotNull("Error on old price : " + product.getPath(), product.getDate());
			assertNotNull("Error on price : " + product.getPath(), product.getPrice());
			assertNotNull("Error on title : " + product.getPath(), product.getTitle());
			assertNotNull("Error on unit : " + product.getPath(), product.getUnit());
			assertNotNull("Error on url : " + product.getPath(), product.getUrl());
		}
	}
}