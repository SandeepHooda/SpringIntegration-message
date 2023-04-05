package com.sandeep.SpringIntegration.messaging;

public interface MessageGateway {
	
	public void send(String message);  
	  
	 public String receive();  

}
