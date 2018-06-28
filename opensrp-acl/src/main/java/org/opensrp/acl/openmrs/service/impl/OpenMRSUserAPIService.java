package org.opensrp.acl.openmrs.service.impl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.acl.entity.User;
import org.opensrp.acl.openmrs.service.OpenMRSConnector;
import org.opensrp.common.util.DefaultRole;
import org.opensrp.connector.openmrs.service.impl.OpenMRSAPIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenMRSUserAPIService implements OpenMRSConnector {
	
	final String PERSON_URL = "ws/rest/v1/person";
	
	final String USER_URL = "ws/rest/v1/user";
	
	final static String ageKey = "age";
	
	final static String genderKey = "gender";
	
	final static String birthdateKey = "birthdate";
	
	final static String namesKey = "names";
	
	private static String PAYLOAD = "";
	
	public String female = "F";
	
	final static String usernameKey = "username";
	
	final static String passwordKey = "password";
	
	public final static String personKey = "person";
	
	String rolesKey = "roles";
	
	JSONObject person = new JSONObject();
	
	@Autowired
	private OpenMRSAPIServiceImpl openMRSAPIServiceImpl;
	
	public JSONObject generatePersonObject(User user) throws JSONException {
		JSONArray personArray = new JSONArray();
		JSONObject personObject = new JSONObject();
		personObject.put("givenName", user.getUsername());
		personObject.put("middleName", "");
		personObject.put("familyName", user.getUsername());
		personArray.put(personObject);
		
		person.put(genderKey, female);
		person.put(birthdateKey, "2017-01-01");
		person.put(ageKey, "32");
		person.put(namesKey, personArray);
		return person;
	}
	
	public JSONObject generateUserJsonObject(User user) throws JSONException {
		JSONArray roleArray = new JSONArray();
		JSONObject roleObject = new JSONObject();
		roleObject.put("role", DefaultRole.Provider);
		roleArray.put(roleObject);
		
		JSONObject userJsonObject = new JSONObject();
		userJsonObject.put(usernameKey, user.getUsername());
		userJsonObject.put(passwordKey, user.getPassword());
		userJsonObject.put(rolesKey, roleArray);
		
		userJsonObject.put(personKey, generatePersonObject(user));
		return userJsonObject;
		
	}
	
	@Override
	public String add(JSONObject jsonObject) throws JSONException {
		String userUuid = "";
		JSONObject createdPerson = openMRSAPIServiceImpl.add(PAYLOAD, jsonObject, PERSON_URL);
		String personUuid = (String) createdPerson.get("uuid");
		if (personUuid != null) {
			JSONObject createdROle = openMRSAPIServiceImpl.add(PAYLOAD, jsonObject, USER_URL);
			userUuid = (String) createdROle.get("uuid");
		} else {
			
		}
		return userUuid;
	}
	
	@Override
	public String update(JSONObject jsonObject, String uuid) throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String get(String uuid) throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String delete(String uuid) throws JSONException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
