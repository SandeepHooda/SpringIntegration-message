package com.sandeep.SpringIntegration.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

@RestController
public class RestEndPoint {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	@Qualifier("inputChannel-one")
	private DirectChannel inputChannelOne;
	

	@Autowired
	@Qualifier("inputChannel-two")
	private DirectChannel inputChannelTwo;
	
	@Autowired
	@Qualifier("inputChannel-three")
	private DirectChannel inputChannelThree;
	
	@Autowired
	@Qualifier("greetingsToWorld")
	private Greetings  greetGateway;
	
	@RequestMapping("/spring-int/{name}")
	public String home(@PathVariable("name") String name ) {
		
		logger.info("Inside : RestEndPoint with args {}", name); 

		//inputChannelOne.send(MessageBuilder.withPayload(name).build());
		//or use this way 
		greetGateway.sendMessageToHelloWorld(name);
		
		inputChannelTwo.send(MessageBuilder.withPayload(name).build());
		
		inputChannelThree.send(MessageBuilder.withPayload(name).build());
		
		return "ok- Check RestEndPoint.java :: system logs for more details" ;//+greetGateway.receiveMessageFromHelloWorld();
	}
}
