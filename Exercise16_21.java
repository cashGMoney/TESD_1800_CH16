import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Exercise16_21 extends Application {

    // Timeline trigger variable for audio
    private Timeline timeline;

    // Integar variable for countdown timer
    private int countDownSeconds;

    public void start(Stage primaryStage) {

        // Create a text field for Interger value from User
        TextField input = new TextField();
        input.setPromptText("Enter time in seconds and press Enter");

        // Create the VBox
        VBox vBox = new VBox(input);
        vBox.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Create the Scene and Stage
        Scene scene = new Scene(vBox, 300, 300);
        primaryStage.setTitle("Exercise 16_21");
        primaryStage.setScene(scene);
        primaryStage.show();

        // setOnAction with Enter key
        input.setOnAction(e -> {
            
            // Create try and catch statements for invalid Number input
            try {
                countDownSeconds = Integer.parseInt(input.getText());
                input.clear();
                startCountDown(input);

            // Number format exception error if value is not a number
            } catch (NumberFormatException ex) {
                input.setText("Invalid. Please enter a number.");
            }
        });
    }

    // Create timeline that uses Keyframe to control action event of Countdown timer
    private void startCountDown(TextField displayField) {
        if (timeline != null) {
            timeline.stop();
        }

        // Add new timeline with Keyframe
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            if (countDownSeconds > 0) {
                countDownSeconds--;
                displayField.setText(countDownSeconds + " seconds");
            } else {
                timeline.stop();
                playMusic();
                displayField.setText("Begin Music (if no audio, make sure connected to internet)");
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void playMusic() {
        // Attached link using String to sound and sound to Media
        String musicHyperLink = "https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3";
        Media sound = new Media(musicHyperLink);
        MediaPlayer mediaPlayer = new MediaPlayer(sound);

        // Play music Continuously by using INDEFINITE CycleCount
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
