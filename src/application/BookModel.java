package application;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BookModel extends MediaTitleModel{
	
	
	
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet rs;
	
	public BookModel() {
		
		connection = SqlConnection.Connector();
		if (connection == null) {
			System.out.println("Connection failed.");
			System.exit(1);
		} 
		
	}
	
	@Override
	public void addTitle(String title,
			String releaseYear, String desc) {
		// TODO Auto-generated method stub
		
	}
	
		public boolean addBookAndAuthor(String subject, boolean refLit, boolean courseLit,
										String firstName, String lastName)  throws SQLException{
			
			try {
				String sql = "INSERT INTO book(ämnesord, referenslitteratur,kurslitteratur) "
							+ "VALUES(?,?,?);"
							+ "INSERT INTO author_or_director(first_name,last_name) "
							+ "VALUES(?,?);";
				
				preparedStatement = connection.prepareStatement(sql);
				
				preparedStatement.setString(1, subject);
				preparedStatement.setBoolean(2, refLit);
				preparedStatement.setBoolean(3, courseLit);
				preparedStatement.setString(4, firstName);
				preparedStatement.setString(5, lastName);
				
				preparedStatement.executeUpdate();
				
				return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}
		
		public String dateMaker(String year, String month, String day) {
			String date = (year+"-"+month+"-"+day);
			return date;
		}
		
	
	
		public boolean addTitle(String title, String desc, String country, int rentalDuration, String year, String month, String day) 
								throws SQLException, ParseException {
				
			
				try {
					
					String releaseDate = dateMaker(year, month, day);
					int authorID = getAuthorID();
					int bookID = getBookID();
					Date madeDate = convertToDate(releaseDate);
					String sqlFirst = ( "INSERT INTO media(title, country, description,rental_duration,release_date,fk_book_id, fk_author_or_director_id)" 
									+ "VALUES (?,?,?,?,?,?,?);");
					
					preparedStatement = connection.prepareStatement(sqlFirst);

					

					preparedStatement.setString(1, title);
					preparedStatement.setString(2, country);
					preparedStatement.setString(3, desc);
					preparedStatement.setInt(4, rentalDuration);
					preparedStatement.setDate(5, madeDate);
					preparedStatement.setInt(6, bookID);
					preparedStatement.setInt(7, authorID);
					
					preparedStatement.executeUpdate();
					
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}				
			}
		
//		public boolean insertNewMediaTitle() throws SQLException {
//			try {
//				preparedStatement.executeUpdate();
//				return true;
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return false;
//			}
//		}
			
	
			
			public int getBookID() throws SQLException {
				String query = "SELECT MAX(book_id) FROM book";
				
				preparedStatement = connection.prepareStatement(query);
				
//				preparedStatement.setString(1, subject);

				rs = preparedStatement.executeQuery();
				
				String bookID = null;
				while(rs.next()) {
					bookID = rs.getString(1);
				}
				if(!(bookID==null)) {
				int bID = Integer.parseInt(bookID);
				return bID;
				} else {
					return 0;
				}
			}
			
			public int getAuthorID() throws SQLException {
				String query = "SELECT MAX(author_id) FROM author_or_director;";
				
				
				preparedStatement = connection.prepareStatement(query);
				
//				preparedStatement.setString(1, firstName);
//				preparedStatement.setString(2, lastName);

				rs = preparedStatement.executeQuery();
				
				String authorID = null;
				while(rs.next()) {
					authorID = rs.getString(1);
				}
				if(!(authorID==null)) {
				int aID = Integer.parseInt(authorID);
				return aID;
				} else {
					return 0;
				}
			}
			
			public Date convertToDate(String stringWithDate) throws ParseException {
				java.sql.Date dDate =  new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(stringWithDate).getTime());
				return dDate;
			}

		
		
		
	
	

	@Override
	void removeTitle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void editTitle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void getMediaInfo() {
		// TODO Auto-generated method stub
		
	}

}
