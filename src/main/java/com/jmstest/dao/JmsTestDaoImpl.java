package com.jmstest.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jmstest.beans.JmsTestBean;
import com.jmstest.exception.JmsTestException;
import static com.jmstest.util.JmsTestConstant.*;

public class JmsTestDaoImpl implements IJmsTestDao {
	Logger logger=Logger.getLogger(this.getClass().getName());

	//Map is used as a in memory data store
	private Map<String, List<String>> dataStore=new HashMap<String, List<String>>();
	private String load;
	
	
	public JmsTestDaoImpl(String load) {
		super();
		this.load = load;
		dataStore.put(RED, new ArrayList<String>());
		dataStore.put(GREEN, new ArrayList<String>());
		dataStore.put(YELLOW, new ArrayList<String>());
		dataStore.put(OTHER, new ArrayList<String>());
	}


	public void addMessage(JmsTestBean testBean) throws JmsTestException {
		logger.log(Level.INFO,"IN - addMessage ");
		List<String> contentList=dataStore.get(testBean.getColorFlag());
		if(contentList==null){
			contentList=new ArrayList<String>();
			dataStore.put(testBean.getColorFlag(), contentList);
		}
		contentList.add(testBean.getText());
		logger.log(Level.INFO,"End - addMessage ");
	}
	
	public void  printMessages(){
		Set<String> keys=dataStore.keySet();
		StringBuilder strBlder=new StringBuilder();
		for(String key:keys){
			List<String> contentList=dataStore.get(key);
			for(String content:contentList){
				strBlder.append(content);
				strBlder.append("\n");
			}
		}
		
		System.out.println(strBlder.toString());
	}

	
}
