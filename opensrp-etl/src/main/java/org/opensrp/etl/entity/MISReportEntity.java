package org.opensrp.etl.entity;

import javax.persistence.Entity;

@Entity
public class MISReportEntity {

    public MISReportEntity() {
    }

    private long id;

    private String mis_division;
    private String mis_district;
    private String mis_upazilla;
    private String mis_ward;
    private String mis_unionname;
    private String mis_unit;
    private int mis_currentMonth;
    private int mis_currentYear;
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

    public String getMis_division() {
        return mis_division;
    }

    public void setMis_division(String mis_division) {
        this.mis_division = mis_division;
    }

    public String getMis_district() {
        return mis_district;
    }

    public void setMis_district(String mis_district) {
        this.mis_district = mis_district;
    }

    public String getMis_upazilla() {
        return mis_upazilla;
    }

    public void setMis_upazilla(String mis_upazilla) {
        this.mis_upazilla = mis_upazilla;
    }

    public String getMis_ward() {
        return mis_ward;
    }

    public void setMis_ward(String mis_ward) {
        this.mis_ward = mis_ward;
    }

    public String getMis_unionname() {
        return mis_unionname;
    }

    public void setMis_unionname(String mis_unionname) {
        this.mis_unionname = mis_unionname;
    }

    public String getMis_unit() {
        return mis_unit;
    }

    public void setMis_unit(String mis_unit) {
        this.mis_unit = mis_unit;
    }

    public int getMis_currentMonth() {
        return mis_currentMonth;
    }

    public void setMis_currentMonth(int mis_currentMonth) {
        this.mis_currentMonth = mis_currentMonth;
    }

    public int getMis_currentYear() {
        return mis_currentYear;
    }

    public void setMis_currentYear(int mis_currentYear) {
        this.mis_currentYear = mis_currentYear;
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
