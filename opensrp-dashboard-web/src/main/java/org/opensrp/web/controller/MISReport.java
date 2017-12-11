package org.opensrp.web.controller;

public class MISReport {
	
	private String fc;
	private String fp;

	public MISReport() {
		// TODO Auto-generated constructor stub
		this.fc = "1";
		this.fp = "2";
	}

	public String getFc() {
		return fc;
	}

	public void setFc(String fc) {
		this.fc = fc;
	}

	public String getFp() {
		return fp;
	}

	public void setFp(String fp) {
		this.fp = fp;
	}

	@Override
	public String toString() {
		return "MISReport [fc=" + fc + ", fp=" + fp + "]";
	}

	
}
