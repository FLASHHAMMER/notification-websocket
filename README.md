# Getting Started

## Project details

Reactive Springboot project

 - Gradle 8.3 / Gradle Wrapper 8.3
 - Springboot 3.1.3
 - Spring Data Reactive MongoDB
 - Spring Test
 - Spring Reactor Test

## How to Compile/Build

### Included

 - Gradle Wrapper

### Pre-requisites

 - JDK 20 (Amazon Corretto 20 flavor used)
```bash
javac -version
```

### Configuration

``` src/main/resources/application.yaml ``` has the configuration variables.

### Clean

```bash
gradlew clean
```

### Build Compile

```bash
gradlew build
```

### Build package

```bash
gradlew jar
```

## How to Run

### Run Locally

```bash
gradlew bootRun
```

## Documentation and Fetching

``` Flux<Notification> ``` represents a stream of notifications. But, by default, it will produce a JSON array because If a stream of individual JSON objects is sent to the browser then It will not be a valid JSON document as a whole. 
A browser client has no way to consume a stream other than using Server-Sent-Events or WebSocket.
However, Non-browser clients can request a stream of JSON by setting the Accept header to ``` application/stream+json ```, and the response will be a stream of JSON similar to Server-Sent-Events but without extra formatting.
