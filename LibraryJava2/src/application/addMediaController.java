package application;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class addMediaController implements Initializable {
	
	BookModel book = new BookModel();
	
	@FXML
	private TextField title;
	
	@FXML 
	private TextField subject;
	
	@FXML 
	private TextField authorFirstName;
	
	@FXML 
	private TextField authorLastName;
	
	@FXML 
	private TextField releaseYear;
	
	@FXML 
	private TextField description;
	
	@FXML 
	private TextField itemAmount;
	
	@FXML
	private TextField country;
	
	@FXML 
	private ComboBox chooseType;
	
	@FXML 
	private CheckBox courseLit;
	
	@FXML 
	private CheckBox refLit;
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		chooseType.getItems().add(0,"kurslitteratur");
		chooseType.getItems().add(1,"referenslitteratur");
		chooseType.getItems().add(2,"övrigt");
		
	}
	
//	public void addBookAndItems(ActionEvent event) {
//
//		try {
//				book.addTitle(title.getText(), description.getText(), country.getText(), rentalDuration, 
//						subject.getText(), courseLit, refLit, authorFirstName.getText(), authorLastName.getText());
//				
//				((Node)event.getSource()).getScene().getWindow().hide();
//				Stage primaryStage = new Stage();
//				FXMLLoader loader = new FXMLLoader();
//				Pane root = loader.load(getClass().getResource("/application/ProgramStart.fxml").openStream());
//	                Scene scene = new Scene(root); 
//	                scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//	                primaryStage.setScene(scene);
//	                primaryStage.show();
//	                
//	              
//			}
//			
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//			
//		}
//		
//		public 
	public void openAddBook(ActionEvent event) {
		try {
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/application/AddBook.fxml").openStream());
			    Scene scene = new Scene(root); 
			    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			    primaryStage.setScene(scene);
			    primaryStage.show();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void openAddDVD(ActionEvent event) {
		try {
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/application/AddDVD.fxml").openStream());
			    Scene scene = new Scene(root); 
			    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			    primaryStage.setScene(scene);
			    primaryStage.show();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void openAddPaper(ActionEvent event) {
		try {
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/application/AddPaper.fxml").openStream());
			    Scene scene = new Scene(root); 
			    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			    primaryStage.setScene(scene);
			    primaryStage.show();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	}
	
	


