package org.opensrp.connector.openmrs.service;

import org.json.JSONException;
import org.json.JSONObject;

public interface APIService {
	
	public JSONObject add(JSONObject jsonObject, String URL) throws JSONException;
	
	public JSONObject update(JSONObject jsonObject, String uuid, String URL) throws JSONException;
	
	public JSONObject get(String uuid, String URL) throws JSONException;
	
	public JSONObject delete(String uuid, String URL) throws JSONException;
}
