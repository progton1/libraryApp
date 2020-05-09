package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookModel extends MediaTitleModel{
	
	Connection connection;
	PreparedStatement preparedStatement;





	
	
	
	

	@Override
	public void addTitle(String title,
			String releaseYear, String desc) {
		// TODO Auto-generated method stub
		
	}
	
		public void addTitle(String title, String desc, String country, int rentalDuration,
							String subject, boolean courseLit, boolean refLit, String authorFirstName, String authorLastName ) throws SQLException {
	
			
				String sqlMedia 	= "INSERT INTO book(ämnesord, referenslitteratur,kurslitteratur) VALUES(?,?,?);"
									+ "INSERT INTO author_or_director(first_name,last_name) VALUES(?,?);"
									+ "INSERT INTO media(title, country, description,rental_duration,fk_book_id, fk_author_or_director_id)" 
									+ "VALUES (?,?,?,?,currval('book_book_id_seq'),currval('author_or_director_author_id_seq'));";

				preparedStatement = connection.prepareStatement(sqlMedia);
				
				preparedStatement.setString(1, subject);
				preparedStatement.setBoolean(2, refLit);
				preparedStatement.setBoolean(3, courseLit);
				preparedStatement.setString(4, authorFirstName);
				preparedStatement.setString(5, authorLastName);
				preparedStatement.setString(6, title);
				preparedStatement.setString(7, country);
				preparedStatement.setString(8, desc);
				preparedStatement.setInt(9, rentalDuration);

									
			}
			
		
				
			public void addItem(String barcode) throws SQLException {
					
				String sqlItem		= "INSERT INTO inventory_item(barcode,fk_media_id)"
									+ "VALUES('7318905467',currval('media_media_id_seq'));";
				preparedStatement = connection.prepareStatement(sqlItem);
				
				preparedStatement.setString(1, barcode);
				
					
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
