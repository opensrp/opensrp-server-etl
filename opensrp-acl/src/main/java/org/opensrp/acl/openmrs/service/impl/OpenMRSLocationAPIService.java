package org.opensrp.acl.openmrs.service.impl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.acl.entity.Location;
import org.opensrp.acl.openmrs.service.OpenMRSConnector;
import org.opensrp.connector.openmrs.service.impl.OpenMRSAPIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenMRSLocationAPIService implements OpenMRSConnector<Location> {
	
	final String LOCATION_URL = "ws/rest/v1/location";
	
	public final static String nameKey = "name";
	
	public final static String tagsKey = "tags";
	
	public final static String parentLocationKey = "parentLocation";
	
	private static String PAYLOAD = "";
	
	@Autowired
	private OpenMRSAPIServiceImpl openMRSAPIServiceImpl;
	
	@Override
	public String add(Location location) throws JSONException {
		String locationUuid = "";
		JSONObject createdLocation = openMRSAPIServiceImpl.add(
		    PAYLOAD,
		    makeLocationObject(location.getName(), location.getLocationTag().getName(), location.getParentLocation()
		            .getUuid()), LOCATION_URL);
		System.err.println(createdLocation);
		if (createdLocation.has("uuid")) {
			locationUuid = (String) createdLocation.get("uuid");
		} else {
			
		}
		return locationUuid;
	}
	
	@Override
	public String update(Location location, String uuid) throws JSONException {
		String locationUuid = "";
		JSONObject updatedLocation = openMRSAPIServiceImpl.update(
		    PAYLOAD,
		    makeLocationObject(location.getName(), location.getLocationTag().getName(), location.getParentLocation()
		            .getUuid()), uuid, LOCATION_URL);
		if (updatedLocation.has("uuid")) {
			locationUuid = (String) updatedLocation.get("uuid");
		}
		return locationUuid;
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
	
	public JSONObject makeLocationObject(String name, String tags, String parentLocation) throws JSONException {
		JSONObject location = new JSONObject();
		JSONArray tagsArray = new JSONArray();
		
		JSONObject tagsObject = new JSONObject();
		tagsObject.put("tag", tags);
		tagsArray.put(tagsObject);
		location.put(tagsKey, tagsArray);
		
		location.put(nameKey, name);
		location.put(parentLocationKey, parentLocation);
		
		return location;
	}
	
}
