name := "HelloSpark"
version := "1.0"
scalaVersion := "2.13.17"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "4.1.1"

Compile / unmanagedSources / excludeFilter := "1.scala"
