package com.gcit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.gcit.domain.Author;
@Component
public class AuthorDAO extends BaseDAO {

	public void insert(Author author) throws SQLException {
		PreparedStatement prepareStatement = getConnection().prepareStatement("INSERT INTO `library`.`tbl_author` (`authorId`, `authorName`) VALUES (?, ?)");
		prepareStatement.setInt(1, author.getAuthorId());
		prepareStatement.setString(2, author.getAuthorName());
		prepareStatement.executeUpdate();
	}

	public void update(Author author) throws SQLException {
		PreparedStatement prepareStatement = getConnection().prepareStatement("UPDATE `library`.`tbl_author` SET `authorName`=? WHERE `authorId`=?");
		prepareStatement.setString(1, author.getAuthorName());
		prepareStatement.setInt(2, author.getAuthorId());
		prepareStatement.executeUpdate();
	}

	public void delete(int authorId) throws SQLException {
		PreparedStatement prepareStatement = getConnection().prepareStatement("DELETE FROM `library`.`tbl_author` WHERE `authorId`=?");
		prepareStatement.setInt(1, authorId);
		prepareStatement.executeUpdate();
	}

	public Author readOne(int authorId) throws SQLException {
		PreparedStatement prepareStatement = getConnection().prepareStatement("SELECT * FROM library.tbl_author where authorId=?");
		prepareStatement.setInt(1, authorId);
		ResultSet resultSet = prepareStatement.executeQuery();
		Author author= new Author();
		while(resultSet.next()){
			author.setAuthorId(resultSet.getInt("authorId"));
			author.setAuthorName(resultSet.getString("authorName"));
		}
		return author;
	}

	

	public List<Author> readAll() throws SQLException {
		PreparedStatement prepareStatement = getConnection().prepareStatement("SELECT * FROM library.tbl_author");
		ResultSet resultSet = prepareStatement.executeQuery();
		List<Author> authorList = new ArrayList<Author>();
		while(resultSet.next()){
			Author author= new Author();
			author.setAuthorId(resultSet.getInt("authorId"));
			author.setAuthorName(resultSet.getString("authorName"));
			authorList.add(author);
		}
		return authorList;
	}

	
}
