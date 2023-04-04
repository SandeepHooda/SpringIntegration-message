package com.sandeep.SpringIntegration.messaging;
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory; 
public class HelloWorld {
 private final static Logger logger = LoggerFactory   .getLogger(HelloWorld.class);
 
 public String greet(String name){
  logger.info("Greeting {}", name); 
  return "Hello " + name; 
 }
}