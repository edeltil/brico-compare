package com.brico.compare.parser;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StringUtils;

import com.brico.compare.entity.Constants;
import com.brico.compare.entity.Product;
import com.brico.compare.entity.Seller;

import static org.junit.Assert.assertNotNull;

/**
 * Created by edeltil on 30/01/2017.
 */
public class LMParserTest {
	private Logger LOGGER = Logger.getLogger(this.getClass().getSimpleName());

	@Test
	public void testParserLM() throws IOException {
		LMParser parser = new LMParser("C:/_tmp/perso", "www.leroymerlin.fr/v3/p/produits");
		/*Product 1*/
		Product product1 = parser.parseHTML(getClass().getResource("/LM/product1_LM.html").getPath()).get();
		LOGGER.log(Level.INFO, product1.toString());
		Assert.assertEquals("Accessoire pour thermostat sans fil DIO Ed se 03", product1.getTitle());
		Assert.assertEquals("Type de chauffage:Radiateur électrique, Type de thermostat:Connecté et intelligent, Filaire ou sans fil:Sans fil",
			product1.getShortDescription());
		Assert.assertEquals("http://www.leroymerlin.fr/v3/p/produits/accessoire-pour-thermostat-sans-fil-dio-ed-se-03-e1401169081", product1.getUrl());
		Assert.assertEquals(new Double(44.9), product1.getPrice());
		Assert.assertNull(product1.getOldPrice());
		Assert.assertEquals(Constants.UNIT, product1.getUnit());
		Assert.assertTrue(product1.getDescription().contains("Radiateur électrique"));
		Assert.assertTrue(product1.getDescription().contains("Connecté et intelligent"));
		Assert.assertTrue(product1.getDescription().contains("Sans fil"));
		Assert.assertTrue(product1.getDescription().contains(
			"Compatibilité avec tous les smartphones/Iphone, pc et tablettes. Indicateur LED. Répétiteur de signal. Portée: 150m champs libre. Protocole: 868MHz, DiO by edisio"));
		Assert.assertTrue(product1.getDescription().contains("Google play et App Store"));
		Assert.assertTrue(product1.getDescription().contains("Avec la gamme DIO via la box"));
		Assert.assertTrue(product1.getDescription().contains("HomeBox DIO"));
		Assert.assertTrue(product1.getDescription().contains("Adapter la température de mon logement en fonction du rythme de vie de ma famille"));
		Assert.assertEquals(
			"Chauffage et plomberie - Radiateur, sèche-serviettes, chaudière, régulation et climatiseur - Thermostat et programmateur de chauffage",
			product1.getCategorieSeller());
		/*Product 2*/
		Product product2 = parser.parseHTML(getClass().getResource("/LM/product2_LM.html").getPath()).get();
		LOGGER.log(Level.INFO, product2.toString());
		Assert.assertEquals("5 IntelliTAG pour Myfox Home Alarm MYFOX blanc", product2.getTitle());
		Assert.assertEquals("Garantie (en année):2, Alimentation principale:Piles, Piles fournies:Oui", product2.getShortDescription());
		Assert.assertEquals("http://www.leroymerlin.fr/v3/p/produits/5-intellitag-pour-myfox-home-alarm-myfox-blanc-e1401449447", product2.getUrl());
		Assert.assertEquals(new Double(199.00), product2.getPrice());
		Assert.assertNull(product2.getOldPrice());
		Assert.assertEquals(Constants.UNIT, product2.getUnit());
		Assert.assertTrue(product2.getDescription().contains("Myfox Home Alarm"));
		Assert.assertTrue(product2.getDescription().contains("Piles"));
		Assert.assertTrue(product2.getDescription().contains("Google play et App Store"));
		Assert.assertTrue(product2.getDescription().contains("Home Alarm MYFOX"));
		Assert.assertTrue(product2.getDescription().contains("868 Mhz MYFOX"));
		Assert.assertEquals(
			"Electricité et domotique - Alarme maison, caméra de surveillance et détecteur de fumée - Alarme maison - Accessoires pour alarme de maison",
			product2.getCategorieSeller());
		Assert.assertFalse(parser.parseHTML(getClass().getResource("/LM/product3_LM.html").getPath()).isPresent());
		Assert.assertFalse(parser.parseHTML(getClass().getResource("/LM/product4_LM.html").getPath()).isPresent());
		Assert.assertFalse(parser.parseHTML(getClass().getResource("/LM/product5_LM.html").getPath()).isPresent());
		Assert.assertFalse(parser.parseHTML(getClass().getResource("/LM/product6_LM.html").getPath()).isPresent());
		/*Product 7*/
		Product product7 = parser.parseHTML(getClass().getResource("/LM/product7_LM.html").getPath()).get();
		LOGGER.log(Level.INFO, product7.toString());
		Assert.assertEquals("Raclette à lisser caoutchouc SEMIN", product7.getTitle());
		Assert.assertTrue(StringUtils.isEmpty(product7.getShortDescription()));
		Assert.assertEquals("http://www.leroymerlin.fr/v3/p/produits/raclette-a-lisser-caoutchouc-semin-e153803", product7.getUrl());
		Assert.assertEquals("http://www.leroymerlin.fr/multimedia/354666859/produits/raclette-a-lisser-caoutchouc-semin.jpg", product7.getImage());
		Assert.assertEquals(new Double(9.6), product7.getPrice());
		Assert.assertNull(product7.getOldPrice());
		Assert.assertEquals(Constants.UNIT, product7.getUnit());
		Assert.assertTrue(StringUtils.isEmpty(product7.getDescription()));
		Assert.assertEquals("Peinture et droguerie - Sous-couche et enduit - Accessoires enduit", product7.getCategorieSeller());

		/*Product 8*/
		Product product8 = parser.parseHTML(getClass().getResource("/LM/product8.html").getPath()).get();
		LOGGER.log(Level.INFO, product8.toString());
		Assert.assertEquals("Parquet massif chêne brut brut L ARTENS Solidclic", product8.getTitle());
		Assert.assertTrue(product8.getShortDescription().contains("Passage:Important (couple avec un enfant), Pose:Flottante clic+, Qualité du bois:Bohème"));
		Assert.assertEquals("http://www.leroymerlin.fr/v3/p/produits/parquet-massif-chene-brut-brut-l-artens-solidclic-e1401294747", product8.getUrl());
		Assert.assertEquals("http://www.leroymerlin.fr/multimedia/7f1401388942/produits/parquet-massif-chene-brut-brut-l-artens-solidclic.jpg",
			product8.getImage());
		Assert.assertEquals(new Double(39.95), product8.getPrice());
		Assert.assertNull(product8.getOldPrice());
		Assert.assertEquals(Constants.M2, product8.getUnit());
		Assert.assertTrue(product8.getDescription().contains("Passage : Important (couple avec un enfant)"));
		Assert.assertTrue(product8.getDescription().contains(
			"Pose : Flottante clic+, Qualité du bois : Bohème, Compatible pièces humides : Non, Epaisseur (en mm) : 15, Longueur (en cm) : 30 à 120, Largeur (en cm) : 12, Finition du produit : Brut, Chanfrein : 4 chanfreins, Effet du chanfrein : 4 chanfreins, pour un effet lame de parquet, Support : Massif, Sol chauffant à eau basse T° (28 °C maxi) : Non, Sol chauffant à accumulation basse T° (28 °C maxi) : Non, Sol chauffant élec. rayonnant basse T° (28 °C max) : Non, Compatible sol rafraîchissant : Non, Produit emballé : poids (en kg) : 10.61"));
		Assert.assertEquals("Carrelage, parquet et sol souple - Parquet, stratifié et plancher - Parquet contrecollé et massif", product8.getCategorieSeller());
	}

