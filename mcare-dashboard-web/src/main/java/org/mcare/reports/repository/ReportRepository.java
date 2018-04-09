package org.mcare.reports.repository;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mcare.reports.service.ReportSearchBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public ReportRepository() {
	}

	public <T> List<T> findAllFormData(String formType, ReportSearchBuilder reportSearchBuilder, String tableClass, String fieldName, String joinTable) {
		Session session = sessionFactory.openSession();
		List<T> result = null;
		try {
			String sql = createSQLStringForFormData(formType, reportSearchBuilder, tableClass, fieldName, joinTable);

			//String sql2 = createSQLStringForFormData("ancrv_1", reportSearchBuilder, "anc", "ancname", "mother");
			//System.err.println("create_report result: " + getCountReport(reportSearchBuilder));
			SQLQuery query = session.createSQLQuery(sql);
			result = query.list();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public <T> List<T> getCountReport(ReportSearchBuilder reportSearchBuilder) {
		Session session = sessionFactory.openSession();
		List<T> result = null;
		try {
			String hql = "select * from my_function(array[:division,:district,:upazila" 
					+ ",:union,:ward,:subunit,:mauzapara,:provider,:start_date,:end_date])";
			Query query = session.createSQLQuery(hql);

			if (reportSearchBuilder.getDivision() != null && !reportSearchBuilder.getDivision().isEmpty()) {
				query.setParameter("division", reportSearchBuilder.getDivision());
			} else {
				query.setParameter("division", "");
			}
			if (reportSearchBuilder.getDistrict() != null && !reportSearchBuilder.getDistrict().isEmpty()) {
				query.setParameter("district", reportSearchBuilder.getDistrict());
			} else {
				query.setParameter("district", "");
			}

			if (reportSearchBuilder.getUpazila() != null && !reportSearchBuilder.getUpazila().isEmpty()) {
				query.setParameter("upazila", reportSearchBuilder.getUpazila());
			} else {
				query.setParameter("upazila", "");
			}

			if (reportSearchBuilder.getUnion() != null && !reportSearchBuilder.getUnion().isEmpty()) {
				query.setParameter("union", reportSearchBuilder.getUnion());
			} else {
				query.setParameter("union", "");
			}

			if (reportSearchBuilder.getWard() != null && !reportSearchBuilder.getWard().isEmpty()) {
				query.setParameter("ward", reportSearchBuilder.getWard());
			} else {
				query.setParameter("ward", "");
			}

			if (reportSearchBuilder.getSubunit() != null && !reportSearchBuilder.getSubunit().isEmpty()) {
				query.setParameter("subunit", reportSearchBuilder.getSubunit());
			} else {
				query.setParameter("subunit", "");
			}

			if (reportSearchBuilder.getMauzapara() != null && !reportSearchBuilder.getMauzapara().isEmpty()) {
				query.setParameter("mauzapara", reportSearchBuilder.getMauzapara());
			} else {
				query.setParameter("mauzapara", "");
			}

			if (reportSearchBuilder.getProvider() != null && !reportSearchBuilder.getProvider().isEmpty()) {
				query.setParameter("provider", reportSearchBuilder.getProvider());
			} else {
				query.setParameter("provider", "");
			}

			if (reportSearchBuilder.getStart() != null && !reportSearchBuilder.getStart().isEmpty() 
					&& reportSearchBuilder.getEnd() != null && !reportSearchBuilder.getEnd().isEmpty()) {
				query.setParameter("start_date", reportSearchBuilder.getStart());
				query.setParameter("end_date", reportSearchBuilder.getEnd());
			} else {
				query.setParameter("start_date", "");
				query.setParameter("end_date", "");
			}

			result = query.list();
			System.err.println("result data fetched");
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public <T> List<T> findAllFDData(String formType, ReportSearchBuilder reportSearchBuilder, String tableClass) {
		Session session = sessionFactory.openSession();
		List<T> result = null;
		try {
			String sql = createSQLStringForFDData(formType, reportSearchBuilder, tableClass);
			SQLQuery query = session.createSQLQuery(sql);
			result = query.list();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private String createSQLStringForFormData(String formType, ReportSearchBuilder reportSearchBuilder,
			String tableClass, String fieldName, String joinTable) {
		String condition1 = "where a.visit_code = '" + formType + "' and a.is_action_active=true ";
		String condition2 = "WHERE a."+ fieldName + " = '" + formType + "' ";
		String condition3 = "WHERE a.visit_code = '" + formType + "' and a.alert_status='urgent' "
				+ "and a.is_action_active=true and a.expiry_date < current_date ";

		condition1 = getLocationConditionString(reportSearchBuilder, condition1);
		condition1 = getDateRangeConditionByStartDateString(reportSearchBuilder, condition1);

		condition2 = getLocationConditionString(reportSearchBuilder, condition2);
		condition2 = getDateRangeConditionByTodayString(reportSearchBuilder, condition2);

		condition3 = getLocationConditionString(reportSearchBuilder, condition3);
		condition3 = getDateRangeConditionByStartDateString(reportSearchBuilder, condition3);

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

		//System.out.println("createSQLStringForFormData: " + sql);
		return sql;
	}

	private String createSQLStringForFDData(String formType, ReportSearchBuilder reportSearchBuilder,
			String tableClass) {
		String condition1 = "where a.visit_code = '" + formType + "' and a.is_action_active=true ";
		String condition2 = "where a.user_type = 'FD' ";
		String condition3 = "WHERE a.visit_code = '" + formType + "' and a.alert_status='urgent' "
				+ "and a.is_action_active=true and a.expiry_date < current_date ";

		condition1 = getLocationConditionString(reportSearchBuilder, condition1);
		condition1 = getDateRangeConditionByStartDateString(reportSearchBuilder, condition1);

		condition2 = getLocationConditionString(reportSearchBuilder, condition2);
		condition2 = getDateRangeConditionByTodayString(reportSearchBuilder, condition2);

		condition3 = getLocationConditionString(reportSearchBuilder, condition3);
		condition3 = getDateRangeConditionByStartDateString(reportSearchBuilder, condition3);

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

	private String getDateRangeConditionByStartDateString(
			ReportSearchBuilder reportSearchBuilder, String condition) {
		if (reportSearchBuilder.getStart() != null && !reportSearchBuilder.getStart().isEmpty() 
				&& reportSearchBuilder.getEnd() != null && !reportSearchBuilder.getEnd().isEmpty()) {
			condition = condition + "and a.start_date between '" + reportSearchBuilder.getStart() + "' and '" 
					+ reportSearchBuilder.getEnd() + "' ";
		}
		return condition;
	}

	private String getDateRangeConditionByTodayString(
			ReportSearchBuilder reportSearchBuilder, String condition) {
		if (reportSearchBuilder.getStart() != null && !reportSearchBuilder.getStart().isEmpty() 
				&& reportSearchBuilder.getEnd() != null && !reportSearchBuilder.getEnd().isEmpty()) {
			condition = condition + "and a.today between '" + reportSearchBuilder.getStart() + "' and '" 
					+ reportSearchBuilder.getEnd() + "' ";
		}
		return condition;
	}

	private String getLocationConditionString(ReportSearchBuilder reportSearchBuilder,
			String condition) {
		if (reportSearchBuilder.getDivision() != null && !reportSearchBuilder.getDivision().isEmpty()) {
			condition = condition + "and upper(m.division) = upper('" + reportSearchBuilder.getDivision() + "') ";
		}
		if (reportSearchBuilder.getDistrict() != null && !reportSearchBuilder.getDistrict().isEmpty()) {
			condition = condition + "and upper(m.district) = upper('" + reportSearchBuilder.getDistrict() + "') ";
		}

		if (reportSearchBuilder.getUpazila() != null && !reportSearchBuilder.getUpazila().isEmpty()) {
			condition = condition + "and upper(m.upazila) = upper('" + reportSearchBuilder.getUpazila() + "') ";
		}

		if (reportSearchBuilder.getUnion() != null && !reportSearchBuilder.getUnion().isEmpty()) {
			condition = condition + "and upper(m.unions) = upper('" + reportSearchBuilder.getUnion() + "') ";
		}

		if (reportSearchBuilder.getWard() != null && !reportSearchBuilder.getWard().isEmpty()) {
			condition = condition + "and upper(m.ward) = upper('" + reportSearchBuilder.getWard() + "') ";
		}

		if (reportSearchBuilder.getSubunit() != null && !reportSearchBuilder.getSubunit().isEmpty()) {
			condition = condition + "and upper(m.subunit) = upper('" + reportSearchBuilder.getSubunit() + "') ";
		}

		if (reportSearchBuilder.getMauzapara() != null && !reportSearchBuilder.getMauzapara().isEmpty()) {
			condition = condition + "and upper(m.mauza_para) = upper('" + reportSearchBuilder.getMauzapara() + "') ";
		}
		return condition;
	}


	public int getReportData(ReportSearchBuilder reportSearchBuilder) {
		Session session = sessionFactory.openSession();
		int Id = -1;
		try {
			String hql = "SELECT * FROM my_function(:division,:district"
					+ ",:upazila,:unions,:ward,:unit,:mauzapara,:provider,:startDate,:endDate) k";

			if (reportSearchBuilder.getDivision() != null && reportSearchBuilder.getDistrict() != null && reportSearchBuilder.getUpazila() != null
					&& reportSearchBuilder.getUnion() != null && reportSearchBuilder.getWard() != null && reportSearchBuilder.getSubunit() != null
					&& reportSearchBuilder.getStart() != null && reportSearchBuilder.getEnd() != null && reportSearchBuilder.getProvider() != null
					&& reportSearchBuilder.getMauzapara() != null
					&& !reportSearchBuilder.getDivision().isEmpty() && !reportSearchBuilder.getDistrict().isEmpty() && !reportSearchBuilder.getUpazila().isEmpty()
					&& !reportSearchBuilder.getUnion().isEmpty() && !reportSearchBuilder.getWard().isEmpty() && !reportSearchBuilder.getSubunit().isEmpty()
					&& !reportSearchBuilder.getStart().isEmpty() && !reportSearchBuilder.getEnd().isEmpty() && !reportSearchBuilder.getProvider().isEmpty()
					&& !reportSearchBuilder.getMauzapara().isEmpty()) {
				System.out.println("searchBuilder: " + reportSearchBuilder.toString());
				Query query = session.createSQLQuery(hql).setParameter("division", reportSearchBuilder.getDivision())
						.setParameter("district", reportSearchBuilder.getDistrict()).setParameter("upazila", reportSearchBuilder.getUpazila())
						.setParameter("unions", reportSearchBuilder.getUnion()).setParameter("ward", reportSearchBuilder.getWard())
						.setParameter("unit", reportSearchBuilder.getSubunit()).setParameter("mauzapara", reportSearchBuilder.getMauzapara())
						.setParameter("provider", reportSearchBuilder.getProvider())
						.setParameter("startDate", reportSearchBuilder.getStart()).setParameter("endDate", reportSearchBuilder.getEnd());
				List results = query.list();
				System.err.println("result: " + results.size());
				Iterator itr = results.iterator();
				while (itr.hasNext()) {
					Object[] obj = (Object[]) itr.next();
					//Integer scheduled = Integer.parseInt(String.valueOf(obj[1]));
					for (int i = 0; i < obj.length; i++) {
						System.err.println("obj: " + obj[i]);
					}

				}

				//Id = (Integer) results.get(0);
				Id = 0;

			} else {

			}
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return Id;
	}
}
