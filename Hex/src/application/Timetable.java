package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Timetable {

	private SimpleStringProperty course;
	private SimpleStringProperty time;
	private SimpleIntegerProperty sn;
	private SimpleStringProperty lectureHall;
	private SimpleStringProperty lecturer;

	public Timetable(int sn, String course, String time, String lectureHall, String lecturer){
		this.sn = new SimpleIntegerProperty(sn);
		this.course = new SimpleStringProperty(course);
		this.time = new SimpleStringProperty(time);
		this.lectureHall = new SimpleStringProperty(lectureHall);
		this.lecturer = new SimpleStringProperty(lecturer);

	}
	
	public Integer getSn() {
		return sn.get();
	}
	public String getCourse() {
		return course.get();
	}
	public String getTime() {
		return time.get();
	}
	public String getLectureHall() {
		return lectureHall.get();
	}
	public String getLecturer() {
		return lecturer.get();
	}
	
	public void setSn(int sn) {
		 this.sn.set(sn);
	}
	public void setCourse(String course) {
		 this.course.set(course);
	}
	public void setLectureHall(String lectureHall) {
		 this.lectureHall.set(lectureHall);
	}
	public void setLecturer(String lecturer) {
		 this.lecturer.set(lecturer);
	}
	public void setUnit(String time) {
		 this.time.set(time);
	}
	
}
