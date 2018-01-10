package org.mcare.location.service;

import java.util.List;

public interface LocationService {
	
	public List<Object[]> getParentData();
	
	public List<Object[]> getChildData(int parentId);
	
}
