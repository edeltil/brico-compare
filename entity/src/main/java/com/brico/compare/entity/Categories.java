package com.brico.compare.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Created by edeltil on 24/02/2017.
 */
@Service
@SuppressWarnings("all")
public class Categories {
	private static final List<Category> LIST_CATEGORIES = new ArrayList<>();

	static {
		LIST_CATEGORIES.add(new Category("Chauffage - Chauffage au bois - Cuisinière", new String[] { "chauffage", "bois", "cuisinière" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Chauffage au bois - Foyer et insert", new String[] { "chauffage", "bois", "foyer", "insert" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Chauffage au bois - Poêle à bois", new String[] { "chauffage", "bois", "poêle" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Chauffage au bois - Accessoire", new String[] { "chauffage", "bois", "accessoire" }));
		LIST_CATEGORIES.add(
			new Category("Chauffage - Chauffage au bois - Poêle à granulés et à pellets", new String[] { "chauffage", "bois", "poêle", "granulé", "pellets" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Chauffage au bois - Conduit et raccord", new String[] { "chauffage", "bois", "conduit", "raccord" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Chauffage au bois - Combustible", new String[] { "chauffage", "bois", "combustible" }));
		LIST_CATEGORIES
			.add(new Category("Chauffage - Chauffage d'appoint - Radiateur soufflant", new String[] { "chauffage", "appoint", "radiateur", "soufflant" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Chauffage d'appoint - Accessoire", new String[] { "chauffage", "appoint", "accessoire" }));
		LIST_CATEGORIES.add(
			new Category("Chauffage - Chauffage d'appoint - Radiateur bain d'huile", new String[] { "chauffage", "appoint", "radiateur", "bain", "huile" }));
		LIST_CATEGORIES
			.add(new Category("Chauffage - Chauffage d'appoint - Radiateur céramique", new String[] { "chauffage", "appoint", "radiateur", "céramique" }));
		LIST_CATEGORIES
			.add(new Category("Chauffage - Chauffage d'appoint - Radiateur spécifique", new String[] { "chauffage", "appoint", "radiateur", "spécifique" }));
		LIST_CATEGORIES
			.add(new Category("Chauffage - Chauffage d'appoint - Convecteur mobile", new String[] { "chauffage", "appoint", "convecteur", "mobile" }));
		LIST_CATEGORIES
			.add(new Category("Chauffage - Chauffage d'appoint - Panneau rayonnant", new String[] { "chauffage", "appoint", "panneau", "rayonnant" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Chauffage d'appoint - Poêle à pétrole", new String[] { "chauffage", "appoint", "poêle", "pétrole" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Livre", new String[] { "chauffage", "livre" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Thermostat et programmateur de chauffage", new String[] { "chauffage", "thermostat", "programmateur" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Climatiseur", new String[] { "chauffage", "climatiseur" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Pompe à chaleur", new String[] { "chauffage", "pompe", "chaleur" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Climatiseur - Climatiseur mobile", new String[] { "climatiseur", "mobile", "chauffage" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Climatiseur - Accessoire", new String[] { "chauffage", "climatiseur", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Raccordement au gaz - Accessoire", new String[] { "chauffage", "raccordement", "gaz", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Raccordement au gaz - Flexible", new String[] { "chauffage", "raccordement", "gaz", "flexible" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Radiateur électrique - Rayonnant", new String[] { "chauffage", "radiateur", "électrique", "rayonnant" }));
		LIST_CATEGORIES
			.add(new Category("Chauffage - Radiateur électrique - Convecteur", new String[] { "chauffage", "radiateur", "électrique", "convecteur" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Radiateur électrique - Inertie", new String[] { "chauffage", "radiateur", "électrique", "inertie" }));
		LIST_CATEGORIES
			.add(new Category("Chauffage - Radiateur électrique - Accessoire", new String[] { "chauffage", "radiateur", "électrique", "accessoire" }));
		LIST_CATEGORIES.add(
			new Category("Chauffage - Radiateur électrique - Sèche-serviettes", new String[] { "chauffage", "radiateur", "électrique", "sèche", "serviette" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Radiateur à eau chaude", new String[] { "chauffage", "radiateur", "eau", "chaude" }));
		LIST_CATEGORIES
			.add(new Category("Chauffage - Radiateur à eau chaude - Accessoire", new String[] { "chauffage", "radiateur", "eau", "chaude", "accessoire" }));
		LIST_CATEGORIES
			.add(new Category("Chauffage - Radiateur à eau chaude - Robinet", new String[] { "chauffage", "radiateur", "eau", "chaude", "robinet" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Radiateur à eau chaude - Sèche-serviettes",
			new String[] { "chauffage", "radiateur", "eau", "chaude", "sèche", "serviette" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Radiateur chauffage centrale", new String[] { "chauffage", "chauffage", "centrale" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Plancher chauffant - Accessoire", new String[] { "chauffage", "plancher", "chauffant", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Plancher chauffant", new String[] { "chauffage", "plancher", "chauffant" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Combustible et allumage", new String[] { "chauffage", "combustible", "allumage" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Production d'énergie et de chauffage renouvelable - Chauffe-eau thermodynamique",
			new String[] { "chauffage", "production", "renouvelable", "chauffe", "eau" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Aérateur - Thermomètre", new String[] { "chauffage", "aérateur", "thermomètre" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Aérateur - VMC", new String[] { "chauffage", "aérateur", "vmc" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Aérateur", new String[] { "chauffage", "aérateur" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Aérateur - Conduit", new String[] { "chauffage", "aérateur", "conduit" }));
		LIST_CATEGORIES.add(new Category("Chauffage - Aérateur - Accessoire", new String[] { "chauffage", "aérateur", "accessoire" }));

		LIST_CATEGORIES.add(new Category("Plomberie - Adoucisseur - Adoucisseur d'eau", new String[] { "plomberie", "adoucisseur", "eau" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Adoucisseur - Adoucisseur d'eau - Sel", new String[] { "plomberie", "adoucisseur", "eau", "sel" }));
		LIST_CATEGORIES
			.add(new Category("Plomberie - Adoucisseur - Adoucisseur d'eau - Eau de boisson", new String[] { "plomberie", "adoucisseur", "eau", "boisson" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Adoucisseur - Adoucisseur d'eau - Eau de boisson - Accessoire",
			new String[] { "plomberie", "adoucisseur", "eau", "boisson", "accessoire" }));
		LIST_CATEGORIES
			.add(new Category("Plomberie - Adoucisseur - Adoucisseur d'eau - Accessoire", new String[] { "plomberie", "adoucisseur", "eau", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Adoucisseur - Station et filtre - Anti-calcaire/anti-tartre - Cartouche",
			new String[] { "plomberie", "adoucisseur", "filtre", "anti", "calcaire", "tartre", "cartouche" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Adoucisseur - Station et filtre - Anti-calcaire/anti-tartre - Accessoire",
			new String[] { "plomberie", "adoucisseur", "filtre", "anti", "calcaire", "tartre", "accessoire" }));
		LIST_CATEGORIES
			.add(new Category("Plomberie - Adoucisseur - Station et filtre - Eau de pluie", new String[] { "plomberie", "adoucisseur", "filtre", "pluie" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Adoucisseur - Station et filtre - Filtre réfrigérateur américain",
			new String[] { "plomberie", "adoucisseur", "filtre", "réfrigérateur", "américain" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Robinet - Accessoire", new String[] { "plomberie", "robinet", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Robinet - Flexible et douchette", new String[] { "plomberie", "robinet", "flexible", "douchette" }));
		LIST_CATEGORIES
			.add(new Category("Plomberie - Robinet - Mousseur et brise-jet robinet", new String[] { "plomberie", "robinet", "mousseur", "brise-jet" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Robinet - Raccord", new String[] { "plomberie", "robinet", "raccord" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Robinet - Robinet à entraxe spécial", new String[] { "plomberie", "robinet", "entraxe" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Robinet - Bec et raccord bec", new String[] { "plomberie", "robinet", "bec", "raccord" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Robinet - Colonnette", new String[] { "plomberie", "robinet", "colonnette" }));
		LIST_CATEGORIES.add(
			new Category("Plomberie - Robinet - Tête de robinet, cartouche et croisillon", new String[] { "plomberie", "robinet", "cartouche", "croisillon" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Chauffe-eau et ballon d'eau chaude - Electrique - Instantanée",
			new String[] { "plomberie", "chauffe", "eau", "ballon", "electrique", "instantanée" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Chauffe-eau et ballon d'eau chaude - Electrique",
			new String[] { "plomberie", "chauffe", "eau", "ballon", "electrique" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Chauffe-eau et ballon d'eau chaude - Electrique - Accessoire",
			new String[] { "plomberie", "chauffe", "eau", "ballon", "electrique", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Alimentation en eau - Lave-linge/vaisselle",
			new String[] { "plomberie", "alimentation", "eau", "lave", "linge", "vaisselle" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Alimentation en eau - Etanchéité", new String[] { "plomberie", "alimentation", "eau", "etanchéité" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Alimentation en eau - Raccord", new String[] { "plomberie", "alimentation", "eau", "raccord" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Alimentation en eau - Flexible", new String[] { "plomberie", "alimentation", "eau", "flexible" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Alimentation en eau - Platine de fixation", new String[] { "plomberie", "alimentation", "fixation" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Alimentation en eau - Joint", new String[] { "plomberie", "alimentation", "eau", "joint" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Alimentation en eau - Clapet", new String[] { "plomberie", "alimentation", "eau", "clapet" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Alimentation en eau - Tube", new String[] { "plomberie", "alimentation", "eau", "tube" }));
		LIST_CATEGORIES.add(
			new Category("Plomberie - Evacuation des eaux usées - Vidage - Douche", new String[] { "plomberie", "evacuation", "eau", "vidage", "douche" }));
		LIST_CATEGORIES.add(
			new Category("Plomberie - Evacuation des eaux usées - Vidage - Lavabo", new String[] { "plomberie", "evacuation", "eau", "vidage", "lavabo" }));
		LIST_CATEGORIES.add(new Category("Plomberie - Evacuation des eaux usées - Vidage - Accessoire",
			new String[] { "plomberie", "evacuation", "eau", "vidage", "accessoire" }));
		LIST_CATEGORIES.add(
			new Category("Plomberie - Evacuation des eaux usées - Trappe de visite", new String[] { "plomberie", "evacuation", "eau", "trappe", "visite" }));
		LIST_CATEGORIES.add(new Category("Plomberie - WC - Chasse d'eau - Robinet flotteur", new String[] { "plomberie", "wc", "chasse", "eau", "flotteur" }));

		LIST_CATEGORIES.add(new Category("Cuisine - Meuble", new String[] { "cuisine", "meuble" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Meuble - Equipement", new String[] { "cuisine", "meuble", "equipement" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Meuble - Intérieur", new String[] { "cuisine", "meuble", "intérieur" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Meuble - Accessoire", new String[] { "cuisine", "meuble", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Meuble - Poignées et boutons", new String[] { "cuisine", "meuble", "poignée", "bouton" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Carrelage", new String[] { "cuisine", "carrelage" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Plan de travail - Accessoire", new String[] { "cuisine", "plan", "travail", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Plan de travail", new String[] { "cuisine", "plan", "travail" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Crédence", new String[] { "cuisine", "crédence" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Crédence - Accessoire", new String[] { "cuisine", "crédence", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Rangement - Accessoire", new String[] { "cuisine", "rangement", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Rangement - Range-couverts", new String[] { "cuisine", "rangement", "range", "couvert" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Rangement - Tapis fond de tiroir", new String[] { "cuisine", "rangement", "tapis", "tiroir" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Evier", new String[] { "cuisine", "evier" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Evier - Accessoire", new String[] { "cuisine", "evier", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Evier - Robinet", new String[] { "cuisine", "evier", "robinet" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Kitchenette", new String[] { "cuisine", "kitchenette" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Eclairage", new String[] { "cuisine", "eclairage" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Etagère", new String[] { "cuisine", "etagère" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Poubelle", new String[] { "cuisine", "poubelle" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Livres", new String[] { "cuisine", "livre" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Chaises", new String[] { "cuisine", "chaise" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Chaises - Tabouret", new String[] { "cuisine", "chaise", "tabouret" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Electroménager - Hotte", new String[] { "cuisine", "electroménager", "hotte" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Electroménager - Four micro-ondes", new String[] { "cuisine", "electroménager", "four", "micro-onde" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Electroménager - Réfrigérateur", new String[] { "cuisine", "electroménager", "réfrigérateur" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Electroménager - Congélateur", new String[] { "cuisine", "electroménager", "congélateur" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Electroménager - Lave-linge", new String[] { "cuisine", "electroménager", "lave-linge" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Electroménager - Four", new String[] { "cuisine", "electroménager", "four" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Electroménager - Four - encastrable", new String[] { "cuisine", "electroménager", "four", "encastrable" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Electroménager - Lave-vaisselle", new String[] { "cuisine", "electroménager", "lave", "vaisselle" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Electroménager - Plaque de cuisson", new String[] { "cuisine", "electroménager", "plaque", "cuisson" }));
		LIST_CATEGORIES.add(new Category("Cuisine - Electroménager - Plaque de cuisson - Vitrocéramique",
			new String[] { "cuisine", "electroménager", "cuisson", "vitrocéramique" }));

		LIST_CATEGORIES.add(new Category("Décoration - Coussin - Chaise", new String[] { "décoration", "coussin", "chaise" }));
		LIST_CATEGORIES.add(new Category("Décoration - Coussin - Décoratif", new String[] { "décoration", "coussin", "décoratif" }));
		LIST_CATEGORIES.add(new Category("Décoration - Coussin - Sol", new String[] { "décoration", "coussin", "sol" }));
		LIST_CATEGORIES.add(new Category("Décoration - Coussin - Housse", new String[] { "décoration", "coussin", "housse" }));
		LIST_CATEGORIES.add(new Category("Décoration - Coussin - Plaid", new String[] { "décoration", "coussin", "plaid" }));
		LIST_CATEGORIES.add(new Category("Décoration - Coussin", new String[] { "décoration", "coussin" }));
		LIST_CATEGORIES.add(new Category("Décoration - Rideau", new String[] { "décoration", "rideau" }));
		LIST_CATEGORIES
			.add(new Category("Décoration - Rideau - Tringle - Sans perçage", new String[] { "décoration", "rideau", "tringle", "sans", "perçage" }));
		LIST_CATEGORIES.add(new Category("Décoration - Rideau - Tringle - Barre de vitrage", new String[] { "décoration", "rideau", "tringle" }));
		LIST_CATEGORIES.add(new Category("Décoration - Rideau - Tringle - Lucarne", new String[] { "décoration", "rideau", "tringle", "lucarne" }));
		LIST_CATEGORIES.add(new Category("Décoration - Rideau - Brise-bise", new String[] { "décoration", "rideau", "brise-bise" }));
		LIST_CATEGORIES.add(new Category("Décoration - Rideau - Vitrage", new String[] { "décoration", "rideau", "vitrage" }));
		LIST_CATEGORIES
			.add(new Category("Décoration - Rideau - Tringle à rideau - A composer", new String[] { "décoration", "rideau", "tringle", "composer" }));
		LIST_CATEGORIES.add(new Category("Décoration - Rideau - Tringle à rideau - A composer - Accessoire",
			new String[] { "décoration", "rideau", "tringle", "composer", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Décoration - Rideau - Tringle à rideau - A composer - Support",
			new String[] { "décoration", "rideau", "tringle", "composer", "support" }));
		LIST_CATEGORIES.add(new Category("Décoration - Rideau - Tringle à rideau - Kit", new String[] { "décoration", "rideau", "tringle", "kit" }));
		LIST_CATEGORIES.add(new Category("Décoration - Rideau - Oeillet", new String[] { "décoration", "rideau", "oeillet" }));
		LIST_CATEGORIES.add(new Category("Décoration - Rideau - Voilage", new String[] { "décoration", "rideau", "voilage" }));
		LIST_CATEGORIES.add(new Category("Décoration - Rideau - Accessoire", new String[] { "décoration", "rideau", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Décoration - Store - Accessoires", new String[] { "décoration", "store", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Décoration - Store - Panneaux japonais", new String[] { "décoration", "store", "panneau", "japonais" }));
		LIST_CATEGORIES.add(new Category("Décoration - Store - Store enrouleur", new String[] { "décoration", "store", "enrouleur" }));
		LIST_CATEGORIES.add(new Category("Décoration - Livre", new String[] { "décoration", "livre" }));
		LIST_CATEGORIES.add(new Category("Décoration - Papier peint - Colle", new String[] { "décoration", "papier", "peint", "colle" }));
		LIST_CATEGORIES.add(new Category("Décoration - Papier peint - Décolleur", new String[] { "décoration", "papier", "peint", "décolleur" }));
		LIST_CATEGORIES.add(new Category("Décoration - Papier peint", new String[] { "décoration", "papier", "peint" }));
		LIST_CATEGORIES.add(new Category("Décoration - Papier peint - Frise", new String[] { "décoration", "papier", "peint", "frise" }));
		LIST_CATEGORIES.add(new Category("Décoration - Papier peint - Fibre de verre", new String[] { "décoration", "papier", "peint", "fibre", "verre" }));
		LIST_CATEGORIES.add(
			new Category("Décoration - Stickers, affiche et toile - Affiche, poster", new String[] { "décoration", "sticker", "affiche", "toile", "poster" }));
		LIST_CATEGORIES
			.add(new Category("Décoration - Stickers, affiche et toile - Cadre", new String[] { "décoration", "sticker", "affiche", "toile", "cadre" }));
		LIST_CATEGORIES
			.add(new Category("Décoration - Stickers, affiche et toile - Lettre", new String[] { "décoration", "sticker", "affiche", "toile", "lettre" }));
		LIST_CATEGORIES
			.add(new Category("Décoration - Stickers, affiche et toile - Miroir", new String[] { "décoration", "sticker", "affiche", "toile", "miroir" }));
		LIST_CATEGORIES.add(new Category("Décoration - Stickers, affiche et toile - Sticker", new String[] { "décoration", "sticker", "affiche", "toile" }));
		LIST_CATEGORIES.add(new Category("Décoration - Moulure - Dalle de plafond", new String[] { "décoration", "moulure", "dalle", "plafond" }));

		//Eclairage
		LIST_CATEGORIES.add(new Category("Eclairage - Ampoule LED", new String[] { "eclairage", "ampoule", "led" }));
		LIST_CATEGORIES.add(new Category("Eclairage - Ampoule LED - Tube", new String[] { "eclairage", "ampoule", "led", "tube" }));
		LIST_CATEGORIES.add(new Category("Eclairage - Extérieur", new String[] { "eclairage", "extérieur" }));
		LIST_CATEGORIES.add(new Category("Eclairage - Extérieur - Lampadaire", new String[] { "eclairage", "extérieur", "lampadaire" }));
		LIST_CATEGORIES.add(new Category("Eclairage - Extérieur - Solaire", new String[] { "eclairage", "extérieur", "solaire" }));
		LIST_CATEGORIES.add(new Category("Eclairage - Extérieur - Terrasse - Borne", new String[] { "eclairage", "extérieur", "terrasse", "borne" }));
		LIST_CATEGORIES.add(new Category("Eclairage - Extérieur - Terrasse - Suspension", new String[] { "eclairage", "extérieur", "terrasse", "suspension" }));
		LIST_CATEGORIES
			.add(new Category("Eclairage - Extérieur - Terrasse - Spot encastré", new String[] { "eclairage", "extérieur", "terrasse", "spot", "encastré" }));
		LIST_CATEGORIES.add(new Category("Eclairage - Extérieur - Terrasse - Applique", new String[] { "eclairage", "extérieur", "terrasse", "applique" }));
		LIST_CATEGORIES.add(new Category("Eclairage - Intérieur - Salle de bain", new String[] { "eclairage", "intérieur", "salle", "bain" }));
		LIST_CATEGORIES.add(new Category("Eclairage - Intérieur - Applique murale", new String[] { "eclairage", "intérieur", "applique" }));
		LIST_CATEGORIES.add(new Category("Eclairage - Intérieur - Accessoire", new String[] { "eclairage", "intérieur", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Eclairage - Intérieur - Cuisine", new String[] { "eclairage", "intérieur", "cuisine" }));
		LIST_CATEGORIES.add(new Category("Eclairage - Intérieur - Spot", new String[] { "eclairage", "intérieur", "spot" }));
		LIST_CATEGORIES.add(new Category("Eclairage - Intérieur - Spot - Encastrable", new String[] { "eclairage", "intérieur", "spot", "encastrable" }));
		LIST_CATEGORIES.add(new Category("Eclairage - Intérieur - Plafonnier", new String[] { "eclairage", "intérieur", "plafonnier" }));
		LIST_CATEGORIES.add(new Category("Eclairage - Intérieur - Dressing", new String[] { "eclairage", "intérieur", "dressing" }));
		LIST_CATEGORIES.add(new Category("Eclairage - Intérieur - Lustre", new String[] { "eclairage", "intérieur", "lustre" }));
		LIST_CATEGORIES.add(new Category("Eclairage - Intérieur - Suspension", new String[] { "eclairage", "intérieur", "suspension" }));
		LIST_CATEGORIES.add(new Category("Eclairage - Intérieur - Lampe de chevet", new String[] { "eclairage", "intérieur", "lampe", "chevet" }));
		LIST_CATEGORIES.add(new Category("Eclairage - Intérieur - Lampe de salon", new String[] { "eclairage", "intérieur", "lampe", "salon" }));
		LIST_CATEGORIES.add(new Category("Eclairage - Intérieur - Pied de lampe", new String[] { "eclairage", "intérieur", "lampe", "pied" }));

		//Electricité
		LIST_CATEGORIES.add(new Category("Electricité - Câbles - Fils", new String[] { "electricité", "câble", "fil" }));
		LIST_CATEGORIES.add(new Category("Electricité - Câbles - Gaîne ICTA", new String[] { "electricité", "câble", "gaîne", "ICTA" }));
		LIST_CATEGORIES.add(new Category("Electricité - Câbles - Fixation", new String[] { "electricité", "câble", "fixation" }));
		LIST_CATEGORIES.add(new Category("Electricité - Câbles - Gaîne préfilée", new String[] { "electricité", "câble", "gaîne", "préfilée" }));
		LIST_CATEGORIES.add(new Category("Electricité - Câbles - IRL", new String[] { "electricité", "câble", "irl" }));
		LIST_CATEGORIES.add(new Category("Electricité - Moulure", new String[] { "electricité", "moulure" }));
		LIST_CATEGORIES.add(new Category("Electricité - Plinthe", new String[] { "electricité", "plinthe" }));
		LIST_CATEGORIES.add(new Category("Electricité - Goulotte", new String[] { "electricité", "goulotte" }));
		LIST_CATEGORIES.add(new Category("Electricité - Livre", new String[] { "electricité", "livre" }));
		LIST_CATEGORIES.add(new Category("Electricité - Domotique - Appareil connecté", new String[] { "electricité", "domotique", "appareil", "connecté" }));
		LIST_CATEGORIES.add(new Category("Electricité - Domotique - Box et kit", new String[] { "electricité", "domotique", "box", "kit" }));
		LIST_CATEGORIES.add(new Category("Electricité - Domotique - Lumière", new String[] { "electricité", "domotique", "lumière" }));
		LIST_CATEGORIES.add(new Category("Electricité - Domotique - Accessoire", new String[] { "electricité", "domotique", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Electricité - Domotique - Porte de garage", new String[] { "electricité", "domotique", "porte", "garage" }));
		LIST_CATEGORIES.add(new Category("Electricité - Domotique - Chauffage", new String[] { "electricité", "domotique", "chauffage" }));
		LIST_CATEGORIES.add(new Category("Electricité - Tableau - Autres", new String[] { "electricité", "tableau", "autres" }));
		LIST_CATEGORIES.add(new Category("Electricité - Tableau - Disjoncteur", new String[] { "electricité", "tableau", "disjoncteur" }));
		LIST_CATEGORIES
			.add(new Category("Electricité - Tableau - Disjoncteur - Différenciel", new String[] { "electricité", "tableau", "disjoncteur", "différenciel" }));
		LIST_CATEGORIES.add(new Category("Electricité - Tableau - Coupe-circuit", new String[] { "electricité", "tableau", "coupe", "circuit" }));
		LIST_CATEGORIES.add(new Category("Electricité - Tableau - Para-foudre", new String[] { "electricité", "tableau", "para-foudre" }));
		LIST_CATEGORIES.add(new Category("Electricité - Tableau - Bornier / peigne", new String[] { "electricité", "tableau", "bornier", "peigne" }));
		LIST_CATEGORIES.add(new Category("Electricité - Tableau - Nu", new String[] { "electricité", "tableau", "nu" }));
		LIST_CATEGORIES.add(new Category("Electricité - Tableau - GTL", new String[] { "electricité", "tableau", "gtl" }));
		LIST_CATEGORIES.add(new Category("Electricité - Tableau - Pré-équipé", new String[] { "electricité", "tableau", "pré-équipé" }));
		LIST_CATEGORIES.add(new Category("Electricité - Alarme maison - Sans fil", new String[] { "electricité", "alarme", "sans", "fil" }));
		LIST_CATEGORIES.add(new Category("Electricité - Alarme maison - Caméra", new String[] { "electricité", "alarme", "caméra" }));
		LIST_CATEGORIES.add(new Category("Electricité - Alarme maison - Accessoire", new String[] { "electricité", "alarme", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Electricité - Alarme maison - Détecteur de mouvement et de lumière",
			new String[] { "electricité", "alarme", "détecteur", "mouvement", "lumière" }));
		LIST_CATEGORIES.add(new Category("Electricité - Alarme maison - Détecteur de fumée, monoxyde de carbone et gaz",
			new String[] { "electricité", "alarme", "détecteur", "fumée", "monoxyde", "carbone", "gaz" }));
		LIST_CATEGORIES.add(new Category("Electricité - Antenne - Accessoire", new String[] { "electricité", "antenne", "accessoire" }));
		LIST_CATEGORIES.add(
			new Category("Electricité - Antenne - Connectique audio et vidéo", new String[] { "electricité", "antenne", "connectique", "audio", "vidéo" }));
		LIST_CATEGORIES.add(new Category("Electricité - Antenne - Satellite", new String[] { "electricité", "antenne", "satellite" }));
		LIST_CATEGORIES.add(new Category("Electricité - Antenne - Alimentation", new String[] { "electricité", "antenne", "alimentation" }));
		LIST_CATEGORIES.add(new Category("Electricité - Antenne - Décodeur TNT", new String[] { "electricité", "antenne", "décodeur", "tnt" }));
		LIST_CATEGORIES
			.add(new Category("Electricité - Antenne - Télécommande universelle", new String[] { "electricité", "antenne", "télécommande", "universelle" }));
		LIST_CATEGORIES.add(new Category("Electricité - Antenne - Décodeur satellite", new String[] { "electricité", "antenne", "décodeur", "satellite" }));
		LIST_CATEGORIES.add(new Category("Electricité - Antenne - CPL", new String[] { "electricité", "antenne", "cpl" }));
		LIST_CATEGORIES.add(new Category("Electricité - Interrupteur / Prise - Adaptateur de voyage",
			new String[] { "electricité", "interrupteur", "prise", "adaptateur", "voyage" }));
		LIST_CATEGORIES
			.add(new Category("Electricité - Interrupteur / Prise - Encastrable", new String[] { "electricité", "interrupteur", "prise", "encastrable" }));
		LIST_CATEGORIES
			.add(new Category("Electricité - Interrupteur / Prise - Composable", new String[] { "electricité", "interrupteur", "prise", "composable" }));
		LIST_CATEGORIES
			.add(new Category("Electricité - Interrupteur / Prise - Multiprise", new String[] { "electricité", "interrupteur", "prise", "multiprise" }));
		LIST_CATEGORIES.add(new Category("Electricité - Interrupteur / Prise - Etanche", new String[] { "electricité", "interrupteur", "prise", "etanche" }));
		LIST_CATEGORIES.add(new Category("Electricité - Motorisation - Accessoire", new String[] { "electricité", "motorisation", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Electricité - Motorisation - Portail", new String[] { "electricité", "motorisation", "portail" }));
		LIST_CATEGORIES.add(new Category("Electricité - Motorisation - Volet", new String[] { "electricité", "motorisation", "volet" }));
		LIST_CATEGORIES.add(new Category("Electricité - Motorisation - Interphone", new String[] { "electricité", "motorisation", "interphone" }));
		LIST_CATEGORIES.add(new Category("Electricité - Motorisation - Garage", new String[] { "electricité", "motorisation", "garage" }));
		LIST_CATEGORIES.add(new Category("Electricité - Motorisation - Visiophone", new String[] { "electricité", "motorisation", "visiophone" }));
		LIST_CATEGORIES.add(new Category("Electricité - Motorisation - SOMFY", new String[] { "electricité", "motorisation", "somfy" }));
		LIST_CATEGORIES
			.add(new Category("Electricité - Motorisation - SOMFY - Accessoire", new String[] { "electricité", "motorisation", "somfy", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Electricité - Motorisation - SOMFY - Portail", new String[] { "electricité", "motorisation", "somfy", "portail" }));
		LIST_CATEGORIES.add(new Category("Electricité - Motorisation - SOMFY - Garage", new String[] { "electricité", "motorisation", "somfy", "garage" }));
		LIST_CATEGORIES.add(new Category("Electricité - Rallonge - Boite de dérivation - Domino borne",
			new String[] { "electricité", "rallonge", "boite", "dérivation", "domino", "borne" }));
		LIST_CATEGORIES.add(new Category("Electricité - Rallonge - Boite de dérivation - Accessoire",
			new String[] { "electricité", "rallonge", "boite", "dérivation", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Electricité - Rallonge - Boite de dérivation", new String[] { "electricité", "rallonge", "boite", "dérivation" }));
		LIST_CATEGORIES.add(new Category("Electricité - Rallonge - Enrouleur", new String[] { "electricité", "rallonge", "enrouleur" }));
		LIST_CATEGORIES.add(new Category("Electricité - Rallonge - Appareil de mesure", new String[] { "electricité", "rallonge", "appareil", "mesure" }));
		LIST_CATEGORIES.add(new Category("Electricité - Rallonge", new String[] { "electricité", "rallonge" }));
		LIST_CATEGORIES.add(new Category("Electricité - Lampe torche - Douille", new String[] { "electricité", "lampe", "torche", "douille" }));
		LIST_CATEGORIES.add(new Category("Electricité - Lampe torche - Chargeur", new String[] { "electricité", "lampe", "torche", "chargeur" }));
		LIST_CATEGORIES.add(new Category("Electricité - Lampe torche - Pile", new String[] { "electricité", "lampe", "torche", "pile" }));
		LIST_CATEGORIES.add(new Category("Electricité - Lampe torche", new String[] { "electricité", "lampe", "torche" }));
		LIST_CATEGORIES.add(new Category("Electricité - Lampe torche - Variateur", new String[] { "electricité", "lampe", "torche", "variateur" }));

		//Jardin
		LIST_CATEGORIES.add(new Category("Jardin - Accessoire", new String[] { "jardin", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Jardin - Balustrades", new String[] { "jardin", "balustrade" }));
		LIST_CATEGORIES.add(new Category("Jardin - Terrasse - Produits", new String[] { "terrasse", "produit" }));
		LIST_CATEGORIES.add(new Category("Jardin - Terrasse - Carrelage", new String[] { "terrasse", "carrelage" }));
		LIST_CATEGORIES.add(new Category("Jardin - Terrasse - Dalle", new String[] { "terrasse", "dalle" }));
		LIST_CATEGORIES.add(new Category("Jardin - Terrasse - Lame", new String[] { "terrasse", "lame" }));
		LIST_CATEGORIES.add(new Category("Jardin - Terrasse - Bordure", new String[] { "terrasse", "bordure" }));
		LIST_CATEGORIES.add(new Category("Jardin - Terrasse - Composite", new String[] { "terrasse", "composite" }));
		LIST_CATEGORIES.add(new Category("Jardin - Terrasse - Pose et entretien", new String[] { "terrasse", "pose", "entretien" }));
		LIST_CATEGORIES.add(new Category("Jardin - Terrasse - Bois - Pose et entretien", new String[] { "terrasse", "bois", "pose", "entretien" }));
		LIST_CATEGORIES.add(new Category("Jardin - Portail - Décoration", new String[] { "portail", "décoration" }));
		LIST_CATEGORIES.add(new Category("Jardin - Portail - Battants", new String[] { "portail", "battant" }));
		LIST_CATEGORIES.add(new Category("Jardin - Portail - Battants - Aluminium", new String[] { "portail", "battant", "aluminium" }));
		LIST_CATEGORIES.add(new Category("Jardin - Portail - Battants - Bois", new String[] { "portail", "portail", "battant", "bois" }));
		LIST_CATEGORIES.add(new Category("Jardin - Portail - Battants - Fer", new String[] { "portail", "portail", "battant", "fer" }));
		LIST_CATEGORIES.add(new Category("Jardin - Portail - Battants - PVC", new String[] { "portail", "portail", "battant", "pvc" }));
		LIST_CATEGORIES.add(new Category("Jardin - Portail - Portillon", new String[] { "portail", "portillon" }));
		LIST_CATEGORIES.add(new Category("Jardin - Portail - Portillon - Aluminium", new String[] { "portail", "portillon", "aluminium" }));
		LIST_CATEGORIES.add(new Category("Jardin - Portail - Coulissant", new String[] { "portail", "portail", "coulissant" }));
		LIST_CATEGORIES.add(new Category("Jardin - Portail - Coulissant - Aluminium", new String[] { "portail", "portail", "coulissant", "aluminium" }));
		LIST_CATEGORIES.add(new Category("Jardin - Store - Banne", new String[] { "store", "banne" }));
		LIST_CATEGORIES.add(new Category("Jardin - Parasol", new String[] { "parasol" }));
		LIST_CATEGORIES.add(new Category("Jardin - Parasol - Accessoire", new String[] { "parasol", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Jardin - Escalier", new String[] { "jardin", "escalier" }));
		LIST_CATEGORIES.add(new Category("Jardin - Tonnelle", new String[] { "tonnelle" }));
		LIST_CATEGORIES.add(new Category("Jardin - Tonnelle - Voile d'ombrage", new String[] { "tonnelle", "voile", "ombrage" }));
		LIST_CATEGORIES.add(new Category("Jardin - Toit terrasse", new String[] { "toit", "terrasse" }));
		LIST_CATEGORIES.add(new Category("Jardin - Clôture", new String[] { "clôture" }));
		LIST_CATEGORIES.add(new Category("Jardin - Clôture - A composer", new String[] { "clôture", "composer" }));
		LIST_CATEGORIES.add(new Category("Jardin - Clôture - Brise vue", new String[] { "clôture", "brise", "vue" }));
		LIST_CATEGORIES.add(new Category("Jardin - Clôture - Brise vent", new String[] { "clôture", "brise", "vent" }));
		LIST_CATEGORIES.add(new Category("Jardin - Clôture - Canisse", new String[] { "clôture", "canisse" }));
		LIST_CATEGORIES.add(new Category("Jardin - Clôture - Occultation", new String[] { "clôture", "occultation" }));
		LIST_CATEGORIES.add(new Category("Jardin - Clôture - Panneaux", new String[] { "clôture", "panneau" }));
		LIST_CATEGORIES.add(new Category("Jardin - Clôture - Panneaux - Bois", new String[] { "clôture", "panneau", "bois" }));
		LIST_CATEGORIES.add(new Category("Jardin - Clôture - Travée", new String[] { "clôture", "travée" }));
		LIST_CATEGORIES.add(new Category("Jardin - Clôture - Poteau", new String[] { "clôture", "poteau" }));
		LIST_CATEGORIES.add(new Category("Jardin - Clôture - Grillage", new String[] { "clôture", "grillage" }));
		LIST_CATEGORIES.add(new Category("Jardin - Clôture - Grillage - Rigide", new String[] { "clôture", "grillage", "rigide" }));
		LIST_CATEGORIES.add(new Category("Jardin - Clôture - Grillage - Animaux", new String[] { "clôture", "grillage", "animaux" }));
		LIST_CATEGORIES.add(new Category("Jardin - Abri", new String[] { "jardin", "abri" }));
		LIST_CATEGORIES.add(new Category("Jardin - Livre", new String[] { "jardin", "livre" }));
		LIST_CATEGORIES.add(new Category("Jardin - Abri - Accessoire", new String[] { "abri", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Jardin - Abri - Kiosque", new String[] { "abri", "kiosque" }));
		LIST_CATEGORIES.add(new Category("Jardin - Abri - Pergola", new String[] { "abri", "pergola" }));
		LIST_CATEGORIES.add(new Category("Jardin - Abri - Treillage", new String[] { "abri", "treillage" }));
		LIST_CATEGORIES.add(new Category("Jardin - Abri - Rangement", new String[] { "abri", "rangement" }));
		LIST_CATEGORIES.add(new Category("Jardin - Abri - Abri de jardin", new String[] { "abri", "abri de jardin" }));
		LIST_CATEGORIES.add(new Category("Jardin - Abri - Coffre de jardin", new String[] { "abri", "coffre" }));
		LIST_CATEGORIES.add(new Category("Jardin - Abri - Garage", new String[] { "abri", "garage" }));
		LIST_CATEGORIES.add(new Category("Jardin - Abri - Carport", new String[] { "abri", "carport" }));
		LIST_CATEGORIES.add(new Category("Jardin - Barbecue - Accessoire", new String[] { "barbecue", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Jardin - Barbecue", new String[] { "barbecue" }));
		LIST_CATEGORIES.add(new Category("Jardin - Barbecue - Robinet", new String[] { "barbecue", "robinet" }));
		LIST_CATEGORIES.add(new Category("Jardin - Barbecue - Fixe", new String[] { "barbecue", "fixe" }));
		LIST_CATEGORIES.add(new Category("Jardin - Barbecue - Four à pizza", new String[] { "barbecue", "four", "pizza" }));
		LIST_CATEGORIES.add(new Category("Jardin - Barbecue - Combustible", new String[] { "barbecue", "combustible" }));
		LIST_CATEGORIES.add(new Category("Jardin - Barbecue - Cuisine extérieure", new String[] { "barbecue", "cuisine", "extérieur" }));
		LIST_CATEGORIES.add(new Category("Jardin - Barbecue - Grilloir", new String[] { "barbecue", "grilloir" }));
		LIST_CATEGORIES.add(new Category("Jardin - Barbecue - Fumoir", new String[] { "barbecue", "fumoir" }));
		LIST_CATEGORIES.add(new Category("Jardin - Barbecue - Plancha", new String[] { "barbecue", "plancha" }));
		LIST_CATEGORIES.add(new Category("Jardin - Barbecue - Bouteille de gaz", new String[] { "barbecue", "bouteille", "gaz" }));
		LIST_CATEGORIES.add(new Category("Jardin - Mobilier - Chauffage", new String[] { "mobilier", "chauffage" }));
		LIST_CATEGORIES.add(new Category("Jardin - Mobilier - Chaise", new String[] { "mobilier", "chaise" }));
		LIST_CATEGORIES.add(new Category("Jardin - Mobilier - Fauteuil", new String[] { "mobilier", "fauteuil" }));
		LIST_CATEGORIES.add(new Category("Jardin - Mobilier - Entretien", new String[] { "mobilier", "entretien" }));
		LIST_CATEGORIES.add(new Category("Jardin - Mobilier - Salon", new String[] { "mobilier", "salon" }));
		LIST_CATEGORIES.add(new Category("Jardin - Mobilier - Salon - Détente", new String[] { "mobilier", "salon", "détente" }));
		LIST_CATEGORIES.add(new Category("Jardin - Mobilier - Salon - Jardin", new String[] { "mobilier", "salon", "jardin" }));
		LIST_CATEGORIES.add(new Category("Jardin - Mobilier - Table", new String[] { "mobilier", "table" }));
		LIST_CATEGORIES.add(new Category("Jardin - Mobilier - Pouf", new String[] { "mobilier", "pouf" }));
		LIST_CATEGORIES.add(new Category("Jardin - Mobilier - Banc", new String[] { "mobilier", "banc" }));
		LIST_CATEGORIES.add(new Category("Jardin - Mobilier - Coussin", new String[] { "mobilier", "coussin" }));
		LIST_CATEGORIES.add(new Category("Jardin - Mobilier - Hamac / Balancelle", new String[] { "mobilier", "hamac", "balancelle" }));
		LIST_CATEGORIES.add(new Category("Jardin - Mobilier - Bain de soleil", new String[] { "mobilier", "bain", "soleil" }));
		LIST_CATEGORIES.add(new Category("Jardin - Fontaine", new String[] { "fontaine" }));
		LIST_CATEGORIES.add(new Category("Jardin - Fontaine - Cascade", new String[] { "fontaine", "cascade" }));
		LIST_CATEGORIES.add(new Category("Jardin - Fontaine - Bassin", new String[] { "fontaine", "bassin" }));
		LIST_CATEGORIES.add(new Category("Jardin - Fontaine - Bassin - Accessoire", new String[] { "fontaine", "bassin", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Jardin - Semence - Gazon", new String[] { "semence", "gazon" }));
		LIST_CATEGORIES.add(new Category("Jardin - Semence - Gazon - Artificiel", new String[] { "semence", "gazon", "artificiel" }));
		LIST_CATEGORIES.add(new Category("Jardin - Semence - Florale", new String[] { "semence", "florale" }));
		LIST_CATEGORIES.add(new Category("Jardin - Semence - Potagère", new String[] { "semence", "potagère" }));
		LIST_CATEGORIES.add(new Category("Jardin - Serre - Plante", new String[] { "serre", "plante" }));
		LIST_CATEGORIES.add(new Category("Jardin - Serre - Accessoire", new String[] { "serre", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Jardin - Serre - Potager", new String[] { "serre", "potager" }));
		LIST_CATEGORIES.add(new Category("Jardin - Serre - Composteur", new String[] { "serre", "composteur" }));
		LIST_CATEGORIES.add(new Category("Jardin - Serre - Terreau", new String[] { "serre", "terreau" }));
		LIST_CATEGORIES.add(new Category("Jardin - Serre", new String[] { "serre" }));
		LIST_CATEGORIES.add(new Category("Jardin - Serre - Traitement contre les insectes", new String[] { "serre", "traitement", "insecte" }));
		LIST_CATEGORIES.add(new Category("Jardin - Serre - Paillage", new String[] { "serre", "paillage" }));
		LIST_CATEGORIES.add(new Category("Jardin - Serre - Jardinière", new String[] { "serre", "jardinière" }));
		LIST_CATEGORIES.add(new Category("Jardin - Serre - Pot", new String[] { "serre", "pot" }));
		LIST_CATEGORIES.add(new Category("Jardin - Serre - Film de protection", new String[] { "serre", "film", "protection" }));
		LIST_CATEGORIES.add(new Category("Jardin - Serre - Tunnel de culture", new String[] { "serre", "tunnel", "culture" }));
		LIST_CATEGORIES.add(new Category("Jardin - Outil - Pelle et pioche", new String[] { "outil", "pelle", "pioche" }));
		LIST_CATEGORIES.add(new Category("Jardin - Outil - Déneigeuse", new String[] { "outil", "déneigeuse" }));
		LIST_CATEGORIES.add(new Category("Jardin - Outil - Motobineuse / Motoculteur", new String[] { "outil", "motobineuse", "motoculteur" }));
		LIST_CATEGORIES.add(new Category("Jardin - Outil - Bûche", new String[] { "outil", "bûche" }));
		LIST_CATEGORIES.add(new Category("Jardin - Outil - Souffleur", new String[] { "outil", "souffleur" }));
		LIST_CATEGORIES.add(new Category("Jardin - Outil - Aspirateur", new String[] { "outil", "aspirateur" }));
		LIST_CATEGORIES.add(new Category("Jardin - Outil - Broyeur végétaux", new String[] { "outil", "broyeur", "végétaux" }));
		LIST_CATEGORIES.add(new Category("Jardin - Outil - Tondeuse - Autoportée", new String[] { "outil", "tondeuse", "autoportée" }));
		LIST_CATEGORIES.add(new Category("Jardin - Outil - Tondeuse - Sans fil", new String[] { "outil", "tondeuse", "sans", "fil" }));
		LIST_CATEGORIES.add(new Category("Jardin - Outil - Tondeuse - Electrique", new String[] { "outil", "tondeuse", "electrique" }));
		LIST_CATEGORIES.add(new Category("Jardin - Outil - Tondeuse - Essence", new String[] { "outil", "tondeuse", "essence" }));
		LIST_CATEGORIES.add(new Category("Jardin - Outil - Débroussailleuse", new String[] { "outil", "débroussailleuse" }));
		LIST_CATEGORIES.add(new Category("Jardin - Outil - Taille haie", new String[] { "outil", "taille", "haie" }));
		LIST_CATEGORIES.add(new Category("Jardin - Outil - Tronçonneuse", new String[] { "outil", "tronçonneuse" }));
		LIST_CATEGORIES.add(new Category("Jardin - Outil - Sac", new String[] { "outil", "sac" }));
		LIST_CATEGORIES.add(new Category("Jardin - Outil - Coupe-bordure", new String[] { "outil", "coupe", "bordure" }));
		LIST_CATEGORIES.add(new Category("Jardin - Outil - Nettoyeur haute pression", new String[] { "outil", "nettoyeur", "haute", "pression" }));
		LIST_CATEGORIES.add(
			new Category("Jardin - Outil - Nettoyeur haute pression - Accessoire", new String[] { "outil", "nettoyeur", "haute", "pression", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Jardin - Outil - Perceuse - Sans fil", new String[] { "outil", "perceuse", "sans", "fil" }));
		LIST_CATEGORIES.add(new Category("Jardin - Piscine - SPA", new String[] { "piscine", "spa" }));
		LIST_CATEGORIES.add(new Category("Jardin - Piscine - SPA - Gonflage", new String[] { "piscine", "spa", "gonflage" }));
		LIST_CATEGORIES.add(new Category("Jardin - Piscine - Sauna", new String[] { "piscine", "sauna" }));
		LIST_CATEGORIES.add(new Category("Jardin - Piscine - Cloture", new String[] { "piscine", "cloture" }));
		LIST_CATEGORIES.add(new Category("Jardin - Piscine - Bâche à bulle", new String[] { "piscine", "bâche", "bulle" }));
		LIST_CATEGORIES.add(new Category("Jardin - Piscine", new String[] { "piscine" }));
		LIST_CATEGORIES.add(new Category("Jardin - Piscine - Douche", new String[] { "piscine", "douche" }));
		LIST_CATEGORIES.add(new Category("Jardin - Piscine - Echelle", new String[] { "piscine", "echelle" }));
		LIST_CATEGORIES.add(new Category("Jardin - Piscine - Nettoyage", new String[] { "piscine", "nettoyage" }));
		LIST_CATEGORIES.add(new Category("Jardin - Piscine - Filtration", new String[] { "piscine", "filtration" }));
		LIST_CATEGORIES.add(new Category("Jardin - Piscine - Traitement", new String[] { "piscine", "traitement" }));
		LIST_CATEGORIES.add(new Category("Jardin - Piscine - Accessoire", new String[] { "piscine", "accessoire" }));
		LIST_CATEGORIES.add(new Category("Jardin - Revêtement - Gravillon", new String[] { "revêtement", "gravillon" }));
		LIST_CATEGORIES.add(new Category("Jardin - Revêtement - Galet", new String[] { "revêtement", "galet" }));
		LIST_CATEGORIES.add(new Category("Jardin - Revêtement - Pas japonais", new String[] { "revêtement", "pas", "japonais" }));
		LIST_CATEGORIES.add(new Category("Jardin - Jeu d'enfant - Maisonnette", new String[] { "jeu", "enfant", "maisonnette" }));
		LIST_CATEGORIES.add(new Category("Jardin - Jeu d'enfant - Portique", new String[] { "jeu", "enfant", "portique" }));
		LIST_CATEGORIES.add(new Category("Jardin - Jeu d'enfant - Balançoire", new String[] { "jeu", "enfant", "balançoire" }));
		LIST_CATEGORIES.add(new Category("Jardin - Jeu d'enfant - Bac à sable", new String[] { "jeu", "enfant", "bac", "sable" }));
		LIST_CATEGORIES.add(new Category("Jardin - Jeu d'enfant - Dalle de sécurité", new String[] { "jeu", "enfant", "dalle", "sécurité" }));
		LIST_CATEGORIES.add(new Category("Jardin - Arrosage - Pulvérisateur", new String[] { "arrosage", "pulvérisateur" }));
		LIST_CATEGORIES.add(new Category("Jardin - Arrosage - Programmateur", new String[] { "arrosage", "programmateur" }));
		LIST_CATEGORIES.add(new Category("Jardin - Arrosage - Récupérateur eau de pluie", new String[] { "arrosage", "récupérateur", "eau" }));
		LIST_CATEGORIES.add(new Category("Jardin - Arrosage - Tuyau", new String[] { "arrosage", "tuyau" }));
		LIST_CATEGORIES.add(new Category("Jardin - Arrosage - Tuyau - Enrouleur", new String[] { "arrosage", "tuyau", "enrouleur" }));
		LIST_CATEGORIES.add(new Category("Jardin - Peinture - Sol", new String[] { "peinture", "sol" }));
		LIST_CATEGORIES.add(new Category("Jardin - Vêtement - Gants", new String[] { "vêtement", "gant" }));

		//Peinture
		LIST_CATEGORIES.add(new Category("Peinture - Intérieur - Bois", new String[] { "peinture", "intérieur", "bois" }));
	}

	public List<Category> getCategories() {
		return LIST_CATEGORIES;
	}
}
