package org.opensrp.etl.entity;

import javax.validation.constraints.NotBlank;

public class FilterCriteria {
	
	public FilterCriteria() {}	
	
    private String division;
    private String district;
    private String upazilla;
    private String ward;
    private String unionname;
    private String unit;
    

    private String year;
    

    private String month;
    
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
	
	@Override
	public String toString() {
		return "FilterCriteria [division=" + division + ", district=" + district + ", upazilla=" + upazilla + ", ward="
				+ ward + ", unionname=" + unionname + ", unit=" + unit + ", year=" + year + ", month=" + month + "]";
	}

    
	

}
