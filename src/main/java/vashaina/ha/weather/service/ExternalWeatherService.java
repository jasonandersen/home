package vashaina.ha.weather.service;

import vashaina.ha.weather.domain.Forecast;

/**
 * Provides forecasts from external weather services.
 */
public interface ExternalWeatherService {

    /**
     * Retrieves tomorrow's high temperature forecast.
     * @param zip
     * @return a forecast containing tomorrow's high temperature forecast
     */
    Forecast getTomorrowsHighTemp(int zip);

}
