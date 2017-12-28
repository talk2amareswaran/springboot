package com.talk2amareswaran.projects.cachemanagerapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {

	@Autowired
	BookService bookService;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public List<Book> getBooks() {
		List<Book> list = bookService.getBooks();
		for (Book book : list) {
			book.setSupportedLanguages(bookService.getSupportedLanguages());
		}
		return list;
	}
	
	@RequestMapping(value="/cache")
	@CacheEvict(value="languages", allEntries=true)
	public String clearCache() {
		return "Cache is cleared successfully";
	}

}
