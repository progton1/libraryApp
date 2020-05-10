package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class SearchResultController implements Initializable {
	
SearchResultModel searchMod = new SearchResultModel();

public String ponkas = "kakboken";

private String titles;
private String authors;
private String countries;
private String subjects;


public SearchResultController(String titles, String authors, String countries, String subjects) {
	this.titles = titles;
	this.authors = authors;
	this.countries = countries;
	this.subjects = subjects;
}

	@FXML
	private Text titleText;
	
	@FXML
	private Text authorText;
	
	@FXML
	private Text countryText;
	
	@FXML
	private Text subjectText;

	@FXML
	private TableView<Book> table;
	@FXML
	private TableColumn<Book, String> columnTitle;
	@FXML
	private TableColumn<Book, String> columnAuthor;
	@FXML
	private TableColumn<Book, String> columnCountry;
	@FXML
	private TableColumn<Book, String> columnSubject;
	
	public void myFunction(String titel) {
		
	}
	
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		titleText.setText(titles);
		authorText.setText(authors);
		countryText.setText(countries);
		subjectText.setText(subjects);
		columnTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		columnAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
		columnCountry.setCellValueFactory(new PropertyValueFactory<Book, String>("country"));
		columnSubject.setCellValueFactory(new PropertyValueFactory<Book, String>("subject"));
		searchMod.getBooks(titleText.getText(), authorText.getText(), countryText.getText(), subjectText.getText());
//		searchMod.getAuthors(authorText.getText());
		table.setItems(searchMod.printBooks());
	}
	
}
