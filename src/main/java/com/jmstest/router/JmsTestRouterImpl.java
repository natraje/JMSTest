package com.jmstest.router;

import com.jmstest.service.IJmsTestService;
import static com.jmstest.util.JmsTestUtil.*;

public class JmsTestRouterImpl implements IJmsTestRouter {
	private IJmsTestService jmsTestService;
	private IJmsTestService jmsTestServiceRed;
	private IJmsTestService jmsTestServiceGreen;
	private IJmsTestService jmsTestServiceYellow;
	
	//For this assignment I assumed that same service is replicated to make this easy implementation. 
	// This can return different services in real case.
	
	public IJmsTestService routeToService(String content) {
		if(isGreenPresent(content)){
			return jmsTestServiceGreen;
		} else if(isRedPresent(content)) {
			return jmsTestServiceRed;
		} else if(isYellowPresent(content)){
			return jmsTestServiceYellow;
		}
		return jmsTestService;
	}

	public void setJmsTestService(IJmsTestService jmsTestService) {
		this.jmsTestService = jmsTestService;
	}

	public void setJmsTestServiceRed(IJmsTestService jmsTestServiceRed) {
		this.jmsTestServiceRed = jmsTestServiceRed;
	}

	public void setJmsTestServiceGreen(IJmsTestService jmsTestServiceGreen) {
		this.jmsTestServiceGreen = jmsTestServiceGreen;
	}

	public void setJmsTestServiceYellow(IJmsTestService jmsTestServiceYellow) {
		this.jmsTestServiceYellow = jmsTestServiceYellow;
	}

	
}


