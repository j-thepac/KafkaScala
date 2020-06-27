**Testing Kafka :**
Here were are going to send message string from one terminal window into another.

Ref : https://kafka.apache.org/quickstart

Pre-Req :

1) https://www.apache.org/dyn/closer.cgi?path=/kafka/2.5.0/kafka_2.12-2.5.0.tgz
2) Download tar
3) Open terminal
4) tar -xzf kafka_2.12-2.5.0.tgz

Steps :

1) cd kafka_2.12-2.5.0
2) bin/zookeeper-server-start.sh config/zookeeper.properties #start zookeeper 
3) Open new terminal
4) cd kafka_2.12-2.5.0
5) bin/kafka-server-start.sh config/server.properties #start Kafka

_if your face below error_

Socket server failed to bind to 0.0.0.0:9092:Address already inuse

_Solution :_

$lsof -n -i :9092 | grep LISTEN

$kill -9 process_id

