package org.mcare.api.utils;

public enum VoidRemarks {
	FALSEREPORTREMARKS("False report identify");
	
	private String remarks;
	
	VoidRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String remarks() {
		return remarks;
	}
}
