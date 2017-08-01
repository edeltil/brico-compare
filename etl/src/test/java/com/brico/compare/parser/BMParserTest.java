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
public class BMParserTest {

	private Logger LOGGER = Logger.getLogger(this.getClass().getSimpleName());

	@Test
	public void testParserBM() throws IOException {
		BMParser parser = new BMParser("C:/_tmp/perso", "www.bricomarche.com/nos-produits");
		/*Product 1 */
		Product product1 = parser.parseHTML(getClass().getResource("/BM/product1_BM.html").getPath()).get();
		LOGGER.log(Level.INFO, product1.toString());
		Assert.assertEquals("Lot de 4 pieds reglables pour receveur de douche", product1.getTitle());
		Assert.assertEquals("Pieds réglables pour receveur de douche (lot de 4)", product1.getShortDescription());
		Assert.assertEquals("http://www.bricomarche.com/lot-de-4-pieds-reglables-pour-receveur-de-douche.html", product1.getUrl());
		Assert.assertEquals("http://www.bricomarche.com/media/catalog/product/cache/1/image/400x/9df78eab33525d08d6e5fb8d27136e95/3/3/3375537197248.jpg",
			product1.getImage());
		Assert.assertEquals(new Double(18.10), product1.getPrice());
		Assert.assertNull(product1.getOldPrice());
		Assert.assertEquals("unit", product1.getUnit());
		Assert.assertEquals(0, product1.getRate());
		Assert.assertTrue(product1.getDescription().contains("Mise en \u009Cuvre simple et précise"));
		Assert.assertTrue(product1.getDescription().contains("Résistant : supporte 450 Kg par pied"));
		Assert.assertTrue(product1.getDescription().contains("Grande plage de réglage : la rallonge permet d'atteindre u"));
		Assert.assertEquals("Bricolage - Plomberie - Evacuation de la baignoire", product1.getCategorieSeller());
		Assert.assertFalse(parser.parseHTML(getClass().getResource("/BM/product2_BM.html").getPath()).isPresent());
		Assert.assertFalse(parser.parseHTML(getClass().getResource("/BM/product3_BM.html").getPath()).isPresent());
		/*Product 4*/
		Product product4 = parser.parseHTML(getClass().getResource("/BM/product4_BM.html").getPath()).get();
		LOGGER.log(Level.INFO, product4.toString());
		Assert.assertEquals("Baignoire Balnéo Cocos 130x130cm", product4.getTitle());
		Assert.assertEquals("La baignoire Balnéo Cocos est équipée d'hydrojets ainsi que d'appuis-têtes de barres de soutien ainsi que de la chromothérapie.",
			product4.getShortDescription());
		Assert.assertEquals("http://www.bricomarche.com/baignoire-balneo-cocos-130x130cm.html", product4.getUrl());
		Assert.assertEquals("http://www.bricomarche.com/media/catalog/product/cache/1/image/400x/9df78eab33525d08d6e5fb8d27136e95/4/8/4895164800483_2_.jpg",
			product4.getImage());
		Assert.assertEquals(new Double(1449.99), product4.getPrice());
		Assert.assertNull(product4.getOldPrice());
		Assert.assertEquals("unit", product4.getUnit());
		Assert.assertEquals(0, product4.getRate());
		Assert.assertTrue(product4.getDescription()
			.contains("La baignoire Balnéo Cocos est équipée d'hydrojets ainsi que d'appuis-têtes de barres de soutien ainsi que de la chromothérapie."));
		Assert.assertTrue(product4.getDescription().contains("5 pieds réglables"));
		Assert.assertTrue(product4.getDescription().contains("4 buses orentables eau + air"));
		Assert.assertEquals("Aménagement intérieur - Salle de bains et WC - Baignoire", product4.getCategorieSeller());
		/*Product 5*/
		Product product5 = parser.parseHTML(getClass().getResource("/BM/product5_BM.html").getPath()).get();
		LOGGER.log(Level.INFO, product5.toString());
		Assert.assertEquals("Suspension diam. 25 cm GLOBO Galactica", product5.getTitle());
		Assert.assertEquals(
			"Suspension luminaire de style design en chrome et en verre en forme de boule. Il s'adapte parfaitement à votre décoration intérieure.",
			product5.getShortDescription());
		Assert.assertEquals("http://www.bricomarche.com/suspension-diam-25-cm-globo-galactica.html", product5.getUrl());
		Assert.assertEquals("http://www.bricomarche.com/media/catalog/product/cache/1/image/400x/9df78eab33525d08d6e5fb8d27136e95/9/0/9007371165827_3.jpg",
			product5.getImage());
		Assert.assertEquals(new Double(54.40), product5.getPrice());
		Assert.assertEquals(3, product5.getRate());
		Assert.assertNull(product5.getOldPrice());
		Assert.assertEquals("unit", product5.getUnit());
		Assert.assertTrue(product5.getDescription()
			.contains("Suspension luminaire de style design en chrome et en verre en forme de boule. Il s'adapte parfaitement à votre décoration intérieure."));
		Assert.assertTrue(product5.getDescription().contains("Diamètre : 25 cm"));
		Assert.assertTrue(product5.getDescription().contains("Hauteur : 160 cm"));
		Assert.assertEquals("Décoration - Luminaire - Luminaire intérieur - Lustre et suspension", product5.getCategorieSeller());

		/*Product 6*/
		Product product6 = parser.parseHTML(getClass().getResource("/BM/product6.html").getPath()).get();
		LOGGER.log(Level.INFO, product6.toString());
		Assert.assertEquals("Plaquette de parement MODULO pour extérieur/intérieur BELIZE GREY", product6.getTitle());
		Assert.assertEquals(
			"Les plaquettes de parement Belize Grey habilleront tout type d'intérieur et d'extérieur avec un aspect brique. Elles sont à base de ciment, la pose est rapide, elles décorent et rénovent vite. .",
			product6.getShortDescription());
		Assert.assertEquals("http://www.bricomarche.com/briquette-de-parement-pour-exterieur-interieur-belize-grey.html", product6.getUrl());
		Assert.assertEquals(
			"http://www.bricomarche.com/media/catalog/product/cache/1/image/400x/9df78eab33525d08d6e5fb8d27136e95/3/4/3414502014033_belize_grey_zoom.jpg",
			product6.getImage());
		Assert.assertEquals(new Double(35.9), product6.getPrice());
		Assert.assertEquals(0, product6.getRate());
		Assert.assertNull(product6.getOldPrice());
		Assert.assertEquals("le m²", product6.getUnit());
		Assert.assertTrue(product6.getDescription().contains(
			"Les plaquettes de parement Belize Grey habilleront tout type d'intérieur et d'extérieur avec un aspect brique. Elles sont à base de ciment, la pose est rapide, elles décorent et rénovent vite. . , Mur intérieur et extérieur , Matière base ciment , Couleur : gris/brun nuancé , Sans joint , Colis 1m2 : 21 kg , Dimensions : 22 x 6,5cm 11x6,5 cm , Epaisseur : 2 cm , Nombre par boite : 56 grandes, 14 petites"));
		Assert.assertEquals("Décoration - Revêtement mur et sol - Plaquettes de parement", product6.getCategorieSeller());
	}

