package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class LoginPageController {
	
	@FXML TextField matric_field;
	@FXML PasswordField pw_field;
	@FXML Label authLabel;
	
	protected String matric_no;
	protected String pw;
	
	@FXML
	private Button submit;
	
	public void submitButtonClicked(ActionEvent event) throws Exception {
		matric_no = matric_field.getText();
		pw = pw_field.getText();
		
		if(pwAuthentication(matric_no, pw)) {   
		
		System.out.println(pw);
		Node node = (Node) event.getSource();								// initialize node from where event was fired
		Stage previousStage = (Stage) node.getScene().getWindow();			// use node to get Stage event was fired from
		previousStage.hide();										
		
		// load page
		
		Stage currentStage = new Stage();													
		//Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("homepageResized.fxml"));
		Scene home = new Scene(root);
		currentStage.setScene(home);
		currentStage.setResizable(false);
		currentStage.show();
		
		}
		
		
	}
	
	public String getMatric() {
		return matric_no;
	}
	
	public String getPw() {
		return pw;
	}
	
	public boolean pwAuthentication(String matric, String pw) throws Exception {
		StudentsDAO dao = new StudentsDAO();			//initialize local  StudentDAO object
		Student student = dao.getStudentLogin(matric);		// initialize student object with StudentDAO method 
		
		if(!(pw.equals(student.getPassword()))){            // compare value in password field to value returned from student object
			authLabel.setText("Invalid email/password");
			return false;
		}
		else {
			return true;
		}
	}
	
}
