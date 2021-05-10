package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.scene.effect.*;

public interface Css{
	
	
	
	public static void successBtn(Button btn) {
		DropShadow dropshadow = new DropShadow();
		dropshadow.setWidth(21.0);
		dropshadow.setHeight(21.0);
		dropshadow.setRadius(10.0);
		dropshadow.setColor(Color.web("0cda51"));
		dropshadow.setBlurType(BlurType.THREE_PASS_BOX);
		
		btn.setEffect(dropshadow);
		
		btn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {			
			btn.setStyle("-fx-background-color : #0cda51");
		}
		});
		
		btn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {			
			btn.setStyle("-fx-background-color : white");
		}
		}); 
		
		btn.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {			
			btn.setStyle("-fx-background-color : #0cdb90");
		}
		});
		
		btn.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {			
			btn.setStyle("-fx-background-color : #0cda51");
		}
		});
	}
	

	public static void dangerBtn(Button btn) {
		DropShadow dropshadow = new DropShadow();
		dropshadow.setWidth(21.0);
		dropshadow.setHeight(21.0);
		dropshadow.setRadius(10.0);
		dropshadow.setColor(Color.web("e70a0a"));
		dropshadow.setBlurType(BlurType.THREE_PASS_BOX);
		
		btn.setEffect(dropshadow);
		
		btn.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {			
			btn.setStyle("-fx-background-color : #e70a0a");
		}
		});
		
		btn.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {			
			btn.setStyle("-fx-background-color : white");
		}
		}); 
		
		btn.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {			
			btn.setStyle("-fx-background-color : #d64242");
		}
		});
		
		btn.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e) {			
			btn.setStyle("-fx-background-color : #e70a0a");
		}
		});
	}
	
	
}
