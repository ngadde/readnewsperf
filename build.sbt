name := "OAuth2Gatling"

version := "0.1"

scalaVersion := "2.12.5"

enablePlugins(GatlingPlugin)

libraryDependencies ++= Seq(
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.3.1",
  "io.gatling"            % "gatling-test-framework"    % "2.3.1" % "test",
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.3.1" % "test")