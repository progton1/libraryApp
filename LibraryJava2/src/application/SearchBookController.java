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
	
//	SearchResultModel sRM = new SearchResultModel();
	
	String tiSe;
	
	String searchTitText;
	
	String tågboken;
	
//	@FXML
//	private SearchResultController sRC;
	
//	SearchBookController(String searchTitText) {
//		this.searchTitText = searchTitText;
//	}
	
	@FXML
	public TextField searchTitleTxt;
	
	public String getSearchTitleTxt() {
		searchTitText = searchTitleTxt.getText();
		return searchTitText;
	}
	
	String titText;
	
	
	
//	public String getTitleTextField() {
//		tågboken = "Tågboken";
//		return tågboken;
//	}

//	public String getSearchTitleTxt() {
//		titText = searchTitleTxt.getText();
//		return titText;
//	}
	
	

	public void setSearchTitleTxt(TextField searchTitleTxt) {
		this.searchTitleTxt = searchTitleTxt;
	}
	
	



//	public String titSearch() {
//		sRM.titleSearch = searchTitleTxt.getText();
//		return sRM.titleSearch;
//	}

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
	
//	public String columnString() {
//		
//	}
	
	public String titText(String tiSe) {
		return tiSe;
	}
	
	
	
//	public void searchExec(ActionEvent event) {
//		try {
////			getSearchTitleTxt(searchTitleTxt.getText());
//			((Node)event.getSource()).getScene().getWindow().hide();
//			Stage primaryStage = new Stage();
//			FXMLLoader loader = new FXMLLoader();
//			Pane root = loader.load(getClass().getResource("/application/SearchResult.fxml").openStream());
//			SearchResultController searchResCon = loader.getController();
//			searchResCon.myFunction(searchTitleTxt.getText());
//			    Scene scene = new Scene(root); 
//			    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			    primaryStage.setScene(scene);
//			    primaryStage.show();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	} 
	
	public void searchExec(ActionEvent event) {
		try {
            String titles = searchTitleTxt.getText();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/SearchResult.fxml"));
            SearchResultController searchResCon = new SearchResultController(titles);
            loader.setController(searchResCon);
            Parent root = loader.load();
 
            //Show scene 2 in new window            
            Stage stage = new Stage();
//            Scene scene = new Scene(root); 
//            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setScene(new Scene(root));
//            stage.setTitle("Second Window");
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }
	}

}