	@Test
	public void testParser() throws IOException {
		LMParser parser = new LMParser("C:/_tmp/perso", "www.leroymerlin.fr/v3/p/produits/");
		List<Product> products = parser.parseDirectory();
		assertNotNull(products);
		for (Product product : products) {
			assertNotNull("Error on rate : " + product.getPath(), product.getRate());
			assertNotNull("Error on path : " + product.getPath(), product.getPath());
			assertNotNull("Error on image : " + product.getPath(), product.getImage());
			assertNotNull("Error on short description : " + product.getPath(), product.getShortDescription());
			assertNotNull("Error on seller : " + product.getPath(), product.getSeller());
			assertNotNull("Error on seller : " + product.getPath(), product.getSeller().equals(Seller.LM.name()));
			assertNotNull("Error on categorie seller : " + product.getPath(), product.getCategorieSeller());
			//			assertNotNull("Error on description : " + product.getPath(), product.getDescription());
			assertNotNull("Error on date : " + product.getPath(), product.getDate());
			assertNotNull("Error on price : " + product.getPath(), product.getPrice());
			assertNotNull("Error on title : " + product.getPath(), product.getTitle());
			assertNotNull("Error on unit : " + product.getPath(), product.getUnit());
			assertNotNull("Error on url : " + product.getPath(), product.getUrl());
		}
	}

}