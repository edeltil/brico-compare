package com.brico.compare.parser;

/**
 * Created by edeltil on 28/07/2017.
 */
public abstract class AbstractParser extends Parser {

	protected String host;

	public AbstractParser(String directory, String path, String host) {
		super(directory, path);
		this.host = host;
	}
}
