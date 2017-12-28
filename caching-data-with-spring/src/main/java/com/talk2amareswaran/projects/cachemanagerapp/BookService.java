package com.talk2amareswaran.projects.cachemanagerapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	BookDAO bookDAO;

	public List<String> getSupportedLanguages() {
		return bookDAO.getSupportedLanguages();
	}

	public List<Book> getBooks() {
		return bookDAO.getBooks();
	}

}
