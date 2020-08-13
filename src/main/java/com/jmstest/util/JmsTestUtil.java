package com.jmstest.util;

import static com.jmstest.util.JmsTestConstant.*;

import com.jmstest.beans.JmsTestBean;

public class JmsTestUtil {
	
	public static String getColorFlag(String content){
		String color=OTHER;
		content=content.toLowerCase();
		if(content.contains(RED)){
			color=RED;
		} else if(content.contains(YELLOW)){
			color=YELLOW;
		} else if(content.contains(GREEN)){
			color=GREEN;
		}
		return color;
	}
	
	public static boolean isGreenPresent(String content){
		return content.toLowerCase().contains(GREEN);
	}

	public static boolean isRedPresent(String content){
		return content.toLowerCase().contains(RED);
	}
	
	public static boolean isYellowPresent(String content){
		return content.toLowerCase().contains(YELLOW);
	}	
	
	public static void transformContent(JmsTestBean bean){
		//transformation logic lies here
	}
}
