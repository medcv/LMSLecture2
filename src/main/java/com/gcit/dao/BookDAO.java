package com.gcit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gcit.domain.Book;

@Component
public class BookDAO extends BaseDAO {

	public void insert(Book book) throws SQLException {
		PreparedStatement prepareStatement = getConnection().prepareStatement(
				"INSERT INTO `library`.`tbl_book` (`bookId`, `title`, `authId`, `pubId`) VALUES (?,?,?,?)");
		prepareStatement.setInt(1, book.getBookId());
		prepareStatement.setString(2, book.getTitle());
		prepareStatement.setInt(3, book.getAuthorId());
		prepareStatement.setInt(4, book.getPublisherId());
		prepareStatement.executeUpdate();
	}

	public void update(Book book) throws SQLException {
		PreparedStatement prepareStatement = getConnection()
				.prepareStatement("UPDATE `library`.`tbl_book` SET `title`=?, `authId`=?, `pubId`=? WHERE `bookId`=?");
		prepareStatement.setString(1, book.getTitle());
		prepareStatement.setInt(2, book.getAuthorId());
		prepareStatement.setInt(3, book.getPublisherId());
		prepareStatement.setInt(4, book.getBookId());
		prepareStatement.executeUpdate();
	}

	public void delete(int bookId) throws SQLException {
		PreparedStatement prepareStatement = getConnection()
				.prepareStatement("DELETE FROM `library`.`tbl_book` WHERE `bookId`=?");
		prepareStatement.setInt(1, bookId);
		prepareStatement.executeUpdate();
	}

	public Book selectById(int bookId) throws SQLException {
		PreparedStatement prepareStatement = getConnection()
				.prepareStatement("SELECT * FROM library.tbl_book WHERE bookId=?");
		prepareStatement.setInt(1, bookId);
		ResultSet resultSet = prepareStatement.executeQuery();
		Book book = new Book();
		while (resultSet.next()) {
			book.setAuthorId(resultSet.getInt("authId"));
			book.setBookId(resultSet.getInt("bookId"));
			book.setPublisherId(resultSet.getInt("pubId"));
			book.setTitle(resultSet.getString("title"));
		}
		return book;
	}

	public List<Book> readAll() throws SQLException {
		PreparedStatement prepareStatement = getConnection().prepareStatement("SELECT * FROM library.tbl_book");
		ResultSet resultSet = prepareStatement.executeQuery();
		List<Book> bookList = new ArrayList<Book>();
		while (resultSet.next()) {
			Book book = new Book();
			book.setAuthorId(resultSet.getInt("authId"));
			book.setBookId(resultSet.getInt("bookId"));
			book.setPublisherId(resultSet.getInt("pubId"));
			book.setTitle(resultSet.getString("title"));

			bookList.add(book);
		}
		return bookList;
	}

}
