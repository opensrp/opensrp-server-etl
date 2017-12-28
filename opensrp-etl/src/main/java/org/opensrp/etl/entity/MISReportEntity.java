package org.opensrp.etl.entity;

import javax.persistence.Entity;

@Entity
public class MISReportEntity {

    public MISReportEntity() {
    }

    private long id;

    private String division;
    private String district;
    private String upazilla;
    private String ward;
    private String unionName;
    private String unit;
    private int month;
    private int year;
    private int fpOldPillUsages;
    private int fpNewPillUsages;
    private int fpCurrentTotalPillUsages;
    private int fpPrevTotalPillUsages;
    private int fpTotalPillUsages;
    private int fpLeftPillAndStartedNone;
    private int fpLeftPillAndStartedOther;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getUnion() {
        return unionName;
    }

    public void setUnion(String union) {
        this.unionName = union;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getFpOldPillUsages() {
        return fpOldPillUsages;
    }

    public void setFpOldPillUsages(int oldPillUsages) {
        this.fpOldPillUsages = oldPillUsages;
    }

    public int getFpNewPillUsages() {
        return fpNewPillUsages;
    }

    public void setFpNewPillUsages(int fpNewPillUsages) {
        this.fpNewPillUsages = fpNewPillUsages;
    }

    public int getFpCurrentTotalPillUsages() {
        return fpCurrentTotalPillUsages;
    }

    public void setFpCurrentTotalPillUsages(int fpCurrentTotalPillUsages) {
        this.fpCurrentTotalPillUsages = fpCurrentTotalPillUsages;
    }

    public int getFpPrevTotalPillUsages() {
        return fpPrevTotalPillUsages;
    }

    public void setFpPrevTotalPillUsages(int fpPrevTotalPillUsages) {
        this.fpPrevTotalPillUsages = fpPrevTotalPillUsages;
    }

    public int getFpTotalPillUsages() {
        return fpTotalPillUsages;
    }

    public void setFpTotalPillUsages(int fpTotalPillUsages) {
        this.fpTotalPillUsages = fpTotalPillUsages;
    }

    public int getFpLeftPillAndStartedNone() {
        return fpLeftPillAndStartedNone;
    }

    public void setFpLeftPillAndStartedNone(int fpLeftPillAndStartedNone) {
        this.fpLeftPillAndStartedNone = fpLeftPillAndStartedNone;
    }

    public int getFpLeftPillAndStartedOther() {
        return fpLeftPillAndStartedOther;
    }

    public void setFpLeftPillAndStartedOther(int fpLeftPillAndStartedOther) {
        this.fpLeftPillAndStartedOther = fpLeftPillAndStartedOther;
    }

}
