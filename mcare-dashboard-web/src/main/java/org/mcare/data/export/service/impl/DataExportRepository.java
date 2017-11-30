package org.mcare.data.export.service.impl;

import java.util.ArrayList;
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
	
	public List<Object[]> executeSelectQuery(String sqlQuery) {
		sqlQuery = "select * from anc";
		
		List<Object[]> cleanedResults = new ArrayList<Object[]>();
		
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sqlQuery);
		//query.setParameter(0, 1);
		List<Object[]> hibernateResults = query.list();
		System.err.println("hibernateResults:" + hibernateResults.size());
		for (Object[] objects : hibernateResults) {
			for (int i = 0; i < objects.length; i++) {
				System.err.println("" + objects[i]);
			}
			//cleanedResults.add(objects);
		}
		
		return hibernateResults;
	}
}
