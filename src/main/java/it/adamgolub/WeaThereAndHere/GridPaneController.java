package it.adamgolub.WeaThereAndHere;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;

/**
 * Created by Adam on 23.12.2019.
 */
public class GridPaneController {

    @FXML
    private Label firstCityName;
    @FXML
    private Label todayDateInFirstCity;
    @FXML
    private ImageView todayWeatherFirstCityImage;
    @FXML
    private Label maxTempTodayFirstCity;
    @FXML
    private Label minTempTodayFirstCity;
    @FXML
    private Label humidityTodayFirstCity;
    @FXML
    private Label windTodayFirstCity;
    @FXML
    private Label pressureTodayFirstCity;

    @FXML
    private Label tomorrowDateInFirstCity;
    @FXML
    private ImageView tomorrowWeatherFirstCityImage;
    @FXML
    private Label tempTomorrowFirstCity;
    @FXML
    private Label humidityTomorrowFirstCity;
    @FXML
    private Label windTomorrowFirstCity;
    @FXML
    private Label pressureTomorrowFirstCity;

    @FXML
    private Label inTwoDaysDateInFirstCity;
    @FXML
    private ImageView inTwoDaysWeatherFirstCityImage;
    @FXML
    private Label tempInTwoDaysFirstCity;
    @FXML
    private Label humidityInTwoDaysFirstCity;
    @FXML
    private Label windInTwoDaysFirstCity;
    @FXML
    private Label pressureInTwoDaysFirstCity;

    @FXML
    private Label inThreeDaysDateInFirstCity;
    @FXML
    private ImageView inThreeDaysWeatherFirstCityImage;
    @FXML
    private Label tempInThreeDaysFirstCity;
    @FXML
    private Label humidityInThreeDaysFirstCity;
    @FXML
    private Label windInThreeDaysFirstCity;
    @FXML
    private Label pressureInThreeDaysFirstCity;

    @FXML
    private Label inFourDaysDateInFirstCity;
    @FXML
    private ImageView inFourDaysWeatherFirstCityImage;
    @FXML
    private Label tempInFourDaysFirstCity;
    @FXML
    private Label humidityInFourDaysFirstCity;
    @FXML
    private Label windInFourDaysFirstCity;
    @FXML
    private Label pressureInFourDaysFirstCity;

    @FXML
    private Label secondCityName;
    @FXML
    private Label todayDateInSecondCity;
    @FXML
    private ImageView todayWeatherSecondCityImage;
    @FXML
    private Label maxTempTodaySecondCity;
    @FXML
    private Label minTempTodaySecondCity;
    @FXML
    private Label humidityTodaySecondCity;
    @FXML
    private Label windTodaySecondCity;
    @FXML
    private Label pressureTodaySecondCity;

    @FXML
    private Label tomorrowDateInSecondCity;
    @FXML
    private ImageView tomorrowWeatherSecondCityImage;
    @FXML
    private Label maxTempTomorrowSecondCity;
    @FXML
    private Label minTempTomorrowSecondCity;
    @FXML
    private Label humidityTomorrowSecondCity;
    @FXML
    private Label windTomorrowSecondCity;
    @FXML
    private Label pressureTomorrowSecondCity;

    @FXML
    private Label inTwoDaysDateInSecondCity;
    @FXML
    private ImageView inTwoDaysWeatherSecondCityImage;
    @FXML
    private Label maxTempInTwoDaysSecondCity;
    @FXML
    private Label minTempInTwoDaysSecondCity;
    @FXML
    private Label humidityInTwoDaysSecondCity;
    @FXML
    private Label windInTwoDaysSecondCity;
    @FXML
    private Label pressureInTwoDaysSecondCity;

    @FXML
    private Label inThreeDaysDateInSecondCity;
    @FXML
    private ImageView inThreeDaysWeatherSecondCityImage;
    @FXML
    private Label maxTempInThreeDaysSecondCity;
    @FXML
    private Label minTempInThreeDaysSecondCity;
    @FXML
    private Label humidityInThreeDaysSecondCity;
    @FXML
    private Label windInThreeDaysSecondCity;
    @FXML
    private Label pressureInThreeDaysSecondCity;

    @FXML
    private Label inFourDaysDateInSecondCity;
    @FXML
    private ImageView inFourDaysWeatherSecondCityImage;
    @FXML
    private Label maxTempInFourDaysSecondCity;
    @FXML
    private Label minTempInFourDaysSecondCity;
    @FXML
    private Label humidityInFourDaysSecondCity;
    @FXML
    private Label windInFourDaysSecondCity;
    @FXML
    private Label pressureInFourDaysSecondCity;

    public GridPaneController() {
        //System.out.println("Jestem kontrolerem");
    }

    @FXML
    void initialize () throws APIException {
        GridPaneModel gridPaneModel = new GridPaneModel();

        firstCityName.setText(gridPaneModel.getCityName());
        maxTempTodayFirstCity.setText(gridPaneModel.getMaxTempToday());
        minTempTodayFirstCity.setText(gridPaneModel.getMinTempToday());
        humidityTodayFirstCity.setText(gridPaneModel.getHumidityToday());
        windTodayFirstCity.setText(gridPaneModel.getWindToday());
        pressureTodayFirstCity.setText(gridPaneModel.getPressureToday());
        tempTomorrowFirstCity.setText(gridPaneModel.getTemperatureForecast(1));
        humidityTomorrowFirstCity.setText(gridPaneModel.getHumidityForecast(1));
        windTomorrowFirstCity.setText(gridPaneModel.getWindForecast(1));
        pressureTomorrowFirstCity.setText(gridPaneModel.getPressureForecast(1));
        tempInTwoDaysFirstCity.setText(gridPaneModel.getTemperatureForecast(2));
        humidityInTwoDaysFirstCity.setText(gridPaneModel.getHumidityForecast(2));
        windInTwoDaysFirstCity.setText(gridPaneModel.getWindForecast(2));
        pressureInTwoDaysFirstCity.setText(gridPaneModel.getPressureForecast(2));
        tempInThreeDaysFirstCity.setText(gridPaneModel.getTemperatureForecast(3));
        humidityInThreeDaysFirstCity.setText(gridPaneModel.getHumidityForecast(3));
        windInThreeDaysFirstCity.setText(gridPaneModel.getWindForecast(3));
        pressureInThreeDaysFirstCity.setText(gridPaneModel.getPressureForecast(3));
        tempInFourDaysFirstCity.setText(gridPaneModel.getTemperatureForecast(4));
        humidityInFourDaysFirstCity.setText(gridPaneModel.getHumidityForecast(4));
        windInFourDaysFirstCity.setText(gridPaneModel.getWindForecast(4));
        pressureInFourDaysFirstCity.setText(gridPaneModel.getPressureForecast(4));
    }
}