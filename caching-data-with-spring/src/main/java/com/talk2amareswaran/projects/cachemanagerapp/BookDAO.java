package com.talk2amareswaran.projects.cachemanagerapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Cacheable(value="languages")
	public List<String> getSupportedLanguages() {
		System.out.println("Fetching from the database table..."+new Date());
		List<String> languages = new ArrayList<>();
		String sql = "SELECT LANGUAGE FROM LANGUAGES";
		Collection<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		rows.stream().forEach((row) -> {
			languages.add((String) row.get("LANGUAGE"));
		});
		return languages;
	}

	public List<Book> getBooks() {
		List<Book> bookslist = new ArrayList<>();
		String sql = "SELECT * FROM BOOKS";
		Collection<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		rows.stream().forEach((row) -> {
			Book book = new Book();
			book.setAuthor((String) row.get("AUTHOR"));
			book.setId(String.valueOf(row.get("ID")));
			book.setName((String) row.get("NAME"));
			book.setPrice((String) row.get("PRICE"));
			bookslist.add(book);
		});
		return bookslist;
	}

}
