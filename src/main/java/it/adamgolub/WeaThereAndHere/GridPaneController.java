package it.adamgolub.WeaThereAndHere;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import it.adamgolub.WeaThereAndHere.ConstantValues;
import it.adamgolub.WeaThereAndHere.InvalidCityNameException;
import it.adamgolub.WeaThereAndHere.model.City;
import it.adamgolub.WeaThereAndHere.model.GridPaneModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import net.aksingh.owmjapis.api.APIException;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Created by Adam on 23.12.2019.
 */
public class GridPaneController {

    private static Integer firstCityId;
    private static Integer secondCityId;

    @FXML
    private Label error;
    @FXML
    private TextField searchingFirstCityName;
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
    private TextField searchingSecondCityName;
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

    GridPaneModel gridPaneModel = new GridPaneModel();
    private Map<String, Integer> citiesMap = new TreeMap<>();

    @FXML
    void initialize () throws APIException {

        try {
            citiesMap = getCitiesMapFromJSON(ConstantValues.JSON_FILE_WITH_CITIES);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }



        getWeatherFirstCity(gridPaneModel);

        getWeatherSecondCity(gridPaneModel);

        setAutoCompleteTextFields();
    }

    private Map<String, Integer> getCitiesMapFromJSON(String source) throws FileNotFoundException {

        try {
            JsonReader reader = new JsonReader(new InputStreamReader(getClass().getResourceAsStream(source)));
            Gson gson = new GsonBuilder().create();
            City[] cities = gson.fromJson(reader, City[].class);

            for (City city : cities) {
                citiesMap.put(city.getName() + "," + city.getCountry(), city.getId());
            }

            return citiesMap;
        } catch (NullPointerException | JsonSyntaxException e) {
            throw new FileNotFoundException();
        }
    }

