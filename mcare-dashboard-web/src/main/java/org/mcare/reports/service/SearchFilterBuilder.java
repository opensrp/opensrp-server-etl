package org.mcare.reports.service;

import org.mcare.params.builder.SearchBuilder;
import org.springframework.stereotype.Component;

@Component
public class SearchFilterBuilder extends SearchBuilder{

	private String start;

	private String end;

	public SearchFilterBuilder() {
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

	@Override
	public String toString() {
		return "SearchFilterBuilder [start=" + start + ", end=" + end + "]";
	}

}
