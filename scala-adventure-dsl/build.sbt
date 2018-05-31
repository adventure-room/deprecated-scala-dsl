organization        := "com.programyourhome.adventureroom"
name                := "scala-dsl"
version             := "0.3-SNAPSHOT"
scalaVersion        := "2.12.3"

libraryDependencies += "com.programyourhome.adventureroom" % "philips-hue-api" % "0.5"
libraryDependencies += "com.programyourhome.adventureroom" % "amazon-polly-api" % "0.5"
libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.1" % "test"
libraryDependencies += "org.mockito" % "mockito-core" % "2.10.0" % "test"

resolvers += Resolver.mavenLocal
publishTo := Some(Resolver.mavenLocal)
