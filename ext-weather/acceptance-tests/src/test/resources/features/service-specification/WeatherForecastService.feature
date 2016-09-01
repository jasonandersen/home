# These scenarios are intended to document the service specification. Any consumers
# of this service should rely on this document as the canonical specification for 
# this service.
# 
# Jason Andersen
# 2016.08.27
@ServiceTest
Feature: ext-weather service specification

    # Stub out the call to the Wunderground API
    Background:
        Given this stubbed response:
            | verb     | GET                                                          |
            | url      | http://api.wunderground.com/api/APIKEY/forecast/q/98070.json |
            | response | /data/wunderground/forecast/98070.json                       |

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
    "todaysForecast":"Monday: Considerable cloudiness. Lows overnight in the mid 50s. Monday night: Mostly cloudy skies. A stray shower or thunderstorm is possible. Low 56F. Winds light and variable.",
    "tomorrowsForecast":"Tuesday: Cloudy. Slight chance of a rain shower. High 71F. Winds SSW at 5 to 10 mph. Tuesday night: Mostly cloudy skies. Low 57F. Winds SSW at 5 to 10 mph.",
    "source":"Wunderground.com",
    "zipCode":"98070"
  },
  "problem":null
}  
"""

    Scenario: Letters in the zip code
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

    Scenario: Zip code with mixed letters and numbers
        When this document is requested:
            | verb     | GET                       |
            | path     | /weather/forecast/a1b2c   |
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

    Scenario: More than 5 digits
        When this document is requested:
            | verb     | GET                       |
            | path     | /weather/forecast/980700  |
            | header   | Accept: application/json  |
        Then a status code 400 is returned
        And this response body is returned:
"""
{
    "forecast":null,
    "problem":{
        "type":"InvalidZipCodeException",
        "description":"zip code must be 5 digits"
    }
}
"""

    Scenario: Zip code+ format 
        When this document is requested:
            | verb     | GET                          |
            | path     | /weather/forecast/98070-1234 |
            | header   | Accept: application/json     |
        Then a status code 400 is returned
        And this response body is returned:
"""
{
    "forecast":null,
    "problem":{
        "type":"InvalidZipCodeException",
        "description":"zip code must be 5 digits"
    }
}
"""
