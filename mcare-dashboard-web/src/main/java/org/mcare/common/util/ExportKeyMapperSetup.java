package org.mcare.common.util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

public class ExportKeyMapperSetup {
	
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	public static List<String> ANC = new ArrayList<String>();
	static {
		ANC.add("existing_gobhhid");
		ANC.add("existing_jivhhid");
		ANC.add("existing_wom_bid");
		ANC.add("existing_wom_nid");
		ANC.add("existing_first_name");
		ANC.add("existing_husname");
		ANC.add("existing_psrlmp");
		
		ANC.add("existing_FWVG");
		ANC.add("existing_FWHR_PSR");
		ANC.add("existing_FWHRP");
		
		ANC.add("existing_dangervalue");
		ANC.add("existing_ELCO");
		
		ANC.add("today");
		ANC.add("start");
		ANC.add("end");
		ANC.add("FWANCDATE");
		ANC.add("FWGESTATIONALAGE");
		ANC.add("FWEDD");
		ANC.add("FWANCREMSTS");
		ANC.add("FWANCINT");
		ANC.add("FWANCKNWPRVDR");
		ANC.add("FWANCANM");
		ANC.add("FWANCHBP");
		ANC.add("FWANCDBT");
		ANC.add("FWANCTHY");
		ANC.add("FWANCPROB");
		ANC.add("FWANCHEAD");
		ANC.add("FWANCBLRVIS");
		
		ANC.add("FWANCSWLNG");
		ANC.add("FWANCBLD");
		ANC.add("FWANCCONVL");
		ANC.add("FWANCDS1");
		ANC.add("FWANCDS2");
		ANC.add("FWANCDS3");
		ANC.add("FWANCDS4");
		ANC.add("FWANCDS5");
		ANC.add("FWANCDS6");
		ANC.add("FWNOTELIGIBLE");
		
		ANC.add("FWHR_ANC");
		ANC.add("FWFLAGVALUE");
		ANC.add("FWSORTVALUE");
		ANC.add("user_type");
		
		ANC.add("external_user_ID");
		ANC.add("anc_current_formStatus");
		ANC.add("relationalid");
	}
	
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	public static List<String> PNC = new ArrayList<String>();
	static {
		PNC.add("existing_gobhhid");
		PNC.add("existing_jivhhid");
		PNC.add("existing_first_name");
		PNC.add("existing_husname");
		PNC.add("existing_wom_nid");
		PNC.add("existing_wom_bid");
		PNC.add("existing_doo");
		PNC.add("existing_outcome_status");
		PNC.add("today");
		PNC.add("start");
		PNC.add("end");
		PNC.add("FWPNCDATE");
		PNC.add("FWPNCREMSTS");
		PNC.add("FWPNCINT");
		PNC.add("FWPNCKNWPRVDR");
		PNC.add("FWPNCFVR");
		PNC.add("FWPNCTEMP");
		PNC.add("FWPNCDNGRSIGN");
		PNC.add("FWPNCDELCOMP");
		PNC.add("FWPNCDELTYPE");
		PNC.add("user_type");
		PNC.add("pnc_current_formStatus");
		PNC.add("relationalid");
	}
	
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	public static List<String> ENCC = new ArrayList<String>();
	static {
		ENCC.add("start");
		ENCC.add("end");
		ENCC.add("today");
		ENCC.add("FWENCDATE");
		ENCC.add("FWENCSTS");
		ENCC.add("FWENCBFINTN");
		ENCC.add("FWENCPRLCTL");
		
		ENCC.add("FWENCDRYWM");
		ENCC.add("FWENCHDCOV");
		ENCC.add("FWENCBTHD");
		
		ENCC.add("FWENCUMBS");
		ENCC.add("FWENCTEMP");
		
		ENCC.add("FWENCDSFOULUMBS");
		ENCC.add("FWENCDSLIMBLUE");
		ENCC.add("FWENCDSSKNYLW");
		ENCC.add("FWENCDSLETH");
		ENCC.add("FWENCDSDIFBRTH");
		ENCC.add("FWENCDSCONVL");
		
		ENCC.add("FWENCDELCOMP");
		
		ENCC.add("encc_current_formStatus");
		
	}
}
