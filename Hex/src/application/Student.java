package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Student {
	private static String matric_no;
	private static String password;
	private static String first_name;
	private static String last_name;
	private static String other_name;
	private static String name;
	private static String dept;
	private static String course;
	private static String course_code;
	private static String lecturer;
	private static String lectureHall;
	private static String time;
	private static String courseTt;
	private static String day;
	private static int unit;
	public static int id;
	public int sn, msn, tsn, wsn, thsn, fsn = 0;
	private ObservableList<Courses> courses = FXCollections.observableArrayList();
	private ObservableList<Timetable> timetableMon = FXCollections.observableArrayList();
	private ObservableList<Timetable> timetableTue = FXCollections.observableArrayList();
	private ObservableList<Timetable> timetableWed = FXCollections.observableArrayList();
	private ObservableList<Timetable> timetableThur = FXCollections.observableArrayList();
	private ObservableList<Timetable> timetableFri = FXCollections.observableArrayList();

	
	private ObservableList<String> populateCB ;
	private ArrayList<String> pop = new ArrayList<String>();

	
	
	
	
	
	public static String getMatric_no() {
		return matric_no;
	}
	public void setMatric_no(String matric_no) {
		Student.matric_no = matric_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		Student.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName() {
		Student.name = String.format("%s %s %s", last_name, first_name, other_name);
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		Student.dept = dept;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		Student.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		Student.last_name = last_name;
	}
	public String getOther_name() {
		return other_name;
	}
	public void setOther_name(String other_name) {
		Student.other_name = other_name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		Student.course = course;
	}
	public String getCourse_code() {
		return course_code;
	}
	public void setCourse_code(String course_code) {
		Student.course_code = course_code;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		Student.unit = unit;
	}
	
	public String getLecturer() {
		return lecturer;
	}
	public void setLecturer(String lecturer) {
		Student.lecturer = lecturer;
	}
	public String getLectureHall() {
		return lectureHall;
	}
	public void setLectureHall(String lectureHall) {
		Student.lectureHall = lectureHall;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		Student.time = time;
	}
	public String getCourseTt() {
		return courseTt;
	}
	public void setCourseTt(String courseTt) {
		Student.courseTt = courseTt;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		Student.day = day;
	}
	

	public void setCourseList(String course, String course_code, int unit){
		
		courses.add(new Courses(++sn, course, course_code, unit));
	}
	
	public ObservableList<Courses> getCourseList() {
		sn = 0;				// set sn back to 0 upon refresh
		return courses;
	}
	
	public void populateCB(String populate){
		pop.add(populate);
		populateCB = FXCollections.observableArrayList(pop);
	
	}
	
	public ObservableList<String> getPopulated(){
		return populateCB;
	}
	
	
	public void setMonTimeTable(String course, String time, String lectureHall, String lecturer){
		timetableMon.add(new Timetable(++msn, course, time, lectureHall, lecturer));
	}
	public void setTueTimeTable(String course, String time, String lectureHall, String lecturer){
		timetableTue.add(new Timetable(++tsn, course, time, lectureHall, lecturer));
	}
	public void setWedTimeTable(String course, String time, String lectureHall, String lecturer){
		timetableWed.add(new Timetable(++wsn, course, time, lectureHall, lecturer));
	}
	public void setThurTimeTable(String course, String time, String lectureHall, String lecturer){
		timetableThur.add(new Timetable(++thsn, course, time, lectureHall, lecturer));
	}
	public void setFriTimeTable(String course, String time, String lectureHall, String lecturer){
		timetableFri.add(new Timetable(++fsn, course, time, lectureHall, lecturer));
	}
	
	public ObservableList<Timetable> getMonTimeTable() {
		msn = 0;				// set sn back to 0 upon refresh
		
		return timetableMon;
	}
	
	public ObservableList<Timetable> getTueTimeTable() {
		tsn = 0;				// set sn back to 0 upon refresh
		
		return timetableTue;
	}
	
	public ObservableList<Timetable> getWedTimeTable() {
		wsn = 0;				// set sn back to 0 upon refresh
		
		return timetableWed;
	}
	
	public ObservableList<Timetable> getThurTimeTable() {
		thsn = 0;				// set sn back to 0 upon refresh
		
		return timetableThur;
	}
	
	public ObservableList<Timetable> getFriTimeTable() {
		fsn = 0;				// set sn back to 0 upon refresh
		
		return timetableFri;
	}
}
