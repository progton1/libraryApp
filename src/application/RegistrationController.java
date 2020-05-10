package application;

import java.io.IOException;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JComboBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RegistrationController implements Initializable {
	
	
	public RegistrationModel registrationModel = new RegistrationModel();
	
	@FXML
	private TextField txtEmail;
	
	@FXML
	private TextField txtFirstname;
	
	@FXML
	private TextField txtLastname;
	
	@FXML
	private TextField txtPhoneNumber;
	
	@FXML
	private TextField txtPassword;
	
	@FXML
	private TextField txtPasswordCtrl;
	
	@FXML
	private Label registrationStatus;
	
	
	@FXML
	private ComboBox<String> roleSelect;
	
//	@FXML
//	private TextArea taInformation;
//	
//	@FXML
//	private void handleButtonAction(ActionEvent event) {
//		
//		taInformation.appendText(String.valueOf(roleSelect.getSelectionModel().getSelectedIndex()));
//		
//		taInformation.appendText(String.valueOf(roleSelect.getItems()) + "\n");
//	
//	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
//		roleSelect.getItems().addAll(registrationModel.roleList);
		roleSelect.getItems().add(0, "Student");
		roleSelect.getItems().add(1, "Forskare");
		roleSelect.getItems().add(2, "Universitetsanställd");
		roleSelect.getItems().add(3, "Bibliotekarie");
		
//		roleSelect.addItem("Student");
//		roleSelect.addItem("Forskare");
//		roleSelect.addItem("Universitetsanställd");
//		roleSelect.addItem("Bibliotekarie");
		
//		roleSelect.setItems(registrationModel.roleList);

	}
	
	public void registration(ActionEvent event) {

		try {
			
			if (passwordControl(txtPasswordCtrl.getText()) == false) {
				txtPassword.clear();
				txtPasswordCtrl.clear();
				registrationStatus.setText("Lösenorden matchar inte");
				
			} else registrationModel.registration(txtFirstname.getText(), txtLastname.getText(), txtPhoneNumber.getText(),
					txtEmail.getText(), (roleSelect.getSelectionModel().getSelectedIndex() + 1),  txtPassword.getText());
			
			
				if (!registrationModel.insertNewAccount()) {
					registrationStatus.setText("Denna Email är redan registrerad");
					
				}  else  {
					registrationModel.insertNewAccount();
				registrationStatus.setText("Registrering lyckades!");
				((Node)event.getSource()).getScene().getWindow().hide();
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("/application/ProgramStart.fxml").openStream());
	                Scene scene = new Scene(root); 
	                scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	                primaryStage.setScene(scene);
	                primaryStage.show();
	                
	              
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}

	}
	
	public boolean passwordControl(String password) {
		
		if (txtPassword.getText().equals(password)) {
			return true;
		} else {
			return false;
		}
	}
	
}
	
	
