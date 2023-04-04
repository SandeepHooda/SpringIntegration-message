package com.sandeep.SpringIntegration.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.SpringIntegration.SpringIntegrationApplication; 

@RestController
public class RestEndPoint {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/{name}")
	public String home(@PathVariable("name") String name ) {

		
		
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("/META-INF/spring/integration/cafeDemo-xml.xml", SpringIntegrationApplication.class);

			Greetings  greetGateway = (Greetings) context.getBean("greetingsToWorld");
			greetGateway.sendMessageToHelloWorld(name);
			//LOGGER.info("REsponse {}", greetGateway.receiveMessageFromHelloWorld()); 
			
		return ""+ greetGateway.receiveMessageFromHelloWorld();
	}
}
