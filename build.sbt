name := "99Scala"

version := "1.0"

scalaVersion := "2.9.1"

//libraryDependencies += "org.scalatest" %% "scalatest" % "1.6.1" % "test"


libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "1.12.2" % "test",
  "junit" % "junit" % "4.8.1" % "test",
  "org.antlr" % "stringtemplate" % "4.0.2",
  "joda-time" % "joda-time" % "2.1",
  "org.joda" % "joda-convert" % "1.3"
)

