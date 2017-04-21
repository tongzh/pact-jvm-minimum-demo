package com.example;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class ConsumerClientContractTest {

	   @Rule
	    public PactProviderRule rule = new PactProviderRule("ProviderService", this);

	    @Pact(provider="ProviderService", consumer="ConsumerService")
	    public PactFragment createFragment(PactDslWithProvider builder) {
	        Map<String, String> headers = new HashMap<>();
	        headers.put("Content-Type", "application/json;charset=UTF-8");

	        return builder.given("some state")
					.uponReceiving("a request for Foos")
					.path("/foos")
	                .method("GET")
	                .willRespondWith()
	                .headers(headers)
	                .status(200)
	                .body("[{\"value\":42}, {\"value\":100}]").toFragment();
	    }

	    @Test
	    @PactVerification("ProviderService")
	    public void runTest() {
	        assertEquals(new ConsumerClient(rule.getConfig().url()).foos(), Arrays.asList(new Foo(42), new Foo(100)));
	    }
}
