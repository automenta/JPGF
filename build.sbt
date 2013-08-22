name := "jpgf"

version := "1.0"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "commons-lang" % "commons-lang" % "2.6"

libraryDependencies += "org.scala-lang" % "jline" % "2.10.1"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.2.0"

libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.0.2"

libraryDependencies += "com.google.guava" % "guava" % "r05"

libraryDependencies += "net.sf.squirrel-sql.thirdparty.non-maven" % "java-cup" % "11a"

scalaVersion := "2.10.2"
