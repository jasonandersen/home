package vashaina.ha.weather.service.wunderground;

import org.springframework.stereotype.Service;

import vashaina.ha.weather.domain.Forecast;
import vashaina.ha.weather.service.ExternalWeatherService;

/**
 * Calls Wunderground.com's API to retrieve weather data.
 */
@Service
public class WundergroundWeatherService implements ExternalWeatherService {

    /**
     * @see vashaina.ha.weather.service.ExternalWeatherService#getTomorrowsHighTemp(int)
     */
    @Override
    public Forecast getTomorrowsHighTemp(int zip) {
        //TODO implement this method!!!
        return new Forecast(105, zip);
    }

}
