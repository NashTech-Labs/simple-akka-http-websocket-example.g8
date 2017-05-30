name := """simple-akka-http-websocket-example"""

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= {
  val AkkaHttpVersion   = "2.4.7"
  Seq(
    "com.typesafe.akka" %% "akka-http-experimental" % AkkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-testkit-experimental" % "2.4.2-RC3",
    "org.scalatest"     %% "scalatest"                 % "2.2.6"

  )
}



fork in run := true