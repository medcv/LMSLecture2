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

import com.gcit.dao.PublisherDAO;
import com.gcit.domain.Publisher;

@RestController
public class LMSPublisherController {

	@Autowired
	PublisherDAO publisherDao;
	@RequestMapping("/publishers/{publisherId}")
	public Publisher getPublisher(@PathVariable(value = "publisherId") int publisherId) throws SQLException {
		return publisherDao.readOne(publisherId);
	}

	@RequestMapping(value = "/publishers", method = RequestMethod.GET)
	public List<Publisher> getPublishers() throws SQLException {
		return publisherDao.readAll();
	}

	@RequestMapping(value = "/publishers/{publisherId}", method = RequestMethod.DELETE)
	public void deletePublisher(@PathVariable(value = "publisherId") int publisherId) throws SQLException {
		publisherDao.delete(publisherId);
	}

	@RequestMapping(value = "/publisher", method = RequestMethod.PUT)
	public void updatePublisher(@RequestBody Publisher publisher, Locale locale, Model model) throws SQLException {
		publisherDao.update(publisher);
	}

	@RequestMapping(value = "/publisher", method = RequestMethod.POST)
	public void addPublisher(@RequestBody Publisher publisher, Locale locale, Model model) throws SQLException {
		publisherDao.insert(publisher);
	}
}
