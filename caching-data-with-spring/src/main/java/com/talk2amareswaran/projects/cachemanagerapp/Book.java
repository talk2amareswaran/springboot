package com.talk2amareswaran.projects.cachemanagerapp;

import java.util.ArrayList;
import java.util.List;

public class Book {

	private String id;
	private String name;
	private String author;
	private String price;
	private List<String> supportedLanguages = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<String> getSupportedLanguages() {
		return supportedLanguages;
	}

	public void setSupportedLanguages(List<String> supportedLanguages) {
		this.supportedLanguages = supportedLanguages;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
