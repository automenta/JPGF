name := "jpgf"

organization := "org.grammaticalframework"

version := "1.0"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "commons-lang" % "commons-lang" % "2.6"

libraryDependencies += "org.scala-lang" % "jline" % "2.10.1"



libraryDependencies += "junit" % "junit" % "4.7" % "test"

libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"


libraryDependencies += "com.google.guava" % "guava" % "r05"

libraryDependencies += "net.sf.squirrel-sql.thirdparty.non-maven" % "java-cup" % "11a"

scalaVersion := "2.11.7"

publishMavenStyle := true

scalacOptions ++= Seq("-unchecked", "-g:vars", "-print")


