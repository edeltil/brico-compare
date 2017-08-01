package com.brico.compare.entity;

/**
 * Created by edeltil on 17/03/2017.
 */
public enum Seller {
	BM("BricoMarché"),
	BD("BricoDépôt"),
	Casto("Castorama"),
	Lapeyre("Lapeyre"),
	LM("Leroy Merlin"),
	Vial("Vial");

	private String label;

	Seller(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
