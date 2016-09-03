# These scenarios are intended to document the service specification. Any consumers
# of this service should rely on this document as the canonical specification for 
# this service.
# 
# Jason Andersen
# 2016.08.27
@ServiceTest
Feature: ext-weather service specification

    # Stub out the upstream dependency on Wunderground.com
    Background:
        Given this stubbed response:
            | verb     | GET                                                          |
            | url      | http://api.wunderground.com/api/APIKEY/forecast/q/98070.json |
            | response | /data/wunderground/forecast/98070.json                       |

    # This is a valid request and response. 
    Scenario: Happy path
        When this document is requested:
            | verb     | GET                       |
            | path     | /weather/forecast/98070   |
            | header   | Accept: application/json  |
        Then a status code 200 is returned
        And this response body is returned:
"""
{
  "forecast": {
    "todaysForecast":"Monday: Considerable cloudiness. Lows overnight in the mid 50s. Monday Night: Mostly cloudy skies. A stray shower or thunderstorm is possible. Low 56F. Winds light and variable.",
    "tomorrowsForecast":"Tuesday: Cloudy. Slight chance of a rain shower. High 71F. Winds SSW at 5 to 10 mph. Tuesday Night: Mostly cloudy skies. Low 57F. Winds SSW at 5 to 10 mph.",
    "source":"Wunderground.com",
    "zipCode":"98070"
  },
  "problem":null
}  
"""

    # An invalid request will return a 400 and describe what the issue is within the 
    # problem object
    Scenario: Exception path - alphabetic characters in the zipcode
        When this document is requested:
            | verb     | GET                       |
            | path     | /weather/forecast/ABC     |
            | header   | Accept: application/json  |
        Then a status code 400 is returned
        And this response body is returned:
"""
{
    "forecast":null,
    "problem":{
        "type":"InvalidZipCodeException",
        "description":"zip code must be numeric"
    }
}
"""
