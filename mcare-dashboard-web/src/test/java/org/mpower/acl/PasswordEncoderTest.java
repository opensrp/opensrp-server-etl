package org.mpower.acl;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
	
	@Test
	public void dd() {
		System.err.println(new BCryptPasswordEncoder().encode("admin"));
	}
	
}
