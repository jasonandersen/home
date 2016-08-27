Feature: Specification for calling the ext-weather service

    Background: stub out Wunderground response
        Given this Wunderground API end point "/api/APIKEY/forecast/q/98070.json" returns this response:
"""
{
  "response": {
  "version":"0.1",
  "termsofService":"http://www.wunderground.com/weather/api/d/terms.html",
  "features": {
  "forecast": 1
  }
    }
        ,
    "forecast":{
        "txt_forecast": {
        "date":"4:25 PM PDT",
        "forecastday": [
        {
        "period":0,
        "icon":"mostlycloudy",
        "icon_url":"http://icons.wxug.com/i/c/k/mostlycloudy.gif",
        "title":"Monday",
        "fcttext":"Considerable cloudiness. Lows overnight in the mid 50s.",
        "fcttext_metric":"Showers early. Low 14C.",
        "pop":"20"
        }
        ,
        {
        "period":1,
        "icon":"nt_mostlycloudy",
        "icon_url":"http://icons.wxug.com/i/c/k/nt_mostlycloudy.gif",
        "title":"Monday Night",
        "fcttext":"Mostly cloudy skies. A stray shower or thunderstorm is possible. Low 56F. Winds light and variable.",
        "fcttext_metric":"Showers early with some clearing overnight. Thunder possible. Low 14C. Winds light and variable. Chance of rain 50%.",
        "pop":"20"
        }
        ,
        {
        "period":2,
        "icon":"cloudy",
        "icon_url":"http://icons.wxug.com/i/c/k/cloudy.gif",
        "title":"Tuesday",
        "fcttext":"Cloudy. Slight chance of a rain shower. High 71F. Winds SSW at 5 to 10 mph.",
        "fcttext_metric":"Cloudy skies. Slight chance of a rain shower. High 21C. Winds SSW at 10 to 15 km/h.",
        "pop":"20"
        }
        ,
        {
        "period":3,
        "icon":"nt_mostlycloudy",
        "icon_url":"http://icons.wxug.com/i/c/k/nt_mostlycloudy.gif",
        "title":"Tuesday Night",
        "fcttext":"Mostly cloudy skies. Low 57F. Winds SSW at 5 to 10 mph.",
        "fcttext_metric":"Considerable cloudiness. Low 14C. Winds SSW at 10 to 15 km/h.",
        "pop":"10"
        }
        ]
        
    }
}
}
"""

    Scenario: Happy path for a zip code
        When I "GET" this end point "/weather/forecast/98070"
        Then I get this response:
"""
{
    "forecast":{
        "todaysForecast":"Monday: Considerable cloudiness. Lows overnight in the mid 50s. Monday Night: Mostly cloudy skies. A stray shower or thunderstorm is possible. Low 56F. Winds light and variable.",
        "tomorrowsForecast:":"Tuesday: Cloudy. Slight chance of a rain shower. High 71F. Winds SSW at 5 to 10 mph. Tuesday Night: Mostly cloudy skies. Low 57F. Winds SSW at 5 to 10 mph."
    },
    "error":{}
}
"""

    Scenario: Alphabetic zip code
        When I "GET" this end point "/weather/forecast/ABC"
        Then I get this response:
"""
{
    "forecast":{},
    "error":{
        "type":"InvalidZipCodeException",
        "description":"zip code must be numeric"
    }
}
"""

    Scenario: Mixed letters and numbers
        When I "GET" this end point "/weather/forecast/a1b2c"
        Then I get this response:
"""
{
    "forecast":{},
    "error":{
        "type":"InvalidZipCodeException",
        "description":"zip code must be numeric"
    }
}
"""

    Scenario: More than 5 digits
        When I "GET" this end point "/weather/forecast/980700"
        Then I get this response:
"""
{
    "forecast":{},
    "error":{
        "type":"InvalidZipCodeException",
        "description":"zip code must 5 digits"
    }
}
"""

    Scenario: Zip code+ format 
        When I "GET" this end point "/weather/forecast/98070-1234"
        Then I get this response:
"""
{
    "forecast":{},
    "error":{
        "type":"InvalidZipCodeException",
        "description":"zip code must be 5 digits"
    }
}
"""
