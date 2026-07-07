# SimpleKafka

A custom, simplified implementation of a distributed messaging system inspired by Apache Kafka. This project is built from scratch to understand the internal mechanics of a distributed message broker, including topic partitioning, leader election, and message persistence.

## Features

- **Topic Partitioning & Replication**: Topics are divided into partitions and distributed across multiple brokers.
- **Leader & Follower Mechanics**: Zookeeper is used to elect a cluster controller, manage leader elections, and handle broker failures.
- **Message Persistence**: Custom sequential log segment structure for persistent message storage.
- **Client-Broker Protocol**: Custom binary protocol for produce, fetch, metadata, and replication requests.
- **Producer & Consumer APIs**: Basic client libraries to interact with the cluster.

## Requirements

- Java 11 or higher
- Maven
- Apache ZooKeeper (tested with 3.8.1)

## Building the Project

Compile the project and package it into a single shaded JAR using Maven:

```bash
mvn clean package
```

## Running the System

### 1. Start ZooKeeper
Ensure ZooKeeper is running locally on the default port `2181`:

```bash
# If ZooKeeper is in your PATH
zkServer start
```

### 2. Start Brokers
Start multiple instances of `SimpleKafkaBroker`. Each requires a unique broker ID, host, port, and the ZooKeeper connection string.

```bash
# Terminal 1 - Broker 1
java -cp target/simple-kafka-1.0-SNAPSHOT.jar com.simplekafka.broker.SimpleKafkaBroker 1 localhost 9091 2181

# Terminal 2 - Broker 2
java -cp target/simple-kafka-1.0-SNAPSHOT.jar com.simplekafka.broker.SimpleKafkaBroker 2 localhost 9092 2181

# Terminal 3 - Broker 3
java -cp target/simple-kafka-1.0-SNAPSHOT.jar com.simplekafka.broker.SimpleKafkaBroker 3 localhost 9093 2181
```

### 3. Produce Messages
Run the producer to create a topic (`test-topic`) and send test messages to the cluster:

```bash
java -cp target/simple-kafka-1.0-SNAPSHOT.jar com.simplekafka.client.SimpleKafkaProducer localhost 9091 test-topic
```

### 4. Consume Messages
Run the consumer to read messages from a specific partition (e.g., partition `0`) of the topic:

```bash
java -cp target/simple-kafka-1.0-SNAPSHOT.jar com.simplekafka.client.SimpleKafkaConsumer localhost 9091 test-topic 0
```
