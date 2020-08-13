package com.jmstest.beans;

import com.jmstest.util.JmsTestUtil;

public class JmsTestBean {

	private String text;
	private String colorFlag;
	
	public JmsTestBean(){}
	
	public JmsTestBean(String text){
		this.text=text;	
		this.colorFlag=JmsTestUtil.getColorFlag(text);
		JmsTestUtil.transformContent(this);
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getColorFlag() {
		return colorFlag;
	}

	public void setColorFlag(String colorFlag) {
		this.colorFlag = colorFlag;
	}

	@Override
	public String toString() {
		return "JmsTestBean [text=" + text + ", colorFlag=" + colorFlag + "]";
	}

	
	
	
}
