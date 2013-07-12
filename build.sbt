name := "99Scala"

version := "1.0"

scalaVersion := "2.10.0"

//libraryDependencies += "org.scalatest" %% "scalatest" % "1.6.1" % "test"


libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.0" % "test",
 "org.scalatest" %% "scalatest" % "1.9.1",
  "junit" % "junit" % "4.8.1" % "test",
  "org.antlr" % "stringtemplate" % "4.0.2",
  "joda-time" % "joda-time" % "2.1",
  "org.joda" % "joda-convert" % "1.3"
)

