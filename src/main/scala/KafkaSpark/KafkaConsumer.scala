package KafkaSpark

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._
object KafkaConsumer extends App {

  val spark = SparkSession
    .builder()
    .master("local")
    .appName("kafkaconsumer")
    .getOrCreate()

  import spark.implicits._

  val df = spark.read
    .format("kafka")
    .option("kafka.bootstrap.servers", "localhost:9092")
    .option("subscribe", "topic1")
    .load()

  df.withColumn("new", 'value.cast(StringType)).show()

}
