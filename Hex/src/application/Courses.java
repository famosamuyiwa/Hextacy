package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Courses {
	
	private SimpleStringProperty course;
	private SimpleStringProperty course_code;
	private SimpleIntegerProperty unit;
	private SimpleIntegerProperty sn;
	
	public Courses(int sn, String course, String course_code, int unit){
		this.sn = new SimpleIntegerProperty(sn);
		this.course = new SimpleStringProperty(course);
		this.course_code = new SimpleStringProperty(course_code);
		this.unit = new SimpleIntegerProperty(unit);
	}
	
	public Integer getSn() {
		return sn.get();
	}
	public String getCourse() {
		return course.get();
	}
	public String getCourseCode() {
		return course_code.get();
	}
	public int getUnit() {
		return unit.get();
	}
	public void setSn(int sn) {
		 this.sn.set(sn);
	}
	public void setCourse(String course) {
		 this.course.set(course);
	}
	public void setCourseCode(String course_code) {
		 this.course_code.set(course_code);
	}
	public void setUnit(int unit) {
		 this.unit.set(unit);
	}
	
	
}
