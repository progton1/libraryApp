package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SearchResultModel{
	
	String titleSearch, authorSearch, countrySearch, subjectSearch = null;
	
	Book books;
	PreparedStatement statement;	
	ResultSet rs;
	ObservableList<Book> bookList = FXCollections.observableArrayList();
	
	Connection connection;
	
//	public PreparedStatement getBooks(String titleSearch) {
//		
//		Connection connection = SqlConnection.Connector();
//		
//		try {
//			String sql = 	"SELECT title, last_name, country, ämnesord FROM media\r\n" + 
//							"JOIN author_or_director ON author_or_director.author_id = media.fk_author_or_director_id\r\n" + 
//							"JOIN book ON book.book_id = media.fk_book_id WHERE title ILIKE ?";
//			
//			statement = connection.prepareStatement(sql);
//			statement.setString(1,"%"+titleSearch+"%");
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return statement;
//	}
	
	public PreparedStatement getBooks(String titleSearch, String authorSearch, String countrySearch, String subjectSearch) {
		this.titleSearch = titleSearch;
		this.authorSearch = authorSearch;
		this.countrySearch = countrySearch;
		this.subjectSearch = subjectSearch;
		
//		titleSearch = null;
//		authorSearch = null;
//		countrySearch = null;
//		subjectSearch = null;
		
		Connection connection = SqlConnection.Connector();
		
		try {
			String sql = 	"SELECT title, last_name, country, ämnesord FROM media\r\n" + 
							"JOIN author_or_director ON author_or_director.author_id = media.fk_author_or_director_id\r\n" + 
							"JOIN book ON book.book_id = media.fk_book_id \r\n" + 
							"WHERE title ILIKE ? AND last_name ILIKE ? AND country ILIKE ? AND ämnesord ILIKE ?";
									
			
			statement = connection.prepareStatement(sql);
//			statement.setString(1,"%"+titleSearch+"%");
			statement.setString(1, "%"+titleSearch+"%");
			statement.setString(2, "%"+authorSearch+"%");
			statement.setString(3, "%"+countrySearch+"%");
			statement.setString(4, "%"+subjectSearch+"%");
//			statement.setString(5, titleSearchTwo);
//			statement.setString(6, authorSearchTwo);
//			statement.setString(7, countrySearchTwo);
			
//			rs = statement.executeQuery();
//			
//	while(rs.next()) {
//		bookList.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
//	}	
//			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statement;
	}
	
//	public PreparedStatement getAuthors(String authorSearch) {
//		
//		Connection connection = SqlConnection.Connector();
//		
//		try {
//			String sql = 	"SELECT title, last_name, country, ämnesord FROM media\r\n" + 
//							"JOIN author_or_director ON author_or_director.author_id = media.fk_author_or_director_id\r\n" + 
//							"JOIN book ON book.book_id = media.fk_book_id WHERE last_name ILIKE ?";
//			
//			statement = connection.prepareStatement(sql);
//			statement.setString(1,"%"+authorSearch+"%");
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return statement;
//	}
		
	public ObservableList<Book> printBooks() {
		
		try {	
			rs = statement.executeQuery();
			
	while(rs.next()) {
		bookList.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
	}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookList;
	}

}
