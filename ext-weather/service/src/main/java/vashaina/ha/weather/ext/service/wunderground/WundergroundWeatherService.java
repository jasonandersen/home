package vashaina.ha.weather.ext.service.wunderground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import vashaina.ha.weather.ext.domain.Forecast;
import vashaina.ha.weather.ext.domain.ZipCode;
import vashaina.ha.weather.ext.service.ExternalWeatherService;

/**
 * Calls Wunderground.com's API to retrieve weather data.
 */
@Service
public class WundergroundWeatherService implements ExternalWeatherService {

    /* URL format for forecast requests based on a zip code:
     * 
     * Ballard forecast:
     * http://api.wunderground.com/api/APIKEY/forecast/q/98117.json
     * 
     * Vashon forecast:
     * http://api.wunderground.com/api/APIKEY/forecast/q/98070.json
     */

    private static final String FORECAST_URL = "%1$s/api/%2$s/forecast/q/%3$s.json";

    private final ConversionService conversionService;
    private final RestTemplate restTemplate;
    private final WundergroundApiKey apiKey;
    private final WundergroundHost host;

    /**
     * Constructor.
     */
    @Autowired
    public WundergroundWeatherService(
            WundergroundHost host,
            WundergroundApiKey apiKey,
            @Qualifier("conversionService") ConversionService conversionService) {
        restTemplate = new RestTemplate();
        this.apiKey = apiKey;
        this.host = host;
        this.conversionService = conversionService;
    }

    /**
     * @throws Exception 
     * @see vashaina.ha.weather.ext.service.ExternalWeatherService#getForecast(ZipCode)
     */
    @Override
    public Forecast getForecast(ZipCode zip) throws Exception {
        String url = getForecastUrl(zip);
        WundergroundForecastCommand command = new WundergroundForecastCommand(url, restTemplate);
        WundergroundForecast forecast = command.run();
        return conversionService.convert(forecast, Forecast.class);
    }

    /**
     * @param zip
     * @return a fully formed URL to request a forecast by zip code 
     */
    private String getForecastUrl(ZipCode zip) {
        return String.format(FORECAST_URL, host, apiKey, zip);
    }

    /**
     * Allow tests to decorate the rest template being used to control test output.
     * @return the rest template used by the service
     */
    protected RestTemplate getRestTemplate() {
        return restTemplate;
    }

}