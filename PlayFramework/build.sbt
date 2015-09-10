name := """PlayFramework"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"
lazy val jacksonVersion = "2.5.3"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
  "com.typesafe.slick" %% "slick" % "3.0.0",
  "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
  "com.rabbitmq" % "amqp-client" % "3.5.3",
  "com.github.tminglei" %% "slick-pg" % "0.9.0",
  "com.github.nscala-time" %% "nscala-time" % "2.0.0",
  "org.scalaz" %% "scalaz-core" % "7.1.2",
  "com.fasterxml.jackson.core" % "jackson-databind" % jacksonVersion,
  "com.fasterxml.jackson.core" % "jackson-annotations" % jacksonVersion,
  "io.spray" %% "spray-json" % "1.3.2"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
// routesGenerator := InjectedRoutesGenerator
