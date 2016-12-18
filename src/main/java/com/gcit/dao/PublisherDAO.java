package com.gcit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gcit.domain.Publisher;
@Component
public class PublisherDAO extends BaseDAO {

	public void insert(Publisher publisher) throws SQLException {
		PreparedStatement prepareStatement = getConnection().prepareStatement(
				"INSERT INTO `library`.`tbl_publisher` (`publisherId`, `publisherName`, `publisherAddress`, `publisherPhone`) VALUES (?, ?, ?, ?)");
				
		prepareStatement.setInt(1, publisher.getPublisherId());
		prepareStatement.setString(2, publisher.getPublisherName());
		prepareStatement.setString(3, publisher.getAddress());
		prepareStatement.setString(4, publisher.getPhone());
		prepareStatement.executeUpdate();
	}

	public void update(Publisher publisher) throws SQLException {
		PreparedStatement prepareStatement = getConnection().prepareStatement(
				"UPDATE `library`.`tbl_publisher` SET   `publisherName`=?, `publisherAddress`=?, `publisherPhone`=? where `publisherId`=?");
		prepareStatement.setString(1, publisher.getPublisherName());
		prepareStatement.setString(2, publisher.getAddress());
		prepareStatement.setString(3, publisher.getPhone());
		prepareStatement.setInt(4, publisher.getPublisherId());
		prepareStatement.executeUpdate();
	}

	public void delete(int publisherId) throws SQLException {
		PreparedStatement prepareStatement = getConnection()
				.prepareStatement("DELETE FROM `library`.`tbl_publisher` WHERE `publisherId`=?");
		prepareStatement.setInt(1, publisherId);
		prepareStatement.executeUpdate();
	}

	public Publisher readOne(int publisherId) throws SQLException {
		PreparedStatement prepareStatement = getConnection()
				.prepareStatement("SELECT * FROM library.tbl_publisher WHERE publisherId=?");
		prepareStatement.setInt(1, publisherId);
		ResultSet resultSet = prepareStatement.executeQuery();
		Publisher publisher = new Publisher();
		while (resultSet.next()) {
			publisher.setAddress(resultSet.getString("PublisherAddress"));
			publisher.setPhone(resultSet.getString("publisherPhone"));
			publisher.setPublisherId(resultSet.getInt("publisherId"));
			publisher.setPublisherName(resultSet.getString("publisherName"));
		}
		return publisher;
	}

	public List<Publisher> readAll() throws SQLException {
		PreparedStatement prepareStatement = getConnection()
				.prepareStatement("SELECT * FROM library.tbl_publisher");
		ResultSet resultSet = prepareStatement.executeQuery();
		List<Publisher> publisherList = new ArrayList<Publisher>();
		while (resultSet.next()) {
			Publisher publisher = new Publisher();
			publisher.setAddress(resultSet.getString("PublisherAddress"));
			publisher.setPhone(resultSet.getString("publisherPhone"));
			publisher.setPublisherId(resultSet.getInt("publisherId"));
			publisher.setPublisherName(resultSet.getString("publisherName"));
			publisherList.add(publisher);
		}
		return publisherList;
	}
}
