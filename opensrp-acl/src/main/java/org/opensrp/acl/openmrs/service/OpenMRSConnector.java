package org.opensrp.acl.openmrs.service;

import org.json.JSONException;
import org.json.JSONObject;

public interface OpenMRSConnector {
	
	public String add(JSONObject jsonObject) throws JSONException;
	
	public String update(JSONObject jsonObject, String uuid) throws JSONException;
	
	public String get(String uuid) throws JSONException;
	
	public String delete(String uuid) throws JSONException;
}
