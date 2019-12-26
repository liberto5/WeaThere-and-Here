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
    private Label precipitationTodayFirstCity;
    @FXML
    private Label windTodayFirstCity;
    @FXML
    private Label pressureTodayFirstCity;

    @FXML
    private Label tomorrowDateInFirstCity;
    @FXML
    private ImageView tomorrowWeatherFirstCityImage;
    @FXML
    private Label maxTempTomorrowFirstCity;
    @FXML
    private Label minTempTomorrowFirstCity;
    @FXML
    private Label precipitationTomorrowFirstCity;
    @FXML
    private Label windTomorrowFirstCity;
    @FXML
    private Label pressureTomorrowFirstCity;

    @FXML
    private Label inTwoDaysDateInFirstCity;
    @FXML
    private ImageView inTwoDaysWeatherFirstCityImage;
    @FXML
    private Label maxTempInTwoDaysFirstCity;
    @FXML
    private Label minTempInTwoDaysFirstCity;
    @FXML
    private Label precipitationInTwoDaysFirstCity;
    @FXML
    private Label windInTwoDaysFirstCity;
    @FXML
    private Label pressureInTwoDaysFirstCity;

    @FXML
    private Label inThreeDaysDateInFirstCity;
    @FXML
    private ImageView inThreeDaysWeatherFirstCityImage;
    @FXML
    private Label maxTempInThreeDaysFirstCity;
    @FXML
    private Label minTempInThreeDaysFirstCity;
    @FXML
    private Label precipitationInThreeDaysFirstCity;
    @FXML
    private Label windInThreeDaysFirstCity;
    @FXML
    private Label pressureInThreeDaysFirstCity;

    @FXML
    private Label inFourDaysDateInFirstCity;
    @FXML
    private ImageView inFourDaysWeatherFirstCityImage;
    @FXML
    private Label maxTempInFourDaysFirstCity;
    @FXML
    private Label minTempInFourDaysFirstCity;
    @FXML
    private Label precipitationInFourDaysFirstCity;
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
    private Label precipitationTodaySecondCity;
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
    private Label precipitationTomorrowSecondCity;
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
    private Label precipitationInTwoDaysSecondCity;
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
    private Label precipitationInThreeDaysSecondCity;
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
    private Label precipitationInFourDaysSecondCity;
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
        precipitationTodayFirstCity.setText(gridPaneModel.getPrecipitationToday());
    }
}