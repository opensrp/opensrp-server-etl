package org.mcare.data.export.service.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataExportRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public DataExportRepository() {
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> executeSelectQuery(String provider, String formName, String sqlQuery) {
		System.err.println("provider;" + provider);
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sqlQuery);
		if (!provider.isEmpty()) {
			query.setParameter("provider", provider);
		}
		query.setParameter("formName", formName);
		List<Object[]> results = query.list();
		
		/*for (Object[] objects : results) {
			System.err.println("objects:" + objects.length);
			for (int i = 0; i < objects.length; i++) {
				
			}
			
		}*/
		
		return results;
	}
}
