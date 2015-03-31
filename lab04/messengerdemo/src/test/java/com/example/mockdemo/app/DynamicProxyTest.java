package com.example.mockdemo.app;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;


import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.MessageServiceSimpleImpl;
import com.example.mockdemo.messenger.SendingStatus;

public class DynamicProxyTest {

	@Test
	public void checkSending() {

		InvocationHandler ih = new MessageServiceSimpleImplHandler();
		
		MessageService msMock = (MessageService) Proxy.newProxyInstance(
				MessageService.class.getClassLoader(),
				new Class[] { MessageService.class }, ih);
		

		Messenger ms = new Messenger(msMock);

		assertEquals(0, ms.sendMessage("wp.pl","kkfalkaf"));
	}
	
	class MessageServiceSimpleImplHandler implements InvocationHandler {

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			if ("checkConnection".equals(method.getName())) {
				return ConnectionStatus.SUCCESS;
			}
			if ("send".equals(method.getName())) {
				return SendingStatus.SENT;
			}

			return -1;
		}
	}
	
	@Test
	public void checkSending1() {

		InvocationHandler ih = new MessageServiceSimpleImplHandler2();
		
		MessageService msMock = (MessageService) Proxy.newProxyInstance(
				MessageService.class.getClassLoader(),
				new Class[] { MessageService.class }, ih);
		

		Messenger ms = new Messenger(msMock);

		assertEquals(2, ms.sendMessage(null,null));
	}
	
	class MessageServiceSimpleImplHandler2 implements InvocationHandler {

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			if ("checkConnection".equals(method.getName())) {
				return ConnectionStatus.FAILURE;
			}
			if ("send".equals(method.getName())) {
				throw new MalformedRecipientException();
			}

			return -1;
		}
	}
		@Test
		public void checkSending2() {

			InvocationHandler ih = new MessageServiceSimpleImplHandler3();
			
			MessageService msMock = (MessageService) Proxy.newProxyInstance(
					MessageService.class.getClassLoader(),
					new Class[] { MessageService.class }, ih);
			

			Messenger ms = new Messenger(msMock);

			assertEquals(2, ms.sendMessage("wp.pl","te"));
		}
		
		class MessageServiceSimpleImplHandler3 implements InvocationHandler {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				if ("checkConnection".equals(method.getName())) {
					return ConnectionStatus.SUCCESS;
				}
				if ("send".equals(method.getName())) {
					throw new MalformedRecipientException();
				}

				return -1;
			}
	}
		
		@Test
		public void checkSending3() {

			InvocationHandler ih = new MessageServiceSimpleImplHandler4();
			
			MessageService msMock = (MessageService) Proxy.newProxyInstance(
					MessageService.class.getClassLoader(),
					new Class[] { MessageService.class }, ih);
			

			Messenger ms = new Messenger(msMock);

			assertEquals(1, ms.sendMessage("wp.com","tekst"));
		}
		
		class MessageServiceSimpleImplHandler4 implements InvocationHandler {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				if ("checkConnection".equals(method.getName())) {
					return ConnectionStatus.FAILURE;
				}
				if ("send".equals(method.getName())) {
					return SendingStatus.SENDING_ERROR;
				}

				return -1;
			}
	}
	
	
}
