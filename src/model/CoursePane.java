package model;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CoursePane {
	private GridPane gridPane;
	private Button addBtn;
	private Button findBtn;
	private Button removeBtn;
	private Button updateBtn;

	private TextField courseTitleField;
	private TextField courseNumberField;
	private TextField TextbookISBNField;
	private TextField numOfCreditsField;
	private TextField facultyIDField;

	private Text text;

	public CoursePane(College college) {
		final int BUTTON_WIDTH = 130;
		final int BUTTON_HEIGHT = 100;
		final int TEXTFIELD_WIDTH = 250;
		text = new Text("Course Pane");
		text.setFont(Font.font("Verdana", 20));
		text.setStrokeWidth(6);
		text.setFill(Color.RED);
		gridPane = new GridPane();
		gridPane.setPadding(new Insets(30));
		gridPane.setHgap(20);
		gridPane.setVgap(30);

		courseTitleField = new TextField();
		courseTitleField.setPromptText("Course Title");
		courseTitleField.setPrefWidth(TEXTFIELD_WIDTH);

		courseNumberField = new TextField();
		courseNumberField.setPromptText("Course Number");
		courseNumberField.setPrefWidth(TEXTFIELD_WIDTH);

		TextbookISBNField = new TextField();
		TextbookISBNField.setPromptText("Textbook ISBN");
		TextbookISBNField.setPrefWidth(TEXTFIELD_WIDTH);

		numOfCreditsField = new TextField();
		numOfCreditsField.setPromptText("Credits");
		numOfCreditsField.setPrefWidth(TEXTFIELD_WIDTH);

		facultyIDField = new TextField();
		facultyIDField.setPromptText("Faculty ID");
		facultyIDField.setPrefWidth(TEXTFIELD_WIDTH);



		TreeItem<String> masterRoot = new TreeItem<>("master");
		TreeItem<String> rootItem1 = new TreeItem<>("CST");
		TreeItem<String> item = new TreeItem<>("Introduction to Computer Science and Info. Tech.");
		TreeItem<String> item1 = new TreeItem<>("Introduction to Programming");
		TreeItem<String> item2 = new TreeItem<>("Principles of Java");
		TreeItem<String> item3 = new TreeItem<>("Adv. Programming and Problem Solving w. Java");
		rootItem1.getChildren().addAll(item, item1, item2, item3);

		TreeItem<String> rootItem2 = new TreeItem<>("CSE");
		TreeItem<String> item4 = new TreeItem<>("Fundamentals of Programming");
		TreeItem<String> item5 = new TreeItem<>("Object-Oriented Programming");
		TreeItem<String> item6 = new TreeItem<>("Data Structures and Algorithims");
		TreeItem<String> item7 = new TreeItem<>("Computer Architecture");
		rootItem2.getChildren().addAll(item4, item5, item6, item7);

		TreeItem<String> rootItem3 = new TreeItem<>("MAT");
		TreeItem<String> item8 = new TreeItem<>("Calculus I");
		TreeItem<String> item9 = new TreeItem<>("Calculus II");
		TreeItem<String> item10 = new TreeItem<>("Calculus III");
		TreeItem<String> item11 = new TreeItem<>("Differential Equations");
		rootItem3.getChildren().addAll(item8, item9, item10, item11);

		TreeItem<String> rootItem4 = new TreeItem<>("PHY");
		TreeItem<String> item12 = new TreeItem<>("Physics I");
		TreeItem<String> item13 = new TreeItem<>("Physics II");
		TreeItem<String> item14 = new TreeItem<>("Physics III");
		TreeItem<String> item15 = new TreeItem<>("Physics IV");
		rootItem4.getChildren().addAll(item12, item13, item14, item15);

		TreeItem<String> rootItem5 = new TreeItem<>("CHE");
		TreeItem<String> item16 = new TreeItem<>("College Chemistry I");
		TreeItem<String> item17 = new TreeItem<>("College Chemistry II");
		TreeItem<String> item18 = new TreeItem<>("Organic Chemistry I");
		TreeItem<String> item19 = new TreeItem<>("Organic Chemistry II");
		rootItem5.getChildren().addAll(item16, item17, item18, item19);

		masterRoot.getChildren().addAll(rootItem1, rootItem2, rootItem3, rootItem4, rootItem5);
		TreeView<String> tree = new TreeView<>(masterRoot);
		tree.setShowRoot(false);




		///////////////////////////////////////////////
		addBtn = new Button("Add");
		addBtn.setFont(Font.font("Matura MT Script Capitals", 20));
		addBtn.setTextFill(Color.BLUE);
		addBtn.setPrefWidth(BUTTON_WIDTH);
		addBtn.setPrefHeight(BUTTON_HEIGHT);
		addBtn.setOnAction(e -> {





		});


		findBtn = new Button("Find");
		findBtn.setFont(Font.font("Matura MT Script Capitals", 20));
		findBtn.setTextFill(Color.BLUE);
		findBtn.setPrefWidth(BUTTON_WIDTH);
		findBtn.setPrefHeight(BUTTON_HEIGHT);


		removeBtn = new Button("Remove");
		removeBtn.setFont(Font.font("Matura MT Script Capitals", 20));
		removeBtn.setTextFill(Color.BLUE);
		removeBtn.setPrefWidth(BUTTON_WIDTH);
		removeBtn.setPrefHeight(BUTTON_HEIGHT);


		updateBtn = new Button("Update");
		updateBtn.setFont(Font.font("Matura MT Script Capitals", 20));
		updateBtn.setTextFill(Color.BLUE);
		updateBtn.setPrefWidth(BUTTON_WIDTH);
		updateBtn.setPrefHeight(BUTTON_HEIGHT);
		///////////////////////////////////////////////


		HBox btnBox = new HBox(40);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().addAll(addBtn, findBtn, removeBtn, updateBtn);


		gridPane.add(courseTitleField, 0, 0, 2, 1);
		gridPane.add(courseNumberField, 2, 0, 2, 1);
		gridPane.add(TextbookISBNField, 0, 2, 2, 1);
		gridPane.add(numOfCreditsField, 2, 2, 2, 1);
		gridPane.add(facultyIDField, 0, 4, 2, 1);
		gridPane.add(btnBox, 0, 8, 8, 1);
		gridPane.add(tree, 4, 0, 5, 7);
	//	gridPane.add(text, 1, 3, 4, 1);
	}

	public GridPane getGridPane() {
		return gridPane;
	}
}