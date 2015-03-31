package com.example.mockdemo.app;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.internal.stubbing.answers.ThrowsException;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.MessageServiceSimpleImpl;
import com.example.mockdemo.messenger.SendingStatus;


@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
	
	@Mock private MessageService ms;
	private Messenger m;
	private Messenger Spym;
	
	public void buidlSpy(){
		m = new Messenger(ms);
		Spym = spy(m);
	}
	
	@Test	
	public void Test1() throws MalformedRecipientException{

		buidlSpy();
		
		Mockito.when(ms.checkConnection("wp.pl")).thenReturn(ConnectionStatus.SUCCESS);
		Mockito.when(ms.send("wp.pl","tekst")).thenReturn(SendingStatus.SENT);
		assertEquals(Spym.testConnection("wp.pl"), 0);
		
	}
	
	@Test	
	public void Test2() throws MalformedRecipientException{

		buidlSpy();
		
		Mockito.when(ms.checkConnection("wp.pl")).thenReturn(ConnectionStatus.SUCCESS);
		Mockito.when(ms.send("wp.pl","tekst")).thenReturn(SendingStatus.SENT);
		assertEquals(Spym.sendMessage("wp.pl", "tekst"), 0);
		
	}
	
	@Test	
	public void Test3() throws MalformedRecipientException{

		buidlSpy();
		
		Mockito.when(ms.checkConnection("wp.pl")).thenReturn(ConnectionStatus.SUCCESS);
		Mockito.when(ms.send("wp.pl","t")).thenThrow(new MalformedRecipientException());
		assertEquals(Spym.sendMessage("wp.pl", "t"), 2);
		
	}
	
	@Test	
	public void Test4() throws MalformedRecipientException{

		buidlSpy();
		
		Mockito.when(ms.checkConnection("wp.com")).thenReturn(ConnectionStatus.FAILURE);
		Mockito.when(ms.send("wp.com","t")).thenReturn(SendingStatus.SENDING_ERROR);
		assertEquals(Spym.testConnection("wp.com"), 1);
		
	}
	
	
	@Test
	public void testMyFunction() throws MalformedRecipientException {
		
		buidlSpy();
		
		when(ms.checkConnection("wp.pl")).thenAnswer(new Answer<ConnectionStatus>(){

			@Override
			public ConnectionStatus answer(InvocationOnMock invocation)
					throws Throwable {
					
				return ConnectionStatus.SUCCESS;
			}

		
		  });
		  
		  assertEquals(Spym.testConnection("wp.pl"), 0);

		}
}


