# A minimum pact jvm demo 

## Dependency

* pact-jvm
* spring boot
* maven 

## Running the consumer

```
cd /pact-consumer
mvn test
```

This will create a pact file in target/pacts.

## Running the provider

Start the provider application

```
cd /pact-provider
mvn spring-boot:run
```

Run the pact verification in a separate window/process

```
cd /pact-provider
mvn pact:verify
```
