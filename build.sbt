name := "kafka_test"

version := "0.1"
scalaVersion := "2.11.0"
val sparkVersion = "2.4.7"
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-streaming-flume" % sparkVersion,
  "org.apache.spark" %% "spark-sql-kafka-0-10" % sparkVersion
)
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.24"
