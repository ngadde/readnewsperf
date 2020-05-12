name := "readnewsperf"

version := "0.1"

scalaVersion := "2.13.0"

enablePlugins(GatlingPlugin)

libraryDependencies ++= Seq(
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.3.0",
  "io.gatling"            % "gatling-test-framework"    % "3.3.0" % "test",
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.3.0" % "test")