    @FXML
    public void changeUserCity() {

        try {
            firstCityId = getCityId(searchingFirstCityName.getText());
            getWeatherFirstCity(gridPaneModel);
        } catch (APIException | InvalidCityNameException e) {
            error.setText("Wybierz miejscowość z listy!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            showErrorMessage();
            e.printStackTrace();
        }
    }

    private void showErrorMessage() {

        Label label = new Label("Przepraszamy, serwis chwilowo nieczynny. Proszę spróbować później.");
        label.getStyleClass().addAll("text-black", "text-20");
        //gridPaneModel.getChildren().clear();
        //gridPaneModel.getChildren().add(label);
    }

    private void setAutoCompleteTextFields() {

        gridPaneModel.setAutoCompleteTextField(searchingFirstCityName, citiesMap);
        //gridPaneModel.setAutoCompleteTextField(travelTextFieldSearch, citiesMap);
    }

    public Integer getCityId(String cityName) throws InvalidCityNameException {

        if (citiesMap.containsKey(cityName)) {
            return citiesMap.get(cityName);
        } else {
            throw new InvalidCityNameException();
        }
    }

    private void getWeatherFirstCity(GridPaneModel gridPaneModel) throws APIException {
        int cityId;
        cityId = Objects.requireNonNullElse(firstCityId, ConstantValues.INITIAL_FIRST_CITY);

        firstCityName.setText(gridPaneModel.getCityName(cityId));

        getTodayWeatherFirstCity(gridPaneModel, cityId);
        getTomorrowWeatherFirstCity(gridPaneModel, cityId);
        getWeatherInTwoDaysFirstCity(gridPaneModel, cityId);
        getWeatherInThreeDaysFirstCity(gridPaneModel, cityId);
        getWeatherInFourDaysFirstCity(gridPaneModel, cityId);
    }

    private void getTodayWeatherFirstCity(GridPaneModel gridPaneModel, int cityId) throws APIException {
        todayDateInFirstCity.setText(gridPaneModel.getDateToday());
        String icon = gridPaneModel.getIconTodayFirstCity(cityId);
        String path = setWeatherIconSymbol(icon);
        Image img = new Image("file:" + path);
        todayWeatherFirstCityImage.setImage(img);
        maxTempTodayFirstCity.setText(gridPaneModel.getMaxTempToday(cityId));
        minTempTodayFirstCity.setText(gridPaneModel.getMinTempToday(cityId));
        humidityTodayFirstCity.setText(gridPaneModel.getHumidityToday(cityId));
        windTodayFirstCity.setText(gridPaneModel.getWindToday(cityId));
        pressureTodayFirstCity.setText(gridPaneModel.getPressureToday(cityId));
    }

    private void getTomorrowWeatherFirstCity(GridPaneModel gridPaneModel, int cityId) throws APIException {
        tomorrowDateInFirstCity.setText(gridPaneModel.getDateForecast(1));
        String icon = gridPaneModel.getIconForecastFirstCity(1, cityId);
        String path = setWeatherIconSymbol(icon);
        Image img = new Image("file:" + path);
        tomorrowWeatherFirstCityImage.setImage(img);
        tempTomorrowFirstCity.setText(gridPaneModel.getTemperatureForecast(1, cityId));
        humidityTomorrowFirstCity.setText(gridPaneModel.getHumidityForecast(1, cityId));
        windTomorrowFirstCity.setText(gridPaneModel.getWindForecast(1, cityId));
        pressureTomorrowFirstCity.setText(gridPaneModel.getPressureForecast(1, cityId));
    }

    private void getWeatherInTwoDaysFirstCity(GridPaneModel gridPaneModel, int cityId) throws APIException {
        inTwoDaysDateInFirstCity.setText(gridPaneModel.getDateForecast(2));
        String icon = gridPaneModel.getIconForecastFirstCity(2, cityId);
        String path = setWeatherIconSymbol(icon);
        Image img = new Image("file:" + path);
        inTwoDaysWeatherFirstCityImage.setImage(img);
        tempInTwoDaysFirstCity.setText(gridPaneModel.getTemperatureForecast(2, cityId));
        humidityInTwoDaysFirstCity.setText(gridPaneModel.getHumidityForecast(2, cityId));
        windInTwoDaysFirstCity.setText(gridPaneModel.getWindForecast(2, cityId));
        pressureInTwoDaysFirstCity.setText(gridPaneModel.getPressureForecast(2, cityId));
    }

    private void getWeatherInThreeDaysFirstCity(GridPaneModel gridPaneModel, int cityId) throws APIException {
        inThreeDaysDateInFirstCity.setText(gridPaneModel.getDateForecast(3));
        String icon = gridPaneModel.getIconForecastFirstCity(3, cityId);
        String path = setWeatherIconSymbol(icon);
        Image img = new Image("file:" + path);
        inThreeDaysWeatherFirstCityImage.setImage(img);
        tempInThreeDaysFirstCity.setText(gridPaneModel.getTemperatureForecast(3, cityId));
        humidityInThreeDaysFirstCity.setText(gridPaneModel.getHumidityForecast(3, cityId));
        windInThreeDaysFirstCity.setText(gridPaneModel.getWindForecast(3, cityId));
        pressureInThreeDaysFirstCity.setText(gridPaneModel.getPressureForecast(3, cityId));
    }

    private void getWeatherInFourDaysFirstCity(GridPaneModel gridPaneModel, int cityId) throws APIException {
        inFourDaysDateInFirstCity.setText(gridPaneModel.getDateForecast(4));
        String icon = gridPaneModel.getIconForecastFirstCity(4, cityId);
        String path = setWeatherIconSymbol(icon);
        Image img = new Image("file:" + path);
        inFourDaysWeatherFirstCityImage.setImage(img);
        tempInFourDaysFirstCity.setText(gridPaneModel.getTemperatureForecast(4, cityId));
        humidityInFourDaysFirstCity.setText(gridPaneModel.getHumidityForecast(4, cityId));
        windInFourDaysFirstCity.setText(gridPaneModel.getWindForecast(4, cityId));
        pressureInFourDaysFirstCity.setText(gridPaneModel.getPressureForecast(4, cityId));
    }

    private void getWeatherSecondCity(GridPaneModel gridPaneModel) throws APIException {
        int cityId;
        cityId = Objects.requireNonNullElse(secondCityId, ConstantValues.INITIAL_SECOND_CITY);

        secondCityName.setText(gridPaneModel.getCityName(cityId));

        getTodayWeatherSecondCity(gridPaneModel, cityId);
        getTomorrowWeatherSecondCity(gridPaneModel, cityId);
        getWeatherInTwoDaysSecondCity(gridPaneModel, cityId);
        getWeatherInThreeDaysSecondCity(gridPaneModel, cityId);
        getWeatherInFourDaysSecondCity(gridPaneModel, cityId);
    }

    private void getTodayWeatherSecondCity(GridPaneModel gridPaneModel, int cityId) throws APIException {
        todayDateInSecondCity.setText(gridPaneModel.getDateToday());
        String icon = gridPaneModel.getIconTodayFirstCity(cityId);
        String path = setWeatherIconSymbol(icon);
        Image img = new Image("file:" + path);
        todayWeatherSecondCityImage.setImage(img);
        maxTempTodaySecondCity.setText(gridPaneModel.getMaxTempToday(cityId));
        minTempTodaySecondCity.setText(gridPaneModel.getMinTempToday(cityId));
        humidityTodaySecondCity.setText(gridPaneModel.getHumidityToday(cityId));
        windTodaySecondCity.setText(gridPaneModel.getWindToday(cityId));
        pressureTodaySecondCity.setText(gridPaneModel.getPressureToday(cityId));
    }

    private void getTomorrowWeatherSecondCity(GridPaneModel gridPaneModel, int cityId) throws APIException {
        tomorrowDateInSecondCity.setText(gridPaneModel.getDateForecast(1));
        String icon = gridPaneModel.getIconForecastFirstCity(1, cityId);
        String path = setWeatherIconSymbol(icon);
        Image img = new Image("file:" + path);
        tomorrowWeatherSecondCityImage.setImage(img);
        tempTomorrowSecondCity.setText(gridPaneModel.getTemperatureForecast(1, cityId));
        humidityTomorrowSecondCity.setText(gridPaneModel.getHumidityForecast(1, cityId));
        windTomorrowSecondCity.setText(gridPaneModel.getWindForecast(1, cityId));
        pressureTomorrowSecondCity.setText(gridPaneModel.getPressureForecast(1, cityId));
    }

    private void getWeatherInTwoDaysSecondCity(GridPaneModel gridPaneModel, int cityId) throws APIException {
        inTwoDaysDateInSecondCity.setText(gridPaneModel.getDateForecast(2));
        String icon = gridPaneModel.getIconForecastFirstCity(2, cityId);
        String path = setWeatherIconSymbol(icon);
        Image img = new Image("file:" + path);
        inTwoDaysWeatherSecondCityImage.setImage(img);
        tempInTwoDaysSecondCity.setText(gridPaneModel.getTemperatureForecast(2, cityId));
        humidityInTwoDaysSecondCity.setText(gridPaneModel.getHumidityForecast(2, cityId));
        windInTwoDaysSecondCity.setText(gridPaneModel.getWindForecast(2, cityId));
        pressureInTwoDaysSecondCity.setText(gridPaneModel.getPressureForecast(2, cityId));
    }

    private void getWeatherInThreeDaysSecondCity(GridPaneModel gridPaneModel, int cityId) throws APIException {
        inThreeDaysDateInSecondCity.setText(gridPaneModel.getDateForecast(3));
        String icon = gridPaneModel.getIconForecastFirstCity(3, cityId);
        String path = setWeatherIconSymbol(icon);
        Image img = new Image("file:" + path);
        inThreeDaysWeatherSecondCityImage.setImage(img);
        tempInThreeDaysSecondCity.setText(gridPaneModel.getTemperatureForecast(3, cityId));
        humidityInThreeDaysSecondCity.setText(gridPaneModel.getHumidityForecast(3, cityId));
        windInThreeDaysSecondCity.setText(gridPaneModel.getWindForecast(3, cityId));
        pressureInThreeDaysSecondCity.setText(gridPaneModel.getPressureForecast(3, cityId));
    }

    private void getWeatherInFourDaysSecondCity(GridPaneModel gridPaneModel, int cityId) throws APIException {
        inFourDaysDateInSecondCity.setText(gridPaneModel.getDateForecast(4));
        String icon = gridPaneModel.getIconForecastFirstCity(4, cityId);
        String path = setWeatherIconSymbol(icon);
        Image img = new Image("file:" + path);
        inFourDaysWeatherSecondCityImage.setImage(img);
        tempInFourDaysSecondCity.setText(gridPaneModel.getTemperatureForecast(4, cityId));
        humidityInFourDaysSecondCity.setText(gridPaneModel.getHumidityForecast(4, cityId));
        windInFourDaysSecondCity.setText(gridPaneModel.getWindForecast(4, cityId));
        pressureInFourDaysSecondCity.setText(gridPaneModel.getPressureForecast(4, cityId));
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