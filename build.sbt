name := "akka-1200"
organization := "Team-B-A"
version := "1.0.0"
scalaVersion := "2.13.5"
mainClass in Compile := Some("Server")
val AkkaVersion = "2.6.8"
val AkkaHttpVersion = "10.2.6"
val AkkaSprayVersion = "10.2.6"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % AkkaSprayVersion,
  "org.slf4j" % "slf4j-simple" % "1.7.13"
)
enablePlugins(JavaAppPackaging)