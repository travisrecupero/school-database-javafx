package model;

import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FacultyPane {
	private GridPane gridPane;
	private Button addBtn;
	private Button findBtn;
	private Button removeBtn;
	private Button updateBtn;
	private Button saveBtn;

	private TextField firstNameField;
	private TextField middleInitialField;
	private TextField lastNameField;
	private TextField phoneField;
	private TextField salaryField;
	private TextField titleField;

	public FacultyPane(College college) {
		final int BUTTON_WIDTH = 130;
		final int BUTTON_HEIGHT = 100;
		final int TEXTFIELD_WIDTH = 250;
		gridPane = new GridPane();
		gridPane.setPadding(new Insets(30));
		gridPane.setHgap(20);
		gridPane.setVgap(30);

		firstNameField = new TextField();
		firstNameField.setPromptText("First Name");
		firstNameField.setPrefWidth(TEXTFIELD_WIDTH);

		middleInitialField = new TextField();
		middleInitialField.setPromptText("M.I.");
		middleInitialField.setPrefWidth(40);

		lastNameField = new TextField();
		lastNameField.setPromptText("Last Name");
		lastNameField.setPrefWidth(TEXTFIELD_WIDTH);

		phoneField = new TextField();
		phoneField.setPromptText("Phone");
		phoneField.setPrefWidth(TEXTFIELD_WIDTH);

		salaryField = new TextField();
		salaryField.setPromptText("Salary");
		salaryField.setPrefWidth(TEXTFIELD_WIDTH);

		ObservableList<String> options = FXCollections.observableArrayList("Academic Chair", "Assistant Academic Chair",
				"Full-Time Professor", "Part-Time Professor", "Tutor");
		final ComboBox<String> titleComboBox = new ComboBox<String>(options);
		titleComboBox.setPromptText("Title(s):");

		///////////////////////////////////////////
		addBtn = new Button("Add");
		addBtn.setFont(Font.font("Matura MT Script Capitals", 20));
		addBtn.setTextFill(Color.VIOLET);
		addBtn.setPrefWidth(BUTTON_WIDTH);
		addBtn.setPrefHeight(BUTTON_HEIGHT);
		addBtn.setOnAction(e -> {
			Name name = new Name(firstNameField.getText(), lastNameField.getText());
			Faculty faculty = new Faculty();
			if (middleInitialField.getText().length() != 0) {
				name.setMiddleInitial(middleInitialField.getText().charAt(0));
			}
			faculty.setPhone(phoneField.getText());
			faculty.setSalary(Double.parseDouble(salaryField.getText()));
			faculty.setName(name);
			faculty.setTitle(titleComboBox.getSelectionModel().getSelectedItem());
			college.getPersonBag().add(faculty);
			firstNameField.clear();
			middleInitialField.clear();
			lastNameField.clear();
			phoneField.clear();
			salaryField.clear();
			titleComboBox.getSelectionModel().clearSelection();

		});

		findBtn = new Button("Find");
		findBtn.setFont(Font.font("Matura MT Script Capitals", 20));
		findBtn.setTextFill(Color.VIOLET);
		findBtn.setPrefWidth(BUTTON_WIDTH);
		findBtn.setPrefHeight(BUTTON_HEIGHT);
		findBtn.setOnAction(e -> {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Find Faculty");
			dialog.setHeaderText("Find Faculty by ID#");
			dialog.setContentText("Please enter ID:");
			Optional<String> result = dialog.showAndWait();

			if (result.isPresent()) {
				Person p1 = college.getPersonBag().findById(result.get());

				if (p1 instanceof Faculty) {
					Faculty f1 = (Faculty) p1;

					BorderPane root = new BorderPane();
					VBox pane = new VBox();
					root.setLeft(pane);

					Text firstName = new Text();
					firstName.setText("First Name: " + f1.getName().getFirstName());
					Text middleInitial = new Text();
					middleInitial.setText("M.I.: " + String.valueOf(f1.getName().getMiddleInitial()));
					Text lastName = new Text();
					lastName.setText("Last Name: " + f1.getName().getLastName());
					Text phone = new Text();
					phone.setText("Phone: " + f1.getPhone());
					Text salary = new Text();
					salary.setText("Salary: " + f1.getSalary());

					pane.getChildren().addAll(firstName, middleInitial, lastName, phone, salary);

					Scene secondScene = new Scene(root, 500, 300);
					Stage stage = new Stage();
					stage.setTitle("Found Student");
					stage.setScene(secondScene);
					stage.showAndWait();
				}
				if (!(p1 instanceof Faculty)) {
					Alert personAlert = new Alert(AlertType.INFORMATION);
					personAlert.setTitle("Alert!");
					personAlert.setHeaderText("Information Alert");
					String s = "The ID entered was not a faculty member!";
					personAlert.setContentText(s);
					personAlert.showAndWait();

				}
			}

		});

		
		removeBtn = new Button("Remove");
		removeBtn.setFont(Font.font("Matura MT Script Capitals", 20));
		removeBtn.setTextFill(Color.VIOLET);
		removeBtn.setPrefWidth(BUTTON_WIDTH);
		removeBtn.setPrefHeight(BUTTON_HEIGHT);
		removeBtn.setOnAction(e -> {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Remove Faculty Member");
			dialog.setHeaderText("Remove Faculty by ID#");
			dialog.setContentText("Please enter ID:");
			Optional<String> result = dialog.showAndWait();
		
			
			if (result.isPresent()) {
				Person p1 = college.getPersonBag().findById(result.get());
				if (!(p1 instanceof Faculty)) {
					Alert personAlert = new Alert(AlertType.INFORMATION);
					personAlert.setTitle("Alert!");
					personAlert.setHeaderText("Information Alert");
					String s = "The ID entered was not a faculty member!";
					personAlert.setContentText(s);
					personAlert.showAndWait();
				} else {
					college.getPersonBag().removeById(result.get());
				}
			}
			
			
		});

		updateBtn = new Button("Update");
		updateBtn.setFont(Font.font("Matura MT Script Capitals", 20));
		updateBtn.setTextFill(Color.VIOLET);
		updateBtn.setPrefWidth(BUTTON_WIDTH);
		updateBtn.setPrefHeight(BUTTON_HEIGHT);
		updateBtn.setOnAction(e -> {
		});

		HBox btnBox = new HBox(40);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().addAll(addBtn, findBtn, removeBtn, updateBtn);

		gridPane.add(firstNameField, 0, 0, 2, 1);
		gridPane.add(middleInitialField, 2, 0, 2, 1);
		gridPane.add(lastNameField, 4, 0, 2, 1);
		gridPane.add(phoneField, 0, 2, 2, 1);
		gridPane.add(salaryField, 2, 2, 2, 1);
		gridPane.add(titleComboBox, 0, 4, 2, 1);
		gridPane.add(btnBox, 0, 8, 8, 1);
	}

	public GridPane getGridPane() {
		return gridPane;
	}
}
