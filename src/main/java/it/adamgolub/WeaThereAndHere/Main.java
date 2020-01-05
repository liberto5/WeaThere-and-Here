package it.adamgolub.WeaThereAndHere;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Created by Adam Gołub on 20.12.2019.
 */

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(loadFXML());
        scene.getStylesheets().add("/it/adamgolub/css/style.css");
        stage.setTitle("WeaThere and Here - by Adam Gołub");
        Image icon = new Image(getClass().getResourceAsStream("/it/adamgolub/icons/favicon.png"));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    private static Parent loadFXML() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("GridPaneMain" + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}