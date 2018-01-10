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

    public void setFamilyPlanningReport(
            FamilyPlanningReport familyPlanningReport) {
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

    public String getDivision() {
        return reporting_division;
    }

    public void setDivision(String division) {
        this.reporting_division = division;
    }

    public String getDistrict() {
        return reporting_district;
    }

    public void setDistrict(String district) {
        this.reporting_district = district;
    }

    public String getUpazilla() {
        return reporting_upazilla;
    }

    public void setUpazilla(String upazilla) {
        this.reporting_upazilla = upazilla;
    }

    public String getWard() {
        return reporting_ward;
    }

    public void setWard(String ward) {
        this.reporting_ward = ward;
    }

    public String getGeo_union() {
        return reporting_union;
    }

    public void setGeo_union(String geo_union) {
        this.reporting_union = geo_union;
    }

    public String getUnit() {
        return reporting_unit;
    }

    public void setUnit(String unit) {
        this.reporting_unit = unit;
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

}
