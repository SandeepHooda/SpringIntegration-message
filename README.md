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