	@Test
	public void testPriceParser() {
		BMParser parser = new BMParser("C:/_tmp/perso", "www.bricomarche.com/nos-produits");
		Assert.assertEquals(Double.valueOf("1449.99"), parser.getPrice("1 449,99 €"));
		Assert.assertEquals(Double.valueOf("1449.99"), parser.getPrice("1449,99 €"));
		Assert.assertEquals(Double.valueOf("449.99"), parser.getPrice("449,99 €"));
		Assert.assertEquals(Double.valueOf("9.99"), parser.getPrice("9,99 €"));
		Assert.assertEquals(Double.valueOf("35.90"), parser.getPrice("soit 35,90&nbsp;€/m²"));
	}

	@Test
	public void testParser() throws IOException {
		BMParser parser = new BMParser("C:/_tmp/perso", "www.bricomarche.com/nos-produits");
		List<Product> products = parser.parseDirectory();
		assertNotNull(products);
		for (Product product : products) {
			assertNotNull("Error on rate : " + product.getPath(), product.getRate());
			assertNotNull("Error on path : " + product.getPath(), product.getPath());
			assertNotNull("Error on image : " + product.getPath(), product.getImage());
			assertNotNull("Error on short description : " + product.getPath(), product.getShortDescription());
			assertNotNull("Error on seller : " + product.getPath(), product.getSeller());
			assertNotNull("Error on seller : " + product.getPath(), product.getSeller().equals(Seller.BM.name()));
			assertNotNull("Error on categorie seller : " + product.getPath(), product.getCategorieSeller());
			assertNotNull("Error on description : " + product.getPath(), product.getDescription());
			assertNotNull("Error on date : " + product.getPath(), product.getDate());
			assertNotNull("Error on price : " + product.getPath(), product.getPrice());
			assertNotNull("Error on title : " + product.getPath(), product.getTitle());
			assertNotNull("Error on unit : " + product.getPath(), product.getUnit());
			assertNotNull("Error on url : " + product.getPath(), product.getUrl());
		}
	}
}