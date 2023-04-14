import javafx.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ComplicatedTextUI extends Application {

    @Override
    public void start(Stage mainStage) {
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 400, 250);
        mainStage.setTitle("ComplicatedText");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
