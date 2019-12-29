package it.adamgolub.WeaThereAndHere;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import net.aksingh.owmjapis.api.APIException;

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
    private Label tempTomorrowSecondCity;
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
    private Label tempInTwoDaysSecondCity;
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
    private Label tempInThreeDaysSecondCity;
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
    private Label tempInFourDaysSecondCity;
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

        getTodayWeatherFirstCity(gridPaneModel);
        getTomorrowWeatherFirstCity(gridPaneModel);
        getWeatherInTwoDaysFirstCity(gridPaneModel);
        getWeatherInThreeDaysFirstCity(gridPaneModel);
        getWeatherInFourDaysFirstCity(gridPaneModel);

        secondCityName.setText(gridPaneModel.getCityName());

        getTodayWeatherSecondCity(gridPaneModel);
        getTomorrowWeatherSecondCity(gridPaneModel);
        getWeatherInTwoDaysSecondCity(gridPaneModel);
        getWeatherInThreeDaysSecondCity(gridPaneModel);
        getWeatherInFourDaysSecondCity(gridPaneModel);
    }

    private void getTodayWeatherFirstCity(GridPaneModel gridPaneModel) throws APIException {
        todayDateInFirstCity.setText(gridPaneModel.getDateToday());
        String icon = gridPaneModel.getIconTodayFirstCity();
        String path = setWeatherIconSymbol(icon);
        Image img = new Image("file:" + path);
        todayWeatherFirstCityImage.setImage(img);
        maxTempTodayFirstCity.setText(gridPaneModel.getMaxTempToday());
        minTempTodayFirstCity.setText(gridPaneModel.getMinTempToday());
        humidityTodayFirstCity.setText(gridPaneModel.getHumidityToday());
        windTodayFirstCity.setText(gridPaneModel.getWindToday());
        pressureTodayFirstCity.setText(gridPaneModel.getPressureToday());
    }

    private void getTomorrowWeatherFirstCity(GridPaneModel gridPaneModel) throws APIException {
        tomorrowDateInFirstCity.setText(gridPaneModel.getDateForecast(1));
        String icon = gridPaneModel.getIconForecastFirstCity(1);
        String path = setWeatherIconSymbol(icon);
        Image img = new Image("file:" + path);
        tomorrowWeatherFirstCityImage.setImage(img);
        tempTomorrowFirstCity.setText(gridPaneModel.getTemperatureForecast(1));
        humidityTomorrowFirstCity.setText(gridPaneModel.getHumidityForecast(1));
        windTomorrowFirstCity.setText(gridPaneModel.getWindForecast(1));
        pressureTomorrowFirstCity.setText(gridPaneModel.getPressureForecast(1));
    }

    private void getWeatherInTwoDaysFirstCity(GridPaneModel gridPaneModel) throws APIException {
        inTwoDaysDateInFirstCity.setText(gridPaneModel.getDateForecast(2));
        String icon = gridPaneModel.getIconForecastFirstCity(2);
        String path = setWeatherIconSymbol(icon);
        Image img = new Image("file:" + path);
        inTwoDaysWeatherFirstCityImage.setImage(img);
        tempInTwoDaysFirstCity.setText(gridPaneModel.getTemperatureForecast(2));
        humidityInTwoDaysFirstCity.setText(gridPaneModel.getHumidityForecast(2));
        windInTwoDaysFirstCity.setText(gridPaneModel.getWindForecast(2));
        pressureInTwoDaysFirstCity.setText(gridPaneModel.getPressureForecast(2));
    }

    private void getWeatherInThreeDaysFirstCity(GridPaneModel gridPaneModel) throws APIException {
        inThreeDaysDateInFirstCity.setText(gridPaneModel.getDateForecast(3));
        String icon = gridPaneModel.getIconForecastFirstCity(3);
        String path = setWeatherIconSymbol(icon);
        Image img = new Image("file:" + path);
        inThreeDaysWeatherFirstCityImage.setImage(img);
        tempInThreeDaysFirstCity.setText(gridPaneModel.getTemperatureForecast(3));
        humidityInThreeDaysFirstCity.setText(gridPaneModel.getHumidityForecast(3));
        windInThreeDaysFirstCity.setText(gridPaneModel.getWindForecast(3));
        pressureInThreeDaysFirstCity.setText(gridPaneModel.getPressureForecast(3));
    }

    private void getWeatherInFourDaysFirstCity(GridPaneModel gridPaneModel) throws APIException {
        inFourDaysDateInFirstCity.setText(gridPaneModel.getDateForecast(4));
        String icon = gridPaneModel.getIconForecastFirstCity(4);
        String path = setWeatherIconSymbol(icon);
        Image img = new Image("file:" + path);
        inFourDaysWeatherFirstCityImage.setImage(img);
        tempInFourDaysFirstCity.setText(gridPaneModel.getTemperatureForecast(4));
        humidityInFourDaysFirstCity.setText(gridPaneModel.getHumidityForecast(4));
        windInFourDaysFirstCity.setText(gridPaneModel.getWindForecast(4));
        pressureInFourDaysFirstCity.setText(gridPaneModel.getPressureForecast(4));
    }

    private void getTodayWeatherSecondCity(GridPaneModel gridPaneModel) throws APIException {
        todayDateInSecondCity.setText(gridPaneModel.getDateToday());
        String icon = gridPaneModel.getIconTodayFirstCity();
        String path = setWeatherIconSymbol(icon);
        Image img = new Image("file:" + path);
        todayWeatherSecondCityImage.setImage(img);
        maxTempTodaySecondCity.setText(gridPaneModel.getMaxTempToday());
        minTempTodaySecondCity.setText(gridPaneModel.getMinTempToday());
        humidityTodaySecondCity.setText(gridPaneModel.getHumidityToday());
        windTodaySecondCity.setText(gridPaneModel.getWindToday());
        pressureTodaySecondCity.setText(gridPaneModel.getPressureToday());
    }

    private void getTomorrowWeatherSecondCity(GridPaneModel gridPaneModel) throws APIException {
        tomorrowDateInSecondCity.setText(gridPaneModel.getDateForecast(1));
        String icon = gridPaneModel.getIconForecastFirstCity(1);
        String path = setWeatherIconSymbol(icon);
        Image img = new Image("file:" + path);
        tomorrowWeatherSecondCityImage.setImage(img);
        tempTomorrowSecondCity.setText(gridPaneModel.getTemperatureForecast(1));
        humidityTomorrowSecondCity.setText(gridPaneModel.getHumidityForecast(1));
        windTomorrowSecondCity.setText(gridPaneModel.getWindForecast(1));
        pressureTomorrowSecondCity.setText(gridPaneModel.getPressureForecast(1));
    }

    private void getWeatherInTwoDaysSecondCity(GridPaneModel gridPaneModel) throws APIException {
        inTwoDaysDateInSecondCity.setText(gridPaneModel.getDateForecast(2));
        String icon = gridPaneModel.getIconForecastFirstCity(2);
        String path = setWeatherIconSymbol(icon);
        Image img = new Image("file:" + path);
        inTwoDaysWeatherSecondCityImage.setImage(img);
        tempInTwoDaysSecondCity.setText(gridPaneModel.getTemperatureForecast(2));
        humidityInTwoDaysSecondCity.setText(gridPaneModel.getHumidityForecast(2));
        windInTwoDaysSecondCity.setText(gridPaneModel.getWindForecast(2));
        pressureInTwoDaysSecondCity.setText(gridPaneModel.getPressureForecast(2));
    }

    private void getWeatherInThreeDaysSecondCity(GridPaneModel gridPaneModel) throws APIException {
        inThreeDaysDateInSecondCity.setText(gridPaneModel.getDateForecast(3));
        String icon = gridPaneModel.getIconForecastFirstCity(3);
        String path = setWeatherIconSymbol(icon);
        Image img = new Image("file:" + path);
        inThreeDaysWeatherSecondCityImage.setImage(img);
        tempInThreeDaysSecondCity.setText(gridPaneModel.getTemperatureForecast(3));
        humidityInThreeDaysSecondCity.setText(gridPaneModel.getHumidityForecast(3));
        windInThreeDaysSecondCity.setText(gridPaneModel.getWindForecast(3));
        pressureInThreeDaysSecondCity.setText(gridPaneModel.getPressureForecast(3));
    }

    private void getWeatherInFourDaysSecondCity(GridPaneModel gridPaneModel) throws APIException {
        inFourDaysDateInSecondCity.setText(gridPaneModel.getDateForecast(4));
        String icon = gridPaneModel.getIconForecastFirstCity(4);
        String path = setWeatherIconSymbol(icon);
        Image img = new Image("file:" + path);
        inFourDaysWeatherSecondCityImage.setImage(img);
        tempInFourDaysSecondCity.setText(gridPaneModel.getTemperatureForecast(4));
        humidityInFourDaysSecondCity.setText(gridPaneModel.getHumidityForecast(4));
        windInFourDaysSecondCity.setText(gridPaneModel.getWindForecast(4));
        pressureInFourDaysSecondCity.setText(gridPaneModel.getPressureForecast(4));
    }

    private String setWeatherIconSymbol(String icon) {

        String path = "";

        switch(icon) {

            case "01d":
                path = "src/main/resources/it/adamgolub/icons/01d.png";
                break;
            case "01n":
                path = "src/main/resources/it/adamgolub/icons/01n.png";
                break;
            case "02d":
                path = "src/main/resources/it/adamgolub/icons/02d.png";
                break;
            case "02n":
                path = "src/main/resources/it/adamgolub/icons/02n.png";
                break;
            case "03d":
            case "04n":
            case "03n":
            case "04d":
                path = "src/main/resources/it/adamgolub/icons/0304dn.png";
                break;
            case "09d":
            case "09n":
                path = "src/main/resources/it/adamgolub/icons/09dn.png";
                break;
            case "10d":
            case "10n":
                path = "src/main/resources/it/adamgolub/icons/10dn.png";
                break;
            case "11d":
            case "11n":
                path = "src/main/resources/it/adamgolub/icons/11dn.png";
                break;
            case "13d":
            case "13n":
                path = "src/main/resources/it/adamgolub/icons/13dn.png";
                break;
            case "50d":
            case "50n":
                path = "src/main/resources/it/adamgolub/icons/50dn.png";
                break;

        }

        return path;

    }

}