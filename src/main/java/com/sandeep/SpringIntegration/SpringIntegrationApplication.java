package com.sandeep.SpringIntegration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageHandler;




@SpringBootApplication
@Configuration
@ImportResource("classpath:beans.xml")
public class SpringIntegrationApplication {
	private final Logger logger = LoggerFactory.getLogger(SpringIntegrationApplication.class);

	public static void main(String[] args) {
	//http://localhost:8080/spring-int/sandeep
		SpringApplication.run(SpringIntegrationApplication.class, args);
		
	}
	
	
	@Bean
	public MessageHandler outputMessageHandler() {
	    return message -> {
	        // business logic to process the message
	    	logger.info("Message handler on output channel: {}", message.getPayload()); 

	    };
	}

	@Bean
	public IntegrationFlow outputFlowOne() {
	    return IntegrationFlows.from("outputChannel-one")
	            .handle(outputMessageHandler())
	            .get();
	}
	
	@Bean
	public IntegrationFlow outputFlowTwo() {
	    return IntegrationFlows.from("outputChannel-two")
	            .handle(outputMessageHandler())
	            .get();
	}
}
