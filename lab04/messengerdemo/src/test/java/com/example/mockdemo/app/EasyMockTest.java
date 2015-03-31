package com.example.mockdemo.app;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;

import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;


public class EasyMockTest {
/*
	@Rule
	public EasyMockRule mocks = new EasyMockRule(this);

	@Mock
	private MessageService mock;

	@TestSubject
	private Messenger ms = new Messenger(mock);
*/
	
	// SUT
	private Messenger ms;
	private MessageService mock;

	@Before
	public void setUp() {
		mock = createMock(MessageService.class);
		ms = new Messenger(mock);
	}
	
	
	@Test
	public void MessengerCheck() throws MalformedRecipientException {
		expect(mock.checkConnection("wp.pl")).andReturn(ConnectionStatus.SUCCESS).anyTimes();
		expect(mock.send("wp.pl", "tekst")).andReturn(SendingStatus.SENT).atLeastOnce();
		replay(mock);
		assertEquals(0, ms.sendMessage("wp.pl", "tekst"));
		verify(mock);
	}
	
	@Test
	public void MessengerCheck2() throws MalformedRecipientException {
		expect(mock.checkConnection("wp.com")).andReturn(ConnectionStatus.FAILURE).anyTimes();
		expect(mock.send("wp.com", "t")).andReturn(SendingStatus.SENDING_ERROR).atLeastOnce();
		replay(mock);
		assertEquals(1, ms.sendMessage("wp.com", "t"));
		verify(mock);
	}
	
	@Test
	public void MessengerCheck3() throws MalformedRecipientException {
		expect(mock.checkConnection("wp.pl")).andReturn(ConnectionStatus.SUCCESS).anyTimes();
		expect(mock.send("wp.pl", "t")).andThrow(new MalformedRecipientException()).atLeastOnce();
		replay(mock);
		assertEquals(2, ms.sendMessage("wp.pl", "t"));
		verify(mock);
	}
	
	@Test
	public void MessengerCheck4() throws MalformedRecipientException {
		expect(mock.checkConnection("wp.com")).andReturn(ConnectionStatus.FAILURE).anyTimes();
		//expect(mock.send("wp.pl", "test")).andReturn(SendingStatus.SENT).atLeastOnce();
		replay(mock);
		assertEquals(1, ms.testConnection("wp.com"));
		verify(mock);
	}
	
	@Test
	public void MessengerCheck5() throws MalformedRecipientException {
		expect(mock.checkConnection("wp.pl")).andReturn(ConnectionStatus.SUCCESS).anyTimes();
		//expect(mock.send("wp.pl", "test")).andReturn(SendingStatus.SENT).atLeastOnce();
		replay(mock);
		assertEquals(0, ms.testConnection("wp.pl"));
		verify(mock);
	}
	
	@Test
	public void MessengerCheck6() throws MalformedRecipientException {
		expect(mock.checkConnection(".pl")).andReturn(ConnectionStatus.SUCCESS).anyTimes();
		expect(mock.send(".pl", "tekst")).andThrow(new MalformedRecipientException()).atLeastOnce();
		replay(mock);
		assertEquals(2, ms.sendMessage(".pl", "tekst"));
		verify(mock);
	}
}