package org.mcare.common.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

public class ExportKeyMapperSetup {
	
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	public static List<String> ANC = new ArrayList<String>();
	static {
		ANC.add("id");
		ANC.add("NameS");
		ANC.add("Names");
		ANC.add("Namess");
		ANC.add("Namess");
		
	}
}
