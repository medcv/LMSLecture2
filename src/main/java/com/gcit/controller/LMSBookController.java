package com.gcit.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.dao.BookDAO;
import com.gcit.domain.Book;

@RestController
public class LMSBookController {

	@Autowired
	BookDAO bookDao;
	@RequestMapping("/books/{bookId}")
	public Book getBook(@PathVariable(value = "bookId") int bookId) throws SQLException {
		return bookDao.selectById(bookId);
	}
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public List<Book> getBooks() throws SQLException {
		return bookDao.readAll();
	}

	@RequestMapping(value = "/books/{bookId}", method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable(value = "bookId") int bookId) throws SQLException {
		bookDao.delete(bookId);
	}

	@RequestMapping(value = "/book", method = RequestMethod.PUT)
	public void updateBook(@RequestBody Book book, Locale locale, Model model) throws SQLException {
		bookDao.update(book);
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public void addBook(@RequestBody Book book, Locale locale, Model model) throws SQLException {
		bookDao.insert(book);
	}
}
