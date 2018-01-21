package org.opensrp.etl.service;

import java.util.Date;
import javax.transaction.Transactional;
import org.opensrp.etl.entity.BNFEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.CommonDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BNFService implements RegisterService<BNFEntity> {

    @Autowired
    private CommonDatabaseRepository commonDatabaseRepository;

    public BNFService() {
    }

    @Transactional
    @Override
    public void save(BNFEntity bnfEntity) {
        BNFEntity existingbnfEntity = findByCaseIdAndToday(
                bnfEntity.getRelationalid(), bnfEntity.getToday());
        if (existingbnfEntity == null) {
            commonDatabaseRepository.save(bnfEntity);
        } else {
            if (delete(existingbnfEntity))
                commonDatabaseRepository.save(bnfEntity);
        }
    }

    @Transactional
    @Override
    public boolean delete(BNFEntity bnfEntity) {
        return commonDatabaseRepository.delete(bnfEntity);
    }

    @Transactional
    @Override
    public void update(BNFEntity bnfEntity) {
        commonDatabaseRepository.update(bnfEntity);
    }

    @Override
    public BNFEntity findById(int id) {
        return null;
    }

    @Override
    public BNFEntity findByCaseId(String caseId) {
        return null;
    }

    @Transactional
    public BNFEntity findByCaseIdAndToday(String caseId, Date today) {
        return commonDatabaseRepository.findByCaseIdAndToday(caseId, today,
                BNFEntity.class);
    }
}
