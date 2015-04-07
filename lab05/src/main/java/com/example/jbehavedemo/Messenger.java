package com.example.jbehavedemo;

import com.example.jbehavedemo.messenger.MalformedRecipientException;
import com.example.jbehavedemo.messenger.MessageService;
import com.example.jbehavedemo.messenger.SendingStatus;

public class Messenger {

	private MessageService ms;

	public Messenger(MessageService ms) {
		this.ms = ms;
	}

	public int testConnection(String server) {
		switch (ms.checkConnection(server)) {
		case FAILURE:
			return 1;
		case SUCCESS:
			return 0;
		}
		return 1;
	}

	public int sendMessage(String server, String message) {

		int result = 3;

		try {
			SendingStatus sStatus = ms.send(server, message);
			switch (sStatus) {
			case SENT:
				result = 0;
				break;
			case SENDING_ERROR:
				result = 1;
				break;
			default:
				result = 3;
			}

		} catch (MalformedRecipientException e) {
			result = 2;
		}
		return result;
	}
}
