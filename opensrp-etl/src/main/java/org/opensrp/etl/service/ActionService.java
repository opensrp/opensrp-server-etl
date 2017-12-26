package org.opensrp.etl.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.opensrp.etl.entity.ActionEntity;
import org.opensrp.etl.interfaces.RegisterService;
import org.opensrp.etl.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ActionService implements RegisterService<ActionEntity> {

    @Autowired
    private ActionRepository actionRepository;

    public ActionService() {
        // TODO Auto-generated constructor stub
    }

    @Transactional
    @Override
    public void save(ActionEntity actionEntity) {
        ActionEntity existingActionEntity = findByCaseIdAndAlertStatusAndVisitCode(
                actionEntity.getCaseId(), actionEntity.getAlertStatus(),
                actionEntity.getVisitCode(), actionEntity.getStartDate());
        if (existingActionEntity == null) {
            actionRepository.save(actionEntity);
        } else {
            if (delete(existingActionEntity))
                actionRepository.save(actionEntity);
        }
    }

    @Transactional
    public boolean isActionExist(ActionEntity actionEntity) {
        return actionRepository.isActionExist(actionEntity.getCaseId(),
                actionEntity.getVisitCode(), actionEntity.getAlertStatus(),
                actionEntity.getStartDate()) > 0 ? true : false;

    }

    @Override
    public boolean delete(ActionEntity actionEntity) {
        return actionRepository.delete(actionEntity);
    }

    @Override
    public void update(ActionEntity t) {
        // TODO Auto-generated method stub

    }

    @Override
    public ActionEntity findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Transactional
    @Override
    public ActionEntity findByCaseId(String caseId) {
        return actionRepository.findByCaseId(caseId);
    }

    @Transactional
    public ActionEntity findByCaseIdAndAlertStatusAndVisitCode(String caseId,
            String alertStatus, String visitCode, Date startDate) {
        return actionRepository.findByCaseIdAndAlertStatusAndVisitCode(caseId,
                alertStatus, visitCode, startDate);
    }
}
