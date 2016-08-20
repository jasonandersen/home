Feature: Service Testing

    Background:
        Given this mock response:
            | verb     | GET                                                                |
            | url      | http://api.wunderground.com/api/APIKEY/forecast/q/98070.json       |
            | response | src/test/resources/data/wunderground/responses/forecast/98070.json |

    Scenario: Happy path
        When this request is received:
            | verb          | GET                       |
            | url           | /weather/forecast/98070   |
            | header        | Accept: application/json  |
        Then a "200 OK" status code is returned
        And this response body is returned:
"""
{
  "forecast": {
    "todaysForecast":"Monday: Considerable cloudiness. Lows overnight in the mid 50s. Monday night: Mostly cloudy skies. A stray shower or thunderstorm is possible. Low 56F. Winds light and variable.";
    "tomorrowsForecast":"Tuesday: Cloudy. Slight chance of a rain shower. High 71F. Winds SSW at 5 to 10 mph. Tuesday night: Mostly cloudy skies. Low 57F. Winds SSW at 5 to 10 mph."
    "source":"Wunderground.com"
    "zipCode":"98070"
  }
  "error":{}
}  
"""        

