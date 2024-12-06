import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Exercise16_01 extends Application {
    protected Text text = new Text(50, 50, "Programming is fun");

    protected BorderPane getPane() {

        // Create an HBox for the Color buttons at the top
        HBox paneForTopButton = new HBox();

		// Red Radio Button
        RadioButton btRedButton = new RadioButton("Red");
		// btRedButton.setTextFill(Color.RED);

		// Yellow Radio Button
		RadioButton btYellowButton = new RadioButton("Yellow");

		// Black Radio Button
		RadioButton btBlackButton = new RadioButton("Black");

		// Orange Radio Button
		RadioButton btOrangeButton = new RadioButton("Orange");

		// Green Radio Button
		RadioButton btGreenButton = new RadioButton("Green");

		// Color Button Toggle
		ToggleGroup group = new ToggleGroup();
  		btRedButton.setToggleGroup(group);
  		btYellowButton.setToggleGroup(group);
		btBlackButton.setToggleGroup(group);
		btOrangeButton.setToggleGroup(group);
		btGreenButton.setToggleGroup(group);

        paneForTopButton.getChildren().addAll(btRedButton, btYellowButton, btBlackButton, btOrangeButton, btGreenButton);
        paneForTopButton.setAlignment(Pos.CENTER);
        paneForTopButton.setStyle("-fx-border-color: black");

		// Change Text color to RED
		btRedButton.setOnAction(e -> {
			if (btRedButton.isSelected()) {
			text.setFill(Color.RED);
			}
		});

		// Change Text color to YELLOW
		btYellowButton.setOnAction(e -> {
			if (btYellowButton.isSelected()) {
			text.setFill(Color.YELLOW);
			}
		});

		// Change Text color to BLACK
		btBlackButton.setOnAction(e -> {
			if (btBlackButton.isSelected()) {
			text.setFill(Color.BLACK);
			}
		});

		// Change Text color to ORANGE
		btOrangeButton.setOnAction(e -> {
			if (btOrangeButton.isSelected()) {
			text.setFill(Color.ORANGE);
			}
		});

		// Change Text color to GREEN
		btGreenButton.setOnAction(e -> {
			if (btGreenButton.isSelected()) {
			text.setFill(Color.GREEN);
			}
		});

        // Create an HBox for the Left and Right buttons and place them at the bottom
        HBox paneForBottomButtons = new HBox(20);
        Button btLeft = new Button("<=");
        Button btRight = new Button("=>");
        paneForBottomButtons.getChildren().addAll(btLeft, btRight);
        paneForBottomButtons.setAlignment(Pos.CENTER);
        paneForBottomButtons.setStyle("-fx-border-color: black");

        // Create the BorderPane and set the top, bottom, and center
        BorderPane pane = new BorderPane();
        pane.setTop(paneForTopButton);
        pane.setBottom(paneForBottomButtons);

        // Add the text to the center
        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);

        // Set button actions
        btLeft.setOnAction(e -> text.setX(text.getX() - 10));
        btRight.setOnAction(e -> text.setX(text.getX() + 10));

        return pane;
    }

    @Override
    public void start(Stage primaryStage) {

        // Create a scene and place it in the stage
        Scene scene = new Scene(getPane(), 450, 200);
        primaryStage.setTitle("Exercise 16_01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
