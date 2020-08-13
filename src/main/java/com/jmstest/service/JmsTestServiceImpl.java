package com.jmstest.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.jmstest.beans.JmsTestBean;
import com.jmstest.dao.IJmsTestDao;
import com.jmstest.exception.JmsTestException;

public class JmsTestServiceImpl implements IJmsTestService {

	Logger logger=Logger.getLogger(this.getClass().getName());
	private IJmsTestDao jmsTestDao;
	
	public void addMessage(String content) throws JmsTestException {
		JmsTestBean testBean=new JmsTestBean(content);
		logger.log(Level.INFO,"IN - addMessage ");
		jmsTestDao.addMessage(testBean);
		logger.log(Level.INFO,"End - addMessage ");
	}

	public void  printMessages(){
		this.jmsTestDao.printMessages();
	}
	
	public void setJmsTestDao(IJmsTestDao jmsTestDao) {
		this.jmsTestDao = jmsTestDao;
	}
	
}
