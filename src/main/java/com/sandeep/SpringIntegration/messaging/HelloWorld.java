package com.sandeep.SpringIntegration.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;

public class HelloWorld {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 
		 
	 public String greetOne(String name){
		  logger.info("Greeting in HelloWorld method: greet <- 1 {}", name); 
		  return "Hello world  greet-> 1 " + name; 
	}
	 
	 @ServiceActivator(inputChannel = "inputChannel-two", outputChannel = "outputChannel-two")
	 public String greetTwo(String name){
		 logger.info("Greeting in HelloWorld method : greet <- 2 ", name); 
		  return "Hello world  greet -> 2 " + name; 
	 }
	 
	 @ServiceActivator(inputChannel = "inputChannel-three", outputChannel = "outputChannel-three")
	 public String greetThree(String name){
		 logger.info("Greeting in HelloWorld method : greet <- 3", name); 
		  return "Hello world  greet -> 3 " + name; 
	 }
	 
	 @ServiceActivator(inputChannel = "outputChannel-three", outputChannel = "outputChannel-two")
	 public String outputHandlerForChannelThree(String message){
		 logger.info("Greeting in HelloWorld method : outputHandlerForChannelThree  ", message); 
		  return "Hello world  greetThree " + message; 
	 }
}
