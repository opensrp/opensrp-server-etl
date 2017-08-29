package org.opensrp.report.service;

import org.springframework.stereotype.Component;

@Component
public class DemoTest {
	
	public DemoTest() {
		System.err.println("dddd");
	}
	
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
