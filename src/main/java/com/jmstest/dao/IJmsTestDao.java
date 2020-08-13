package com.jmstest.dao;

import com.jmstest.beans.JmsTestBean;
import com.jmstest.exception.JmsTestException;

public interface IJmsTestDao {
	void addMessage(JmsTestBean textBean) throws JmsTestException;
	public void  printMessages();
}
