package net.kamradtfamily.oath2gatling

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class OAuth2Simulation extends Simulation {
  val httpConf = http
    .baseURL("http://localhost:8888")
    .authorizationHeader("Basic dXNlcjpwYXNzd29yZA==")
    .acceptHeader("application/json")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .contentTypeHeader("application/json")

  val scn = scenario("BasicSimulation")
    .exec(http("request_1")
    .get("/client"))
    .pause(5)

  setUp(
    scn.inject(atOnceUsers(100))
  ).protocols(httpConf)

}
