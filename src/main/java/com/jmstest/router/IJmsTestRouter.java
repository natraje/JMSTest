package com.jmstest.router;

import com.jmstest.service.IJmsTestService;

public interface IJmsTestRouter {

	IJmsTestService routeToService(String content);
	
}
