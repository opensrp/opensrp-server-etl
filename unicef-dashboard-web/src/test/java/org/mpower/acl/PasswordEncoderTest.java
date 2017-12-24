package org.mpower.acl;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
	
	@Ignore
	@Test
	public void dd() {
		System.err.println(new BCryptPasswordEncoder().encode("admin"));
	}
	
}
