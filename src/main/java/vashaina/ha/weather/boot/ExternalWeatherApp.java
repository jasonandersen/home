package vashaina.ha.weather.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * This application retrieves weather forecasts from external weather services such 
 * as wunderground.com and weather.com.
 */
@SpringBootApplication
@ComponentScan("vashaina.ha.weather")
public class ExternalWeatherApp {

    /**
     * Application main entrypoint method.
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ExternalWeatherApp.class, args);
    }
}
