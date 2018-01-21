package org.opensrp.etl.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.AdolescentEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.CommonDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AdolescentService implements RegisterService<AdolescentEntity> {

    private static final String ADOLESCENT_TODAY = "adolescent_today";
    @Autowired
    private CommonDatabaseRepository commonDatabaseRepository;

    public AdolescentService() {
    }

    @Transactional
    @Override
    public void save(AdolescentEntity adolescentEntity) {
        AdolescentEntity existingadolescentEntity = findByCaseIdAndToday(
                adolescentEntity.getRelationalid(),
                adolescentEntity.getAdolescent_today());
        if (existingadolescentEntity == null) {
            commonDatabaseRepository.save(adolescentEntity);
        } else {
            if (delete(existingadolescentEntity))
                commonDatabaseRepository.save(adolescentEntity);
        }

    }

    @Transactional
    @Override
    public boolean delete(AdolescentEntity adolescentEntity) {
        return commonDatabaseRepository.delete(adolescentEntity);
    }

    @Transactional
    @Override
    public void update(AdolescentEntity adolescentEntity) {
        commonDatabaseRepository.update(adolescentEntity);
    }

    @Override
    public AdolescentEntity findById(int id) {
        return null;
    }

    @Override
    public AdolescentEntity findByCaseId(String caseId) {
        return null;
    }

    @Transactional
    private AdolescentEntity findByCaseIdAndToday(String relationalid,
            Date today) {
        return commonDatabaseRepository.findByCaseIdAndToday(ADOLESCENT_TODAY,
                relationalid, today, AdolescentEntity.class);
    }
}
