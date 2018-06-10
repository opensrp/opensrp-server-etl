package org.mcare.api.utils;

public enum ScheduleName {
	psrf("ELCO PSRF"), anc("Ante Natal Care Reminder Visit"), bnf("BirthNotificationPregnancyStatusFollowUp"), pnc(
	        "Post Natal Care Reminder Visit"), encc("Essential Newborn Care Checklist");
	
	private String schedule;
	
	ScheduleName(String schedule) {
		this.schedule = schedule;
	}
	
	public String schedule() {
		return schedule;
	}
}
