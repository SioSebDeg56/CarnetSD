package stage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApp extends Application {

    private static Stage stg;
    public User logUser;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stg = primaryStage;
        primaryStage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Connexion.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        //scene.getStylesheets().add("style.css");
        primaryStage.setTitle("Stagiaires");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void nextScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
//test github efzefezfezfzefezf vevezfezfezfezfezfef
        launch(args);
    }

}
//  fx:controller="stage.Connexion"