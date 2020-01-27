package model;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FindTextBookPane {

	private BorderPane borderPane;
	private VBox vbox = new VBox();
	private Stage stage = new Stage();
	private Scene scene = new Scene(borderPane, 500, 500);
	
	
	public FindTextBookPane(Textbook textbook){
		
		
	}


	public BorderPane getBorderPane() {
		return borderPane;
	}


	public void setBorderPane(BorderPane borderPane) {
		this.borderPane = borderPane;
	}


	public VBox getVbox() {
		return vbox;
	}


	public void setVbox(VBox vbox) {
		this.vbox = vbox;
	}


	public Stage getStage() {
		return stage;
	}


	public void setStage(Stage stage) {
		this.stage = stage;
	}


	public Scene getScene() {
		return scene;
	}


	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
}
