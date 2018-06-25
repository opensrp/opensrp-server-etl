package org.opensrp.connector.openmrs.service.impl;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:test-applicationContext.xml" })
public class OpenmrsRoleServiceTest {

	@Autowired
	private OpenmrsRoleService openmrsRoleService;
	@Value("#{opensrp['openmrs.url']}")
	protected String OPENMRS_BASE_URL;
	@Before
	public void setup() throws IOException {
		
	}
	
	@Test
	public void test(){
		System.err.println("okkk:"+openmrsRoleService+":"+OPENMRS_BASE_URL);
	}
}
