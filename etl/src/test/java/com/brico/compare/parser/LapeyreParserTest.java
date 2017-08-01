package com.brico.compare.parser;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.brico.compare.entity.Constants;
import com.brico.compare.entity.Product;
import com.brico.compare.entity.Seller;

import static org.junit.Assert.assertNotNull;

/**
 * Created by edeltil on 08/02/2017.
 */
public class LapeyreParserTest {

	private Logger LOGGER = Logger.getLogger(this.getClass().getSimpleName());

	@Test
	public void testParserLapeyre() throws IOException {
		LapeyreParser parser = new LapeyreParser("C:/_tmp/perso", "www.lapeyre.fr");
		/*Product 1 C:\DEXXIS\samples\etl\src\test\resources\BricoDepot\product1_BD.html*/
		Product product1 = parser.parseHTML(getClass().getResource("/Lapeyre/product1.html").getPath()).get();
		LOGGER.log(Level.INFO, product1.toString());
		Assert.assertEquals("Abattant Classic Chêne", product1.getTitle());
		Assert.assertEquals(
			"Offrez-vous la qualité avec l’abattant Classic Chêne qui se distingue par sa finition, sa résistance aux intempéries et ses performances d'isolation thermique et phonique. Il est aussi garanti 10 ans.",
			product1.getShortDescription());
		Assert.assertEquals("https://www.lapeyre.fr/abattant-classic-chene-FPC2310630", product1.getUrl());
		Assert.assertEquals("http://static.lapeyre.fr/img/catalogue/standardMain/206/638/201206638.jpg", product1.getImage());
		Assert.assertEquals(new Double(140), product1.getPrice());
		Assert.assertEquals(new Double(140), product1.getOldPrice());
		Assert.assertEquals("unit", product1.getUnit());
		Assert.assertTrue(product1.getDescription().contains("Chêne d’Europe abouté et certifié PEFC."));
		Assert.assertTrue(product1.getDescription().contains("Epaisseurs: ouvrant 46mm et dormant 45mm."));
		Assert.assertTrue(product1.getDescription().contains("intercalaire noir traité faible émissivité avec gaz argon."));
		Assert.assertTrue(product1.getDescription().contains("Haute Isolation Thermique: Ug = 1.1 et Haute Isolation Acoustique: AC1 (RA ; tr = 28dB)."));
		Assert.assertTrue(product1.getDescription().contains("Etanchéité: A*4 E*6B V*A2"));
		Assert.assertTrue(
			product1.getDescription().contains("Joint d’isolation thermique et acoustique. Joint de vitrage assorti et intercalaire de vitrage noir."));
		Assert.assertTrue(product1.getDescription().contains("Pièce d'appui courte de 68mm."));
		Assert.assertTrue(product1.getDescription().contains(
			"Finition bois lasuré foncé à base d'eau sans solvant, traitement Finistar sur chaque pièce de bois (insecticide, fongicide, finition)."));
		Assert.assertTrue(product1.getDescription().contains("216 dimensions standard (abattant, châssis, fenêtre, porte-fenêtre et baie coulissante)."));
		Assert.assertTrue(product1.getDescription()
			.contains("Les dimensions indiquées sont les hauteurs et largeurs tableau (dimensions entre murs exprimées en centimètre)."));

		Assert.assertEquals("Fenêtres", product1.getCategorieSeller());
		/*Product 2*/
		Assert.assertFalse(parser.parseHTML(getClass().getResource("/Lapeyre/product2.html").getPath()).isPresent());
				/*Product 3*/
		Product product3 = parser.parseHTML(getClass().getResource("/Lapeyre/product3.html").getPath()).get();
		LOGGER.log(Level.INFO, product3.toString());
		Assert.assertEquals("Baie coulissante Excellence Alubois", product3.getTitle());
		Assert.assertEquals(
			"Cette baie vitrée sur mesure en bois et aluminium est disponible en plusieurs coloris. Elle allie la chaleur du bois à l'intérieur et les avantages de l'aluminium à l'extérieur. Facile à entretenir, elle vous isolera du bruit et du froid en toute praticité",
			product3.getShortDescription());
		Assert.assertEquals("https://www.lapeyre.fr/baie-coulissante-performance-alubois-FPC2176290", product3.getUrl());
		Assert.assertEquals("http://static.lapeyre.fr/img/catalogue/collMain/amb/@01/2176290@AMB@01.jpg", product3.getImage());
		Assert.assertNull(product3.getPrice());
		Assert.assertNull(product3.getOldPrice());
		Assert.assertEquals("unit", product3.getUnit());
		Assert.assertTrue(product3.getDescription().contains("Ouvrant et dormant à assemblage mécanique pour une plus grande solidité."));
		Assert.assertTrue(product3.getDescription().contains("Bois abouté, lamellé, collé et plaqué pour une tenue parfaite."));
		Assert.assertTrue(product3.getDescription().contains("Traitement IFH (insecticide, fongicide et hydrofuge) des bois pour une durabilité maximale."));
		Assert.assertTrue(product3.getDescription().contains("Ouvrant d'épaisseur totale de 68mm dont 38mm de bois."));
		Assert.assertTrue(product3.getDescription().contains("Crémone à galets multipoints (selon hauteur)."));
		Assert.assertTrue(product3.getDescription().contains("Sécurité : 2 pions anti-dégondage."));
		Assert.assertTrue(product3.getDescription().contains("Disponible en 2, 3 ou 4 vantaux sur 2 ou 3 rails."));
		Assert.assertTrue(product3.getDescription().contains("Deux chariots dont un réglable pour l'ouvrant."));
		Assert.assertTrue(product3.getDescription().contains("Baie vitrée sur mesure uniquement."));
		Assert.assertTrue(product3.getDescription().contains(
			"Bois côté intérieur : Essences Pin et Chêne: finition Pin naturel, Pin lasuré cendré, Pin lasuré sable, Chêne naturel, Chêne blanchi, Chêne moyen."));
		Assert.assertEquals("Fenêtres - Baies coulissantes", product3.getCategorieSeller());
				/*Product 4*/
		Assert.assertFalse(parser.parseHTML(getClass().getResource("/Lapeyre/product4.html").getPath()).isPresent());
		Assert.assertFalse(parser.parseHTML(getClass().getResource("/Lapeyre/product5.html").getPath()).isPresent());
		/*Product 7*/
		Product product7 = parser.parseHTML(getClass().getResource("/Lapeyre/product7.html").getPath()).get();
		LOGGER.log(Level.INFO, product7.toString());
		Assert.assertEquals("Parquet contrecollé Extrem Silence Chêne Blanchi brossé verni", product7.getTitle());
		Assert.assertEquals(
			"Gagnez la sympathie de vos voisins avec le parquet contrecollé Extrem Silence certifié PEFC ! La sous-couche isophonique et la garantie de 10 ans vous assurent un parquet silencieux et durable…",
			product7.getShortDescription());
		Assert.assertEquals("https://www.lapeyre.fr/parquet-contrecolle-extrem-silence-blanchi-verni-FPC2268370", product7.getUrl());
		Assert.assertEquals("http://static.lapeyre.fr/img/catalogue/standardMain/308/807/201308807.jpg", product7.getImage());
		Assert.assertEquals(new Double(28.95), product7.getPrice());
		Assert.assertEquals(new Double(57.9), product7.getOldPrice());
		Assert.assertEquals(Constants.M2, product7.getUnit());
		Assert.assertTrue(product7.getDescription().contains("Épaisseur 11,7 mm dont 1,2 mm de sous couche intégrée."));
		Assert.assertTrue(product7.getDescription().contains("Couche d'usure de 2.5 mm."));
		Assert.assertTrue(product7.getDescription().contains("Longueur 119 cm, - Largeur de lame 14 cm."));
		Assert.assertTrue(product7.getDescription().contains("Botte de 1.33 m²."));
		Assert.assertTrue(product7.getDescription().contains("Chêne brossé verni mat."));
		Assert.assertTrue(product7.getDescription().contains("Disponible en décor Blanc polaire huilé."));
		Assert.assertEquals("Sols & murs - Parquets - Parquets Blanchis", product7.getCategorieSeller());
	}

	@Test
	public void testParser() throws IOException {
		LapeyreParser parser = new LapeyreParser("C:/_tmp/perso", "www.lapeyre.fr/");
		List<Product> products = parser.parseDirectory();
		assertNotNull(products);
		for (Product product : products) {
			assertNotNull("Error on rate : " + product.getPath(), product.getRate());
			assertNotNull("Error on path : " + product.getPath(), product.getPath());
			assertNotNull("Error on image : " + product.getPath(), product.getImage());
			assertNotNull("Error on short description : " + product.getPath(), product.getShortDescription());
			assertNotNull("Error on seller : " + product.getPath(), product.getSeller());
			assertNotNull("Error on seller : " + product.getPath(), product.getSeller().equals(Seller.LAPEYRE.name()));
			assertNotNull("Error on categorie seller : " + product.getPath(), product.getCategorieSeller());
			assertNotNull("Error on description : " + product.getPath(), product.getDescription());
			assertNotNull("Error on date : " + product.getPath(), product.getDate());
			assertNotNull("Error on title : " + product.getPath(), product.getTitle());
			assertNotNull("Error on unit : " + product.getPath(), product.getUnit());
			assertNotNull("Error on url : " + product.getPath(), product.getUrl());
		}
	}
}