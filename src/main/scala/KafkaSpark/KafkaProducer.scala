package KafkaSpark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
object KafkaProducer extends App {

  val spark = SparkSession
    .builder()
    .master("local")
    .appName("kafkaconsumer")
    .getOrCreate()

  import spark.implicits._
  val df = Seq(("Ram", 20))
    .toDF("name", "age")
    .withColumn("value", to_json(struct('name, 'age)))
    .withColumn("key", lit("key1"))
    .select("key", "value")

  df.write
    .format("kafka")
    .option("kafka.bootstrap.servers", "localhost:9092")
    .option("topic", "topic1")
    .save()
}
