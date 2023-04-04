package com.sandeep.SpringIntegration.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld2 {
	
	private final static Logger logger = LoggerFactory   .getLogger(HelloWorld.class);
	 
	 public String greet(String name){
	  logger.info("Greeting in hello2 {}", name); 
	  return "Hello world 2 " + name; 
	 }

	 
	 public String greet2(String name){
		  logger.info("Greeting in hello2 method 2 {}", name); 
		  return "Hello world 2 method 2 " + name; 
		 }
}
