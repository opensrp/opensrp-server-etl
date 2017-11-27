package org.opensrp.etl.service;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.MemberEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements RegisterService<MemberEntity> {
	
	@Autowired
	private MemberRepository elcoRepository;
	
	public MemberService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void save(MemberEntity elcoEntity) {
		MemberEntity existingMemberEntity = findByCaseId(elcoEntity.getCaseId());
		if (existingMemberEntity == null) {
			elcoRepository.save(elcoEntity);
		} else {
			if (delete(existingMemberEntity))
				elcoRepository.save(elcoEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(MemberEntity elcoEntity) {
		return elcoRepository.delete(elcoEntity);
		
	}
	
	@Transactional
	@Override
	public void update(MemberEntity elcoEntity) {
		elcoRepository.update(elcoEntity);
		
	}
	
	@Override
	public MemberEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public MemberEntity findByCaseId(String caseId) {
		return elcoRepository.findByCaseId(caseId);
	}
	
}
