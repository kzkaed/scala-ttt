name := "Scala Tic Tac Toe"

version := "2.0"

organization := "com.scutigera"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "org.scala-lang"          % "scala-reflect"   % "2.11.2",
  "org.scalaz"             %% "scalaz-core"     % "7.1.3", //functional data structures to complement standard
  "org.scalacheck"         %% "scalacheck"      % "1.11.5" % "test",
  "org.scalatest"          %% "scalatest"       % "2.2.4"  % "test",
  "org.specs2"             %% "specs2"          % "2.4"    % "test",
  "junit"                   % "junit-dep"       % "4.10"   % "test",
  "com.novocode"            % "junit-interface" % "0.10"   % "test",
  "org.scalamock" %% "scalamock-scalatest-support" % "3.2" % "test"
)



scalacOptions ++= Seq(
  "-encoding", "UTF-8", "-optimise",
  "-deprecation", "-unchecked", "-feature", "-Xlint",
  "-Ywarn-infer-any")

javacOptions  ++= Seq(
  "-Xlint:unchecked", "-Xlint:deprecation") // Java 8: "-Xdiags:verbose")

// Enable improved incremental compilation feature in 2.11.X.
// see http://www.scala-lang.org/news/2.11.1
incOptions := incOptions.value.withNameHashing(true)
