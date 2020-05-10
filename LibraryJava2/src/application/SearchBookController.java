package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SearchBookController implements Initializable {
	
	String tiSe;
	
	String searchTitText;
	
	String tågboken;
	
	@FXML
	public TextField searchTitleTxt;
	
	@FXML
	public TextField searchAuthorTxt;
	
	@FXML
	public TextField searchCountryTxt;
	
	@FXML
	public TextField searchSubjectTxt;
	
	public String getSearchTitleTxt() {
		searchTitText = searchTitleTxt.getText();
		return searchTitText;
	}
	
	String titText;

	public void setSearchTitleTxt(TextField searchTitleTxt) {
		this.searchTitleTxt = searchTitleTxt;
	}

	public Button getSearchExecute() {
		return searchExecute;
	}

	public void setSearchExecute(Button searchExecute) {
		this.searchExecute = searchExecute;
	}

	@FXML
	private Button searchExecute;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	public String titText(String tiSe) {
		return tiSe;
	}
	
	public void searchExec(ActionEvent event) {
		try {
            String titles = searchTitleTxt.getText();
            String authors = searchAuthorTxt.getText();
            String countries = searchCountryTxt.getText();
            String subjects = searchSubjectTxt.getText();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/SearchResult.fxml"));
            SearchResultController searchResCon = new SearchResultController(titles, authors, countries, subjects);
            loader.setController(searchResCon);
            Parent root = loader.load();         
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }
	}

}
