package it.adamgolub.WeaThereAndHere;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Adam on 26.12.2019.
 */
public class GridPaneModel {

    private OWM owmFirstCity;

    public GridPaneModel() {

    }

    public String getCityName() throws APIException {
        owmFirstCity = new OWM(ConstantValues.API_KEY);
        CurrentWeather cwdFirstCity = owmFirstCity.currentWeatherByCityName(ConstantValues.INITIAL_FIRST_CITY);
        return cwdFirstCity.getCityName();
    }

    public String getMaxTempToday() throws APIException {
        owmFirstCity = new OWM(ConstantValues.API_KEY);
        CurrentWeather cwdFirstCity = owmFirstCity.currentWeatherByCityName(ConstantValues.INITIAL_FIRST_CITY);

        Double tempInCelsiusDegrees = cwdFirstCity.getMainData().getTempMax() - 273;
        int tempInCelsiusDegreesAsInteger = (int) Math.round(tempInCelsiusDegrees);
        String tempInCelsiusDegreesAsIntegerConvertedToString = String.valueOf(tempInCelsiusDegreesAsInteger);

        return tempInCelsiusDegreesAsIntegerConvertedToString;
    }

    public String getMinTempToday() throws APIException {
        owmFirstCity = new OWM(ConstantValues.API_KEY);
        CurrentWeather cwdFirstCity = owmFirstCity.currentWeatherByCityName(ConstantValues.INITIAL_FIRST_CITY);

        Double tempInCelsiusDegrees = cwdFirstCity.getMainData().getTempMin() - 273;
        int tempInCelsiusDegreesAsInteger = (int) Math.round(tempInCelsiusDegrees);
        String tempInCelsiusDegreesAsIntegerConvertedToString = String.valueOf(tempInCelsiusDegreesAsInteger);

        return tempInCelsiusDegreesAsIntegerConvertedToString;
    }

    public String getPrecipitationToday() throws APIException {
        owmFirstCity = new OWM(ConstantValues.API_KEY);
        CurrentWeather cwdFirstCity = owmFirstCity.currentWeatherByCityName(ConstantValues.INITIAL_FIRST_CITY);

        //Double tempInCelsiusDegrees = cwdFirstCity.getRainData().component1();
        //int tempInCelsiusDegreesAsInteger = (int) Math.round(tempInCelsiusDegrees);
        //String tempInCelsiusDegreesAsIntegerConvertedToString = String.valueOf(tempInCelsiusDegreesAsInteger);

        System.out.println(cwdFirstCity.getRainData().getPrecipVol3h());

        return "la";
    }
}
