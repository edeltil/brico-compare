package com.brico.compare.parser;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.brico.compare.entity.Product;
import com.brico.compare.entity.Seller;

import static org.junit.Assert.assertNotNull;

/**
 * Created by edeltil on 30/01/2017.
 */
public class CastoParserTest {

	private Logger LOGGER = Logger.getLogger(this.getClass().getSimpleName());

	@Test
	public void testParserCasto() throws IOException {
		CastoParser parser = new CastoParser("http://www.castorama.fr", "C:/_tmp/perso", "www.castorama.fr/store");
		/*Product 1*/
		Product product1 = parser.parseHTML(getClass().getResource("/Casto/product1_Casto.html").getPath());
		LOGGER.log(Level.INFO, product1.toString());
		Assert.assertEquals("Abri de jardin en bois Ylistaro", product1.getTitle());
		Assert.assertEquals("Abri de jardin en bois Ylistaro", product1.getShortDescription());
		Assert.assertEquals("http://www.castorama.fr/store/Abri-de-jardin-en-bois-Ylistaro-prod10290198.html", product1.getUrl());
		Assert.assertEquals("http://www.castorama.fr/images/products/h/h_631206.jpg", product1.getImage());
		Assert.assertEquals(new Double(1699.00), product1.getPrice());
		Assert.assertNull(product1.getOldPrice());
		Assert.assertEquals("unit", product1.getUnit());
		Assert.assertTrue(product1.getDescription().contains("Epicéa origine Finlande"));
		Assert.assertTrue(product1.getDescription().contains(
			"1 double porte coulissante vitrée (verre synthétique) avec croisillons bois et 1 fenêtre vitrée (verre synthétique) fixe avec croisillons en bois."));
		Assert.assertTrue(product1.getDescription().contains("Revêtement en feutre bitumeux, pas de shingles possible."));
		Assert.assertEquals("Jardin et Terrasse - Abri, serre, carport, garage, rangement - Abri de jardin", product1.getCategorieSeller());

		/*Product 2*/
		Product product2 = parser.parseHTML(getClass().getResource("/Casto/product2_Casto.html").getPath());
		LOGGER.log(Level.INFO, product2.toString());
		Assert.assertEquals("Bain de soleil Papaya eucalyptus", product2.getTitle());
		Assert.assertEquals("Bain de soleil Papaya eucalyptus", product2.getShortDescription());
		Assert.assertEquals("http://www.castorama.fr/store/Bain-de-soleil-Papaya-eucalyptus-prod15600066.html", product2.getUrl());
		Assert.assertEquals("http://www.castorama.fr/images/products/h/h_667624.jpg", product2.getImage());
		Assert.assertEquals(new Double(34.90), product2.getPrice());
		Assert.assertNull(product2.getOldPrice());
		Assert.assertEquals("unit", product2.getUnit());
		Assert.assertTrue(product2.getDescription().contains("Structure en acier. Toile 100% PVC tissé."));
		Assert.assertTrue(product2.getDescription().contains("173 x 58 x h.65 cm."));
		Assert.assertTrue(product2.getDescription().contains("Coloris eucalyptus."));
		Assert.assertTrue(product2.getDescription().contains("Avec bandoulière."));
		Assert.assertEquals("Jardin et Terrasse - Mobilier de jardin - Bain de soleil", product2.getCategorieSeller());

		/*Product 3*/
		Product product3 = parser.parseHTML(getClass().getResource("/Casto/product3.html").getPath());
		LOGGER.log(Level.INFO, product3.toString());
		Assert.assertEquals("Fauteuil de jardin en métal Colombia", product3.getTitle());
		Assert.assertEquals("Fauteuil de jardin en métal Colombia", product3.getShortDescription());
		Assert.assertEquals("http://www.castorama.fr/store/Fauteuil-de-jardin-en-metal-Colombia-prod19090090.html", product3.getUrl());
		Assert.assertEquals("http://www.castorama.fr/images/products/h/h_689008.jpg", product3.getImage());
		Assert.assertEquals(new Double(35), product3.getPrice());
		Assert.assertNull(product3.getOldPrice());
		Assert.assertEquals("unit", product3.getUnit());
		Assert.assertTrue(product3.getDescription().contains("Ce fauteuil de jardin mêle aluminium et polyester"));
		Assert.assertTrue(product3.getDescription()
			.contains("A associer avec la table de jardin de la même collection pour une déco extérieure contemporaine et harmonieuse."));
		Assert.assertTrue(product3.getDescription().contains("Toile 75% PVC et 25% polyester."));
		Assert.assertTrue(product3.getDescription().contains("Dimensions : 55 x 60,5 x h.86 cm."));
		Assert.assertEquals("Jardin et Terrasse - Mobilier de jardin - Chaise et fauteuil de jardin", product3.getCategorieSeller());

		/*Product 5*/
		Product product5 = parser.parseHTML(getClass().getResource("/Casto/product5.html").getPath());
		LOGGER.log(Level.INFO, product5.toString());
		Assert.assertEquals("Bétonnière électrique B165", product5.getTitle());
		Assert.assertEquals("Bétonnière électrique B165", product5.getShortDescription());
		Assert.assertEquals("http://www.castorama.fr/store/Betonniere-electrique-B165-prod13970046.html", product5.getUrl());
		Assert.assertEquals("http://www.castorama.fr./product5_files/h_658286.jpg", product5.getImage());
		Assert.assertEquals(new Double(219), product5.getPrice());
		Assert.assertEquals(4, product5.getRate());
		Assert.assertNull(product5.getOldPrice());
		Assert.assertEquals("unit", product5.getUnit());
		Assert.assertTrue(product5.getDescription().contains("Grâce à sa cuve de 160 litres"));
		Assert.assertTrue(product5.getDescription().contains("Ses deux roues de 200 mm de diamètre vous permettront de la déplacer facilement."));
		Assert.assertTrue(product5.getDescription().contains(" Capacité de malaxage : 130 L."));
		Assert.assertEquals("Jardin et Terrasse - Outillage - Matériel et outillage de bâtiment - Bétonnière", product5.getCategorieSeller());

		/*Product 6*/
		Product product6 = parser.parseHTML(getClass().getResource("/Casto/product6.html").getPath());
		LOGGER.log(Level.INFO, product6.toString());
		Assert.assertEquals("Cloison à lames orientables Yotta beige", product6.getTitle());
		Assert.assertEquals("Découvrez les offres et promotions de cloisons amovibles sur www.castorama.fr !  ", product6.getShortDescription());
		Assert.assertEquals("http://www.castorama.fr/store/Cloison-amovible-cat50004.htm", product6.getUrl());
		Assert.assertEquals("http://www.castorama.fr/images/products/g/g_647470.jpg", product6.getImage());
		Assert.assertEquals(new Double(29.9), product6.getPrice());
		Assert.assertEquals(0, product6.getRate());
		Assert.assertNull(product6.getOldPrice());
		Assert.assertEquals("unit", product6.getUnit());
		Assert.assertTrue(product6.getDescription().contains("Cloison à lames orientables Yotta beige."));
		Assert.assertTrue(product6.getDescription().contains("La lame décorative permet une installation facile grâce au système de pieds réglables."));
		Assert.assertTrue(product6.getDescription()
			.contains("MDF (panneaux de fibres de moyenne densité). Finition : Beige. Dimensions : 24 x h.239-252 cm. Epaisseur 28 mm."));
		Assert.assertEquals("Jardin et Terrasse - Porte intérieure, escalier et cloison amovible", product6.getCategorieSeller());

		/*Product 7*/
		Product product7 = parser.parseHTML(getClass().getResource("/Casto/product7.html").getPath());
		LOGGER.log(Level.INFO, product7.toString());
		Assert.assertEquals("Lame de terrasse composite Dixi marron L.220 x l.14,5 cm", product7.getTitle());
		Assert.assertEquals("Lame de terrasse composite Dixi marron L.220 x l.14,5 cm", product7.getShortDescription());
		Assert.assertEquals("http://www.castorama.fr/store/Lame-de-terrasse-composite-Dixi-marron-L220-x-l145-cm-prod9350044.html", product7.getUrl());
		Assert.assertEquals("http://www.castorama.fr/images/products/h/h_623023.jpg", product7.getImage());
		Assert.assertEquals(new Double(26.99), product7.getPrice());
		Assert.assertEquals(0, product7.getRate());
		Assert.assertNull(product7.getOldPrice());
		Assert.assertEquals("le m²", product7.getUnit());
		Assert.assertTrue(product7.getDescription().contains(
			"Pour habiller vos extérieurs avec une touche évidente de déco tout en bénéficiant des avantages du composite, la lame de terrasse en composite marron Dixi est idéale."));
		Assert.assertEquals("Jardin et Terrasse - Revêtement terrasse et sol extérieur - Lame de terrasse", product7.getCategorieSeller());
	}

	@Test
	public void testParser() throws IOException {
		CastoParser parser = new CastoParser("http://www.castorama.fr", "C:/_tmp/perso", "www.castorama.fr/store");
		List<Product> products = parser.parseDirectory();
		assertNotNull(products);
		for (Product product : products) {
			assertNotNull("Error on rate : " + product.getPath(), product.getRate());
			assertNotNull("Error on path : " + product.getPath(), product.getPath());
			assertNotNull("Error on short description : " + product.getPath(), product.getShortDescription());
			assertNotNull("Error on seller : " + product.getPath(), product.getSeller());
			assertNotNull("Error on seller : " + product.getPath(), product.getSeller().equals(Seller.Casto.name()));
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