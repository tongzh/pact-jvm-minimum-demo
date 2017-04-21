# pact-java
A consumer-driven contract testing example using pact-jvm, spring boot, and maven 

## Running the consumer
    cd /pact-consumer
    mvn test

This will create a pact file in target/pacts. If the tests pass, we know that the consumer interacts correctly with the contract.

## Running the provider
Start the provider application

    cd /pact-provider
    mvn spring-boot:run

In a separate window/process

    cd /pact-provider
    mvn pact:verify
