Feature: Call an external weather service to retrieve a text forecast

    Background:
        Given today is "Monday"
        And we are requesting a forecast for zip code 98070
        And the Wunderground forecast for today is "Considerable cloudiness. Lows overnight in the mid 50s."
        And the Wunderground forecast for tonight is "Mostly cloudy skies. A stray shower or thunderstorm is possible. Low 56F. Winds light and variable."
        And the Wunderground forecast for tomorrow is "Cloudy. Slight chance of a rain shower. High 71F. Winds SSW at 5 to 10 mph."
        And the Wunderground forecast for tomorrow night is "Mostly cloudy skies. Low 57F. Winds SSW at 5 to 10 mph."

    Scenario: Retrieve text forecast based on zip code
        When I request a forecast for zip code "98070"
        Then the forecast for today is "Monday: Considerable cloudiness. Lows overnight in the mid 50s. Monday night: Mostly cloudy skies. A stray shower or thunderstorm is possible. Low 56F. Winds light and variable."
        And the forecast for tomorrow is "Tuesday: Cloudy. Slight chance of a rain shower. High 71F. Winds SSW at 5 to 10 mph. Tuesday night: Mostly cloudy skies. Low 57F. Winds SSW at 5 to 10 mph."
        And the source is "Wunderground.com"
        And the zip code is "98070"
        And there are no errors
        