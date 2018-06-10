package org.mcare.api.utils;

public enum VoidStatus {
	NOACTION(0), FALSEREPORT(1);
	
	private int status;
	
	VoidStatus(int status) {
		this.status = status;
	}
	
	public int status() {
		return status;
	}
}
