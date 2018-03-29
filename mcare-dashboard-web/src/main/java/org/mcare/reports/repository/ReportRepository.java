package org.mcare.reports.repository;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mcare.params.builder.SearchBuilder;
import org.mcare.reports.service.ReportSearchBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public ReportRepository() {
	}

	public <T> List<T> findAllFormData(String formType, ReportSearchBuilder searchBuilder, String tableClass, String fieldName, String joinTable) {
		Session session = sessionFactory.openSession();
		List<T> result = null;
		try {
			String sql = createSQLStringFormData(searchBuilder, tableClass, fieldName,
					joinTable);

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
			String sql = createSQLStringFDData(searchBuilder, tableClass);

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

	private String createSQLStringFormData(ReportSearchBuilder searchBuilder,
			String tableClass, String fieldName, String joinTable) {
		String condition1 = "where a.visit_code = :formType and a.is_action_active=true ";
		String condition2 = "WHERE a."+ fieldName + " = :formType ";
		String condition3 = "WHERE a.visit_code = :formType and a.alert_status='urgent' "
				+ "and a.is_action_active=true and a.expiry_date < current_date ";

		if (searchBuilder.getDivision() != null && !searchBuilder.getDivision().isEmpty()) {
			String wardCondition = "and upper(m.division) = upper('" + searchBuilder.getDivision() + "') ";
			condition1 = condition1 + wardCondition;
			condition2 = condition2 + wardCondition;
			condition3 = condition3 + wardCondition;
		}

		if (searchBuilder.getDistrict() != null && !searchBuilder.getDistrict().isEmpty()) {
			String wardCondition = "and upper(m.district) = upper('" + searchBuilder.getDistrict() + "') ";
			condition1 = condition1 + wardCondition;
			condition2 = condition2 + wardCondition;
			condition3 = condition3 + wardCondition;
		}

		if (searchBuilder.getUpazila() != null && !searchBuilder.getUpazila().isEmpty()) {
			String wardCondition = "and upper(m.upazila) = upper('" + searchBuilder.getUpazila() + "') ";
			condition1 = condition1 + wardCondition;
			condition2 = condition2 + wardCondition;
			condition3 = condition3 + wardCondition;
		}

		if (searchBuilder.getWard() != null && !searchBuilder.getWard().isEmpty()) {
			String wardCondition = "and upper(m.ward) = upper('" + searchBuilder.getWard() + "') ";
			condition1 = condition1 + wardCondition;
			condition2 = condition2 + wardCondition;
			condition3 = condition3 + wardCondition;
		}

		if (searchBuilder.getStart() != null && !searchBuilder.getStart().isEmpty() 
				&& searchBuilder.getEnd() != null && !searchBuilder.getEnd().isEmpty()) {
			String dateRangeCondition = "and a.start_date between '" + searchBuilder.getStart() + "' and '" 
					+ searchBuilder.getEnd() + "' ";
			condition1 = condition1 + dateRangeCondition;
			//condition2 = condition2 + dateRangeCondition;
			condition3 = condition3 + dateRangeCondition;
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
		return sql;
	}

	private String createSQLStringFDData(SearchBuilder searchBuilder,
			String tableClass) {
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
		return sql;
	}

}
