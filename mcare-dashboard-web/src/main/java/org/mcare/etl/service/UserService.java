package org.mcare.etl.service;

import javax.transaction.Transactional;

import org.mcare.etl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public UserService(){
		
	}
	
	@Transactional
	public void test(){
		System.err.println(""+userRepository);
		userRepository.test();
	}

}
