# Kafka

## Steps:
### 1. Manual 
    
    cd root/src/main/scala/
    docker-compose up -d
    docker ps -a
    docker exec -it <kafka_container_id> bash
    $cd /opt/kafka_<version>/bin
Create Topic

    $kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic quickstart
Run Producer

    $kafka-console-producer.sh --topic quickstart --bootstrap-server localhost:9092

    >HI
    
Open New Terminal
    
    docker exec -it <kafka_container_id> bash
    $cd /opt/kafka_<version>/bin
    $kafka-console-consumer.sh --topic quickstart --from-beginning --bootstrap-server localhost:9092

Close both the Terminals
### 2. Run Scala Code
- Run Producer
- Run Consumer
    
## To stop all services

    cd <to the locaton of docker-compose.yml>
    docker-compose down
    
    
