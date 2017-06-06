# *** DEPRECATED *** home-automation

_Note: See individual project repos instead._

This is a hand-rolled microservices-based home system. It's in its infancy stages so don't get too excited about the available features just. This is primarily serving as a distributed system I can run at home to do things I want. Eventually, there will be some home automation stuff. I'm working on some simple health data import and analysis at the moment. It also has the ability to retrieve weather forecasts.

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
