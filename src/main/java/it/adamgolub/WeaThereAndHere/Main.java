package it.adamgolub.WeaThereAndHere;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;
import java.io.IOException;

/**
 * Created by Adam Gołub on 20.12.2019.
 */

public class Main extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("GridPaneMain"));

        scene.getStylesheets().add("it/adamgolub/css/style.css");

        stage.setScene(scene);
        //OWM owm = new OWM("40089bcd3a7da1d179139e9ed0126510");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws APIException {
        //OWM owm = new OWM("40089bcd3a7da1d179139e9ed0126510");
        //CurrentWeather cwd = owm.currentWeatherByCityName("London");


        //System.out.println("City: " + cwd.getCityName());
        //System.out.println("Temperature: " + cwd.getMainData().getTempMax()
        //        + "/" + cwd.getMainData().getTempMin() + "\'K");
        launch();
    }
}