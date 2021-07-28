# **Testing Kafka :**
Here were are going to send message string from one terminal window into another.

Ref : https://kafka.apache.org/quickstart

## **Pre-Req :**

1) https://www.apache.org/dyn/closer.cgi?path=/kafka/2.5.0/kafka_2.12-2.5.0.tgz
2) Download tar
3) Open terminal
4) tar -xzf kafka_2.12-2.5.0.tgz
5) Extract the files to a folder

## **Error**
Socket server failed to bind to 0.0.0.0:9092:Address already inuse

### solution:
*$lsof -n -i :9092 | grep LISTEN
$kill -9 process_id*

## **Manual Steps** 
* Open new terminal
* cd kafka_2.12-2.5.0
* **Start zookeeper **: $bin/zookeeper-server-start.sh config/zookeeper.properties
* Open new terminal and **Start Kafka Server / Cluster** : $bin/kafka-server-start.sh config/server.properties 
* Open new terminal and **Create Topic** ( $bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic topic_name)
*  Open new terminal and **Create a producer** ($bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic topic_name)
* Open new terminal and **Create a Consumer ** ($bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic_name --from-beginning )

### NOTE : 
1) You can add real time message into Kafka and it should be displayed in the consumer
2) After this make sure u open new terminal and stop Zookeeper and Kafka process sequentially.

## **To Run Scala Consumer and Producer**
1. Make sure zookeeper ,Kafka Server/Cluster is up and running (refer Manual steps)
2. In manual steps topic created is "topic_name" , u can change to "test" either in code or create a new topic to play around.

## **Stopping Services** 

1) bin/kafka-server-stop.sh config/server.properties

2) bin/zookeeper-server-stop.sh config/zookeeper.properties

