package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class StudyTimeController extends HomePageController implements Initializable{
	
	@FXML
	public void coursesView(ActionEvent event) throws IOException {
		super.coursesView(event);
	}

	@FXML
	public void timeTableView(ActionEvent event) throws IOException {
		super.timeTableView(event);
	}
	
	@FXML
	public void studyTimeView(ActionEvent event) throws IOException {
		super.studyTimeView(event);
	}
	
	@FXML
	public void logoutView(ActionEvent event) throws IOException {
		super.logoutView(event);
	}
	@FXML
	public void homeButton(ActionEvent event) throws IOException {
		super.homeButton(event);
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
