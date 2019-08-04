package org.mcare.location.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mcare.acl.util.AuthenticationManagerUtil;
import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.location.service.LocationService;
import org.mcare.params.builder.SearchBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;

	@Autowired
	private SessionFactory sessionFactory;

	public LocationServiceImpl() {

	}

	@Transactional
	@Override
	public List<Object[]> getLocationByTagId(int tagId) {
		// TODO Auto-generated method stub
		String sqlQuery = "SELECT location.name,location.location_id FROM location left join location_tag_map  on location.location_id =location_tag_map.location_id "
				+ "WHERE location_tag_id=:location_tag_id";
		return databaseRepositoryImpl.executeSelectQuery(sqlQuery, "location_tag_id", tagId);
	}

	@Transactional
	@Override
	public List<Object[]> getChildData(int parentId) {
		String sqlQuery = "SELECT location.name,location.location_id from location where parent_location=:parentId";
		return databaseRepositoryImpl.executeSelectQuery(sqlQuery, "parentId", parentId);
	}

	@Override
	public List<Object[]> getProviderByLocation(String key, String value) {
		String condition = "";
		if (!key.isEmpty() && !key.equals("")) condition = " where "+key+" = '"+value+"'";
		if (AuthenticationManagerUtil.isFPI()) {
			if (!condition.equals("")) condition += " and fpi_username = '"+AuthenticationManagerUtil.getFPIUsername()+"'";
			else condition += " where fpi_username = '"+AuthenticationManagerUtil.getFPIUsername()+"'";
		}
		Session session = sessionFactory.openSession();
		List<Object[]> providerList = null;
		try {
			SQLQuery query = session.createSQLQuery("select * from provider_location"+condition+";");
			providerList = query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return providerList;
	}

	@SuppressWarnings("unchecked")
	public <T> boolean isExist(String className) {
		Session session = sessionFactory.openSession();
		List<T> result = null;
		try {
			SQLQuery query = session.createSQLQuery("SELECT * from " + className);
			if(query!= null && !query.list().isEmpty()) {
				result = query.list();
			}
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if(result != null && !result.isEmpty() &&result.size() > 0) {
			return true;
		}
		return false;
	}

	public String getName(int length, List<Object[]> providerList) {
		String filterString = "and provider in('";
		for(int i = 0; i < length; i++) {
			if (i != 0) filterString += "'";
			filterString += providerList.get(i)[1] +"'";
			if (i != length-1) filterString += ", ";
		}
		filterString += ")";
		return filterString;
	}

	public String getFilterString(SearchBuilder searchBuilder) {
		String filterString = "";

		if (searchBuilder.getProvider() != null && !searchBuilder.getProvider().isEmpty()) {
			filterString = "and provider in('"+searchBuilder.getProvider()+"')";
		} else if (searchBuilder.getUnion() != null && !searchBuilder.getUnion().isEmpty()) {
			List<Object[]> providerList = getProviderByLocation("union1", searchBuilder.getUnion());
			int length = providerList.size();
			if (length > 0) filterString = getName(length, providerList);
			else filterString = "and provider in('')";
		} else if (searchBuilder.getUpazila() != null && !searchBuilder.getUpazila().isEmpty()) {
			List<Object[]> providerList = getProviderByLocation("upazila", searchBuilder.getUpazila());
			int length = providerList.size();
			if (length > 0) filterString = getName(length, providerList);
			else filterString = "and provider in('')";
		} else if (searchBuilder.getDistrict() != null && !searchBuilder.getDistrict().isEmpty()) {
			List<Object[]> providerList = getProviderByLocation("district", searchBuilder.getDistrict());
			int length = providerList.size();
			if (length > 0) filterString = getName(length, providerList);
			else filterString = "and provider in('')";
		} else if (searchBuilder.getDivision() != null && !searchBuilder.getDivision().isEmpty()) {
			List<Object[]> providerList = getProviderByLocation("division", searchBuilder.getDivision());
			int length = providerList.size();
			if (length > 0) filterString = getName(length, providerList);
			else filterString = "and provider in('')";
		}

		if (filterString.equals("") && AuthenticationManagerUtil.isFPI()) {
			filterString += "and provider in(select provider from provider_location where fpi_username = '" +
					AuthenticationManagerUtil.getFPIUsername()+"')";
		}

		return filterString;
	}
}
