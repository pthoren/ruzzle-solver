name := "ruzzle-solver"

version := "1.0.0"

scalaVersion := "2.9.2"

scalacOptions ++= Seq("-unchecked", "-deprecation")

libraryDependencies += "org.scalatest" %% "scalatest" % "1.8" % "test"

libraryDependencies += "junit" % "junit" % "4.10" % "test"

mainClass := Some("ruzzlesolver.RuzzleSolver")