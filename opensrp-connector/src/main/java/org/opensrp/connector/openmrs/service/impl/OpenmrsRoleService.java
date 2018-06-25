package org.opensrp.connector.openmrs.service.impl;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.common.util.HttpResponse;
import org.opensrp.common.util.HttpUtil;
import org.opensrp.connector.openmrs.service.OpenMRSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OpenmrsRoleService extends OpenmrsCredentialsService implements OpenMRSService{

	private static final String AUTHENTICATION_URL = "ws/rest/v1/session";
	private static final String USER_URL = "ws/rest/v1/user";
	private static final String PROVIDER_URL = "ws/rest/v1/provider";
	private static final String TEAM_MEMBER_URL = "ws/rest/v1/teammodule/member";
	private static Logger logger = LoggerFactory.getLogger(OpenmrsRoleService.class.toString());

    public OpenmrsRoleService() { }

    public OpenmrsRoleService(String openmrsUrl, String user, String password) {
    	super(openmrsUrl, user, password);
    }

	
	
	public JSONObject getRoleMember(String uuid) throws JSONException{
		HttpResponse op = HttpUtil.get(HttpUtil.removeEndingSlash(OPENMRS_BASE_URL)+"/"+TEAM_MEMBER_URL+"/"+uuid, "v=full", OPENMRS_USER, OPENMRS_PWD);
		return new JSONObject(op.body());
	}
	
	public void get(){
		System.err.println("OPENMRS_USER:"+OPENMRS_USER);
	}
}
