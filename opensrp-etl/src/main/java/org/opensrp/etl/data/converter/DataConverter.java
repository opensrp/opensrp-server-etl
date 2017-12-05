/**
 * 
 */
package org.opensrp.etl.data.converter;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import javax.persistence.Temporal;

import org.json.JSONObject;
import org.opensrp.etl.util.DateUtil;
import org.opensrp.etl.util.NumbertUtil;

/**
 * @author proshanto
 */

public class DataConverter {
	
	public DataConverter() {
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	public <Any> Any convert(JSONObject JsonDocument, Class<?> className, Object object) {
		String property = null;
		try {
			BeanInfo beaninfo = Introspector.getBeanInfo(className);
			PropertyDescriptor pds[] = beaninfo.getPropertyDescriptors();
			Method setterMethod = null;
			for (PropertyDescriptor pd : pds) {
				try {
					setterMethod = pd.getWriteMethod();
					String dataTypeClass = pd.getPropertyType().getName();
					String[] properties = setterMethod.getName().split("set");
					property = properties[1];

					if (setterMethod == null) {
						continue;
					} else if ("java.util.Date".equalsIgnoreCase(dataTypeClass)) {
						Method readMethod = pd.getReadMethod();
						Class<Temporal> c = (Class<Temporal>) Class.forName("javax.persistence.Temporal");
						if (readMethod.isAnnotationPresent(c)) {
							System.err.println("P:" + property);
							setterMethod.invoke(object, DateUtil.getDateFromString(JsonDocument, property));
						} else {
							//System.err.println("PD:" + property);
							setterMethod.invoke(object, DateUtil.getDateTimeFromString(JsonDocument, property));
						}
						
					} else if ("java.lang.Integer".equalsIgnoreCase(dataTypeClass)) {
						setterMethod.invoke(object, NumbertUtil.convertToInteger(JsonDocument.getString(property)));
					} else if ("java.lang.Long".equalsIgnoreCase(dataTypeClass)) {
						setterMethod.invoke(object, NumbertUtil.convertToLong(JsonDocument.getString(property)));
					} else if ("java.lang.Double".equalsIgnoreCase(dataTypeClass)) {
						setterMethod.invoke(object, NumbertUtil.convertToDouble(JsonDocument.getString(property)));
					}else {
						setterMethod.invoke(object, JsonDocument.getString(property));
					}
				}
				catch (Exception e) {
					//System.err.println("property:" + property);
					//e.printStackTrace();
				}
			}
		}
		catch (Exception e) {}
		return (Any) object;
	}
}
