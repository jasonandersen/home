Feature: Tomorrow's high temperature

    Scenario: Happy path
        Given   I am located in Vashon Island, WA
        And     Wunderground is predicting tomorrow's high temperature for Vashon Island, WA will be 78 degrees fahrenheit
        When    I ask for tomorrow's temperature
        Then    I see 78 degrees fahrenheit