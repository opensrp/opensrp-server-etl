package org.opensrp.etl.service;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.ANCEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.CommonDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ANCService implements RegisterService<ANCEntity> {

    private static final String ANC_NAME = "ancName";
    @Autowired
    private CommonDatabaseRepository commonDatabaseRepository;

    public ANCService() {
    }

    @Transactional
    @Override
    public void save(ANCEntity ancEntity) {
        ANCEntity existingancEntity = findByCaseIdAndName(
                ancEntity.getRelationalid(), ancEntity.getAncName());
        if (existingancEntity == null) {
            commonDatabaseRepository.save(ancEntity);
        } else {
            if (delete(existingancEntity))
                commonDatabaseRepository.save(ancEntity);
        }

    }

    @Transactional
    @Override
    public boolean delete(ANCEntity ancEntity) {
        return commonDatabaseRepository.delete(ancEntity);
    }

    @Transactional
    @Override
    public void update(ANCEntity ancEntity) {
        commonDatabaseRepository.update(ancEntity);

    }

    @Override
    public ANCEntity findById(int id) {
        return null;
    }

    @Transactional
    @Override
    public ANCEntity findByCaseId(String caseId) {
        return null;
    }

    @Transactional
    public ANCEntity findByCaseIdAndName(String relationalId, String name) {
        return commonDatabaseRepository.findByCaseIdAndName(ANC_NAME,
                relationalId, name, ANCEntity.class);
    }
}
