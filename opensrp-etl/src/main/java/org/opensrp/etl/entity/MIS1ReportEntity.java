package org.opensrp.etl.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.opensrp.etl.report.BirthAndDeathReport;
import org.opensrp.etl.report.ChildCareReport;
import org.opensrp.etl.report.FamilyPlanningReport;
import org.opensrp.etl.report.MaternityCareReport;
import org.opensrp.etl.report.NutritionReport;

@Entity
@Table(name = "mis1report")
public class MIS1ReportEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mis1report_id_seq")
	@SequenceGenerator(name = "mis1report_id_seq", sequenceName = "mis1report_id_seq", allocationSize = 1)
	private int id;
	
	private String reporting_division;
	
	private String reporting_district;
	
	private String reporting_upazilla;
	
	private String reporting_ward;
	
	private String reporting_union;
	
	private String reporting_unit;
	
	private String reporting_year;
	
	private String reporting_month;
	
	private String reporting_provider;
	
	@Embedded
	private FamilyPlanningReport familyPlanningReport;
	
	@Embedded
	private MaternityCareReport maternityCareReport;
	
	@Embedded
	private ChildCareReport childCareReport;
	
	@Embedded
	private BirthAndDeathReport birthAndDeathReport;
	
	@Embedded
	private NutritionReport nutritionReport;
	
	public MIS1ReportEntity() {
	}
	
	public FamilyPlanningReport getFamilyPlanningReport() {
		return familyPlanningReport;
	}
	
	public void setFamilyPlanningReport(FamilyPlanningReport familyPlanningReport) {
		this.familyPlanningReport = familyPlanningReport;
	}
	
	public MaternityCareReport getMaternityCareReport() {
		return maternityCareReport;
	}
	
	public void setMaternityCareReport(MaternityCareReport maternityCareReport) {
		this.maternityCareReport = maternityCareReport;
	}
	
	public BirthAndDeathReport getBirthAndDeathReport() {
		return birthAndDeathReport;
	}
	
	public void setBirthAndDeathReport(BirthAndDeathReport birthAndDeathReport) {
		this.birthAndDeathReport = birthAndDeathReport;
	}
	
	public ChildCareReport getChildCareReport() {
		return childCareReport;
	}
	
	public void setChildCareReport(ChildCareReport childCareReport) {
		this.childCareReport = childCareReport;
	}
	
	public NutritionReport getNutritionReport() {
		return nutritionReport;
	}
	
	public void setNutritionReport(NutritionReport nutritionReport) {
		this.nutritionReport = nutritionReport;
	}
	
	public String getReporting_division() {
		return reporting_division;
	}
	
	public void setReporting_division(String reporting_division) {
		this.reporting_division = reporting_division;
	}
	
	public String getReporting_district() {
		return reporting_district;
	}
	
	public void setReporting_district(String reporting_district) {
		this.reporting_district = reporting_district;
	}
	
	public String getReporting_upazilla() {
		return reporting_upazilla;
	}
	
	public void setReporting_upazilla(String reporting_upazilla) {
		this.reporting_upazilla = reporting_upazilla;
	}
	
	public String getReporting_ward() {
		return reporting_ward;
	}
	
	public void setReporting_ward(String reporting_ward) {
		this.reporting_ward = reporting_ward;
	}
	
	public String getReporting_union() {
		return reporting_union;
	}
	
	public void setReporting_union(String reporting_union) {
		this.reporting_union = reporting_union;
	}
	
	public String getReporting_unit() {
		return reporting_unit;
	}
	
	public void setReporting_unit(String reporting_unit) {
		this.reporting_unit = reporting_unit;
	}
	
	public String getReporting_year() {
		return reporting_year;
	}
	
	public void setReporting_year(String reporting_year) {
		this.reporting_year = reporting_year;
	}
	
	public String getReporting_month() {
		return reporting_month;
	}
	
	public void setReporting_month(String reporting_month) {
		this.reporting_month = reporting_month;
	}
	
	public String getReporting_provider() {
		return reporting_provider;
	}
	
	public void setReporting_provider(String reporting_provider) {
		this.reporting_provider = reporting_provider;
	}
}
