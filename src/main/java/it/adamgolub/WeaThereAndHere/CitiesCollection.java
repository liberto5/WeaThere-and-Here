package it.adamgolub.WeaThereAndHere;

import it.adamgolub.WeaThereAndHere.InvalidCityNameException;

import java.util.Map;

public class CitiesCollection {

    public static Integer getCityId(String cityName, Map<String, Integer> citiesMap) throws InvalidCityNameException {

        if (citiesMap.containsKey(cityName)) {
            return citiesMap.get(cityName);
        } else {
            throw new InvalidCityNameException();
        }
    }
}
