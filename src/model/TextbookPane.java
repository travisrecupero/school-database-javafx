package model;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextbookPane {
	private GridPane gridPane;
	private Button addBtn;
	private Button findBtn;
	private Button removeBtn;
	private Button updateBtn;

	private TextField textbookTitleField;
	private TextField textbookISBNField;
	private TextField firstNameField;
	private TextField middleInitialField;
	private TextField lastNameField;
	private TextField priceField;


	public TextbookPane(College college) {
		final int BUTTON_WIDTH = 130;
		final int BUTTON_HEIGHT = 100;
		final int TEXTFIELD_WIDTH = 250;
	
		
		gridPane = new GridPane();
		gridPane.setPadding(new Insets(30));
		gridPane.setHgap(20);
		gridPane.setVgap(30);
	
		textbookTitleField = new TextField();
		textbookTitleField.setPromptText("Textbook Title");
		textbookTitleField.setPrefWidth(TEXTFIELD_WIDTH);
		
		firstNameField = new TextField();
		firstNameField.setPromptText("Author's First Name");
		firstNameField.setPrefWidth(TEXTFIELD_WIDTH);

		middleInitialField = new TextField();
		middleInitialField.setPromptText("Author's M.I.");
		middleInitialField.setPrefWidth(40);

		lastNameField = new TextField();
		lastNameField.setPromptText("Author's Last Name");
		lastNameField.setPrefWidth(TEXTFIELD_WIDTH);
		
		textbookISBNField = new TextField();
		textbookISBNField.setPromptText("Textbook ISBN");
		textbookISBNField.setPrefWidth(TEXTFIELD_WIDTH);
	
		
		priceField = new TextField();
		priceField.setPromptText("Price");
		priceField.setPrefWidth(TEXTFIELD_WIDTH);
		
		
		///////////////////////////////////////////////
		addBtn = new Button("Add");
		addBtn.setFont(Font.font("Matura MT Script Capitals", 20));
		addBtn.setTextFill(Color.GREEN);
		addBtn.setPrefWidth(BUTTON_WIDTH);
		addBtn.setPrefHeight(BUTTON_HEIGHT);
		addBtn.setOnAction(e -> {
			
			Textbook textbook = new Textbook();
			Name name = new Name(firstNameField.getText(), lastNameField.getText());
			if (middleInitialField.getText().length() != 0) {
				name.setMiddleInitial(middleInitialField.getText().charAt(0));
			}
			textbook.setTitle(textbookTitleField.getText());
			textbook.setAuthor(name);
			textbook.setIsbn(textbookISBNField.getText());
			textbook.setPrice(Double.parseDouble(priceField.getText()));
			college.getTextbookBag().add(textbook);
			textbookTitleField.clear();
			firstNameField.clear();
			middleInitialField.clear();
			lastNameField.clear();
			textbookISBNField.clear();
			
		});

		findBtn = new Button("Find");
		findBtn.setFont(Font.font("Matura MT Script Capitals", 20));
		findBtn.setTextFill(Color.GREEN);
		findBtn.setPrefWidth(BUTTON_WIDTH);
		findBtn.setPrefHeight(BUTTON_HEIGHT);
		
		
		removeBtn = new Button("Remove");
		removeBtn.setFont(Font.font("Matura MT Script Capitals", 20));
		removeBtn.setTextFill(Color.GREEN);
		removeBtn.setPrefWidth(BUTTON_WIDTH);
		removeBtn.setPrefHeight(BUTTON_HEIGHT);
	
		
		updateBtn = new Button("Update");
		updateBtn.setFont(Font.font("Matura MT Script Capitals", 20));
		updateBtn.setTextFill(Color.GREEN);
		updateBtn.setPrefWidth(BUTTON_WIDTH);
		updateBtn.setPrefHeight(BUTTON_HEIGHT);
	
		
		
		HBox btnBox = new HBox(40);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().addAll(addBtn, findBtn, removeBtn, updateBtn);

		
		gridPane.add(textbookTitleField, 0, 0, 2, 1);
		gridPane.add(firstNameField, 0, 2, 2, 1);
		gridPane.add(middleInitialField, 2, 2, 2, 1);
		gridPane.add(lastNameField, 4, 2, 2, 1);
		gridPane.add(textbookISBNField, 0, 4, 2, 1);
		gridPane.add(priceField, 2, 4, 2, 1);
		gridPane.add(btnBox, 0, 8, 8, 1);
	//	gridPane.add(text, 1, 3, 4, 1);
	}

	
	
	public GridPane getGridPane() {
		return gridPane;
	}
}
