package com.example.mockdemo.app;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Assert;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.MessageServiceSimpleImpl;
import com.example.mockdemo.messenger.SendingStatus;

import static org.hamcrest.BaseMatcher.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class StubTest {
	
	Messenger ms = new Messenger(new MessageServiceSimpleImpl());
	
	@Test
	public void MessengeServiceTest(){
		assertEquals(0, ms.testConnection("wp.pl"));
	}
	
	
	@Test
	public void MessengeServiceTest2() throws MalformedRecipientException{
		assertEquals(0, ms.sendMessage("wp.org.pl","witam"));
	}
	
	@Test
	public void MessengeServiceTest3() throws MalformedRecipientException{
		assertEquals(2, ms.sendMessage(".pl","witam"));
	}
	
	@Test
	public void MessengeServiceTest4() throws MalformedRecipientException{
		assertEquals(2, ms.sendMessage(null,"witam"));
	}
	
	@Test
	public void MessengeServiceTest5() throws MalformedRecipientException{
		assertEquals(2, ms.sendMessage(null,null));
	}
	
	@Test
	public void MessengeServiceTest6() throws MalformedRecipientException{
		assertEquals(2, ms.sendMessage("wp.org.pl","wi"));
	}
	
	@Test
	public void MessengeServiceTest7() throws MalformedRecipientException{
		assertEquals(1, ms.sendMessage("wp.org.com","witam"));
	}
}
