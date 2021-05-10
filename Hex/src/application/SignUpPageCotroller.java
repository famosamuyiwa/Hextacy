package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpPageCotroller{

	protected String matric_no;
	protected String pw;
	protected String cpw;
	protected String first_name;
	protected String last_name;
	protected String dept;
	
	
	@FXML TextField first_name_field;
	@FXML TextField last_name_field;
	@FXML TextField dept_field;
	@FXML TextField matric_field;
	@FXML PasswordField pw_field;
	@FXML PasswordField cpw_field;
	
	
	@FXML
	private Button submit;
	
	@FXML
	public void submitButtonClicked(ActionEvent event) throws IOException {
		
		dept = dept_field.getText();
		first_name = first_name_field.getText();
		last_name = last_name_field.getText();
		matric_no = matric_field.getText();
		pw = pw_field.getText();
		cpw = cpw_field.getText();
			
		
		Node node = (Node) event.getSource();
		Stage primaryStage = (Stage) node.getScene().getWindow();
		primaryStage.hide();
		
		Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
		Scene home = new Scene(root);
		Stage thisStage = new Stage();
		thisStage.setScene(home);
		thisStage.setTitle("Hextacy");
		thisStage.setResizable(false);
		thisStage.show();
		
	}
	
	public String getMatric() {
		return matric_no;
	}
	
	public String getPw() {
		return pw;
	}
	
	public String getFullName() {
		return last_name + " " + first_name;
	}
	
	public String getCpw() {
		return cpw;
	}
	public String getDepartment() {
		return dept;
	}
	
}
