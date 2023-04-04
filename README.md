# SpringIntegration-message
Lauch http://localhost:8080/spring-int/sandeep

This takes the flow to RestEndPoint.home
here we sent message to inputChannelOne, inputChannelTwo, and inputChannelThree

service-activator for inputChannel-one and outputChannel-one are defined in beans.xml
inputChannelOne.send(MessageBuilder.withPayload(name).build()); 
---and 
greetGateway.sendMessageToHelloWorld(name);
---both means the same thing

ServiceActivator for inputChannel-two, outputChannel-two are defines in HelloWorld

ServiceActivator for inputChannel-three, outputChannel-three are defines in HelloWorld

output channel handles for outputChannel-one and outputChannel-two are common "outputMessageHandler" which is defines in SpringIntegrationApplication.java

#service-activator
Think of service-activator as a method in a class that takes input from inputChannel and sends output to outputChannel
gateway  is quite similar to service-activator. It is more abstract. We don't write clsss and method. instead Sprint writes its own class and method to create service-activator and then connect that service-activator (method) to input and ouitput channels. We call the interface method but intern that message reached to the service-activator written by sprint via the inputChannel. 
