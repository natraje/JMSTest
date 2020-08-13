package com.jmstest.listener;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;

import com.jmstest.exception.JmsTestException;
import com.jmstest.router.IJmsTestRouter;
import com.jmstest.service.IJmsTestService;

public class JmsTestAdapter {
	Logger logger=Logger.getLogger(this.getClass().getName());
	private IJmsTestRouter jmsTestRouter;
	private JmsTemplate jmsTemplate;
	
	public void lookForMessages() throws JmsTestException{
		while(true){
			Message message=jmsTemplate.receive();
			if(message!=null && message instanceof TextMessage){
				String content=null;
				TextMessage textMess=(TextMessage)message;
				try {
					content=textMess.getText();
					IJmsTestService jmsTestService=jmsTestRouter.routeToService(content);
					jmsTestService.addMessage(content);
				}catch (Exception exp){
					logger.log(Level.SEVERE, exp.getMessage());
				}
			}
		}
	}
	
	public void setJmsTestRouter(IJmsTestRouter jmsTestRouter) {
		this.jmsTestRouter = jmsTestRouter;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	
	
}
