package org.opensrp.etl.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KeyConversionCheck {
	
	private static final String ANC = "ANC";
	
	private static ArrayList<String> ancKeys = new ArrayList<String>();
	
	private static Map<String, String> ancVisitKeyMap = new HashMap<String, String>();
	
	private static void setANCCommonKeys() {
		ancKeys.add("FWHR_ANC");
		ancKeys.add("FWANCBLRVIS");
		ancKeys.add("FWANCSWLNG");
		ancKeys.add("FWancSWLNG");
		ancKeys.add("STS");
	}
	
	private static Map<String, String> getANCVisitKeys(String visitNo) {
		for (String ancKey : ancKeys) {
			if (ancKey.toUpperCase().contains(ANC)) {
				String anc = ancKey.substring(ancKey.toUpperCase().indexOf(ANC), ancKey.toUpperCase().indexOf(ANC) + 3);
				ancVisitKeyMap.put(ancKey, ancKey.replaceFirst(anc, anc.concat(visitNo)));
			} else {
				ancVisitKeyMap.put(ancKey, ancKey);
			}
		}
		return ancVisitKeyMap;
	}
	
	public static void main(String[] args) {
		setANCCommonKeys();
		Map<String, String> ancVisitKeys = getANCVisitKeys("1");
		System.out.println("ancVisitKeys" + ancVisitKeys);
	}
	
}
