package org.mcare.acl.service;

import org.mcare.acl.entity.Account;
import org.mcare.acl.repository.DatabaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private DatabaseRepositoryImpl repository;
    
    @Autowired
    private StandardPasswordEncoder standardPasswordEncoder;

    @Transactional
    public void registerNewUserAccount(Account account) {
        //Account user = new Account();    
        //user.setFirstName(accountDto.getFirstName());
        //user.setLastName(accountDto.getLastName());
        //user.setPassword(accountDto.getPassword());
        //user.setEmail(accountDto.getEmail());
        //user.setRoles(Arrays.asList("ROLE_USER"));
    	account.setUsername(account.getUsername());
		account.setUsername(account.getFirstName());
		account.setUsername(account.getLastName());
		account.setUsername(account.getEmail());
		account.setEnabled(true);
		System.out.println("adding password: " + account.getPassword());
		account.setPassword(standardPasswordEncoder.encode(account.getPassword()));
        repository.save(account);
    }
}
