package vashaina.ha.weather.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller to provide external weather forecasts.
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @RequestMapping("/{zip}/tomorrow/high-temp")
    public Integer retrieveTomorrowsHighTemp(@PathVariable String zip) {
        return Integer.parseInt(zip);
    }
}
