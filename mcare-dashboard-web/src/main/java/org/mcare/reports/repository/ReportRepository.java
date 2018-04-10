package org.mcare.reports.repository;

import java.util.List;

import org.hibernate.Query;
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

	public <T> List<T> findFormWiseReport(ReportSearchBuilder reportSearchBuilder) {
		Session session = sessionFactory.openSession();
		List<T> result = null;
		try {
			String hql = "select * from generate_form_wise_report(array[:division,:district,:upazila"
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
}
