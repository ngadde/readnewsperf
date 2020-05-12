package net.kamradtfamily.oath2gatling

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class ReadNewsSimulation extends Simulation {
  val httpConf = http
    .baseURL("http://localhost:8080")
    .acceptHeader("application/json")

  val scn = scenario("BasicSimulation")
    .exec(http("request_1")
    .get("/v1/headlines?limit=50&to=2021-01-01T00:00:00Z"))
    .pause(5)

  setUp(
    scn.inject(atOnceUsers(100))
  ).protocols(httpConf)

}
