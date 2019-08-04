package org.mcare.location.service;

import java.util.List;

public interface LocationService {
	
	public List<Object[]> getLocationByTagId(int tagId);
	
	public List<Object[]> getChildData(int parentId);

	public List<Object[]> getProviderByLocation(String key, String value);
	
}
