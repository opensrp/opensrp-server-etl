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
	private MemberRepository memberRepository;
	
	public MemberService() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	@Override
	public void save(MemberEntity memberEntity) {
		MemberEntity existingMemberEntity = findByCaseId(memberEntity.getCaseId());
		if (existingMemberEntity == null) {
			memberRepository.save(memberEntity);
		} else {
			if (delete(existingMemberEntity))
				memberRepository.save(memberEntity);
		}
	}
	
	@Transactional
	@Override
	public boolean delete(MemberEntity elcoEntity) {
		return memberRepository.delete(elcoEntity);
		
	}
	
	@Transactional
	@Override
	public void update(MemberEntity elcoEntity) {
		memberRepository.update(elcoEntity);
		
	}
	
	@Override
	public MemberEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public MemberEntity findByCaseId(String caseId) {
		return memberRepository.findByCaseId(caseId);
	}
	
}
