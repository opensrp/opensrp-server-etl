package org.opensrp.connector.openmrs.service.impl;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.common.util.HttpResponse;
import org.opensrp.common.util.HttpUtil;
import org.opensrp.connector.openmrs.service.APIService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OpenMRSAPIServiceImpl extends OpenmrsCredentialsService implements APIService {
	
	private static final String PURGE_PART = "?purge=true";
	
	private static Logger logger = LoggerFactory.getLogger(OpenMRSAPIServiceImpl.class.toString());
	
	public OpenMRSAPIServiceImpl() {
	}
	
	public OpenMRSAPIServiceImpl(String openmrsUrl, String user, String password) {
		super(openmrsUrl, user, password);
	}
	
	@Override
	public JSONObject add(JSONObject jsonObject, String URL) throws JSONException {
		return new JSONObject(HttpUtil.post(getURL() + "/" + URL, "", jsonObject.toString(), OPENMRS_USER, OPENMRS_PWD)
		        .body());
	}
	
	@Override
	public JSONObject update(JSONObject roleObjectForUpdate, String uuid, String URL) throws JSONException {
		return new JSONObject(HttpUtil.post(getURL() + "/" + URL + "/" + uuid, "", roleObjectForUpdate.toString(),
		    OPENMRS_USER, OPENMRS_PWD).body());
	}
	
	@Override
	public JSONObject delete(String uuid, String URL) throws JSONException {
		return new JSONObject(HttpUtil.delete(getURL() + "/" + URL + "/" + uuid + PURGE_PART, "", OPENMRS_USER, OPENMRS_PWD));
	}
	
	@Override
	public JSONObject get(String uuid, String URL) throws JSONException {
		HttpResponse op = HttpUtil.get(HttpUtil.removeEndingSlash(OPENMRS_BASE_URL) + "/" + URL + "/" + uuid, "v=full",
		    OPENMRS_USER, OPENMRS_PWD);
		return new JSONObject(op.body());
	}
	
}
