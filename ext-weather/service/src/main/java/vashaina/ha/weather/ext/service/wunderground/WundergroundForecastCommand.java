package vashaina.ha.weather.ext.service.wunderground;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import vashaina.ha.weather.ext.service.CommandGroup;
import vashaina.ha.weather.ext.service.wunderground.response.ForecastResponse;

/**
 * Resilient command to run a call to Wunderground to obtain a forecast.
 */
public class WundergroundForecastCommand extends HystrixCommand<WundergroundForecast> {

    private static Logger log = LoggerFactory.getLogger(WundergroundForecastCommand.class);

    private final String url;

    private final RestTemplate restTemplate;

    /**
     * Constructor
     * @param url
     * @param restTemplate
     */
    public WundergroundForecastCommand(String url, RestTemplate restTemplate) {
        super(HystrixCommandGroupKey.Factory.asKey(CommandGroup.WUNDERGROUND_API));
        Validate.notNull(restTemplate, "REST template cannot be null");
        Validate.notNull(url, "URL cannot be null");
        this.url = url;
        this.restTemplate = restTemplate;
    }

    /**
     * @see com.netflix.hystrix.HystrixCommand#run()
     */
    @Override
    protected WundergroundForecast run() throws Exception {
        log.debug("requesting wunderground forecast from {}", url);
        ForecastResponse response = restTemplate.getForObject(url, ForecastResponse.class);
        WundergroundForecast forecast = new WundergroundForecast(response, url);
        log.debug("response received from wunderground API: {}", forecast.toString());
        return forecast;
    }

}
