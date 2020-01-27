package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.*;

public class App extends Application {

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		VBox root = new VBox(100);
		
//		HBox pane1 = new HBox(30);
//		HBox pane2 = new HBox(30);
//		HBox pane3 = new HBox(30);
		
		Button btn1 = new Button("Course");
		root.getChildren().add(btn1);
		root.setAlignment(Pos.CENTER);
		btn1.setOnAction(e -> {
//			primaryStage.setScene(coursePane.getScene());
			
		});
		
		
		Button btn2 = new Button("Student");
		root.getChildren().add(btn2);
		root.setAlignment(Pos.CENTER);
		btn2.setOnAction(e -> {
//			primaryStage.setScene(studentPane.getScene());
			
		});

		Button btn3 = new Button("Faculty");
		root.getChildren().add(btn3);
		root.setAlignment(Pos.CENTER);
		btn3.setOnAction(e -> {
//			primaryStage.setScene(facultyPane.getScene());
			
		});
		
		Button btn4 = new Button("Textbook");
		root.getChildren().add(btn4);
		root.setAlignment(Pos.CENTER);
		btn4.setOnAction(e -> {
//			primaryStage.setScene(textbookPane.getScene());
			
		});
		
		Scene scene = new Scene(root, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("SAIN Report");
		primaryStage.show();
		
	}

}
