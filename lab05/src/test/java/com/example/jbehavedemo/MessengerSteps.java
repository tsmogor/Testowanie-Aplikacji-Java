package com.example.jbehavedemo;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import static org.junit.Assert.assertEquals;
import com.example.jbehavedemo.messenger.MessageServiceSimpleImpl;
import com.example.jbehavedemo.*;

public class MessengerSteps {
	
	private Messenger ms;
	private String message;
	private String server;
	
	@Given("a messenger")
	public void messangerSetup(){
		ms = new Messenger(new MessageServiceSimpleImpl());
	}
	
	@When("set server name to $server2")
	public void setServer(String server2){
		server = server2;
	}
	@When("set message text to $text")
	public void setMessage(String text){
		message = text;
	}
	
	@Then("test connection should return $result")
	public void testConnection(int result){
		assertEquals(result, ms.testConnection(server));
	}
	
	@Then("send message return $result")
	public void send(int result){
		assertEquals(result, ms.sendMessage(server, message));
	}

}
