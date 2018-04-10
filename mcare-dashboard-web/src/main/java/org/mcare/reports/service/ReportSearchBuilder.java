package org.mcare.reports.service;

import org.mcare.params.builder.SearchBuilder;
import org.springframework.stereotype.Component;

@Component
public class ReportSearchBuilder extends SearchBuilder{

	private String start;

	private String end;

	public ReportSearchBuilder() {
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

}
