import java.util

import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}
import java.util.{Properties, UUID}

import scala.collection.JavaConverters._

object Consumer {
  def main(args: Array[String]): Unit = {
    consumeFromKafka("test")
  }

  def consumeFromKafka(topic: String) = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")//copy  from kafka  ie., server port = 9092
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("auto.offset.reset", "latest")
    props.put("group.id", "consumer-group")
    props.put(ConsumerConfig.GROUP_ID_CONFIG, UUID.randomUUID().toString());
    props.put(ConsumerConfig.CLIENT_ID_CONFIG, "your_client_id");
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

    val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](props)
    consumer.subscribe(util.Arrays.asList(topic))

    println("polling started !!")
    while (true) {
      val record = consumer.poll(1000).asScala
      for (data <- record.iterator) {
        println(data.value())
      }
    }
  }
}