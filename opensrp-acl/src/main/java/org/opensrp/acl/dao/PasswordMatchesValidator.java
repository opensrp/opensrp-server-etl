package org.opensrp.acl.dao;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.opensrp.acl.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext arg1) {
		Account account = (Account) obj;
		return passwordEncoder.matches(account.getPassword(), account.getRetypePassword());
	}

}
