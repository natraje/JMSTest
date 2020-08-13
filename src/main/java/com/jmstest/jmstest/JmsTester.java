package com.jmstest.jmstest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.jmstest.exception.JmsTestException;
import com.jmstest.listener.JmsTestAdapter;

public class JmsTester {
	private static final ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/jmstest/resources/spring.xml");
	final static ExecutorService execService=Executors.newFixedThreadPool(5);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JmsTestAdapter jmsTestAdapter=(JmsTestAdapter)ctx.getBean("jmsTestAdapter");
		try {
			jmsTestAdapter.lookForMessages();
		} catch (JmsTestException e) {
			// TODO Auto-generated catch block
			
		}
		
		execService.submit(new MessageGenerator());
	}
	
	private static class MessageGenerator implements Runnable{

		public void run() {
			try{
				Thread.sleep(10000);
			} catch (InterruptedException exp){
				//logic for restore if needed
			}
			JmsTemplate jmsTemplate=(JmsTemplate)ctx.getBean("jmsTemplate");
			jmsTemplate.send(new MessageCreator() {
				
				public Message createMessage(Session session) throws JMSException {
					// TODO Auto-generated method stub
					return session.createTextMessage("red color");
				}
			});
			
		}
		
	}
	

}
