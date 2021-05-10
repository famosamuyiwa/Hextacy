package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TimeTableController extends HomePageController implements Initializable{
	
	StudentsDAO dao = new StudentsDAO();
	
	
	@FXML TabPane tabPane;
	
	@FXML ComboBox<String> courseComboBox;
	

	@FXML private TableView<Timetable> monTable;
	@FXML private TableColumn<Timetable, Integer> snColumnMon;
	@FXML private TableColumn<Timetable, String> courseColumnMon;
	@FXML private TableColumn<Timetable, String> timeColumnMon;
	@FXML private TableColumn<Timetable, String> lectureHallColumnMon;
	@FXML private TableColumn<Timetable, String> lecturerColumnMon;
	
	@FXML private TableView<Timetable> tueTable;
	@FXML private TableColumn<Timetable, Integer> snColumnTue;
	@FXML private TableColumn<Timetable, String> courseColumnTue;
	@FXML private TableColumn<Timetable, String> timeColumnTue;
	@FXML private TableColumn<Timetable, String> lectureHallColumnTue;
	@FXML private TableColumn<Timetable, String> lecturerColumnTue;
	
	@FXML private TableView<Timetable> wedTable;
	@FXML private TableColumn<Timetable, Integer> snColumnWed;
	@FXML private TableColumn<Timetable, String> courseColumnWed;
	@FXML private TableColumn<Timetable, String> timeColumnWed;
	@FXML private TableColumn<Timetable, String> lectureHallColumnWed;
	@FXML private TableColumn<Timetable, String> lecturerColumnWed;
	
	@FXML private TableView<Timetable> thurTable;
	@FXML private TableColumn<Timetable, Integer> snColumnThur;
	@FXML private TableColumn<Timetable, String> courseColumnThur;
	@FXML private TableColumn<Timetable, String> timeColumnThur;
	@FXML private TableColumn<Timetable, String> lectureHallColumnThur;
	@FXML private TableColumn<Timetable, String> lecturerColumnThur;
	
	@FXML private TableView<Timetable> friTable;
	@FXML private TableColumn<Timetable, Integer> snColumnFri;
	@FXML private TableColumn<Timetable, String> courseColumnFri;
	@FXML private TableColumn<Timetable, String> timeColumnFri;
	@FXML private TableColumn<Timetable, String> lectureHallColumnFri;
	@FXML private TableColumn<Timetable, String> lecturerColumnFri; 
	
	@FXML Button addBtnTtP;
	@FXML Button removeBtnTtP;
	
	public ObservableList<Timetable> monData = FXCollections.observableArrayList();  // Where Timetable gotten from db is stored
	public ObservableList<Timetable> tueData = FXCollections.observableArrayList();
	public ObservableList<Timetable> wedData = FXCollections.observableArrayList();
	public ObservableList<Timetable> thurData = FXCollections.observableArrayList();
	public ObservableList<Timetable> friData = FXCollections.observableArrayList();

	@FXML TextField timeField;
	@FXML TextField hallField;
	@FXML TextField lecturerField;

	
	private String time = null;
	private String lectureHall = null;
	private String lecturer = null;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		snColumnMon.setCellValueFactory(new PropertyValueFactory<Timetable, Integer>("sn"));		
		courseColumnMon.setCellValueFactory(new PropertyValueFactory<Timetable, String>("course"));
		timeColumnMon.setCellValueFactory(new PropertyValueFactory<Timetable, String>("time"));
		lectureHallColumnMon.setCellValueFactory(new PropertyValueFactory<Timetable, String>("lectureHall"));	
		lecturerColumnMon.setCellValueFactory(new PropertyValueFactory<Timetable, String>("lecturer"));	
		
		snColumnTue.setCellValueFactory(new PropertyValueFactory<Timetable, Integer>("sn"));		
		courseColumnTue.setCellValueFactory(new PropertyValueFactory<Timetable, String>("course"));
		timeColumnTue.setCellValueFactory(new PropertyValueFactory<Timetable, String>("time"));
		lectureHallColumnTue.setCellValueFactory(new PropertyValueFactory<Timetable, String>("lectureHall"));	
		lecturerColumnTue.setCellValueFactory(new PropertyValueFactory<Timetable, String>("lecturer"));	
		
		snColumnWed.setCellValueFactory(new PropertyValueFactory<Timetable, Integer>("sn"));		
		courseColumnWed.setCellValueFactory(new PropertyValueFactory<Timetable, String>("course"));
		timeColumnWed.setCellValueFactory(new PropertyValueFactory<Timetable, String>("time"));
		lectureHallColumnWed.setCellValueFactory(new PropertyValueFactory<Timetable, String>("lectureHall"));	
		lecturerColumnWed.setCellValueFactory(new PropertyValueFactory<Timetable, String>("lecturer"));	
		
		snColumnThur.setCellValueFactory(new PropertyValueFactory<Timetable, Integer>("sn"));		
		courseColumnThur.setCellValueFactory(new PropertyValueFactory<Timetable, String>("course"));
		timeColumnThur.setCellValueFactory(new PropertyValueFactory<Timetable, String>("time"));
		lectureHallColumnThur.setCellValueFactory(new PropertyValueFactory<Timetable, String>("lectureHall"));	
		lecturerColumnThur.setCellValueFactory(new PropertyValueFactory<Timetable, String>("lecturer"));	
		
		snColumnFri.setCellValueFactory(new PropertyValueFactory<Timetable, Integer>("sn"));		
		courseColumnFri.setCellValueFactory(new PropertyValueFactory<Timetable, String>("course"));
		timeColumnFri.setCellValueFactory(new PropertyValueFactory<Timetable, String>("time"));
		lectureHallColumnFri.setCellValueFactory(new PropertyValueFactory<Timetable, String>("lectureHall"));	
		lecturerColumnFri.setCellValueFactory(new PropertyValueFactory<Timetable, String>("lecturer"));	
		

		
		try {
			Student student = dao.populateCB();
			courseComboBox.getItems().setAll(student.getPopulated());
			student = dao.getTimeTable();
			monData = student.getMonTimeTable();
			tueData = student.getTueTimeTable();
			wedData = student.getWedTimeTable();
			thurData = student.getThurTimeTable();
			friData = student.getFriTimeTable();
			
			monTable.setItems(monData);
			tueTable.setItems(tueData);
			wedTable.setItems(wedData);
			thurTable.setItems(thurData);
			friTable.setItems(friData);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		 removeTimetableBtnCss();
		 addTimetableBtnCss();
		}
	
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

	@FXML public void addTimetableBtn() throws Exception{
		time = timeField.getText();
		lectureHall = hallField.getText();
		lecturer = lecturerField.getText();
		Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
		
		if(selectedTab.getText().equals("MONDAY")) {
		dao.addTimeTable(++Student.id, "monday", courseComboBox.getValue(), time, lectureHall, lecturer);		
		}
		else if(selectedTab.getText().equals("TUESDAY")) {
		dao.addTimeTable(++Student.id, "tuesday", courseComboBox.getValue(), time, lectureHall, lecturer);		
		}
		else if(selectedTab.getText().equals("WEDNESDAY")) {
		dao.addTimeTable(++Student.id, "wednesday", courseComboBox.getValue(), time, lectureHall, lecturer);		
		}
		else if(selectedTab.getText().equals("THURSDAY")) {
		dao.addTimeTable(++Student.id, "thursday", courseComboBox.getValue(), time, lectureHall, lecturer);		
		}
		else if(selectedTab.getText().equals("FRIDAY")) {
		dao.addTimeTable(++Student.id, "friday", courseComboBox.getValue(), time, lectureHall, lecturer);		
		}
		else {
			System.out.println("Error. Invalid tab selected");
		}
		refresh();

	}
	@FXML
	public void removeTimetableBtn() throws Exception{
		Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
	
		if(selectedTab.getText().equals("MONDAY")) {
		Timetable selectedItem = monTable.getSelectionModel().getSelectedItem();
		dao.removeTimeTable(selectedItem.getCourse(), "monday", selectedItem.getTime());
		}
		else if(selectedTab.getText().equals("TUESDAY")) {
			Timetable selectedItem = tueTable.getSelectionModel().getSelectedItem();
			dao.removeTimeTable(selectedItem.getCourse(), "tuesday", selectedItem.getTime());
		}
		else if(selectedTab.getText().equals("WEDNESDAY")) {
			Timetable selectedItem = wedTable.getSelectionModel().getSelectedItem();
			dao.removeTimeTable(selectedItem.getCourse(), "wednesday", selectedItem.getTime());
		}
		else if(selectedTab.getText().equals("THURSDAY")) {
			Timetable selectedItem = thurTable.getSelectionModel().getSelectedItem();
			dao.removeTimeTable(selectedItem.getCourse(), "thursday", selectedItem.getTime());
		}
		else if(selectedTab.getText().equals("FRIDAY")) {
			Timetable selectedItem = friTable.getSelectionModel().getSelectedItem();
			dao.removeTimeTable(selectedItem.getCourse(), "friday", selectedItem.getTime());
		}else {
			System.out.println("Error. Invalid tab selected");
		}
	
		refresh();
		
	}
	
	public void refresh() {
		
		monTable.getItems().clear();
		tueTable.getItems().clear();
		wedTable.getItems().clear();
		thurTable.getItems().clear();
		friTable.getItems().clear();

		try {
			Student student = dao.getTimeTable();
			monData = student.getMonTimeTable();
			tueData = student.getTueTimeTable();
			wedData = student.getWedTimeTable();
			thurData = student.getThurTimeTable();
			friData = student.getFriTimeTable();
			
			monTable.setItems(monData);
			tueTable.setItems(tueData);
			wedTable.setItems(wedData);
			thurTable.setItems(thurData);
			friTable.setItems(friData);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	public void removeTimetableBtnCss() {
		Css.dangerBtn(removeBtnTtP);
	}
	
	@FXML
	public void addTimetableBtnCss() {
		Css.successBtn(addBtnTtP);
	}
}
