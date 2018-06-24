package org.opensrp.acl.service;

import java.util.List;

public interface LocationService {
	
	public List<Object[]> getLocationByTagId(int tagId);
	
	public List<Object[]> getChildData(int parentId);
	
}
