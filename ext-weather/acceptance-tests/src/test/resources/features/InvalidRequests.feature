Feature: Respond to incorrectly formatted requests

    Scenario: Zip code with alphabetic characters
        When I request a forecast for zip code "ABC"
        Then I get an "InvalidZipCodeException" error
        And the error message is "zip code must be numeric"
        