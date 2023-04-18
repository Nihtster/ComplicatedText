import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * ComplicatedTextUI is the GUI adaption of the code for ComplicatedText,
 * providing the user with a more approachable and more enjoyble user
 * experience.
 * 
 * @author Christian "Nihtster" Ilog
 * @version 0.2
 */

public class ComplicatedTextUI extends Application {

    @Override
    public void start(Stage mainStage) {
        mainStage.setTitle("ComplicatedText");

        // Display formatting
        Label display = new Label("This is where the displayed text will appear.");
        display.setFont(new Font(40));
        display.setWrapText(true);
        display.setAlignment(Pos.CENTER);
        display.setTextAlignment(TextAlignment.CENTER);
        display.setPadding(new Insets(40));

        // TextField formatting
        TextField userStr = new TextField();
        userStr.setMaxWidth(500);
        userStr.setMinHeight(40);
        userStr.setFont(new Font(20));

        // Button Formatting
        Button enter = new Button("Enter");
        enter.setAlignment(Pos.CENTER);
        enter.setTextAlignment(TextAlignment.CENTER);
        enter.setFont(new Font(20));
        enter.setPrefSize(200, 50);

        // -----------------------

        Button send = new Button("Send");
        send.setAlignment(Pos.CENTER);
        send.setTextAlignment(TextAlignment.CENTER);
        send.setFont(new Font(20));
        send.setPrefSize(200, 50);

        // ------------------------
        FlowPane buttons = new FlowPane();
        buttons.setHgap(20);
        buttons.setAlignment(Pos.CENTER);
        ObservableList list = buttons.getChildren();
        list.addAll(enter, send);

        // Window & Pane Formatting

        BorderPane interactPane = new BorderPane();
        interactPane.setPadding(new Insets(0));
        interactPane.setTop(userStr);
        interactPane.setCenter(buttons);
        BorderPane.setAlignment(userStr, Pos.TOP_CENTER);

        BorderPane mainPane = new BorderPane();
        mainPane.setTop(display);
        mainPane.setCenter(interactPane);
        Scene scene = new Scene(mainPane, 600, 350);
        mainStage.setResizable(false);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
