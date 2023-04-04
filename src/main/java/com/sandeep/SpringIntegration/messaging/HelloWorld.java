package com.sandeep.SpringIntegration.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;

public class HelloWorld {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 
		 
	 public String greetOne(String name){
		  logger.info("Greeting in HelloWorld method: greetOne {}", name); 
		  return "Hello world  greetOne " + name; 
	}
	 
	 @ServiceActivator(inputChannel = "inputChannel-two", outputChannel = "outputChannel-two")
	 public String greetTwo(String name){
		 logger.info("Greeting in HelloWorld method : greetTwo ", name); 
		  return "Hello world  greetTwo " + name; 
	 }
	 
	 @ServiceActivator(inputChannel = "inputChannel-three", outputChannel = "outputChannel-three")
	 public String greetThree(String name){
		 logger.info("Greeting in HelloWorld method : greetThree ", name); 
		  return "Hello world  greetThree " + name; 
	 }
	 
	 @ServiceActivator(inputChannel = "outputChannel-three", outputChannel = "outputChannel-two")
	 public String outputHandlerForChannelThree(String message){
		 logger.info("Greeting in HelloWorld method : outputHandlerForChannelThree ", message); 
		  return "Hello world  greetThree " + message; 
	 }
}
