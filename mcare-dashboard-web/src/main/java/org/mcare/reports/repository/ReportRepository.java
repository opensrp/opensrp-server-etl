package org.mcare.reports.repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mcare.location.serviceimpl.LocationServiceImpl;
import org.mcare.reports.service.SearchFilterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportRepository {

	private static final Logger logger = Logger.getLogger(ReportRepository.class);

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private LocationServiceImpl locationService;

	public ReportRepository() {
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findReportDataListByProvider(SearchFilterBuilder searchFilterBuilder) {

		String startDate = "2017-01-01";
		String endDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

		if (searchFilterBuilder.getEnd() != null && !searchFilterBuilder.getEnd().isEmpty()
				&& searchFilterBuilder.getStart() != null && !searchFilterBuilder.getStart().isEmpty()) {
			startDate = searchFilterBuilder.getStart();
			endDate = searchFilterBuilder.getEnd();
		}

		String filterString = "";
		filterString = locationService.getFilterString(searchFilterBuilder);

		if (filterString.equals("")) {
			List<Object[]> providerList = locationService.getProviderByLocation("", "");
			int length = providerList.size();
			if (length > 0) filterString += locationService.getName(length, providerList);
			else filterString += "and provider in('')";
		}

		String filterString1 = "";
		if (searchFilterBuilder.getFormName() != null && !searchFilterBuilder.getFormName().isEmpty()){
			filterString1 += "and visit_type in('"+searchFilterBuilder.getFormName()+"')";
		} else {
			filterString1 += "and visit_type in('ancrv_1', 'ancrv_2', 'ancrv_3', 'ancrv_4', 'pncrv_1', 'pncrv_2', 'pncrv_3', 'enccrv_1', 'enccrv_2', 'enccrv_3')";
		}

		Session session = sessionFactory.openSession();
		List<T> aggregatedList = null;

		try {
			String hql = "select provider_name provider, due,submitted,expired, \n" +
					"case\n" +
					"when (due+submitted+expired) > 0 then round(expired*100.00/(due+submitted+expired),2) \n" +
					"else 0.00 \n" +
					"end perc_expired\n" +
					"from\n" +
					"(\n" +
					"select *, (select sum(due) due from schedule_summary where day = latest_day and provider=provider_name "+filterString1+") \n" +
					"from\n" +
					"(select provider provider_name, sum(submitted) submitted, sum(expired) expired,max(day) as latest_day\n" +
					"from schedule_summary\n" +
					"where day >= '"+startDate+"' and day <= '"+endDate+"' "+filterString1+" "+filterString+"\n" +
					"group by provider order by provider) as a\n" +
					") b;";
			Query query = session.createSQLQuery(hql);
//			setParameter(searchFilterBuilder, query);
			aggregatedList = query.list();

		}
		catch (Exception e) {
			logger.error(e);
		} finally {
			session.close();
		}
		return aggregatedList;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findReportDataList(SearchFilterBuilder searchFilterBuilder, String procedureName) {

		String filterString = locationService.getFilterString(searchFilterBuilder);
		filterString.replaceAll("and", "where");

		Session session = sessionFactory.openSession();
		List<T> aggregatedList = null;
		String startDate = "2017-01-01";
		String endDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

		if (searchFilterBuilder.getStart() != null && !searchFilterBuilder.getStart().isEmpty()
			&& searchFilterBuilder.getEnd() != null && !searchFilterBuilder.getEnd().isEmpty()) {
			startDate = searchFilterBuilder.getStart();
			endDate = searchFilterBuilder.getEnd();
		}

		try {
//			String hql = "select * from " + procedureName + "(array[:division,:district,:upazila"
//					+ ",:union,:ward,:subunit,:mauzapara,:provider,:start_date,:end_date])";
			String hql = "select visit_code form, due,submitted,expired, \n" +
					"case\n" +
					"when (due+submitted+expired) > 0 then round(expired*100.00/(due+submitted+expired),2) \n" +
					"else 0.00 \n" +
					"end perc_expired\n" +
					"from\n" +
					"(\n" +
					"select *, (select sum(due) due from schedule_summary where day = latest_day and visit_type=visit_code "+filterString+") \n" +
					"from\n" +
					"(select visit_type visit_code, sum(submitted) submitted, sum(expired) expired,max(day) as latest_day\n" +
					"from schedule_summary\n" +
					"where day >= '"+startDate+"' and day <= '"+endDate+"' "+filterString+"\n" +
					"group by visit_type order by visit_type) as a\n" +
					") b;";
			Query query = session.createSQLQuery(hql);
//			setParameter(searchFilterBuilder, query);
			aggregatedList = query.list();

			logger.info("Report Data fetched successfully from " + procedureName 
					+", aggregatedList size: " + aggregatedList.size());
		}
		catch (Exception e) {
			logger.error("Data fetch from " + procedureName + " error:" + e.getMessage());
		} finally {
			session.close();
		}
		return aggregatedList;
	}

	private void setParameter(SearchFilterBuilder searchFilterBuilder,
			Query query) {
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
	}
}
