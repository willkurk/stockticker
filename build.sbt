name := """ticker"""
organization := "com.scalaticker"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.1"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.6.1"
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.6.1"
libraryDependencies += "com.yahoofinance-api" % "YahooFinanceAPI" % "3.15.0"
// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.scalaticker.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.scalaticker.binders._"
