package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentsDAO {
	
	Student student = new Student();
	
	String url = "jdbc:mysql://localhost:3306/hextacy?serverTimezone=UTC";
	String uname= "root";
	String pass = "Kay80704080.";
	
	public Student getStudentLogin(String matric_no) throws Exception{
	
	String query = String.format("SELECT password FROM login WHERE matric_no = '%s';", matric_no);
	
	student.setMatric_no(matric_no);
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection(url, uname, pass);
	Statement st = con.createStatement();
	
	try {
	ResultSet rs = st.executeQuery(query);	
	rs.next();	
	student.setPassword(rs.getString("password"));
	}
	catch(Exception e){
	e.printStackTrace();
	student.setPassword(null);
	}
		
	
	con.close();
	
	return student;
	}
	

	
	public Student getStudentInfo() throws Exception{
	
		String query = String.format("SELECT first_name, last_name, other_name, department FROM studentInfo WHERE matric_no = '%s';", Student.getMatric_no() );
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		
		try {
		ResultSet rs = st.executeQuery(query);	
		rs.next();	
		
		student.setFirst_name(rs.getString("first_name"));
		student.setLast_name(rs.getString("last_name"));
		student.setOther_name(rs.getString("other_name"));
		student.setName();
		student.setDept(rs.getString("department"));

		}
		catch(Exception e){
		e.printStackTrace();
		student.setFirst_name(null);
		student.setLast_name(null);
		student.setOther_name(null);
		student.setDept(null);		
		}
		
		con.close();
		return student;
	}
	
	public void addCourse(String course, String course_code, int unit) throws Exception{
	
		String query = String.format("INSERT into course_info (course, course_code, unit, matric_no) VALUES ('%s','%s',%d,'%s');" , course, course_code, unit, Student.getMatric_no());
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		
		try {
		int count = st.executeUpdate(query);	
		System.out.println(count + "row has been affected");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void removeCourse(String course_code) throws Exception{
		String query = String.format("DELETE from course_info WHERE (course_code = '%s' AND matric_no = '%s'); ", course_code, Student.getMatric_no());
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		
		try {
		int count = st.executeUpdate(query);	
		System.out.println(count + "row has been affected");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	

	
	public Student getCourseList() throws Exception{
		String query = String.format(" SELECT course, course_code, unit from course_info WHERE matric_no = '%s';", Student.getMatric_no());
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		try {
			while(rs.next()) {
				student.setCourse(rs.getString("course"));
				student.setCourse_code(rs.getString("course_code"));
				student.setUnit(Integer.parseInt(rs.getString("unit")));
				student.setCourseList(rs.getString("course"), rs.getString("course_code"), Integer.parseInt(rs.getString("unit")));
			}
			}
		catch(Exception e) {
			student.setCourse(null);
			student.setCourse_code(null);
			student.setUnit(0);
		}
		
		return student;
	}
	
	public void addTimeTable(int id, String day, String course, String time, String lecturer, String lectureHall) throws Exception{
		
		String query = String.format("INSERT into timetable_info (id, day, course, time, lecturer, lecture_hall, matric_no) VALUES ('%d','%s','%s','%s','%s','%s', '%s');" , id, day, course, time, lecturer, lectureHall, Student.getMatric_no());
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		
		try {
		int count = st.executeUpdate(query);	
		System.out.println(count + "row has been affected");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void removeTimeTable(String course, String day, String time) throws Exception{
		String query = String.format("DELETE from timetable_info WHERE (day = '%s' AND course = '%s' AND time = '%s' AND matric_no = '%s'); ", day, course, time, Student.getMatric_no());
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		
		try {
		int count = st.executeUpdate(query);	
		System.out.println(count + "row has been affected");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	

	
	public Student getTimeTable() throws Exception{
		String query = String.format("SELECT id, day, course, time, lecturer, lecture_hall FROM timetable_info WHERE matric_no = '%s';", Student.getMatric_no());
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		try {
			while(rs.next()) {
				student.setDay(rs.getString("day"));
				student.setCourseTt(rs.getString("course"));
				student.setTime(rs.getString("time"));
				student.setLecturer(rs.getString("lecturer"));
				student.setLectureHall(rs.getString("lecture_hall"));
				Student.id = Integer.parseInt(rs.getString("id"));
				
				if(rs.getString("day").equals("monday")) {
				student.setMonTimeTable(rs.getString("course"), rs.getString("time"), rs.getString("lecturer"), rs.getString("lecture_hall"));
				}
				if(rs.getString("day").equals("tuesday")) {
				student.setTueTimeTable(rs.getString("course"), rs.getString("time"), rs.getString("lecturer"), rs.getString("lecture_hall"));
				}
				if(rs.getString("day").equals("wednesday")) {
					student.setWedTimeTable(rs.getString("course"), rs.getString("time"), rs.getString("lecturer"), rs.getString("lecture_hall"));
					}
				if(rs.getString("day").equals("thursday")) {
					student.setThurTimeTable(rs.getString("course"), rs.getString("time"), rs.getString("lecturer"), rs.getString("lecture_hall"));
					}
				if(rs.getString("day").equals("friday")) {
					student.setFriTimeTable(rs.getString("course"), rs.getString("time"), rs.getString("lecturer"), rs.getString("lecture_hall"));
					}
			}
		}
		catch(Exception e) {
			student.setCourseTt(null);
			student.setTime(null);
			student.setDay(null);
			student.setLecturer(null);
			student.setLectureHall(null);
			
		}
		
		return student;
	}
	
	public Student populateCB() throws Exception{
		String query = String.format("SELECT course FROM course_info WHERE matric_no = '%s';", Student.getMatric_no());
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		try {
			while(rs.next()) {
				student.populateCB(rs.getString("course"));
			}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return student;
	}
}
