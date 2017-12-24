package org.unicef.etl.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unicef.etl.entity.ClientEntity;
import org.unicef.etl.interfaces.RegisterService;
import org.unicef.etl.repository.CommonDatabaseRepository;

@Service
public class ClientService implements RegisterService<ClientEntity> {
	
	@Autowired
	private CommonDatabaseRepository commonDatabaseRepository;
	
	public ClientService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void save(ClientEntity clientEntity) {
		if (findBybaseEntityId(clientEntity.getBaseEntityId()) == null) {
			commonDatabaseRepository.save(clientEntity);
		} else {
			System.out.println("client already exists in database!!!");
		}
		
	}
	
	@Override
	public boolean delete(ClientEntity t) {
		return true;
		// TODO Auto-generated method stub
		
	}
	
	@Transactional
	@Override
	public void update(ClientEntity clientEntity) {
		commonDatabaseRepository.update(clientEntity);
		
	}
	
	@Override
	public ClientEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public ClientEntity findBybaseEntityId(String baseEntityId) {
		return commonDatabaseRepository.findByKey(baseEntityId, "baseEntityId", ClientEntity.class);
	}
	
}
