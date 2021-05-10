package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HomePageController implements Initializable{

	
	@FXML
	public Button coursesBtn;
	@FXML
	public Button timeTableBtn;
	@FXML
	public Button studyTimeBtn;
	@FXML
	public Button logoutBtn;
	
	@FXML 
	public Button markAsDoneBtn;
	
	@FXML
	public TextField full_name_field;
	
	@FXML
	public TextField matric_field;
	
	@FXML
	public TextField dept_field;
	
	
	@FXML
	public void coursesView(ActionEvent event) throws IOException {
		Node node = (Node) event.getSource();
		Stage currentStage = (Stage) node.getScene().getWindow();
	//	Parent root = FXMLLoader.load(getClass().getResource("CoursePage.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("coursepageResized.fxml"));
		Scene courseScene = new Scene(root);
		currentStage.setScene(courseScene);
		currentStage.setTitle("Hextacy - Courses");

	}
	
	@FXML
	public void timeTableView(ActionEvent event) throws IOException {
		Node node = (Node) event.getSource();
		Stage currentStage = (Stage) node.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("timetableResized.fxml"));
		Scene timeTableScene = new Scene(root);
		currentStage.setScene(timeTableScene);
		currentStage.setTitle("Hextacy - TimeTable");

	}
	@FXML
	public void studyTimeView(ActionEvent event) throws IOException {
		Node node = (Node) event.getSource();
		Stage currentStage = (Stage) node.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("StudyTime.fxml"));
		Scene studyTimeScene = new Scene(root);
		currentStage.setScene(studyTimeScene);
		currentStage.setTitle("Hextacy - StudyTime");

	}
	@FXML
	public void logoutView(ActionEvent event) throws IOException {
		Node node = (Node) event.getSource();
		Stage previousStage = (Stage) node.getScene().getWindow();
		previousStage.hide();
		
		Stage currentStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
		Scene HomePageScene = new Scene(root);
		currentStage.setScene(HomePageScene);
		currentStage.show();
		currentStage.setResizable(false);
		currentStage.setTitle("Hextacy");
		
	}
	
	@FXML
	public void homeButton(ActionEvent event) throws IOException {
		Node node = (Node) event.getSource();
		Stage currentStage = (Stage) node.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("homepageResized.fxml"));
		Scene studyTimeScene = new Scene(root);
		currentStage.setScene(studyTimeScene);
		currentStage.setTitle("Hextacy - Home");

	}
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		madBtnCss();			//style btn
		try {
			setParams();		// populate student info fields
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void madBtnCss() {
		Css.successBtn(markAsDoneBtn);            // Style button with Css interface
	}
	
	public void setParams() throws Exception {
		StudentsDAO dao = new StudentsDAO();			//initialize studentDAO object
		Student student = dao.getStudentInfo();			//initialize student object with StudentdAO method
		full_name_field.setText(student.getName());			// set name field
		matric_field.setText(Student.getMatric_no());
		dept_field.setText(student.getDept());
		
	}
	

}
