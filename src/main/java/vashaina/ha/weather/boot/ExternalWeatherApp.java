package vashaina.ha.weather.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Entry point for application.
 */
@SpringBootApplication
@ComponentScan("vashaina.ha.weather.controller")
public class ExternalWeatherApp {

    /**
     * Main entrypoint method.
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ExternalWeatherApp.class, args);
    }
}
