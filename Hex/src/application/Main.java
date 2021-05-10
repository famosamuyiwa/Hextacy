package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import java.sql.*;

public class Main extends Application {
	
	/*
	 * 1. import ---> java.sql.*
	 * 2. load and register the driver ---> com.mysql.jdbc.Driver
	 * 3. create connection
	 * 4. create a statement
	 * 5. execute the query
	 * 6. process the results
	 * 7. close
	*/
	
	protected boolean registered = true;
	public static String password;
	
	@Override
	public void start(Stage primaryStage) {
		if(registered) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.setTitle("Hextacy");
				primaryStage.show();
				primaryStage.setResizable(false);

		}
		catch(Exception e)
			{
			e.printStackTrace();
		}
		}
		else {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hextacy");
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		launch(args);

	}
}
