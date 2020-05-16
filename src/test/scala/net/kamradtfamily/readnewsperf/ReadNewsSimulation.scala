package net.kamradtfamily.readnewsperf

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._

class ReadNewsSimulation extends Simulation {
  val httpConfBlocking = http
    .baseUrl("https://readnewsblock.local")
    .acceptHeader("application/json")

  val httpConfNonBlocking = http
    .baseUrl("https://readnews.local")
    .acceptHeader("text/event-stream")

  def generateReadScenario(scenarioName: String,
                           requestName: String,
                           limit: Int):ScenarioBuilder = {
    scenario(scenarioName)
      .exec(http(requestName)
        .get(s"/v1/headlines?limit=${limit}&to=2021-01-01T00:00:00Z"))
  }
  val testTime = 60
  val users = 20

   setUp(
     generateReadScenario(
       "BigNonBlocking",
       "big-non-blocking",
       1000).inject(
       constantConcurrentUsers(users).during(testTime)).protocols(httpConfNonBlocking),
     generateReadScenario(
       "MedNonBlocking",
       "med-non-blocking",
       100).inject(
       constantConcurrentUsers(users).during(testTime)).protocols(httpConfNonBlocking),
     generateReadScenario(
       "SmallNonBlocking",
       "small-non-blocking",
       1).inject(
       constantConcurrentUsers(users).during(testTime)).protocols(httpConfNonBlocking),
     generateReadScenario(
       "BigBlocking",
       "big-blocking",
       1000).inject(
       constantConcurrentUsers(users).during(testTime)).protocols(httpConfBlocking),
     generateReadScenario(
       "MedBlocking",
       "med-blocking",
       100).inject(
       constantConcurrentUsers(users).during(testTime)).protocols(httpConfBlocking),
     generateReadScenario(
       "SmallBlocking",
       "small-blocking",
       1).inject(
       constantConcurrentUsers(users).during(testTime)).protocols(httpConfBlocking)
   )
}
