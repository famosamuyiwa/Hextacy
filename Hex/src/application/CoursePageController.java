package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections; 
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CoursePageController extends HomePageController implements Initializable {

	@FXML private TableView<Courses> coursesTable;
	@FXML private TableColumn<Courses, Integer> snColumn;
	@FXML private TableColumn<Courses, String> courseColumn;
	@FXML private TableColumn<Courses, String> courseCodeColumn;
	@FXML private TableColumn<Courses, Integer> unitColumn;
	
	@FXML private TextField courseField;
	@FXML private TextField courseCodeField;
	@FXML private TextField unitField;

	@FXML private Button addBtnCP; // add button Course Page
	@FXML private Button removeBtnCP; // remove button Course Page
	
	public String course = null;
	public String courseCode = null;
	public int unit = 0 ;
	public ObservableList<Courses> data = FXCollections.observableArrayList(); // list to populate table
	StudentsDAO dao = new StudentsDAO();

	
	private int sn = 0;
	

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
	
	@FXML
	public void addCourseBtn() throws Exception{
		course = courseField.getText();
		courseCode = courseCodeField.getText();
		unit = Integer.parseInt(unitField.getText());
		sn = data.size();
		
		dao.addCourse(course, courseCode, unit);
		refresh();

	}
	
	@FXML
	public void removeCourseBtn() throws Exception {
		Courses selectedItem = coursesTable.getSelectionModel().getSelectedItem();
		dao.removeCourse(selectedItem.getCourseCode());
		refresh();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		snColumn.setCellValueFactory(new PropertyValueFactory<Courses, Integer>("sn"));		
		courseColumn.setCellValueFactory(new PropertyValueFactory<Courses, String>("course"));
		courseCodeColumn.setCellValueFactory(new PropertyValueFactory<Courses, String>("courseCode"));
		unitColumn.setCellValueFactory(new PropertyValueFactory<Courses, Integer>("unit"));		

		try {
			Student student = dao.getCourseList();
			data = student.getCourseList();
			coursesTable.setItems(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		addCourseBtnCss();
		removeCourseBtnCss();
	}
	
	public void refresh() {
		coursesTable.getItems().clear();
		try {
			Student student = dao.getCourseList();
			data = student.getCourseList();
			coursesTable.setItems(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	public void removeCourseBtnCss() {
		Css.dangerBtn(removeBtnCP);
	}
	
	
	@FXML
	public void addCourseBtnCss() {
		Css.successBtn(addBtnCP);
	}

}
