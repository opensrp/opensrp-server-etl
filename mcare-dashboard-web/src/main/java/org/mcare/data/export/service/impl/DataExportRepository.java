package org.mcare.data.export.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataExportRepository {

	private static final Logger logger = Logger.getLogger(DataExportRepository.class);

	@Autowired
	private SessionFactory sessionFactory;

	public DataExportRepository() {

	}

	@SuppressWarnings("unchecked")
	public List<Object[]> executeSelectQuery(String provider, String formName, String sqlQuery) {
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sqlQuery);
		if (!provider.isEmpty()) {
			query.setParameter("provider", provider);
		}
		query.setParameter("formName", formName);
		logger.debug("formName: " + formName);
		List<Object[]> results = query.list();
		return results;
	}
}
