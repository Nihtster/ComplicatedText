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

    TextField userStr;
    Label display;
    Button enter;
    Button send;
    FlowPane buttons;
    BorderPane interactPane;
    BorderPane mainPane;
    Scene scene;
    Stage mainStage;

    @Override
    public void start(Stage mainStage) {
        mainStage.setTitle("ComplicatedText");

        dispSetup();
        txtfieldSetup();
        enterButtonSetup();
        sendButtonSetup();
        buttonPaneSetup();
        sceneSetup();

        mainStage.setResizable(false);
        mainStage.setScene(scene);
        mainStage.show();

        // Window & Pane Formatting

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void dispSetup() {
        // Display formatting
        display = new Label("This is where the displayed text will appear.");
        display.setFont(new Font(40));
        display.setWrapText(true);
        display.setAlignment(Pos.CENTER);
        display.setTextAlignment(TextAlignment.CENTER);
        display.setPadding(new Insets(40));
    }

    private void txtfieldSetup() {
        userStr = new TextField();
        userStr.setMaxWidth(500);
        userStr.setMinHeight(40);
        userStr.setFont(new Font(20));
    }

    private void enterButtonSetup() {
        enter = new Button("Enter");
        enter.setAlignment(Pos.CENTER);
        enter.setTextAlignment(TextAlignment.CENTER);
        enter.setFont(new Font(20));
        enter.setPrefSize(200, 50);
    }

    private void sendButtonSetup() {
        send = new Button("Send");
        send.setAlignment(Pos.CENTER);
        send.setTextAlignment(TextAlignment.CENTER);
        send.setFont(new Font(20));
        send.setPrefSize(200, 50);
    }

    private void buttonPaneSetup() {
        buttons = new FlowPane();
        buttons.setHgap(20);
        buttons.setAlignment(Pos.CENTER);
        ObservableList list = buttons.getChildren();
        list.addAll(enter, send);
    }

    private void sceneSetup() {
        interactPane = new BorderPane();
        interactPane.setPadding(new Insets(0));
        interactPane.setTop(userStr);
        interactPane.setCenter(buttons);
        BorderPane.setAlignment(userStr, Pos.TOP_CENTER);

        mainPane = new BorderPane();
        mainPane.setTop(display);
        mainPane.setCenter(interactPane);
        scene = new Scene(mainPane, 600, 350);

    }

}
