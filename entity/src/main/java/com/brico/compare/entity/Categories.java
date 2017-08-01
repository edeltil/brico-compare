package com.brico.compare.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Created by edeltil on 24/02/2017.
 */
@Service
public class Categories {
	private List<Category> categories = new ArrayList<>();

	{
		categories.add(new Category("Chauffage - Chauffage au bois - Cuisinière", new String[] { "chauffage", "bois", "cuisinière" }));
		categories.add(new Category("Chauffage - Chauffage au bois - Foyer et insert", new String[] { "chauffage", "bois", "foyer", "insert" }));
		categories.add(new Category("Chauffage - Chauffage au bois - Poêle à bois", new String[] { "chauffage", "bois", "poêle" }));
		categories.add(new Category("Chauffage - Chauffage au bois - Accessoire", new String[] { "chauffage", "bois", "accessoire" }));
		categories.add(
			new Category("Chauffage - Chauffage au bois - Poêle à granulés et à pellets", new String[] { "chauffage", "bois", "poêle", "granulé", "pellets" }));
		categories.add(new Category("Chauffage - Chauffage au bois - Conduit et raccord", new String[] { "chauffage", "bois", "conduit", "raccord" }));
		categories.add(new Category("Chauffage - Chauffage au bois - Combustible", new String[] { "chauffage", "bois", "combustible" }));
		categories
			.add(new Category("Chauffage - Chauffage d'appoint - Radiateur soufflant", new String[] { "chauffage", "appoint", "radiateur", "soufflant" }));
		categories.add(new Category("Chauffage - Chauffage d'appoint - Accessoire", new String[] { "chauffage", "appoint", "accessoire" }));
		categories.add(
			new Category("Chauffage - Chauffage d'appoint - Radiateur bain d'huile", new String[] { "chauffage", "appoint", "radiateur", "bain", "huile" }));
		categories
			.add(new Category("Chauffage - Chauffage d'appoint - Radiateur céramique", new String[] { "chauffage", "appoint", "radiateur", "céramique" }));
		categories
			.add(new Category("Chauffage - Chauffage d'appoint - Radiateur spécifique", new String[] { "chauffage", "appoint", "radiateur", "spécifique" }));
		categories.add(new Category("Chauffage - Chauffage d'appoint - Convecteur mobile", new String[] { "chauffage", "appoint", "convecteur", "mobile" }));
		categories.add(new Category("Chauffage - Chauffage d'appoint - Panneau rayonnant", new String[] { "chauffage", "appoint", "panneau", "rayonnant" }));
		categories.add(new Category("Chauffage - Chauffage d'appoint - Poêle à pétrole", new String[] { "chauffage", "appoint", "poêle", "pétrole" }));
		categories.add(new Category("Chauffage - Livre", new String[] { "chauffage", "livre" }));
		categories.add(new Category("Chauffage - Thermostat et programmateur de chauffage", new String[] { "chauffage", "thermostat", "programmateur" }));
		categories.add(new Category("Chauffage - Climatiseur", new String[] { "chauffage", "climatiseur" }));
		categories.add(new Category("Chauffage - Pompe à chaleur", new String[] { "chauffage", "pompe", "chaleur" }));
		categories.add(new Category("Chauffage - Climatiseur - Climatiseur mobile", new String[] { "climatiseur", "mobile", "chauffage" }));
		categories.add(new Category("Chauffage - Climatiseur - Accessoire", new String[] { "chauffage", "climatiseur", "accessoire" }));
		categories.add(new Category("Chauffage - Raccordement au gaz - Accessoire", new String[] { "chauffage", "raccordement", "gaz", "accessoire" }));
		categories.add(new Category("Chauffage - Raccordement au gaz - Flexible", new String[] { "chauffage", "raccordement", "gaz", "flexible" }));
		categories.add(new Category("Chauffage - Radiateur électrique - Rayonnant", new String[] { "chauffage", "radiateur", "électrique", "rayonnant" }));
		categories.add(new Category("Chauffage - Radiateur électrique - Convecteur", new String[] { "chauffage", "radiateur", "électrique", "convecteur" }));
		categories.add(new Category("Chauffage - Radiateur électrique - Inertie", new String[] { "chauffage", "radiateur", "électrique", "inertie" }));
		categories.add(new Category("Chauffage - Radiateur électrique - Accessoire", new String[] { "chauffage", "radiateur", "électrique", "accessoire" }));
		categories.add(
			new Category("Chauffage - Radiateur électrique - Sèche-serviettes", new String[] { "chauffage", "radiateur", "électrique", "sèche", "serviette" }));
		categories.add(new Category("Chauffage - Radiateur à eau chaude", new String[] { "chauffage", "radiateur", "eau", "chaude" }));
		categories
			.add(new Category("Chauffage - Radiateur à eau chaude - Accessoire", new String[] { "chauffage", "radiateur", "eau", "chaude", "accessoire" }));
		categories.add(new Category("Chauffage - Radiateur à eau chaude - Robinet", new String[] { "chauffage", "radiateur", "eau", "chaude", "robinet" }));
		categories.add(new Category("Chauffage - Radiateur à eau chaude - Sèche-serviettes",
			new String[] { "chauffage", "radiateur", "eau", "chaude", "sèche", "serviette" }));
		categories.add(new Category("Chauffage - Radiateur chauffage centrale", new String[] { "chauffage", "chauffage", "centrale" }));
		categories.add(new Category("Chauffage - Plancher chauffant - Accessoire", new String[] { "chauffage", "plancher", "chauffant", "accessoire" }));
		categories.add(new Category("Chauffage - Plancher chauffant", new String[] { "chauffage", "plancher", "chauffant" }));
		categories.add(new Category("Chauffage - Combustible et allumage", new String[] { "chauffage", "combustible", "allumage" }));
		categories.add(new Category("Chauffage - Production d'énergie et de chauffage renouvelable - Chauffe-eau thermodynamique",
			new String[] { "chauffage", "production", "renouvelable", "chauffe", "eau" }));
		categories.add(new Category("Chauffage - Aérateur - Thermomètre", new String[] { "chauffage", "aérateur", "thermomètre" }));
		categories.add(new Category("Chauffage - Aérateur - VMC", new String[] { "chauffage", "aérateur", "vmc" }));
		categories.add(new Category("Chauffage - Aérateur", new String[] { "chauffage", "aérateur" }));
		categories.add(new Category("Chauffage - Aérateur - Conduit", new String[] { "chauffage", "aérateur", "conduit" }));
		categories.add(new Category("Chauffage - Aérateur - Accessoire", new String[] { "chauffage", "aérateur", "accessoire" }));

		categories.add(new Category("Plomberie - Adoucisseur - Adoucisseur d'eau", new String[] { "plomberie", "adoucisseur", "eau" }));
		categories.add(new Category("Plomberie - Adoucisseur - Adoucisseur d'eau - Sel", new String[] { "plomberie", "adoucisseur", "eau", "sel" }));
		categories
			.add(new Category("Plomberie - Adoucisseur - Adoucisseur d'eau - Eau de boisson", new String[] { "plomberie", "adoucisseur", "eau", "boisson" }));
		categories.add(new Category("Plomberie - Adoucisseur - Adoucisseur d'eau - Eau de boisson - Accessoire",
			new String[] { "plomberie", "adoucisseur", "eau", "boisson", "accessoire" }));
		categories
			.add(new Category("Plomberie - Adoucisseur - Adoucisseur d'eau - Accessoire", new String[] { "plomberie", "adoucisseur", "eau", "accessoire" }));
		categories.add(new Category("Plomberie - Adoucisseur - Station et filtre - Anti-calcaire/anti-tartre - Cartouche",
			new String[] { "plomberie", "adoucisseur", "filtre", "anti", "calcaire", "tartre", "cartouche" }));
		categories.add(new Category("Plomberie - Adoucisseur - Station et filtre - Anti-calcaire/anti-tartre - Accessoire",
			new String[] { "plomberie", "adoucisseur", "filtre", "anti", "calcaire", "tartre", "accessoire" }));
		categories
			.add(new Category("Plomberie - Adoucisseur - Station et filtre - Eau de pluie", new String[] { "plomberie", "adoucisseur", "filtre", "pluie" }));
		categories.add(new Category("Plomberie - Adoucisseur - Station et filtre - Filtre réfrigérateur américain",
			new String[] { "plomberie", "adoucisseur", "filtre", "réfrigérateur", "américain" }));
		categories.add(new Category("Plomberie - Robinet - Accessoire", new String[] { "plomberie", "robinet", "accessoire" }));
		categories.add(new Category("Plomberie - Robinet - Flexible et douchette", new String[] { "plomberie", "robinet", "flexible", "douchette" }));
		categories.add(new Category("Plomberie - Robinet - Mousseur et brise-jet robinet", new String[] { "plomberie", "robinet", "mousseur", "brise-jet" }));
		categories.add(new Category("Plomberie - Robinet - Raccord", new String[] { "plomberie", "robinet", "raccord" }));
		categories.add(new Category("Plomberie - Robinet - Robinet à entraxe spécial", new String[] { "plomberie", "robinet", "entraxe" }));
		categories.add(new Category("Plomberie - Robinet - Bec et raccord bec", new String[] { "plomberie", "robinet", "bec", "raccord" }));
		categories.add(new Category("Plomberie - Robinet - Colonnette", new String[] { "plomberie", "robinet", "colonnette" }));
		categories.add(
			new Category("Plomberie - Robinet - Tête de robinet, cartouche et croisillon", new String[] { "plomberie", "robinet", "cartouche", "croisillon" }));
		categories.add(new Category("Plomberie - Chauffe-eau et ballon d'eau chaude - Electrique - Instantanée",
			new String[] { "plomberie", "chauffe", "eau", "ballon", "electrique", "instantanée" }));
		categories.add(new Category("Plomberie - Chauffe-eau et ballon d'eau chaude - Electrique",
			new String[] { "plomberie", "chauffe", "eau", "ballon", "electrique" }));
		categories.add(new Category("Plomberie - Chauffe-eau et ballon d'eau chaude - Electrique - Accessoire",
			new String[] { "plomberie", "chauffe", "eau", "ballon", "electrique", "accessoire" }));
		categories.add(new Category("Plomberie - Alimentation en eau - Lave-linge/vaisselle",
			new String[] { "plomberie", "alimentation", "eau", "lave", "linge", "vaisselle" }));
		categories.add(new Category("Plomberie - Alimentation en eau - Etanchéité", new String[] { "plomberie", "alimentation", "eau", "etanchéité" }));
		categories.add(new Category("Plomberie - Alimentation en eau - Raccord", new String[] { "plomberie", "alimentation", "eau", "raccord" }));
		categories.add(new Category("Plomberie - Alimentation en eau - Flexible", new String[] { "plomberie", "alimentation", "eau", "flexible" }));
		categories.add(new Category("Plomberie - Alimentation en eau - Platine de fixation", new String[] { "plomberie", "alimentation", "fixation" }));
		categories.add(new Category("Plomberie - Alimentation en eau - Joint", new String[] { "plomberie", "alimentation", "eau", "joint" }));
		categories.add(new Category("Plomberie - Alimentation en eau - Clapet", new String[] { "plomberie", "alimentation", "eau", "clapet" }));
		categories.add(new Category("Plomberie - Alimentation en eau - Tube", new String[] { "plomberie", "alimentation", "eau", "tube" }));
		categories.add(
			new Category("Plomberie - Evacuation des eaux usées - Vidage - Douche", new String[] { "plomberie", "evacuation", "eau", "vidage", "douche" }));
		categories.add(
			new Category("Plomberie - Evacuation des eaux usées - Vidage - Lavabo", new String[] { "plomberie", "evacuation", "eau", "vidage", "lavabo" }));
		categories.add(new Category("Plomberie - Evacuation des eaux usées - Vidage - Accessoire",
			new String[] { "plomberie", "evacuation", "eau", "vidage", "accessoire" }));
		categories.add(
			new Category("Plomberie - Evacuation des eaux usées - Trappe de visite", new String[] { "plomberie", "evacuation", "eau", "trappe", "visite" }));
		categories.add(new Category("Plomberie - WC - Chasse d'eau - Robinet flotteur", new String[] { "plomberie", "wc", "chasse", "eau", "flotteur" }));

		categories.add(new Category("Cuisine - Meuble", new String[] { "cuisine", "meuble" }));
		categories.add(new Category("Cuisine - Meuble - Equipement", new String[] { "cuisine", "meuble", "equipement" }));
		categories.add(new Category("Cuisine - Meuble - Intérieur", new String[] { "cuisine", "meuble", "intérieur" }));
		categories.add(new Category("Cuisine - Meuble - Accessoire", new String[] { "cuisine", "meuble", "accessoire" }));
		categories.add(new Category("Cuisine - Meuble - Poignées et boutons", new String[] { "cuisine", "meuble", "poignée", "bouton" }));
		categories.add(new Category("Cuisine - Carrelage", new String[] { "cuisine", "carrelage" }));
		categories.add(new Category("Cuisine - Plan de travail - Accessoire", new String[] { "cuisine", "plan", "travail", "accessoire" }));
		categories.add(new Category("Cuisine - Plan de travail", new String[] { "cuisine", "plan", "travail" }));
		categories.add(new Category("Cuisine - Crédence", new String[] { "cuisine", "crédence" }));
		categories.add(new Category("Cuisine - Crédence - Accessoire", new String[] { "cuisine", "crédence", "accessoire" }));
		categories.add(new Category("Cuisine - Rangement - Accessoire", new String[] { "cuisine", "rangement", "accessoire" }));
		categories.add(new Category("Cuisine - Rangement - Range-couverts", new String[] { "cuisine", "rangement", "range", "couvert" }));
		categories.add(new Category("Cuisine - Rangement - Tapis fond de tiroir", new String[] { "cuisine", "rangement", "tapis", "tiroir" }));
		categories.add(new Category("Cuisine - Evier", new String[] { "cuisine", "evier" }));
		categories.add(new Category("Cuisine - Evier - Accessoire", new String[] { "cuisine", "evier", "accessoire" }));
		categories.add(new Category("Cuisine - Evier - Robinet", new String[] { "cuisine", "evier", "robinet" }));
		categories.add(new Category("Cuisine - Kitchenette", new String[] { "cuisine", "kitchenette" }));
		categories.add(new Category("Cuisine - Eclairage", new String[] { "cuisine", "eclairage" }));
		categories.add(new Category("Cuisine - Etagère", new String[] { "cuisine", "etagère" }));
		categories.add(new Category("Cuisine - Poubelle", new String[] { "cuisine", "poubelle" }));
		categories.add(new Category("Cuisine - Livres", new String[] { "cuisine", "livre" }));
		categories.add(new Category("Cuisine - Chaises", new String[] { "cuisine", "chaise" }));
		categories.add(new Category("Cuisine - Chaises - Tabouret", new String[] { "cuisine", "chaise", "tabouret" }));
		categories.add(new Category("Cuisine - Electroménager - Hotte", new String[] { "cuisine", "electroménager", "hotte" }));
		categories.add(new Category("Cuisine - Electroménager - Four micro-ondes", new String[] { "cuisine", "electroménager", "four", "micro-onde" }));
		categories.add(new Category("Cuisine - Electroménager - Réfrigérateur", new String[] { "cuisine", "electroménager", "réfrigérateur" }));
		categories.add(new Category("Cuisine - Electroménager - Congélateur", new String[] { "cuisine", "electroménager", "congélateur" }));
		categories.add(new Category("Cuisine - Electroménager - Lave-linge", new String[] { "cuisine", "electroménager", "lave-linge" }));
		categories.add(new Category("Cuisine - Electroménager - Four", new String[] { "cuisine", "electroménager", "four" }));
		categories.add(new Category("Cuisine - Electroménager - Four - encastrable", new String[] { "cuisine", "electroménager", "four", "encastrable" }));
		categories.add(new Category("Cuisine - Electroménager - Lave-vaisselle", new String[] { "cuisine", "electroménager", "lave", "vaisselle" }));
		categories.add(new Category("Cuisine - Electroménager - Plaque de cuisson", new String[] { "cuisine", "electroménager", "plaque", "cuisson" }));
		categories.add(new Category("Cuisine - Electroménager - Plaque de cuisson - Vitrocéramique",
			new String[] { "cuisine", "electroménager", "cuisson", "vitrocéramique" }));

		categories.add(new Category("Décoration - Coussin - Chaise", new String[] { "décoration", "coussin", "chaise" }));
		categories.add(new Category("Décoration - Coussin - Décoratif", new String[] { "décoration", "coussin", "décoratif" }));
		categories.add(new Category("Décoration - Coussin - Sol", new String[] { "décoration", "coussin", "sol" }));
		categories.add(new Category("Décoration - Coussin - Housse", new String[] { "décoration", "coussin", "housse" }));
		categories.add(new Category("Décoration - Coussin - Plaid", new String[] { "décoration", "coussin", "plaid" }));
		categories.add(new Category("Décoration - Coussin", new String[] { "décoration", "coussin" }));
		categories.add(new Category("Décoration - Rideau", new String[] { "décoration", "rideau" }));
		categories.add(new Category("Décoration - Rideau - Tringle - Sans perçage", new String[] { "décoration", "rideau", "tringle", "sans", "perçage" }));
		categories.add(new Category("Décoration - Rideau - Tringle - Barre de vitrage", new String[] { "décoration", "rideau", "tringle" }));
		categories.add(new Category("Décoration - Rideau - Tringle - Lucarne", new String[] { "décoration", "rideau", "tringle", "lucarne" }));
		categories.add(new Category("Décoration - Rideau - Brise-bise", new String[] { "décoration", "rideau", "brise-bise" }));
		categories.add(new Category("Décoration - Rideau - Vitrage", new String[] { "décoration", "rideau", "vitrage" }));
		categories.add(new Category("Décoration - Rideau - Tringle à rideau - A composer", new String[] { "décoration", "rideau", "tringle", "composer" }));
		categories.add(new Category("Décoration - Rideau - Tringle à rideau - A composer - Accessoire",
			new String[] { "décoration", "rideau", "tringle", "composer", "accessoire" }));
		categories.add(new Category("Décoration - Rideau - Tringle à rideau - A composer - Support",
			new String[] { "décoration", "rideau", "tringle", "composer", "support" }));
		categories.add(new Category("Décoration - Rideau - Tringle à rideau - Kit", new String[] { "décoration", "rideau", "tringle", "kit" }));
		categories.add(new Category("Décoration - Rideau - Oeillet", new String[] { "décoration", "rideau", "oeillet" }));
		categories.add(new Category("Décoration - Rideau - Voilage", new String[] { "décoration", "rideau", "voilage" }));
		categories.add(new Category("Décoration - Rideau - Accessoire", new String[] { "décoration", "rideau", "accessoire" }));
		categories.add(new Category("Décoration - Store - Accessoires", new String[] { "décoration", "store", "accessoire" }));
		categories.add(new Category("Décoration - Store - Panneaux japonais", new String[] { "décoration", "store", "panneau", "japonais" }));
		categories.add(new Category("Décoration - Store - Store enrouleur", new String[] { "décoration", "store", "enrouleur" }));
		categories.add(new Category("Décoration - Livre", new String[] { "décoration", "livre" }));
		categories.add(new Category("Décoration - Papier peint - Colle", new String[] { "décoration", "papier", "peint", "colle" }));
		categories.add(new Category("Décoration - Papier peint - Décolleur", new String[] { "décoration", "papier", "peint", "décolleur" }));
		categories.add(new Category("Décoration - Papier peint", new String[] { "décoration", "papier", "peint" }));
		categories.add(new Category("Décoration - Papier peint - Frise", new String[] { "décoration", "papier", "peint", "frise" }));
		categories.add(new Category("Décoration - Papier peint - Fibre de verre", new String[] { "décoration", "papier", "peint", "fibre", "verre" }));
		categories.add(
			new Category("Décoration - Stickers, affiche et toile - Affiche, poster", new String[] { "décoration", "sticker", "affiche", "toile", "poster" }));
		categories.add(new Category("Décoration - Stickers, affiche et toile - Cadre", new String[] { "décoration", "sticker", "affiche", "toile", "cadre" }));
		categories
			.add(new Category("Décoration - Stickers, affiche et toile - Lettre", new String[] { "décoration", "sticker", "affiche", "toile", "lettre" }));
		categories
			.add(new Category("Décoration - Stickers, affiche et toile - Miroir", new String[] { "décoration", "sticker", "affiche", "toile", "miroir" }));
		categories.add(new Category("Décoration - Stickers, affiche et toile - Sticker", new String[] { "décoration", "sticker", "affiche", "toile" }));
		categories.add(new Category("Décoration - Moulure - Dalle de plafond", new String[] { "décoration", "moulure", "dalle", "plafond" }));

		//Eclairage
		categories.add(new Category("Eclairage - Ampoule LED", new String[] { "eclairage", "ampoule", "led" }));
		categories.add(new Category("Eclairage - Ampoule LED - Tube", new String[] { "eclairage", "ampoule", "led", "tube" }));
		categories.add(new Category("Eclairage - Extérieur", new String[] { "eclairage", "extérieur" }));
		categories.add(new Category("Eclairage - Extérieur - Lampadaire", new String[] { "eclairage", "extérieur", "lampadaire" }));
		categories.add(new Category("Eclairage - Extérieur - Solaire", new String[] { "eclairage", "extérieur", "solaire" }));
		categories.add(new Category("Eclairage - Extérieur - Terrasse - Borne", new String[] { "eclairage", "extérieur", "terrasse", "borne" }));
		categories.add(new Category("Eclairage - Extérieur - Terrasse - Suspension", new String[] { "eclairage", "extérieur", "terrasse", "suspension" }));
		categories
			.add(new Category("Eclairage - Extérieur - Terrasse - Spot encastré", new String[] { "eclairage", "extérieur", "terrasse", "spot", "encastré" }));
		categories.add(new Category("Eclairage - Extérieur - Terrasse - Applique", new String[] { "eclairage", "extérieur", "terrasse", "applique" }));
		categories.add(new Category("Eclairage - Intérieur - Salle de bain", new String[] { "eclairage", "intérieur", "salle", "bain" }));
		categories.add(new Category("Eclairage - Intérieur - Applique murale", new String[] { "eclairage", "intérieur", "applique" }));
		categories.add(new Category("Eclairage - Intérieur - Accessoire", new String[] { "eclairage", "intérieur", "accessoire" }));
		categories.add(new Category("Eclairage - Intérieur - Cuisine", new String[] { "eclairage", "intérieur", "cuisine" }));
		categories.add(new Category("Eclairage - Intérieur - Spot", new String[] { "eclairage", "intérieur", "spot" }));
		categories.add(new Category("Eclairage - Intérieur - Spot - Encastrable", new String[] { "eclairage", "intérieur", "spot", "encastrable" }));
		categories.add(new Category("Eclairage - Intérieur - Plafonnier", new String[] { "eclairage", "intérieur", "plafonnier" }));
		categories.add(new Category("Eclairage - Intérieur - Dressing", new String[] { "eclairage", "intérieur", "dressing" }));
		categories.add(new Category("Eclairage - Intérieur - Lustre", new String[] { "eclairage", "intérieur", "lustre" }));
		categories.add(new Category("Eclairage - Intérieur - Suspension", new String[] { "eclairage", "intérieur", "suspension" }));
		categories.add(new Category("Eclairage - Intérieur - Lampe de chevet", new String[] { "eclairage", "intérieur", "lampe", "chevet" }));
		categories.add(new Category("Eclairage - Intérieur - Lampe de salon", new String[] { "eclairage", "intérieur", "lampe", "salon" }));
		categories.add(new Category("Eclairage - Intérieur - Pied de lampe", new String[] { "eclairage", "intérieur", "lampe", "pied" }));

		//Electricité
		categories.add(new Category("Electricité - Câbles - Fils", new String[] { "electricité", "câble", "fil" }));
		categories.add(new Category("Electricité - Câbles - Gaîne ICTA", new String[] { "electricité", "câble", "gaîne", "ICTA" }));
		categories.add(new Category("Electricité - Câbles - Fixation", new String[] { "electricité", "câble", "fixation" }));
		categories.add(new Category("Electricité - Câbles - Gaîne préfilée", new String[] { "electricité", "câble", "gaîne", "préfilée" }));
		categories.add(new Category("Electricité - Câbles - IRL", new String[] { "electricité", "câble", "irl" }));
		categories.add(new Category("Electricité - Moulure", new String[] { "electricité", "moulure" }));
		categories.add(new Category("Electricité - Plinthe", new String[] { "electricité", "plinthe" }));
		categories.add(new Category("Electricité - Goulotte", new String[] { "electricité", "goulotte" }));
		categories.add(new Category("Electricité - Livre", new String[] { "electricité", "livre" }));
		categories.add(new Category("Electricité - Domotique - Appareil connecté", new String[] { "electricité", "domotique", "appareil", "connecté" }));
		categories.add(new Category("Electricité - Domotique - Box et kit", new String[] { "electricité", "domotique", "box", "kit" }));
		categories.add(new Category("Electricité - Domotique - Lumière", new String[] { "electricité", "domotique", "lumière" }));
		categories.add(new Category("Electricité - Domotique - Accessoire", new String[] { "electricité", "domotique", "accessoire" }));
		categories.add(new Category("Electricité - Domotique - Porte de garage", new String[] { "electricité", "domotique", "porte", "garage" }));
		categories.add(new Category("Electricité - Domotique - Chauffage", new String[] { "electricité", "domotique", "chauffage" }));
		categories.add(new Category("Electricité - Tableau - Autres", new String[] { "electricité", "tableau", "autres" }));
		categories.add(new Category("Electricité - Tableau - Disjoncteur", new String[] { "electricité", "tableau", "disjoncteur" }));
		categories
			.add(new Category("Electricité - Tableau - Disjoncteur - Différenciel", new String[] { "electricité", "tableau", "disjoncteur", "différenciel" }));
		categories.add(new Category("Electricité - Tableau - Coupe-circuit", new String[] { "electricité", "tableau", "coupe", "circuit" }));
		categories.add(new Category("Electricité - Tableau - Para-foudre", new String[] { "electricité", "tableau", "para-foudre" }));
		categories.add(new Category("Electricité - Tableau - Bornier / peigne", new String[] { "electricité", "tableau", "bornier", "peigne" }));
		categories.add(new Category("Electricité - Tableau - Nu", new String[] { "electricité", "tableau", "nu" }));
		categories.add(new Category("Electricité - Tableau - GTL", new String[] { "electricité", "tableau", "gtl" }));
		categories.add(new Category("Electricité - Tableau - Pré-équipé", new String[] { "electricité", "tableau", "pré-équipé" }));
		categories.add(new Category("Electricité - Alarme maison - Sans fil", new String[] { "electricité", "alarme", "sans", "fil" }));
		categories.add(new Category("Electricité - Alarme maison - Caméra", new String[] { "electricité", "alarme", "caméra" }));
		categories.add(new Category("Electricité - Alarme maison - Accessoire", new String[] { "electricité", "alarme", "accessoire" }));
		categories.add(new Category("Electricité - Alarme maison - Détecteur de mouvement et de lumière",
			new String[] { "electricité", "alarme", "détecteur", "mouvement", "lumière" }));
		categories.add(new Category("Electricité - Alarme maison - Détecteur de fumée, monoxyde de carbone et gaz",
			new String[] { "electricité", "alarme", "détecteur", "fumée", "monoxyde", "carbone", "gaz" }));
		categories.add(new Category("Electricité - Antenne - Accessoire", new String[] { "electricité", "antenne", "accessoire" }));
		categories.add(
			new Category("Electricité - Antenne - Connectique audio et vidéo", new String[] { "electricité", "antenne", "connectique", "audio", "vidéo" }));
		categories.add(new Category("Electricité - Antenne - Satellite", new String[] { "electricité", "antenne", "satellite" }));
		categories.add(new Category("Electricité - Antenne - Alimentation", new String[] { "electricité", "antenne", "alimentation" }));
		categories.add(new Category("Electricité - Antenne - Décodeur TNT", new String[] { "electricité", "antenne", "décodeur", "tnt" }));
		categories
			.add(new Category("Electricité - Antenne - Télécommande universelle", new String[] { "electricité", "antenne", "télécommande", "universelle" }));
		categories.add(new Category("Electricité - Antenne - Décodeur satellite", new String[] { "electricité", "antenne", "décodeur", "satellite" }));
		categories.add(new Category("Electricité - Antenne - CPL", new String[] { "electricité", "antenne", "cpl" }));
		categories.add(new Category("Electricité - Interrupteur / Prise - Adaptateur de voyage",
			new String[] { "electricité", "interrupteur", "prise", "adaptateur", "voyage" }));
		categories
			.add(new Category("Electricité - Interrupteur / Prise - Encastrable", new String[] { "electricité", "interrupteur", "prise", "encastrable" }));
		categories.add(new Category("Electricité - Interrupteur / Prise - Composable", new String[] { "electricité", "interrupteur", "prise", "composable" }));
		categories.add(new Category("Electricité - Interrupteur / Prise - Multiprise", new String[] { "electricité", "interrupteur", "prise", "multiprise" }));
		categories.add(new Category("Electricité - Interrupteur / Prise - Etanche", new String[] { "electricité", "interrupteur", "prise", "etanche" }));
		categories.add(new Category("Electricité - Motorisation - Accessoire", new String[] { "electricité", "motorisation", "accessoire" }));
		categories.add(new Category("Electricité - Motorisation - Portail", new String[] { "electricité", "motorisation", "portail" }));
		categories.add(new Category("Electricité - Motorisation - Volet", new String[] { "electricité", "motorisation", "volet" }));
		categories.add(new Category("Electricité - Motorisation - Interphone", new String[] { "electricité", "motorisation", "interphone" }));
		categories.add(new Category("Electricité - Motorisation - Garage", new String[] { "electricité", "motorisation", "garage" }));
		categories.add(new Category("Electricité - Motorisation - Visiophone", new String[] { "electricité", "motorisation", "visiophone" }));
		categories.add(new Category("Electricité - Motorisation - SOMFY", new String[] { "electricité", "motorisation", "somfy" }));
		categories.add(new Category("Electricité - Motorisation - SOMFY - Accessoire", new String[] { "electricité", "motorisation", "somfy", "accessoire" }));
		categories.add(new Category("Electricité - Motorisation - SOMFY - Portail", new String[] { "electricité", "motorisation", "somfy", "portail" }));
		categories.add(new Category("Electricité - Motorisation - SOMFY - Garage", new String[] { "electricité", "motorisation", "somfy", "garage" }));
		categories.add(new Category("Electricité - Rallonge - Boite de dérivation - Domino borne",
			new String[] { "electricité", "rallonge", "boite", "dérivation", "domino", "borne" }));
		categories.add(new Category("Electricité - Rallonge - Boite de dérivation - Accessoire",
			new String[] { "electricité", "rallonge", "boite", "dérivation", "accessoire" }));
		categories.add(new Category("Electricité - Rallonge - Boite de dérivation", new String[] { "electricité", "rallonge", "boite", "dérivation" }));
		categories.add(new Category("Electricité - Rallonge - Enrouleur", new String[] { "electricité", "rallonge", "enrouleur" }));
		categories.add(new Category("Electricité - Rallonge - Appareil de mesure", new String[] { "electricité", "rallonge", "appareil", "mesure" }));
		categories.add(new Category("Electricité - Rallonge", new String[] { "electricité", "rallonge" }));
		categories.add(new Category("Electricité - Lampe torche - Douille", new String[] { "electricité", "lampe", "torche", "douille" }));
		categories.add(new Category("Electricité - Lampe torche - Chargeur", new String[] { "electricité", "lampe", "torche", "chargeur" }));
		categories.add(new Category("Electricité - Lampe torche - Pile", new String[] { "electricité", "lampe", "torche", "pile" }));
		categories.add(new Category("Electricité - Lampe torche", new String[] { "electricité", "lampe", "torche" }));
		categories.add(new Category("Electricité - Lampe torche - Variateur", new String[] { "electricité", "lampe", "torche", "variateur" }));

		//Jardin
		categories.add(new Category("Jardin - Accessoire", new String[] { "jardin", "accessoire" }));
		categories.add(new Category("Jardin - Balustrades", new String[] { "jardin", "balustrade" }));
		categories.add(new Category("Jardin - Terrasse - Produits", new String[] { "terrasse", "produit" }));
		categories.add(new Category("Jardin - Terrasse - Carrelage", new String[] { "terrasse", "carrelage" }));
		categories.add(new Category("Jardin - Terrasse - Dalle", new String[] { "terrasse", "dalle" }));
		categories.add(new Category("Jardin - Terrasse - Lame", new String[] { "terrasse", "lame" }));
		categories.add(new Category("Jardin - Terrasse - Bordure", new String[] { "terrasse", "bordure" }));
		categories.add(new Category("Jardin - Terrasse - Composite", new String[] { "terrasse", "composite" }));
		categories.add(new Category("Jardin - Terrasse - Pose et entretien", new String[] { "terrasse", "pose", "entretien" }));
		categories.add(new Category("Jardin - Terrasse - Bois - Pose et entretien", new String[] { "terrasse", "bois", "pose", "entretien" }));
		categories.add(new Category("Jardin - Portail - Décoration", new String[] { "portail", "décoration" }));
		categories.add(new Category("Jardin - Portail - Battants", new String[] { "portail", "battant" }));
		categories.add(new Category("Jardin - Portail - Battants - Aluminium", new String[] { "portail", "battant", "aluminium" }));
		categories.add(new Category("Jardin - Portail - Battants - Bois", new String[] { "portail", "portail", "battant", "bois" }));
		categories.add(new Category("Jardin - Portail - Battants - Fer", new String[] { "portail", "portail", "battant", "fer" }));
		categories.add(new Category("Jardin - Portail - Battants - PVC", new String[] { "portail", "portail", "battant", "pvc" }));
		categories.add(new Category("Jardin - Portail - Portillon", new String[] { "portail", "portillon" }));
		categories.add(new Category("Jardin - Portail - Portillon - Aluminium", new String[] { "portail", "portillon", "aluminium" }));
		categories.add(new Category("Jardin - Portail - Coulissant", new String[] { "portail", "portail", "coulissant" }));
		categories.add(new Category("Jardin - Portail - Coulissant - Aluminium", new String[] { "portail", "portail", "coulissant", "aluminium" }));
		categories.add(new Category("Jardin - Store - Banne", new String[] { "store", "banne" }));
		categories.add(new Category("Jardin - Parasol", new String[] { "parasol" }));
		categories.add(new Category("Jardin - Parasol - Accessoire", new String[] { "parasol", "accessoire" }));
		categories.add(new Category("Jardin - Escalier", new String[] { "jardin", "escalier" }));
		categories.add(new Category("Jardin - Tonnelle", new String[] { "tonnelle" }));
		categories.add(new Category("Jardin - Tonnelle - Voile d'ombrage", new String[] { "tonnelle", "voile", "ombrage" }));
		categories.add(new Category("Jardin - Toit terrasse", new String[] { "toit", "terrasse" }));
		categories.add(new Category("Jardin - Clôture", new String[] { "clôture" }));
		categories.add(new Category("Jardin - Clôture - A composer", new String[] { "clôture", "composer" }));
		categories.add(new Category("Jardin - Clôture - Brise vue", new String[] { "clôture", "brise", "vue" }));
		categories.add(new Category("Jardin - Clôture - Brise vent", new String[] { "clôture", "brise", "vent" }));
		categories.add(new Category("Jardin - Clôture - Canisse", new String[] { "clôture", "canisse" }));
		categories.add(new Category("Jardin - Clôture - Occultation", new String[] { "clôture", "occultation" }));
		categories.add(new Category("Jardin - Clôture - Panneaux", new String[] { "clôture", "panneau" }));
		categories.add(new Category("Jardin - Clôture - Panneaux - Bois", new String[] { "clôture", "panneau", "bois" }));
		categories.add(new Category("Jardin - Clôture - Travée", new String[] { "clôture", "travée" }));
		categories.add(new Category("Jardin - Clôture - Poteau", new String[] { "clôture", "poteau" }));
		categories.add(new Category("Jardin - Clôture - Grillage", new String[] { "clôture", "grillage" }));
		categories.add(new Category("Jardin - Clôture - Grillage - Rigide", new String[] { "clôture", "grillage", "rigide" }));
		categories.add(new Category("Jardin - Clôture - Grillage - Animaux", new String[] { "clôture", "grillage", "animaux" }));
		categories.add(new Category("Jardin - Abri", new String[] { "jardin", "abri" }));
		categories.add(new Category("Jardin - Livre", new String[] { "jardin", "livre" }));
		categories.add(new Category("Jardin - Abri - Accessoire", new String[] { "abri", "accessoire" }));
		categories.add(new Category("Jardin - Abri - Kiosque", new String[] { "abri", "kiosque" }));
		categories.add(new Category("Jardin - Abri - Pergola", new String[] { "abri", "pergola" }));
		categories.add(new Category("Jardin - Abri - Treillage", new String[] { "abri", "treillage" }));
		categories.add(new Category("Jardin - Abri - Rangement", new String[] { "abri", "rangement" }));
		categories.add(new Category("Jardin - Abri - Abri de jardin", new String[] { "abri", "abri de jardin" }));
		categories.add(new Category("Jardin - Abri - Coffre de jardin", new String[] { "abri", "coffre" }));
		categories.add(new Category("Jardin - Abri - Garage", new String[] { "abri", "garage" }));
		categories.add(new Category("Jardin - Abri - Carport", new String[] { "abri", "carport" }));
		categories.add(new Category("Jardin - Barbecue - Accessoire", new String[] { "barbecue", "accessoire" }));
		categories.add(new Category("Jardin - Barbecue", new String[] { "barbecue" }));
		categories.add(new Category("Jardin - Barbecue - Robinet", new String[] { "barbecue", "robinet" }));
		categories.add(new Category("Jardin - Barbecue - Fixe", new String[] { "barbecue", "fixe" }));
		categories.add(new Category("Jardin - Barbecue - Four à pizza", new String[] { "barbecue", "four", "pizza" }));
		categories.add(new Category("Jardin - Barbecue - Combustible", new String[] { "barbecue", "combustible" }));
		categories.add(new Category("Jardin - Barbecue - Cuisine extérieure", new String[] { "barbecue", "cuisine", "extérieur" }));
		categories.add(new Category("Jardin - Barbecue - Grilloir", new String[] { "barbecue", "grilloir" }));
		categories.add(new Category("Jardin - Barbecue - Fumoir", new String[] { "barbecue", "fumoir" }));
		categories.add(new Category("Jardin - Barbecue - Plancha", new String[] { "barbecue", "plancha" }));
		categories.add(new Category("Jardin - Barbecue - Bouteille de gaz", new String[] { "barbecue", "bouteille", "gaz" }));
		categories.add(new Category("Jardin - Mobilier - Chauffage", new String[] { "mobilier", "chauffage" }));
		categories.add(new Category("Jardin - Mobilier - Chaise", new String[] { "mobilier", "chaise" }));
		categories.add(new Category("Jardin - Mobilier - Fauteuil", new String[] { "mobilier", "fauteuil" }));
		categories.add(new Category("Jardin - Mobilier - Entretien", new String[] { "mobilier", "entretien" }));
		categories.add(new Category("Jardin - Mobilier - Salon", new String[] { "mobilier", "salon" }));
		categories.add(new Category("Jardin - Mobilier - Salon - Détente", new String[] { "mobilier", "salon", "détente" }));
		categories.add(new Category("Jardin - Mobilier - Salon - Jardin", new String[] { "mobilier", "salon", "jardin" }));
		categories.add(new Category("Jardin - Mobilier - Table", new String[] { "mobilier", "table" }));
		categories.add(new Category("Jardin - Mobilier - Pouf", new String[] { "mobilier", "pouf" }));
		categories.add(new Category("Jardin - Mobilier - Banc", new String[] { "mobilier", "banc" }));
		categories.add(new Category("Jardin - Mobilier - Coussin", new String[] { "mobilier", "coussin" }));
		categories.add(new Category("Jardin - Mobilier - Hamac / Balancelle", new String[] { "mobilier", "hamac", "balancelle" }));
		categories.add(new Category("Jardin - Mobilier - Bain de soleil", new String[] { "mobilier", "bain", "soleil" }));
		categories.add(new Category("Jardin - Fontaine", new String[] { "fontaine" }));
		categories.add(new Category("Jardin - Fontaine - Cascade", new String[] { "fontaine", "cascade" }));
		categories.add(new Category("Jardin - Fontaine - Bassin", new String[] { "fontaine", "bassin" }));
		categories.add(new Category("Jardin - Fontaine - Bassin - Accessoire", new String[] { "fontaine", "bassin", "accessoire" }));
		categories.add(new Category("Jardin - Semence - Gazon", new String[] { "semence", "gazon" }));
		categories.add(new Category("Jardin - Semence - Gazon - Artificiel", new String[] { "semence", "gazon", "artificiel" }));
		categories.add(new Category("Jardin - Semence - Florale", new String[] { "semence", "florale" }));
		categories.add(new Category("Jardin - Semence - Potagère", new String[] { "semence", "potagère" }));
		categories.add(new Category("Jardin - Serre - Plante", new String[] { "serre", "plante" }));
		categories.add(new Category("Jardin - Serre - Accessoire", new String[] { "serre", "accessoire" }));
		categories.add(new Category("Jardin - Serre - Potager", new String[] { "serre", "potager" }));
		categories.add(new Category("Jardin - Serre - Composteur", new String[] { "serre", "composteur" }));
		categories.add(new Category("Jardin - Serre - Terreau", new String[] { "serre", "terreau" }));
		categories.add(new Category("Jardin - Serre", new String[] { "serre" }));
		categories.add(new Category("Jardin - Serre - Traitement contre les insectes", new String[] { "serre", "traitement", "insecte" }));
		categories.add(new Category("Jardin - Serre - Paillage", new String[] { "serre", "paillage" }));
		categories.add(new Category("Jardin - Serre - Jardinière", new String[] { "serre", "jardinière" }));
		categories.add(new Category("Jardin - Serre - Pot", new String[] { "serre", "pot" }));
		categories.add(new Category("Jardin - Serre - Film de protection", new String[] { "serre", "film", "protection" }));
		categories.add(new Category("Jardin - Serre - Tunnel de culture", new String[] { "serre", "tunnel", "culture" }));
		categories.add(new Category("Jardin - Outil - Pelle et pioche", new String[] { "outil", "pelle", "pioche" }));
		categories.add(new Category("Jardin - Outil - Déneigeuse", new String[] { "outil", "déneigeuse" }));
		categories.add(new Category("Jardin - Outil - Motobineuse / Motoculteur", new String[] { "outil", "motobineuse", "motoculteur" }));
		categories.add(new Category("Jardin - Outil - Bûche", new String[] { "outil", "bûche" }));
		categories.add(new Category("Jardin - Outil - Souffleur", new String[] { "outil", "souffleur" }));
		categories.add(new Category("Jardin - Outil - Aspirateur", new String[] { "outil", "aspirateur" }));
		categories.add(new Category("Jardin - Outil - Broyeur végétaux", new String[] { "outil", "broyeur", "végétaux" }));
		categories.add(new Category("Jardin - Outil - Tondeuse - Autoportée", new String[] { "outil", "tondeuse", "autoportée" }));
		categories.add(new Category("Jardin - Outil - Tondeuse - Sans fil", new String[] { "outil", "tondeuse", "sans", "fil" }));
		categories.add(new Category("Jardin - Outil - Tondeuse - Electrique", new String[] { "outil", "tondeuse", "electrique" }));
		categories.add(new Category("Jardin - Outil - Tondeuse - Essence", new String[] { "outil", "tondeuse", "essence" }));
		categories.add(new Category("Jardin - Outil - Débroussailleuse", new String[] { "outil", "débroussailleuse" }));
		categories.add(new Category("Jardin - Outil - Taille haie", new String[] { "outil", "taille", "haie" }));
		categories.add(new Category("Jardin - Outil - Tronçonneuse", new String[] { "outil", "tronçonneuse" }));
		categories.add(new Category("Jardin - Outil - Sac", new String[] { "outil", "sac" }));
		categories.add(new Category("Jardin - Outil - Coupe-bordure", new String[] { "outil", "coupe", "bordure" }));
		categories.add(new Category("Jardin - Outil - Nettoyeur haute pression", new String[] { "outil", "nettoyeur", "haute", "pression" }));
		categories.add(
			new Category("Jardin - Outil - Nettoyeur haute pression - Accessoire", new String[] { "outil", "nettoyeur", "haute", "pression", "accessoire" }));
		categories.add(new Category("Jardin - Outil - Perceuse - Sans fil", new String[] { "outil", "perceuse", "sans", "fil" }));
		categories.add(new Category("Jardin - Piscine - SPA", new String[] { "piscine", "spa" }));
		categories.add(new Category("Jardin - Piscine - SPA - Gonflage", new String[] { "piscine", "spa", "gonflage" }));
		categories.add(new Category("Jardin - Piscine - Sauna", new String[] { "piscine", "sauna" }));
		categories.add(new Category("Jardin - Piscine - Cloture", new String[] { "piscine", "cloture" }));
		categories.add(new Category("Jardin - Piscine - Bâche à bulle", new String[] { "piscine", "bâche", "bulle" }));
		categories.add(new Category("Jardin - Piscine", new String[] { "piscine" }));
		categories.add(new Category("Jardin - Piscine - Douche", new String[] { "piscine", "douche" }));
		categories.add(new Category("Jardin - Piscine - Echelle", new String[] { "piscine", "echelle" }));
		categories.add(new Category("Jardin - Piscine - Nettoyage", new String[] { "piscine", "nettoyage" }));
		categories.add(new Category("Jardin - Piscine - Filtration", new String[] { "piscine", "filtration" }));
		categories.add(new Category("Jardin - Piscine - Traitement", new String[] { "piscine", "traitement" }));
		categories.add(new Category("Jardin - Piscine - Accessoire", new String[] { "piscine", "accessoire" }));
		categories.add(new Category("Jardin - Revêtement - Gravillon", new String[] { "revêtement", "gravillon" }));
		categories.add(new Category("Jardin - Revêtement - Galet", new String[] { "revêtement", "galet" }));
		categories.add(new Category("Jardin - Revêtement - Pas japonais", new String[] { "revêtement", "pas", "japonais" }));
		categories.add(new Category("Jardin - Jeu d'enfant - Maisonnette", new String[] { "jeu", "enfant", "maisonnette" }));
		categories.add(new Category("Jardin - Jeu d'enfant - Portique", new String[] { "jeu", "enfant", "portique" }));
		categories.add(new Category("Jardin - Jeu d'enfant - Balançoire", new String[] { "jeu", "enfant", "balançoire" }));
		categories.add(new Category("Jardin - Jeu d'enfant - Bac à sable", new String[] { "jeu", "enfant", "bac", "sable" }));
		categories.add(new Category("Jardin - Jeu d'enfant - Dalle de sécurité", new String[] { "jeu", "enfant", "dalle", "sécurité" }));
		categories.add(new Category("Jardin - Arrosage - Pulvérisateur", new String[] { "arrosage", "pulvérisateur" }));
		categories.add(new Category("Jardin - Arrosage - Programmateur", new String[] { "arrosage", "programmateur" }));
		categories.add(new Category("Jardin - Arrosage - Récupérateur eau de pluie", new String[] { "arrosage", "récupérateur", "eau" }));
		categories.add(new Category("Jardin - Arrosage - Tuyau", new String[] { "arrosage", "tuyau" }));
		categories.add(new Category("Jardin - Arrosage - Tuyau - Enrouleur", new String[] { "arrosage", "tuyau", "enrouleur" }));
		categories.add(new Category("Jardin - Peinture - Sol", new String[] { "peinture", "sol" }));
		categories.add(new Category("Jardin - Vêtement - Gants", new String[] { "vêtement", "gant" }));

		//		categories.add(new Category("Jardin - Accesoire", new String[] { "jardin", "accessoire" }));
		//		categories.add(new Category("Jardin - Balustrades", new String[] { "jardin", "balustrade" }));
		//		categories.add(new Category("Jardin - Terrasse - Produits", new String[] { "jardin", "terrasse", "produit" }));
		//		categories.add(new Category("Jardin - Terrasse - Carrelage", new String[] { "jardin", "terrasse", "carrelage" }));
		//		categories.add(new Category("Jardin - Terrasse - Dalle", new String[] { "jardin", "terrasse", "dalle" }));
		//		categories.add(new Category("Jardin - Terrasse - Lame", new String[] { "jardin", "terrasse", "lame" }));
		//		categories.add(new Category("Jardin - Terrasse - Bordure", new String[] { "jardin", "terrasse", "bordure" }));
		//		categories.add(new Category("Jardin - Terrasse - Composite", new String[] { "jardin", "terrasse", "composite" }));
		//		categories.add(new Category("Jardin - Terrasse - Pose et entretien", new String[] { "jardin", "terrasse", "pose", "entretien" }));
		//		categories.add(new Category("Jardin - Terrasse - Bois - Pose et entretien", new String[] { "jardin", "terrasse", "bois", "pose", "entretien" }));
		//		categories.add(new Category("Jardin - Portail - Décoration", new String[] { "jardin", "portail", "décoration" }));
		//		categories.add(new Category("Jardin - Portail - Battants", new String[] { "jardin", "portail", "battant" }));
		//		categories.add(new Category("Jardin - Portail - Battants - Aluminium", new String[] { "jardin", "portail", "battant", "aluminium" }));
		//		categories.add(new Category("Jardin - Portail - Battants - Bois", new String[] { "jardin", "portail", "portail", "battant", "bois" }));
		//		categories.add(new Category("Jardin - Portail - Battants - Fer", new String[] { "jardin", "portail", "portail", "battant", "fer" }));
		//		categories.add(new Category("Jardin - Portail - Battants - PVC", new String[] { "jardin", "portail", "portail", "battant", "pvc" }));
		//		categories.add(new Category("Jardin - Portail - Portillon", new String[] { "jardin", "portail", "portillon" }));
		//		categories.add(new Category("Jardin - Portail - Portillon - Aluminium", new String[] { "jardin", "portail", "portillon", "aluminium" }));
		//		categories.add(new Category("Jardin - Portail - Coulissant", new String[] { "jardin", "portail", "portail", "coulissant" }));
		//		categories.add(new Category("Jardin - Portail - Coulissant - Aluminium", new String[] { "jardin", "portail", "portail", "coulissant", "aluminium" }));
		//		categories.add(new Category("Jardin - Store - Banne", new String[] { "jardin", "store", "banne" }));
		//		categories.add(new Category("Jardin - Parasol", new String[] { "jardin", "parasol" }));
		//		categories.add(new Category("Jardin - Parasol - Accessoire", new String[] { "jardin", "parasol", "accessoire" }));
		//		categories.add(new Category("Jardin - Escalier", new String[] { "jardin", "escalier" }));
		//		categories.add(new Category("Jardin - Tonnelle", new String[] { "jardin", "tonnelle" }));
		//		categories.add(new Category("Jardin - Tonnelle - Voile d'ombrage", new String[] { "jardin", "tonnelle", "voile", "ombrage" }));
		//		categories.add(new Category("Jardin - Toit terrasse", new String[] { "jardin", "toit", "terrasse" }));
		//		categories.add(new Category("Jardin - Clôture", new String[] { "jardin", "clôture" }));
		//		categories.add(new Category("Jardin - Clôture - A composer", new String[] { "jardin", "clôture", "à", "composer" }));
		//		categories.add(new Category("Jardin - Clôture - Brise vue", new String[] { "jardin", "clôture", "brise", "vue" }));
		//		categories.add(new Category("Jardin - Clôture - Brise vent", new String[] { "jardin", "clôture", "brise", "vent" }));
		//		categories.add(new Category("Jardin - Clôture - Canisse", new String[] { "jardin", "clôture", "canisse" }));
		//		categories.add(new Category("Jardin - Clôture - Occultation", new String[] { "jardin", "clôture", "occultation" }));
		//		categories.add(new Category("Jardin - Clôture - Panneaux", new String[] { "jardin", "clôture", "panneau" }));
		//		categories.add(new Category("Jardin - Clôture - Panneaux - Bois", new String[] { "jardin", "clôture", "panneau", "bois" }));
		//		categories.add(new Category("Jardin - Clôture - Travée", new String[] { "jardin", "clôture", "travée" }));
		//		categories.add(new Category("Jardin - Clôture - Poteau", new String[] { "jardin", "clôture", "poteau" }));
		//		categories.add(new Category("Jardin - Clôture - Grillage", new String[] { "jardin", "clôture", "grillage" }));
		//		categories.add(new Category("Jardin - Clôture - Grillage - Rigide", new String[] { "jardin", "clôture", "grillage", "rigide" }));
		//		categories.add(new Category("Jardin - Clôture - Grillage - Animaux", new String[] { "jardin", "clôture", "grillage", "animaux" }));
		//		categories.add(new Category("Jardin - Abri", new String[] { "jardin", "abri" }));
		//		categories.add(new Category("Jardin - Livre", new String[] { "jardin", "livre" }));
		//		categories.add(new Category("Jardin - Abri - Accessoire", new String[] { "jardin", "abri", "accessoire" }));
		//		categories.add(new Category("Jardin - Abri - Kiosque", new String[] { "jardin", "abri", "kiosque" }));
		//		categories.add(new Category("Jardin - Abri - Pergola", new String[] { "jardin", "abri", "pergola" }));
		//		categories.add(new Category("Jardin - Abri - Treillage", new String[] { "jardin", "abri", "treillage" }));
		//		categories.add(new Category("Jardin - Abri - Rangement", new String[] { "jardin", "abri", "rangement" }));
		//		categories.add(new Category("Jardin - Abri - Abri de jardin", new String[] { "jardin", "abri", "abri de jardin" }));
		//		categories.add(new Category("Jardin - Abri - Coffre de jardin", new String[] { "jardin", "abri", "coffre" }));
		//		categories.add(new Category("Jardin - Abri - Garage", new String[] { "jardin", "abri", "garage" }));
		//		categories.add(new Category("Jardin - Abri - Carport", new String[] { "jardin", "abri", "carport" }));
		//		categories.add(new Category("Jardin - Barbecue - Accessoire", new String[] { "jardin", "barbecue", "accessoire" }));
		//		categories.add(new Category("Jardin - Barbecue", new String[] { "jardin", "barbecue" }));
		//		categories.add(new Category("Jardin - Barbecue - Robinet", new String[] { "jardin", "barbecue", "robinet" }));
		//		categories.add(new Category("Jardin - Barbecue - Fixe", new String[] { "jardin", "barbecue", "fixe" }));
		//		categories.add(new Category("Jardin - Barbecue - Four à pizza", new String[] { "jardin", "barbecue", "four", "pizza" }));
		//		categories.add(new Category("Jardin - Barbecue - Combustible", new String[] { "jardin", "barbecue", "combustible" }));
		//		categories.add(new Category("Jardin - Barbecue - Cuisine extérieure", new String[] { "jardin", "barbecue", "cuisine", "extérieur" }));
		//		categories.add(new Category("Jardin - Barbecue - Grilloir", new String[] { "jardin", "barbecue", "grilloir" }));
		//		categories.add(new Category("Jardin - Barbecue - Fumoir", new String[] { "jardin", "barbecue", "fumoir" }));
		//		categories.add(new Category("Jardin - Barbecue - Plancha", new String[] { "jardin", "barbecue", "plancha" }));
		//		categories.add(new Category("Jardin - Barbecue - Bouteille de gaz", new String[] { "jardin", "barbecue", "bouteille", "gaz" }));
		//		categories.add(new Category("Jardin - Mobilier - Chauffage", new String[] { "jardin", "mobilier", "chauffage" }));
		//		categories.add(new Category("Jardin - Mobilier - Chaise", new String[] { "jardin", "mobilier", "chaise" }));
		//		categories.add(new Category("Jardin - Mobilier - Fauteuil", new String[] { "jardin", "mobilier", "fauteuil" }));
		//		categories.add(new Category("Jardin - Mobilier - Entretien", new String[] { "jardin", "mobilier", "entretien" }));
		//		categories.add(new Category("Jardin - Mobilier - Salon", new String[] { "jardin", "mobilier", "salon" }));
		//		categories.add(new Category("Jardin - Mobilier - Salon - Détente", new String[] { "jardin", "mobilier", "salon", "détente" }));
		//		categories.add(new Category("Jardin - Mobilier - Salon - Jardin", new String[] { "jardin", "mobilier", "salon", "jardin" }));
		//		categories.add(new Category("Jardin - Mobilier - Table", new String[] { "jardin", "mobilier", "table" }));
		//		categories.add(new Category("Jardin - Mobilier - Pouf", new String[] { "jardin", "mobilier", "pouf" }));
		//		categories.add(new Category("Jardin - Mobilier - Banc", new String[] { "jardin", "mobilier", "banc" }));
		//		categories.add(new Category("Jardin - Mobilier - Coussin", new String[] { "jardin", "mobilier", "coussin" }));
		//		categories.add(new Category("Jardin - Mobilier - Hamac / Balancelle", new String[] { "jardin", "mobilier", "hamac", "balancelle" }));
		//		categories.add(new Category("Jardin - Mobilier - Bain de soleil", new String[] { "jardin", "mobilier", "bain", "soleil" }));
		//		categories.add(new Category("Jardin - Fontaine", new String[] { "jardin", "fontaine" }));
		//		categories.add(new Category("Jardin - Fontaine - Cascade", new String[] { "jardin", "fontaine", "cascade" }));
		//		categories.add(new Category("Jardin - Fontaine - Bassin", new String[] { "jardin", "fontaine", "bassin" }));
		//		categories.add(new Category("Jardin - Fontaine - Bassin - Accessoire", new String[] { "jardin", "fontaine", "bassin", "accessoire" }));
		//		categories.add(new Category("Jardin - Semence - Gazon", new String[] { "jardin", "semence", "gazon" }));
		//		categories.add(new Category("Jardin - Semence - Gazon - Artificiel", new String[] { "jardin", "semence", "gazon", "artificiel" }));
		//		categories.add(new Category("Jardin - Semence - Florale", new String[] { "jardin", "semence", "florale" }));
		//		categories.add(new Category("Jardin - Semence - Potagère", new String[] { "jardin", "semence", "potagère" }));
		//		categories.add(new Category("Jardin - Serre - Plante", new String[] { "jardin", "serre", "plante" }));
		//		categories.add(new Category("Jardin - Serre - Accessoire", new String[] { "jardin", "serre", "accessoire" }));
		//		categories.add(new Category("Jardin - Serre - Potager", new String[] { "jardin", "serre", "potager" }));
		//		categories.add(new Category("Jardin - Serre - Composteur", new String[] { "jardin", "serre", "potager" }));
		//		categories.add(new Category("Jardin - Serre - Terreau", new String[] { "jardin", "serre", "terreau" }));
		//		categories.add(new Category("Jardin - Serre", new String[] { "jardin", "serre" }));
		//		categories.add(new Category("Jardin - Serre - Traitement contre les insectes", new String[] { "jardin", "serre", "traitement", "insecte" }));
		//		categories.add(new Category("Jardin - Serre - Paillage", new String[] { "jardin", "serre", "paillage" }));
		//		categories.add(new Category("Jardin - Serre - Jardinière", new String[] { "jardin", "serre", "jardinière" }));
		//		categories.add(new Category("Jardin - Serre - Pot", new String[] { "jardin", "serre", "pot" }));
		//		categories.add(new Category("Jardin - Serre - Film de protection", new String[] { "jardin", "serre", "film", "protection" }));
		//		categories.add(new Category("Jardin - Serre - Tunnel de culture", new String[] { "jardin", "serre", "tunnel", "culture" }));
		//		categories.add(new Category("Jardin - Outil - Pelle et pioche", new String[] { "jardin", "outil", "pelle", "pioche" }));
		//		categories.add(new Category("Jardin - Outil - Déneigeuse", new String[] { "jardin", "outil", "déneigeuse" }));
		//		categories.add(new Category("Jardin - Outil - Motobineuse / Motoculteur", new String[] { "jardin", "outil", "motobineuse", "motoculteur" }));
		//		categories.add(new Category("Jardin - Outil - Bûche", new String[] { "jardin", "outil", "bûche" }));
		//		categories.add(new Category("Jardin - Outil - Souffleur", new String[] { "jardin", "outil", "souffleur" }));
		//		categories.add(new Category("Jardin - Outil - Aspirateur", new String[] { "jardin", "outil", "aspirateur" }));
		//		categories.add(new Category("Jardin - Outil - Broyeux végétaux", new String[] { "jardin", "outil", "broyeur", "végétaux" }));
		//		categories.add(new Category("Jardin - Outil - Tondeuse - Autoportée", new String[] { "jardin", "outil", "tondeuse", "autoportée" }));
		//		categories.add(new Category("Jardin - Outil - Tondeuse - Sans fil", new String[] { "jardin", "outil", "tondeuse", "sans", "fil" }));
		//		categories.add(new Category("Jardin - Outil - Tondeuse - Electique", new String[] { "jardin", "outil", "tondeuse", "électrique" }));
		//		categories.add(new Category("Jardin - Outil - Tondeuse - Essence", new String[] { "jardin", "outil", "tondeuse", "essence" }));
		//		categories.add(new Category("Jardin - Outil - Débroussailleuse", new String[] { "jardin", "outil", "débroussailleuse" }));
		//		categories.add(new Category("Jardin - Outil - Taille haie", new String[] { "jardin", "outil", "taille", "haie" }));
		//		categories.add(new Category("Jardin - Outil - Tronçonneuse", new String[] { "jardin", "outil", "tronconneuse" }));
		//		categories.add(new Category("Jardin - Outil - Sac", new String[] { "jardin", "outil", "sac" }));
		//		categories.add(new Category("Jardin - Outil - Coupe-bordure", new String[] { "jardin", "outil", "coupe", "bordure" }));
		//		categories.add(new Category("Jardin - Outil - Nettoyeur haute pression", new String[] { "jardin", "outil", "nettoyeur", "haute", "pression" }));
		//		categories.add(new Category("Jardin - Outil - Nettoyeur haute pression - Accessoire",
		//			new String[] { "jardin", "outil", "nettoyeur", "haute", "pression", "accessoire" }));
		//		categories.add(new Category("Jardin - Outil - Perceuse - Sans fil", new String[] { "jardin", "outil", "perceuse", "sans", "fil" }));
		//		categories.add(new Category("Jardin - Piscine - SPA", new String[] { "jardin", "piscine", "spa" }));
		//		categories.add(new Category("Jardin - Piscine - SPA - Gonflage", new String[] { "jardin", "piscine", "spa", "gonflable" }));
		//		categories.add(new Category("Jardin - Piscine - Sauna", new String[] { "jardin", "piscine", "sauna" }));
		//		categories.add(new Category("Jardin - Piscine - Cloture", new String[] { "jardin", "piscine", "cloture" }));
		//		categories.add(new Category("Jardin - Piscine - Bâche à bulle", new String[] { "jardin", "piscine", "bâche", "bulle" }));
		//		categories.add(new Category("Jardin - Piscine", new String[] { "jardin", "piscine" }));
		//		categories.add(new Category("Jardin - Piscine - Douche", new String[] { "jardin", "piscine", "douche" }));
		//		categories.add(new Category("Jardin - Piscine - Echelle", new String[] { "jardin", "piscine", "échelle" }));
		//		categories.add(new Category("Jardin - Piscine - Nettoyage", new String[] { "jardin", "piscine", "nettoyage" }));
		//		categories.add(new Category("Jardin - Piscine - Filtration", new String[] { "jardin", "piscine", "filtration" }));
		//		categories.add(new Category("Jardin - Piscine - Traitement", new String[] { "jardin", "piscine", "traitement" }));
		//		categories.add(new Category("Jardin - Piscine - Accessoire", new String[] { "jardin", "piscine", "accessoire" }));
		//		categories.add(new Category("Jardin - Revêtement - Gravillon", new String[] { "jardin", "revêtement", "gravillon" }));
		//		categories.add(new Category("Jardin - Revêtement - Galet", new String[] { "jardin", "revêtement", "galet" }));
		//		categories.add(new Category("Jardin - Revêtement - Pas japonais", new String[] { "jardin", "revêtement", "pas", "japonais" }));
		//		categories.add(new Category("Jardin - Jeu d'enfant - Maisonnette", new String[] { "jardin", "jeu", "enfant", "maisonnette" }));
		//		categories.add(new Category("Jardin - Jeu d'enfant - Portique", new String[] { "jardin", "jeu", "enfant", "portique" }));
		//		categories.add(new Category("Jardin - Jeu d'enfant - Balançoire", new String[] { "jardin", "jeu", "enfant", "balancoire" }));
		//		categories.add(new Category("Jardin - Jeu d'enfant - Bac à sable", new String[] { "jardin", "jeu", "enfant", "bac", "sable" }));
		//		categories.add(new Category("Jardin - Jeu d'enfant - Dalle de sécurité", new String[] { "jardin", "jeu", "enfant", "dalle", "sécurité" }));
		//		categories.add(new Category("Jardin - Arrosage - Pulvérisateur", new String[] { "jardin", "arrosage", "pulvérisateur" }));
		//		categories.add(new Category("Jardin - Arrosage - Programmateur", new String[] { "jardin", "arrosage", "programmateur" }));
		//		categories.add(new Category("Jardin - Arrosage - Récupérateur eau de pluie", new String[] { "jardin", "arrosage", "récupérateur", "eau" }));
		//		categories.add(new Category("Jardin - Arrosage - Tuyau", new String[] { "jardin", "arrosage", "tuyau" }));
		//		categories.add(new Category("Jardin - Arrosage - Tuyau - Enrouleur", new String[] { "jardin", "arrosage", "tuyau", "enrouleur" }));
		//		categories.add(new Category("Jardin - Peinture - Sol", new String[] { "jardin", "peinture", "sol" }));
		//		categories.add(new Category("Jardin - Vêtement - Gants", new String[] { "jardin", "vêtement", "gant" }));

		//Peinture
		categories.add(new Category("Peinture - Intérieur - Bois", new String[] { "peinture", "intérieur", "bois" }));
	}
	//"Chauffage - Chauffage au bois - Poêle à bois"
	//"Chauffage - Chauffage au bois - Accessoire"
	//"Chauffage - Chauffage au bois - Poêle à granulés et à pellets"
	//"Chauffage - Chauffage au bois - Conduit et raccord"
	//"Chauffage - Chauffage au bois - Combustible"
	//"Chauffage - Chauffage d'appoint - Radiateur soufflant"
	//"Chauffage - Chauffage d'appoint - Accessoire"
	//"Chauffage - Chauffage d'appoint - Radiateur bain d'huile"
	//"Chauffage - Chauffage d'appoint - Radiateur céramique"
	//"Chauffage - Chauffage d'appoint - Radiateur spécifique"
	//"Chauffage - Chauffage d'appoint - Convecteur mobile et panneau rayonnant"
	//"Chauffage - Chauffage d'appoint - Panneau rayonnant"
	//"Chauffage - Chauffage d'appoint - Poêle à pétrole"
	//"Chauffage - Livre"
	//"Chauffage - Thermostat et programmateur de chauffage"
	//"Chauffage - Climatiseur"
	//"Chauffage - Pompe à chaleur"
	//"Chauffage - Climatiseur - Climatiseur mobile"
	//"Chauffage - Climatiseur - Accessoire"
	//"Chauffage - Raccordement au gaz - Accessoire"
	//"Chauffage - Raccordement au gaz - Flexible"
	//"Chauffage - Radiateur électrique - Rayonnant"
	//"Chauffage - Radiateur électrique - Convecteur"
	//"Chauffage - Radiateur électrique - Inertie"
	//"Chauffage - Radiateur électrique - Accessoire"
	//"Chauffage - Radiateur électrique - Sèche-serviettes"
	//"Chauffage - Radiateur à eau chaude"
	//"Chauffage - Radiateur à eau chaude - Accessoire"
	//"Chauffage - Radiateur à eau chaude - Robinet"
	//"Chauffage - Radiateur à eau chaude - Sèche-serviettes"
	//"Chauffage - Radiateur chauffage centrale"
	//"Chauffage - Plancher chauffant - Accessoire"
	//"Chauffage - Combustible et allumage"
	//"Chauffage - Combustible et allumage - Allumage"
	//"Chauffage - Production d'énergie et de chauffage renouvelable - Chauffe-eau thermodynamique"
	//"Chauffage - Aérateur - Thermomètre"
	//"Chauffage - Aérateur - VMC"
	//"Chauffage - Aérateur"
	//"Chauffage - Aérateur - Conduit"
	//"Chauffage - Aérateur - Accessoire"
	//"Plomberie - Adoucisseur - Adoucisseur d'eau"
	//"Plomberie - Adoucisseur - Adoucisseur d'eau - Sel"
	//"Plomberie - Adoucisseur - Adoucisseur d'eau - Eau de boisson"
	//"Plomberie - Adoucisseur - Adoucisseur d'eau - Eau de boisson - Accessoire"
	//"Plomberie - Adoucisseur - Adoucisseur d'eau - Accessoire"
	//"Plomberie - Adoucisseur - Station et filtre - Anti-calcaire/anti-tartre - Cartouche"
	//"Plomberie - Adoucisseur - Station et filtre - Anti-calcaire/anti-tartre - Accessoire"
	//"Plomberie - Adoucisseur - Station et filtre - Eau de pluie"
	//"Plomberie - Adoucisseur - Station et filtre - Filtre réfrigérateur américain"
	//"Plomberie - Robinet - Accessoire"
	//"Plomberie - Robinet - Flexible et douchette"
	//"Plomberie - Robinet - Mousseur et brise-jet robinet"
	//"Plomberie - Robinet - Raccord"
	//"Plomberie - Robinet - Robinet à entraxe spécial"
	//"Plomberie - Robinet - Bec et raccord bec"
	//"Plomberie - Robinet - Colonnette"
	//"Plomberie - Robinet - Tête de robinet, cartouche et croisillon"
	//"Plomberie - Chauffe-eau et ballon d'eau chaude - Electrique - Instantanée"
	//"Plomberie - Chauffe-eau et ballon d'eau chaude - Electrique"
	//"Plomberie - Chauffe-eau et ballon d'eau chaude - Electrique - Accessoire"
	//"Plomberie - Alimention en eau - Lave-linge/vaiselle"
	//"Plomberie - Alimention en eau - Etanchéité"
	//"Plomberie - Alimention en eau - Raccord"
	//"Plomberie - Alimention en eau - Flexible"
	//"Plomberie - Alimention en eau - Platine de fixation"
	//"Plomberie - Alimention en eau - Joint"
	//"Plomberie - Alimention en eau - Clapet"
	//"Plomberie - Alimention en eau - Tube"
	//"Plomberie - Evacuation des eaux usées - Vidage - Douche"
	//"Plomberie - Evacuation des eaux usées - Vidage - Lavabo"
	//"Plomberie - Evacuation des eaux usées - Vidage - Accessoire"
	//"Plomberie - Evacuation des eaux usées - Trappe de visite"
	//"Plomberie - WC - Chasse d'eau - Robinet flotteur"
	//"Cuisine - Meuble"
	//"Cuisine - Meuble - Equipement"
	//"Cuisine - Meuble - Intérieur"
	//"Cuisine - Meuble - Accessoire"
	//"Cuisine - Meuble - Poignées et boutons"
	//"Cuisine - Carrelage"
	//"Cuisine - Plan de travail - Accessoire"
	//"Cuisine - Plan de travail"
	//"Cuisine - Crédence"
	//"Cuisine - Crédence - Accessoire"
	//"Cuisine - Rangement - Accessoire"
	//"Cuisine - Rangement - Range-couverts"
	//"Cuisine - Rangement - Tapis fond de tiroir"
	//"Cuisine - Evier"
	//"Cuisine - Evier - Accessoire"
	//"Cuisine - Evier - Robinet"
	//"Cuisine - Kitchenette"
	//"Cuisine - Eclairage"
	//"Cuisine - Etagère"
	//"Cuisine - Poubelle"
	//"Cuisine - Livres"
	//"Cuisine - Chaise - Tabouret"
	//"Cuisine - Electroménager - Hotte"
	//"Cuisine - Electroménager - Four micro-ondes"
	//"Cuisine - Electroménager - Réfrigérateur"
	//"Cuisine - Electroménager - Congélateur"
	//"Cuisine - Electroménager - Lave linge"
	//"Cuisine - Electroménager - Four"
	//"Cuisine - Electroménager - Four encastrable"
	//"Cuisine - Electroménager - Lave-vaisselle"
	//"Cuisine - Electroménager - Plaque de cuisson"
	//"Cuisine - Electroménager - Plaque de cuisson - Vitrocéramique"
	//"Décoration - Coussin - Chaise"
	//"Décoration - Coussin - Décoratif"
	//"Décoration - Coussin - Sol"
	//"Décoration - Coussin - Housse"
	//"Décoration - Coussin - Plaid"
	//"Décoration - Coussin"
	//"Décoration - Rideau"
	//"Décoration - Rideau - Tringle - Sans perçage"
	//"Décoration - Rideau - Tringle - Barre de vitrage"
	//"Décoration - Rideau - Tringle - Lucarne"
	//"Décoration - Rideau - Brise-bise"
	//"Décoration - Rideau - Vitrage"
	//"Décoration - Rideau - Tringle à rideau - A composer"
	//"Décoration - Rideau - Tringle à rideau - A composer - Accessoire"
	//"Décoration - Rideau - Tringle à rideau - A composer - Support"
	//"Décoration - Rideau - Tringle à rideau - Kit"
	//"Décoration - Rideau - Oeillet"
	//"Décoration - Rideau - Voilage"
	//"Décoration - Rideau - Accessoire"
	//"Décoration - Store - Accesoires"
	//"Décoration - Store - Panneaux japonais"
	//"Décoration - Store - Store enrouleur"
	//"Décoration - Voilage"
	//"Décoration - Livre"
	//"Décoration - Papier peint - Colle"
	//"Décoration - Papier peint - Décolleur"
	//"Décoration - Papier peint"
	//"Décoration - Papier peint - Frise"
	//"Décoration - Papier peint - Fibre de verre"
	//"Décoration - Stickers, affiche et toile - Affiche, poster"
	//"Décoration - Stickers, affiche et toile - Cadre"
	//"Décoration - Stickers, affiche et toile - Lettre"
	//"Décoration - Stickers, affiche et toile - Miroir"
	//"Décoration - Stickers, affiche et toile - Sticker"
	//"Décoration - Moulure - Dalle de plafond"
	//"Eclairage - Ampoule LED"
	//"Eclairage - Ampoule LED - Tube"
	//"Eclairage - Extérieur"
	//"Eclairage - Extérieur - Lampadaire"
	//"Eclairage - Extérieur - Solaire"
	//"Eclairage - Extérieur - Terrasse - Borne"
	//"Eclairage - Extérieur - Terrasse - Suspension"
	//"Eclairage - Extérieur - Terrasse - Spot encastré"
	//"Eclairage - Extérieur - Terrasse - Applique"
	//"Eclairage - Intérieur - Salle de bain"
	//"Eclairage - Intérieur - Applique murale"
	//"Eclairage - Intérieur - Accessoire"
	//"Eclairage - Intérieur - Cuisine"
	//"Eclairage - Intérieur - Spot"
	//"Eclairage - Intérieur - Spot - Encastrable"
	//"Eclairage - Intérieur - Plafonnier"
	//"Eclairage - Intérieur - Dressing"
	//"Eclairage - Intérieur - Lustre"
	//"Eclairage - Intérieur - Suspension"
	//"Eclairage - Intérieur - Lampe de chevet"
	//"Eclairage - Intérieur - Lampe de salon"
	//"Eclairage - Intérieur - Applique murale"
	//"Eclairage - Intérieur - Pied de lampe"
	//"Peinture - Intérieur - Bois"
	//"Electricité - Câbles - Fils"
	//"Electricité - Câbles - Gaîne ICTA"
	//"Electricité - Câbles - Fixation"
	//"Electricité - Câbles - Gaine préfilée"
	//"Electricité - Câbles - IRL"
	//"Electricité - Moulure"
	//"Electricité - Plinthe"
	//"Electricité - Goulotte"
	//"Electricité - Livre"
	//"Electricité - Domotique - Appareil connecté"
	//"Electricité - Domotique - Box et kit"
	//"Electricité - Domotique - Lumière"
	//"Electricité - Domotique - Accessoire"
	//"Electricité - Domotique - Porte de garage"
	//"Electricité - Domotique - Chauffage"
	//"Electricité - Tableau - Autres"
	//"Electricité - Tableau - Disjoncteur"
	//"Electricité - Tableau - Disjoncteur - Différenciel"
	//"Electricité - Tableau - Coupe-circuit"
	//"Electricité - Tableau - Para-foudre"
	//"Electricité - Tableau - Bornier / peigne"
	//"Electricité - Tableau - Nu"
	//"Electricité - Tableau - GTL"
	//"Electricité - Tableau - Pré-équipé"
	//"Electricité - Alarme maison - Sans fil"
	//"Electricité - Alarme maison - Caméra"
	//"Electricité - Alarme maison - Accessoire"
	//"Electricité - Alarme maison - Détecteur de mouvement et de lumière"
	//"Electricité - Alarme maison - Détecteur de fumée, monoxyde de carbone et gaz"
	//"Electricité - Antenne - Accessoire"
	//"Electricité - Antenne - Connectique audio et vidéo"
	//"Electricité - Antenne - Satellite"
	//"Electricité - Antenne - Alimentation"
	//"Electricité - Antenne - Décodeur TNT"
	//"Electricité - Antenne - Télécommande universelle"
	//"Electricité - Antenne - Décodeur satellite"
	//"Electricité - Antenne - CPL"
	//"Electricité - Interrupteur / Prise - Adaptateur de voyage"
	//"Electricité - Interrupteur / Prise - Encastrable"
	//"Electricité - Interrupteur / Prise - Composable"
	//"Electricité - Interrupteur / Prise - Multiprise"
	//"Electricité - Interrupteur / Prise - Etanche"
	//"Electricité - Motorisation - Accessoire"
	//"Electricité - Motorisation - Portail"
	//"Electricité - Motorisation - Volet"
	//"Electricité - Motorisation - Interphone"
	//"Electricité - Motorisation - Garage"
	//"Electricité - Motorisation - Visiophone"
	//"Electricité - Motorisation - SOMFY"
	//"Electricité - Motorisation - SOMFY - Accesoire"
	//"Electricité - Motorisation - SOMFY - Portail"
	//"Electricité - Motorisation - SOMFY - Garage"
	//"Electricité - Rallonge - Boite de dérivation - Domino borne"
	//"Electricité - Rallonge - Boite de dérivation - Accessoire"
	//"Electricité - Rallonge - Boite de dérivation"
	//"Electricité - Rallonge - Boite de dérivation"
	//"Electricité - Rallonge - Enrouleur"
	//"Electricité - Rallonge - Appareil de mesure"
	//"Electricité - Rallonge"
	//"Electricité - Lampe torche - Douille"
	//"Electricité - Lampe torche - Chargeur"
	//"Electricité - Lampe torche - Pile"
	//"Electricité - Lampe torche"
	//"Electricité - Lampe torche - Variateur"
	//"Jardin - Accesoire"
	//"Jardin - Balustrades"
	//"Jardin - Terrasse - Produits"
	//"Jardin - Terrasse - Carrelage"
	//"Jardin - Terrasse - Dalle"
	//"Jardin - Terrasse - Lame"
	//"Jardin - Terrasse - Bordure"
	//"Jardin - Terrasse - Composite"
	//"Jardin - Terrasse - Pose et entretien"
	//"Jardin - Terrasse - Bois - Pose et entretien"
	//"Jardin - Terrasse - Pose et entretien"
	//"Jardin - Portail - Décoration"
	//"Jardin - Portail - Battants"
	//"Jardin - Portail - Battants - Aluminium"
	//"Jardin - Portail - Battants - Bois"
	//"Jardin - Portail - Battants - Fer"
	//"Jardin - Portail - Battants - PVC"
	//"Jardin - Portail - Portillon"
	//"Jardin - Portail - Portillon - Aluminium"
	//"Jardin - Portail - Coulissant"
	//"Jardin - Portail - Coulissant - Aluminium"
	//"Jardin - Store - Banne"
	//"Jardin - Parasol"
	//"Jardin - Parasol - Accessoire"
	//"Jardin - Escalier"
	//"Jardin - Tonnelle"
	//"Jardin - Tonnelle - Voile d'ombrage"
	//"Jardin - Toit terrasse"
	//"Jardin - Clôture"
	//"Jardin - Clôture - A composer"
	//"Jardin - Clôture - Brise vue"
	//"Jardin - Clôture - Brise vent"
	//"Jardin - Clôture - Canisse"
	//"Jardin - Clôture - Occulation"
	//"Jardin - Clôture - Panneaux"
	//"Jardin - Clôture - Panneaux - Bois"
	//"Jardin - Clôture - Travée"
	//"Jardin - Clôture - Poteau"
	//"Jardin - Clôture - Grillage"
	//"Jardin - Clôture - Grillage - Rigide"
	//"Jardin - Clôture - Grillage - Animaux"
	//"Jardin - Abri"
	//"Jardin - Livre"
	//"Jardin - Abri - Accessoire"
	//"Jardin - Abri - Kiosque"
	//"Jardin - Abri - Pergola"
	//"Jardin - Abri - Treillage"
	//"Jardin - Abri - Rangement"
	//"Jardin - Abri - Abri de jardin"
	//"Jardin - Abri - Coffre de jardin"
	//"Jardin - Abri - Garage"
	//"Jardin - Abri - Carport"
	//"Jardin - Barbecue - Accessoire"
	//"Jardin - Barbecue"
	//"Jardin - Barbecue - Robinet"
	//"Jardin - Barbecue - Fixe"
	//"Jardin - Barbecue - Four à pizza"
	//"Jardin - Barbecue - Combustible"
	//"Jardin - Barbecue - Cuisine extérieure"
	//"Jardin - Barbecue - Grilloir"
	//"Jardin - Barbecue - Fumoir"
	//"Jardin - Barbecue - Plancha"
	//"Jardin - Barbecue - Bouteille de gaz"
	//"Jardin - Barbecue - Accessoire"
	//"Jardin - Mobilier - Chauffage"
	//"Jardin - Mobilier - Chaise"
	//"Jardin - Mobilier - Fauteuil"
	//"Jardin - Mobilier - Entretien"
	//"Jardin - Mobilier - Salon"
	//"Jardin - Mobilier - Salon - Détente"
	//"Jardin - Mobilier - Salon - Jardin"
	//"Jardin - Mobilier - Table"
	//"Jardin - Mobilier - Pouf"
	//"Jardin - Mobilier - Banc"
	//"Jardin - Mobilier - Coussin"
	//"Jardin - Mobilier - Hamac / Balancelle"
	//"Jardin - Mobilier - Bain de soleil"
	//"Jardin - Fontaine"
	//"Jardin - Fontaine - Cascade"
	//"Jardin - Fontaine - Bassin"
	//"Jardin - Fontaine - Bassin - Accessoire"
	//"Jardin - Semence - Gazon"
	//"Jardin - Semence - Gazon - Artificiel"
	//"Jardin - Semence - Florale"
	//"Jardin - Semence - Potagère"
	//"Jardin - Serre - Plante"
	//"Jardin - Serre - Accessoire"
	//"Jardin - Serre - Potager"
	//"Jardin - Serre - Composteur"
	//"Jardin - Serre - Terreau"
	//"Jardin - Serre"
	//"Jardin - Serre - Traitement contre les insectes"
	//"Jardin - Serre - Paillage"
	//"Jardin - Serre - Jardinière"
	//"Jardin - Serre - Pot"
	//"Jardin - Serre - Film de protection"
	//"Jardin - Serre - Tunnel de culture"
	//"Jardin - Outil - Pelle et pioche"
	//"Jardin - Outil - Déneigeuse"
	//"Jardin - Outil - Motobineuse / Motoculteur"
	//"Jardin - Outil - Bûche"
	//"Jardin - Outil - Souffleur"
	//"Jardin - Outil - Aspirateur"
	//"Jardin - Outil - Broyeux végétaux"
	//"Jardin - Outil - Tondeuse - Autoportée"
	//"Jardin - Outil - Tondeuse - Sans fil"
	//"Jardin - Outil - Tondeuse - Electique"
	//"Jardin - Outil - Tondeuse - Essence"
	//"Jardin - Outil - Débroussailleuse"
	//"Jardin - Outil - Taille haie"
	//"Jardin - Outil - Tronçonneuse"
	//"Jardin - Outil - Sac"
	//"Jardin - Outil - Coupe-bordure"
	//"Jardin - Outil - Nettoyeur haute pression"
	//"Jardin - Outil - Nettoyeur haute pression - Accessoire"
	//"Jardin - Outil - Perceuse - Sans fil"
	//"Jardin - Piscine - SPA"
	//"Jardin - Piscine - SPA - Gonflage"
	//"Jardin - Piscine - Sauna"
	//"Jardin - Piscine - Cloture"
	//"Jardin - Piscine - Bâche à bulle"
	//"Jardin - Piscine"
	//"Jardin - Piscine - Douche"
	//"Jardin - Piscine - Echelle"
	//"Jardin - Piscine - Nettoyage"
	//"Jardin - Piscine - Filtration"
	//"Jardin - Piscine - Traitement"
	//"Jardin - Piscine - Accessoire"
	//"Jardin - Revêtement - Gravillon"
	//"Jardin - Revêtement - Galet"
	//"Jardin - Revêtement - Pas japonais"
	//"Jardin - Jeu d'enfant - Maisonnette"
	//"Jardin - Jeu d'enfant - Portique"
	//"Jardin - Jeu d'enfant - Balançoire"
	//"Jardin - Jeu d'enfant - Bac à sable"
	//"Jardin - Jeu d'enfant - Dalle de sécurité"
	//"Jardin - Arrosage - Pulvérisateur"
	//"Jardin - Arrosage - Programmateur"
	//"Jardin - Arrosage - Récupérateur eau de pluie"
	//"Jardin - Arrosage - Tuyau"
	//"Jardin - Arrosage - Tuyau - Enrouleur"
	//"Jardin - Peinture - Sol"
	//"Jardin - Vêtement - Gant"

	public List<Category> getCategories() {
		return categories;
	}
}
