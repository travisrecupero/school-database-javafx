package model;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.shape.*;



public class App extends Application {

	final FileChooser fileChooser = new FileChooser();
	
	public static void main(String[] args) {

		launch(args);

	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		College college = new College();
		BorderPane root = new BorderPane();
		MenuBar menuBar = new MenuBar();
		root.setTop(menuBar); //adds menu bar to border pane

		
		Image suffolkImage = new Image("file:///G:/Programming%20242/Recupero%20CST242%20FinalProject%20Part%202/src/SuffolkLogo.png");
		ImageView iv1 = new ImageView(suffolkImage);
		iv1.setImage(suffolkImage);
	    iv1.setPreserveRatio(true);
        iv1.setFitWidth(400);
        iv1.setFitHeight(300);
		root.setCenter(iv1);
		
		
		/////////////////////////////////////////
		Menu fileMenu = new Menu("File");//adds file drop down menu to the menu bar
		menuBar.getMenus().addAll(fileMenu);

		MenuItem saveItem = new MenuItem("Save"); //adds save to drop down menu (menu)
		fileMenu.getItems().addAll(saveItem);
		saveItem.setOnAction(e -> {
			college.saveAll();
		});


		MenuItem loadItem = new MenuItem("Load");
		fileMenu.getItems().addAll(loadItem);
		loadItem.setOnAction(e -> {
			college.loadAll();
			college.getPersonBag().display();
		});

		
		MenuItem importItem = new MenuItem("Import People");
		fileMenu.getItems().addAll(importItem);
		importItem.setOnAction(e -> {
			File file = fileChooser.showOpenDialog(primaryStage);
			if (file != null) {
				try {
					Scanner scanner = new Scanner(file);
					// System.out.println(scanner.nextLine());
				} catch (FileNotFoundException e1) {
				}

			}
		});
		
		
		MenuItem exportItem = new MenuItem("Export People");
		fileMenu.getItems().addAll(exportItem);
		exportItem.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();

			// Set extension filter
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
			fileChooser.getExtensionFilters().add(extFilter);

			// Show save file dialog
			File file = fileChooser.showSaveDialog(primaryStage);

			if (file != null) {
				try {
					PrintWriter pw = new PrintWriter(file);
					for (int i = 0; i < college.getPersonBag().getPersonArray().length; i++) {
						pw.println(college.getPersonBag().getPersonArray()[i].getName() + ": " 
								+ college.getPersonBag().getPersonArray()[i].getId() );
					}
					pw.close();
				} catch (FileNotFoundException ee) {
					//Util.failureAlert("Failure exporting persons.txt file");
				}
			}
		});
		///////////////////////////////////////////


		Menu personMenu = new Menu("Persons");
		menuBar.getMenus().addAll(personMenu);
		MenuItem studentItem = new MenuItem("Student");
		MenuItem facultyItem = new MenuItem("Faculty");
		personMenu.getItems().addAll(studentItem, facultyItem);
		//items
		studentItem.setOnAction(e -> {
			StudentPane studentPane = new StudentPane(college);
		    root.setCenter(studentPane.getGridPane());
		});
		facultyItem.setOnAction(e -> {
			FacultyPane facultyPane = new FacultyPane(college);
		    root.setCenter(facultyPane.getGridPane());
		});

		
		
		Menu courseMenu = new Menu("Courses");
		menuBar.getMenus().addAll(courseMenu);
		MenuItem courseItem = new MenuItem("Course Manager");
		courseMenu.getItems().addAll(courseItem);
		courseItem.setOnAction(e -> {
			CoursePane coursePane = new CoursePane(college);
		    root.setCenter(coursePane.getGridPane());
		});
		
		
		Menu textbookMenu = new Menu("Textbook");
		menuBar.getMenus().addAll(textbookMenu);
		MenuItem textbookAddItem = new MenuItem("Add Textbooks");
		MenuItem textbookFindRemoveItem = new MenuItem("Find/Remove Textbooks");
		textbookMenu.getItems().addAll(textbookAddItem, textbookFindRemoveItem);
		
		
		
		textbookAddItem.setOnAction(e -> {
			TextbookPane textbookPane = new TextbookPane(college);
		    root.setCenter(textbookPane.getGridPane());
		});


		
		
		Scene scene = new Scene(root, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("SAIN Report");
		primaryStage.show();
		
		
	




//		HBox pane1 = new HBox(30);


//		Button btn1 = new Button("Course");
//		root.getChildren().add(btn1);
//		root.setAlignment(Pos.CENTER);
//		btn1.setOnAction(e -> {
////			primaryStage.setScene(coursePane.getScene());
//
//		});

//
//		Button btn2 = new Button("Student");
//		root.getChildren().add(btn2);
//		btn2.setOnAction(e -> {
//			StudentPane studentPane = new StudentPane(college);
//		    primaryStage.getScene().setRoot(studentPane.getGridPane());
//
//		});
//
//		Button btn3 = new Button("Faculty");
//		root.getChildren().add(btn3);
//		root.setAlignment(Pos.CENTER);
//		btn3.setOnAction(e -> {
////			primaryStage.setScene(facultyPane.getScene());
//
//		});
//
//		Button btn4 = new Button("Textbook");
//		root.getChildren().add(btn4);
//		root.setAlignment(Pos.CENTER);
//		btn4.setOnAction(e -> {
////			primaryStage.setScene(textbookPane.getScene());
//
//		});

	

	}

}
