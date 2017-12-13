package org.opensrp.etl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "misreport")
public class MISReportEntity {

    public MISReportEntity() {
        // TODO Auto-generated constructor stub
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "misreport_id_seq")
    @SequenceGenerator(name = "misreport_id_seq", sequenceName = "misreport_id_seq", allocationSize = 1)
    private long id;

    private String division;
    private String district;
    private String upazilla;
    private String ward;
    private String unionName;
    private String unit;
    private int month;
    private int year;
    private int oldPillUsages;

    public long getId() {
        return id;
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

    public int getOldPillUsages() {
        return oldPillUsages;
    }

    public void setOldPillUsages(int oldPillUsages) {
        this.oldPillUsages = oldPillUsages;
    }

}
