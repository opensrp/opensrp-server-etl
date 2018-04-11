package org.mcare.reports.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mcare.reports.service.SearchFilterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public ReportRepository() {
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findFormWiseReport(SearchFilterBuilder searchFilterBuilder) {
		Session session = sessionFactory.openSession();
		List<T> formWiseAggregatedList = null;
		try {
			String hql = "select * from generate_form_wise_report(array[:division,:district,:upazila"
					+ ",:union,:ward,:subunit,:mauzapara,:provider,:start_date,:end_date])";
			Query query = session.createSQLQuery(hql);

			if (searchFilterBuilder.getDivision() != null && !searchFilterBuilder.getDivision().isEmpty()) {
				query.setParameter("division", searchFilterBuilder.getDivision());
			} else {
				query.setParameter("division", "");
			}
			if (searchFilterBuilder.getDistrict() != null && !searchFilterBuilder.getDistrict().isEmpty()) {
				query.setParameter("district", searchFilterBuilder.getDistrict());
			} else {
				query.setParameter("district", "");
			}

			if (searchFilterBuilder.getUpazila() != null && !searchFilterBuilder.getUpazila().isEmpty()) {
				query.setParameter("upazila", searchFilterBuilder.getUpazila());
			} else {
				query.setParameter("upazila", "");
			}

			if (searchFilterBuilder.getUnion() != null && !searchFilterBuilder.getUnion().isEmpty()) {
				query.setParameter("union", searchFilterBuilder.getUnion());
			} else {
				query.setParameter("union", "");
			}

			if (searchFilterBuilder.getWard() != null && !searchFilterBuilder.getWard().isEmpty()) {
				query.setParameter("ward", searchFilterBuilder.getWard());
			} else {
				query.setParameter("ward", "");
			}

			if (searchFilterBuilder.getSubunit() != null && !searchFilterBuilder.getSubunit().isEmpty()) {
				query.setParameter("subunit", searchFilterBuilder.getSubunit());
			} else {
				query.setParameter("subunit", "");
			}

			if (searchFilterBuilder.getMauzapara() != null && !searchFilterBuilder.getMauzapara().isEmpty()) {
				query.setParameter("mauzapara", searchFilterBuilder.getMauzapara());
			} else {
				query.setParameter("mauzapara", "");
			}

			if (searchFilterBuilder.getProvider() != null && !searchFilterBuilder.getProvider().isEmpty()) {
				query.setParameter("provider", searchFilterBuilder.getProvider());
			} else {
				query.setParameter("provider", "");
			}

			if (searchFilterBuilder.getStart() != null && !searchFilterBuilder.getStart().isEmpty() 
					&& searchFilterBuilder.getEnd() != null && !searchFilterBuilder.getEnd().isEmpty()) {
				query.setParameter("start_date", searchFilterBuilder.getStart());
				query.setParameter("end_date", searchFilterBuilder.getEnd());
			} else {
				query.setParameter("start_date", "");
				query.setParameter("end_date", "");
			}

			formWiseAggregatedList = query.list();
			System.err.println("findFormWiseReport fetched successfull formWiseAggregatedList size: " + formWiseAggregatedList.size());
			session.close();
		}
		catch (Exception e) {
			System.err.println("findFormWiseReport error:" + e.getMessage());
		}
		return formWiseAggregatedList;
	}
}
