package com.sandeep.SpringIntegration.messaging;

public class Transformer {
	
	public String transform1(String input) {
		return input + " added by transformer 1. ";
	}
	
	public String transform2(String input) {
		return input + " added by transformer 2. \r\n";
	}

}
