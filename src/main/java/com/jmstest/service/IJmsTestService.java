package com.jmstest.service;

import com.jmstest.exception.JmsTestException;

public interface IJmsTestService {

	void addMessage(String content) throws JmsTestException;
	void  printMessages();
}
