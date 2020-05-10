package application;
	
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/chooseMediaType.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws ParseException {
		
//		BookModel book = new BookModel();
//		RegistrationModel rm = new RegistrationModel();
//		ItemModel im = new ItemModel();
//		AddBookController bc = new AddBookController();
//		String kl = bc.dateMaker("1992", "12", "17");
//		System.out.println(kl);
//		try {
//			rm.registration("Big", "Guy", "555-HOT-TAKES", "bigguy@bigguy.com", 1, "aligator6");
//			rm.insertNewAccount();
//			book.registration("Tommy", "Tuta", "0705678904", "tommy@tutar.com", 1, "aligator9");
//			book.insertNewAccount();
//			book.addBookAndAuthor("Margarin",false,false,"Göran", "Persson");
//			book.addTitle("Margarinboken", "En bok om margarin", "Sverige", 30, "1992-12-17");
//			book.insertNewMediaTitle();
//			im.addItem("73186904040");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
			launch(args);
		}
		
	}


