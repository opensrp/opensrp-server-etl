package org.mcare.acl.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.mcare.acl.service.AclService;
import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nursat
 *
 */

@Service
public class UsageHistoryServiceImpl implements AclService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private DatabaseRepositoryImpl repository;

    public UsageHistoryServiceImpl() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public <T> long save(T t) throws Exception {
        return repository.save(t);
    }

    @Override
    public <T> int update(T t) {
        return repository.update(t);
    }

    @Override
    public <T> boolean delete(T t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <T> T findById(int id, String fieldName, Class<?> className) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T findByKey(String value, String fieldName, Class<?> className) {
        return repository.findByKey(value, fieldName, className);
    }

    @Override
    public <T> List<T> findAll(String tableClass) {
        return repository.findAll(tableClass);
    }

}
