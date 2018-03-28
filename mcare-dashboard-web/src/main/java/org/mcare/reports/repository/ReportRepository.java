package org.mcare.reports.repository;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mcare.params.builder.SearchBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public ReportRepository() {
		// TODO Auto-generated constructor stub
	}

	public <T> List<T> findAllFormData(String formType,SearchBuilder searchBuilder, String tableClass, String fieldName, String joinTable) {
		Session session = sessionFactory.openSession();
		List<T> result = null;
		try {
			String condition1 = "where a.visit_code = :formType and a.is_action_active=true ";
			String condition2 = "WHERE a."+ fieldName + " = :formType ";
			String condition3 = "WHERE a.visit_code = :formType and a.alert_status='urgent' "
					+ "and a.is_action_active=true and a.expiry_date < current_date ";

			if (searchBuilder.getWard() != null && !searchBuilder.getWard().isEmpty()) {
				String wardCondition = "and upper(m.ward) = upper('" + searchBuilder.getWard() + "') ";
				condition1 = condition1 + wardCondition;
				condition2 = condition2 + wardCondition;
				condition3 = condition3 + wardCondition;
			}

			String sql = "SELECT "
					+ "(select count(*) as scheduled from action a "
					+ "join " + joinTable + " m on (m.case_id=a.case_id) "
					+ condition1
					+ "), "
					+ "(select count(*) as completed from " + tableClass + " a "
					+ "join " + joinTable + " m on (m.case_id=a.relationalid) "
					+ condition2
					+ "), "
					+ "count(*) as expired FROM action a "
					+ "join " + joinTable + " m on (m.case_id=a.case_id) "
					+ condition3;

			SQLQuery query = session.createSQLQuery(sql);
			query.setParameter("formType", formType);
			result = query.list();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public <T> List<T> findAllFDData(String formType,SearchBuilder searchBuilder, String tableClass) {
		Session session = sessionFactory.openSession();
		List<T> result = null;
		try {
			String condition1 = "where a.visit_code = :formType and a.is_action_active=true ";
			String condition2 = "where a.user_type = 'FD' ";
			String condition3 = "WHERE a.visit_code = :formType and a.alert_status='urgent' "
					+ "and a.is_action_active=true and a.expiry_date < current_date ";

			if (searchBuilder.getWard() != null && !searchBuilder.getWard().isEmpty()) {
				String wardCondition = "and upper(m.ward) = upper('" + searchBuilder.getWard() + "') ";
				condition1 = condition1 + wardCondition;
				condition2 = condition2 + wardCondition;
				condition3 = condition3 + wardCondition;
			}

			String sql = "SELECT "
					+ "(select count(*) as scheduled from action a "
					+ "join mother m on (m.case_id=a.case_id) "
					+ condition1
					+ "), "
					+ "(select count(*) as completed from " + tableClass + " a "
					+ "join mother m on (m.case_id=a.relationalid) "
					+ condition2
					+ "), "
					+ "count(*) as expired FROM action a "
					+ "join mother m on (m.case_id=a.case_id) "
					+ condition3;

			SQLQuery query = session.createSQLQuery(sql);
			query.setParameter("formType", formType);
			result = query.list();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
