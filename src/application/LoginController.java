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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	
	
	
	public LoginModel loginModel = new LoginModel();
	
	@FXML
	private Label isConnected;
	
	@FXML
	private TextField txtUsername;
	
	@FXML
	private TextField txtPassword;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if(loginModel.isDbConnected()) {
			isConnected.setText("Connected");
		} else {
			isConnected.setText("Not Connected");
		}
		
	}
	
	public void isLogin(ActionEvent event) {
		try {
			if(loginModel.isLogin(txtUsername.getText(), txtPassword.getText())) {
				isConnected.setText("Username and password is correct");
				((Node)event.getSource()).getScene().getWindow().hide(); 
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("/application/StudentStartPage.fxml").openStream()); //hämtar fxmlfilen vi vill ladda för att starta interrfacet
//				UserController userController = (UserController)loader.getController();
//				userController.getUser(txtUsername.getText());
				Scene scene = new Scene(root); // kan ta in två till argument, ett x och ett y-värde för att bestämma storleken. Här gör vi inte det eftersom vi vill ha storleken av Login.fxml
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				
			} else {
				isConnected.setText("Wrong username or password");
			}
		} catch (SQLException e) {
			isConnected.setText("Wrong username or password");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
