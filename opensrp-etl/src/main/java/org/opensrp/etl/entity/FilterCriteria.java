package org.opensrp.etl.entity;

public class FilterCriteria {
	
	public FilterCriteria() {
	}
	
	private String division;
	
	private String district;
	
	private String upazilla;
	
	private String unionname;
	
	private String ward;
	
	private String unit;
	
	private String year;
	
	private String month;
	
	private String provider;
	
	private String updateReport;
	
	public String getDivision() {
		return division;
	}
	
	public void setDivision(String division) {
		this.division = division;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public String getUpazilla() {
		return upazilla;
	}
	
	public void setUpazilla(String upazilla) {
		this.upazilla = upazilla;
	}
	
	public String getWard() {
		return ward;
	}
	
	public void setWard(String ward) {
		this.ward = ward;
	}
	
	public String getUnionname() {
		return unionname;
	}
	
	public void setUnionname(String unionname) {
		this.unionname = unionname;
	}
	
	public String getUnit() {
		return unit;
	}
	
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getMonth() {
		return month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public String getProvider() {
		return provider;
	}
	
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	public String getUpdateReport() {
		return updateReport;
	}
	
	public void setUpdateReport(String updateReport) {
		this.updateReport = updateReport;
	}
	
	@Override
	public String toString() {
		return "FilterCriteria [division=" + division + ", district=" + district + ", upazilla=" + upazilla + ", unionname="
		        + unionname + ", ward=" + ward + ", unit=" + unit + ", year=" + year + ", month=" + month + ", provider="
		        + provider + "]";
	}
}
