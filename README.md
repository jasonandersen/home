# home-automation
This is a hand-rolled home automation system. It's in its infancy stages so don't get too excited about the available features just. Right now the only working service is the `ext-weather` service which will retrieve weather forecasts and conditions from external sources.

##Technology stack
The primary technologies for this system is currently:
 * Java 8
 * Maven
 * Jetty
 * Spring MVC
 * Spring DI
 * Docker
 * bash scripts

Testing is accomplished primarily with:
 * JUnit
 * Spring TestContext
 * Cucumber BDD
 * Mountebank (for service test doubles)