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

//public String text;

public String ponkas = "kakboken";

private String titles;

public SearchResultController(String titles) {
	this.titles = titles;
}



//public String titleText = "Tågboken";



//String tåg = "Tågboken";

//SearchBookController sBC = new SearchBookController();
	
//	@FXML
//	private SearchBookController sBC;
	
//	public String titleTex = sBC.searchTitText;
//	
//	String titleInput = sBC.getSearchTitleTxt();

	@FXML
	private Text titleText;

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
	
//	private String getTitleText() {
//		titleText = sBC.getTitleTextField();
//		return titleText;
//	}

//	public String titleInput() {
//		titleInput = sBC.getSearchTitleTxt().getText();
//		return titleInput;
//	}
	
	
	public void myFunction(String titel) {
		

	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		titleText.setText(titles);
		columnTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		columnAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
		columnCountry.setCellValueFactory(new PropertyValueFactory<Book, String>("country"));
		columnSubject.setCellValueFactory(new PropertyValueFactory<Book, String>("subject"));

		System.out.println();
		searchMod.getBooks(titleText.getText());
		table.setItems(searchMod.printBooks());
	}
	


}
