package org.opensrp.etl.interfaces;

import org.json.JSONException;
import org.json.JSONObject;

public interface TransmissionService<T, V, X> {
	
	public T sentDataToConvert(JSONObject t, V v, X x) throws JSONException;
	
}
