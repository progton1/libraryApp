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
	
//	public String titleSearch;
	Book books;
	PreparedStatement statement;	
	ResultSet rs;
	ObservableList<Book> bookList = FXCollections.observableArrayList();
	
//	String titleSearch;
	
//	SearchBookController searchBookC = new SearchBookController();
	
//	SearchResultController searchRC = new SearchResultController();
	
//	SearchResultModel sRM = new SearchResultModel();
	
	Connection connection;
	

	
	public PreparedStatement getBooks(String titleSearch) {
//		this.titleSearch = titleSearch;
		
		Connection connection = SqlConnection.Connector();
		
		try {
			
			String sql = 	"SELECT title, last_name, country, ämnesord FROM media\r\n" + 
							"JOIN author_or_director ON author_or_director.author_id = media.fk_author_or_director_id\r\n" + 
							"JOIN book ON book.book_id = media.fk_book_id WHERE title = ?";
			
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, titleSearch);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return statement;

	}
	
//	public PreparedStatement setStri (String titleSearch) {
//		try {
//			statement.setString(1, titleSearch);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return statement;
//	}
	
//	public ResultSet searchOnTitle(String titleSearch) {
//		try {
//			
//			String sql = 	"SELECT title, last_name, country, ämnesord FROM media\r\n" + 
//							"JOIN author_or_director ON author_or_director.author_id = media.fk_author_or_director_id\r\n" + 
//							"JOIN book ON book.book_id = media.fk_book_id WHERE title = ?";
//			
//			statement = connection.prepareStatement(sql);
//			
//			statement.setString(1, titleSearch);
//			
//			rs = statement.executeQuery();
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} return rs;
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
