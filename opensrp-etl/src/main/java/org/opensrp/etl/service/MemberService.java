package org.opensrp.etl.service;

import static org.opensrp.etl.util.AllConstants.CASE_ID;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.MemberEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.CommonDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements RegisterService<MemberEntity> {
	
	@Autowired
	private CommonDatabaseRepository commonDatabaseRepository;
	
	public MemberService() {
	}
	
	@Transactional
	@Override
	public void save(MemberEntity memberEntity) {
		MemberEntity existingMemberEntity = findByCaseId(memberEntity.getCaseId());
		if (existingMemberEntity == null) {
			commonDatabaseRepository.save(memberEntity);
		} else {
			if (delete(existingMemberEntity))
				commonDatabaseRepository.save(memberEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(MemberEntity memberEntity) {
		return commonDatabaseRepository.delete(memberEntity);
	}
	
	@Transactional
	@Override
	public void update(MemberEntity memberEntity) {
		commonDatabaseRepository.update(memberEntity);
	}
	
	@Override
	public MemberEntity findById(int id) {
		return null;
	}
	
	@Transactional
	@Override
	public MemberEntity findByCaseId(String caseId) {
		return commonDatabaseRepository.findByKey(caseId, CASE_ID, MemberEntity.class);
	}
}
