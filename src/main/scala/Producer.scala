
import java.util.Properties
import org.apache.kafka.clients.producer._

//Note : Make sure Zookeeper and Cluster (server) is up and running  . Refer README

object Producer {

  def main(args: Array[String]): Unit = {
    writeToKafka("test")
  }
  def writeToKafka(topic: String): Unit = {

    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092") //copy  from kafka  ie., server port = 9092
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

    val producer = new KafkaProducer[String, String](props)
    val record = new ProducerRecord[String, String](topic, "Deepak key", " Deepak value")
    producer.send(record)
    producer.close()
    println("Sent !!")
  }
}