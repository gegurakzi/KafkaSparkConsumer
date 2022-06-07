lazy val commonSettings = Seq(
  name := "KafkaSparkConsumer",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.12.15"
)

lazy val app = (project in file(".")).
  settings(commonSettings: _*)

libraryDependencies ++= Seq(
  "org.apache.kafka" %% "kafka" % "2.7.0",
  "org.apache.spark" %% "spark-core" % "3.2.1",
  "org.apache.spark" %% "spark-sql" % "3.2.1",
  "org.apache.spark" %% "spark-sql-kafka-0-10" % "3.2.1",
  "org.scala-lang" % "scala-library" % "2.12.15"
)

assemblyJarName := "KafkaSparkConsumer-1.0-SNAPSHOT-fatJar.jar"

assembly / assemblyMergeStrategy := {
  case "reference.conf" => MergeStrategy.concat
  case "META-INF/services/org.apache.spark.sql.sources.DataSourceRegister" => MergeStrategy.concat
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
