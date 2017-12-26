/**
 * 
 */
package org.unicef.etl.data.converter;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Iterator;

import javax.persistence.Temporal;

import org.json.JSONException;
import org.json.JSONObject;
import org.unicef.etl.util.DateUtil;
import org.unicef.etl.util.NumbertUtil;

/**
 * @author proshanto, sohel
 */

public class DataConverter {
	
	public DataConverter() {
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	public <Any> Any convert(JSONObject JsonDocument, Class<?> className, Object object) {
		String property = null;
		System.out.println("json documents: " + JsonDocument.toString());
		try {
			BeanInfo beaninfo = Introspector.getBeanInfo(className);
			PropertyDescriptor pds[] = beaninfo.getPropertyDescriptors();
			Method setterMethod = null;
			for (PropertyDescriptor pd : pds) {
				try {
					setterMethod = pd.getWriteMethod();
					String dataTypeClass = pd.getPropertyType().getName();
					property = pd.getName();
					System.out.println(
						    "setterMethod: " + setterMethod + " ,dataTypeClass: " + dataTypeClass + " ,property:" + property);
					if (setterMethod == null) {
						System.err.println("setter method  does not exist for property: " + property);
						continue;
					} else if (!JsonDocument.has(property)) {
						System.err.println("key does not exist in  json for property: " + property);
						continue;
						
					} else if ("obs".equals(property)) {
						System.err.println("custom json type will not set from converter property: " + property);
						continue;
						
					}					
					
					if ("java.util.Date".equalsIgnoreCase(dataTypeClass)) {
						Method readMethod = pd.getReadMethod();
						Class<Temporal> c = (Class<Temporal>) Class.forName("javax.persistence.Temporal");
						if (readMethod.isAnnotationPresent(c)) {
							setterMethod.invoke(object, DateUtil.getDateFromString(JsonDocument, property));
						} else {
							setterMethod.invoke(object, DateUtil.getDateTFromString(JsonDocument, property));
						}
						
					} else if ("java.lang.Integer".equalsIgnoreCase(dataTypeClass)
					        || "int".equalsIgnoreCase(dataTypeClass)) {
						setterMethod.invoke(object, NumbertUtil.convertToInteger(JsonDocument.getString(property)));
					} else if ("java.lang.Long".equalsIgnoreCase(dataTypeClass) || "long".equalsIgnoreCase(dataTypeClass)) {
						setterMethod.invoke(object, NumbertUtil.convertToLong(JsonDocument.getString(property)));
					} else if ("java.lang.Double".equalsIgnoreCase(dataTypeClass)) {
						setterMethod.invoke(object, NumbertUtil.convertToDouble(JsonDocument.getString(property)));
					} else {
						if (JsonDocument.has(property)) {
							setterMethod.invoke(object, JsonDocument.getString(property));
						}
					}
				}
				catch (Exception e) {
					System.err.println("property:" + property);
					e.printStackTrace();
				}
			}
		}
		catch (Exception e) {}
		return (Any) object;
	}
	
	public Object getIgnoreCase(JSONObject jobj, String key) {
		
		Iterator<String> iter = jobj.keys();
		while (iter.hasNext()) {
			String key1 = iter.next();
			if (key1.equalsIgnoreCase(key)) {
				try {
					return jobj.get(key1);
				}
				catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
		
	}
}
