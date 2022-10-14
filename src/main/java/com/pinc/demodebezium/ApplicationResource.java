package com.pinc.demodebezium;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ApplicationResource extends RouteBuilder {

	 final String KAFKA_ENDPOINT = "kafka:%s?brokers=localhost:9092";
	 
	@Override
	public void configure() throws Exception {
		
		fromF(KAFKA_ENDPOINT, "mssql.dbo.Emp")
        .log("[${header.kafka.OFFSET}] [${body}]");
		
	}

}
