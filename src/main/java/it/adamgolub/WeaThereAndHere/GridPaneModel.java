package it.adamgolub.WeaThereAndHere;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Adam on 26.12.2019.
 */
public class GridPaneModel {

    private OWM owmFirstCity;

    public GridPaneModel() {

    }

    @NotNull
    private CurrentWeather initializeCurrentWeatherObject(int cityId) throws APIException {
        owmFirstCity = new OWM(ConstantValues.API_KEY);
        return owmFirstCity.currentWeatherByCityId(cityId);
    }

    public String getCityName(int cityId) throws APIException {
        CurrentWeather cwdFirstCity = initializeCurrentWeatherObject(cityId);
        return cwdFirstCity.getCityName();
    }

    public String getDateToday() {
        Date day = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd/MM/yyyy");
        return sdf.format(day);
    }

    public String getIconTodayFirstCity(int cityId) throws APIException {
        CurrentWeather cwdFirstCity = initializeCurrentWeatherObject(cityId);
        return cwdFirstCity.getWeatherList().get(0).getIconCode();
    }

    public String getMaxTempToday(int cityId) throws APIException {
        CurrentWeather cwdFirstCity = initializeCurrentWeatherObject(cityId);

        double tempInCelsiusDegrees =
                Objects.requireNonNull(cwdFirstCity.getMainData()).getTempMax() - ConstantValues.KELVIN_CELSIUS_COEFFICIENT;
        int tempInCelsiusDegreesAsInteger = (int) Math.round(tempInCelsiusDegrees);

        return String.valueOf(tempInCelsiusDegreesAsInteger);
    }

    public String getMinTempToday(int cityId) throws APIException {
        CurrentWeather cwdFirstCity = initializeCurrentWeatherObject(cityId);

        double tempInCelsiusDegrees = Objects.requireNonNull(cwdFirstCity.getMainData()).getTempMin() - ConstantValues.KELVIN_CELSIUS_COEFFICIENT;
        int tempInCelsiusDegreesAsInteger = (int) Math.round(tempInCelsiusDegrees);

        return String.valueOf(tempInCelsiusDegreesAsInteger);
    }

    public String getHumidityToday(int cityId) throws APIException {
        CurrentWeather cwdFirstCity = initializeCurrentWeatherObject(cityId);

        Double humidity = Objects.requireNonNull(cwdFirstCity.getMainData()).getHumidity();
        int humidityAsInteger = (int) Math.round(humidity);

        return String.valueOf(humidityAsInteger);
    }

    public String getWindToday(int cityId) throws APIException {
        CurrentWeather cwdFirstCity = initializeCurrentWeatherObject(cityId);

        Double wind = Objects.requireNonNull(cwdFirstCity.getWindData()).getSpeed();

        return String.valueOf(wind);
    }

    public String getPressureToday(int cityId) throws APIException {
        CurrentWeather cwdFirstCity = initializeCurrentWeatherObject(cityId);

        Double pressure = Objects.requireNonNull(cwdFirstCity.getMainData()).getPressure();
        int pressureAsInteger = (int) Math.round(pressure);

        return String.valueOf(pressureAsInteger);
    }

    @NotNull
    private HourlyWeatherForecast initializeForecastWeatherObject(int cityId) throws APIException {
        owmFirstCity = new OWM(ConstantValues.API_KEY);
        return owmFirstCity.hourlyWeatherForecastByCityId(cityId);
    }

    @NotNull
    private Date getDateToForecast(int days) {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 13);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.DATE, days);
        date = c.getTime();
        return date;
    }

    public String getDateForecast(int days) throws APIException {

        Date day = getDateToForecast(days);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        return sdf.format(day);
    }

    public String getIconForecastFirstCity(int days, int cityId) throws APIException {

        HourlyWeatherForecast cwdFirstCity = initializeForecastWeatherObject(cityId);

        Date date = getDateToForecast(days);

        String iconCode = "";

        for (int i = 0; i < 40; i++) {

            if (Objects.equals(Objects.requireNonNull(cwdFirstCity.getDataList()).get(i).getDateTime(), date)) {
                iconCode = cwdFirstCity.getDataList().get(i).getWeatherList().get(0).getIconCode();
                break;
            }
        }

        return iconCode;
    }

    public String getTemperatureForecast(int days, int cityId) throws APIException {

        HourlyWeatherForecast cwdFirstCity = initializeForecastWeatherObject(cityId);

        Date date = getDateToForecast(days);

        double temperature;
        String temperatureAsString = "";

        for (int i = 0; i < 40; i++) {

            if (Objects.equals(Objects.requireNonNull(cwdFirstCity.getDataList()).get(i).getDateTime(), date)) {
                temperature = Objects.requireNonNull(cwdFirstCity.getDataList().get(i).getMainData()).getTemp() - ConstantValues.KELVIN_CELSIUS_COEFFICIENT;
                int temperatureAsInteger = (int) Math.round(temperature);
                temperatureAsString = String.valueOf(temperatureAsInteger);
                break;
            }
        }

        return temperatureAsString;
    }

    public String getHumidityForecast(int days, int cityId) throws APIException {

        HourlyWeatherForecast cwdFirstCity = initializeForecastWeatherObject(cityId);

        Date date = getDateToForecast(days);

        double humidity;
        String humidityAsString = "";

        for (int i = 0; i < 40; i++) {

            if (Objects.equals(Objects.requireNonNull(cwdFirstCity.getDataList()).get(i).getDateTime(), date)) {
                humidity = Objects.requireNonNull(cwdFirstCity.getDataList().get(i).getMainData()).getHumidity();
                int tempMaxAsInteger = (int) Math.round(humidity);
                humidityAsString = String.valueOf(tempMaxAsInteger);
                break;
            }
        }

        return humidityAsString;
    }

    public String getWindForecast(int days, int cityId) throws APIException {
        HourlyWeatherForecast cwdFirstCity = initializeForecastWeatherObject(cityId);

        Date date = getDateToForecast(days);

        double wind;
        String windAsString;
        String windAsStringWithDotAsSeparator = "";

        for (int i = 0; i < 40; i++) {

            if (Objects.equals(cwdFirstCity.getDataList().get(i).getDateTime(), date)) {
                wind = Objects.requireNonNull(cwdFirstCity.getDataList().get(i).getWindData()).getSpeed();
                windAsString = String.format("%.1f", wind);
                windAsStringWithDotAsSeparator = windAsString.replace(',', '.');
                break;
            }
        }

        return windAsStringWithDotAsSeparator;
    }

    public String getPressureForecast(int days, int cityId) throws APIException {
        HourlyWeatherForecast cwdFirstCity = initializeForecastWeatherObject(cityId);

        Date date = getDateToForecast(days);

        double pressure;
        String pressureAsString = "";

        for (int i = 0; i < 40; i++) {

            if (Objects.equals(cwdFirstCity.getDataList().get(i).getDateTime(), date)) {
                pressure = Objects.requireNonNull(cwdFirstCity.getDataList().get(i).getMainData()).getPressure();
                int pressureAsInteger = (int) Math.round(pressure);
                pressureAsString = String.valueOf(pressureAsInteger);
                break;
            }
        }

        return pressureAsString;
    }


}