package vashaina.ha.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vashaina.ha.weather.domain.Forecast;
import vashaina.ha.weather.service.ExternalWeatherService;

/**
 * REST controller to provide external weather forecasts.
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private ExternalWeatherService weatherService;

    @Autowired
    private ConversionService conversionService;

    /**
     * @param zip
     * @return tomorrow's high temperature for the zip code passed in
     */
    @RequestMapping("/{zip}/tomorrow/high-temp")
    public Forecast retrieveTomorrowsHighTemp(@PathVariable String zip) {
        int zipCode = conversionService.convert(zip, Integer.class);
        return weatherService.getTomorrowsHighTemp(zipCode);
    }
}
