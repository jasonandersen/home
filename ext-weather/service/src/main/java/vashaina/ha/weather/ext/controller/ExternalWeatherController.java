package vashaina.ha.weather.ext.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vashaina.ha.weather.ext.domain.Forecast;
import vashaina.ha.weather.ext.domain.ZipCode;
import vashaina.ha.weather.ext.service.ExternalWeatherService;

/**
 * REST controller to provide external weather forecasts.
 */
@RestController
@RequestMapping("/weather")
public class ExternalWeatherController {

    private static Logger log = LoggerFactory.getLogger(ExternalWeatherController.class);

    @Autowired
    private ExternalWeatherService weatherService;

    /**
     * @param zip
     * @return tomorrow's forecast
     */
    @RequestMapping("/forecast/{zip}")
    public Forecast retrieveForecast(@PathVariable String zip) {
        log.info("retrieving forecast for zip {}", zip);
        try {
            ZipCode zipCode = new ZipCode(zip);
            return weatherService.getForecast(zipCode);
        } catch (Exception e) {
            log.error("Error handling zip " + zip, e);
            //TODO make this return something more interesting than null!!!
            return null;
        }
    }
}
