package org.opensrp.etl.report;

import org.hibernate.annotations.ColumnDefault;

public class BirthAndDeathReport {
    @ColumnDefault("0")
    private int bdTotalLiveBirth;
    @ColumnDefault("0")
    private int bdtotalChildWithUnderWeight;
    @ColumnDefault("0")
    private int bdTotalPrematureChild;
    @ColumnDefault("0")
    private int bdStillBirthCount;
    @ColumnDefault("0")
    private int bdDeathLessThan7Days;
    @ColumnDefault("0")
    private int bdDeathLessThan28Days;
    @ColumnDefault("0")
    private int bdDeathLessThan1Yr;
    @ColumnDefault("0")
    private int bdTotalDeathLessThan1Yr;
    @ColumnDefault("0")
    private int bdDeathLessThan5Yr;
    @ColumnDefault("0")
    private int bdDeathOfMother;
    @ColumnDefault("0")
    private int bdDeathOfOther;
    @ColumnDefault("0")
    private int bdTotalDeathCount;

    public BirthAndDeathReport() {
        // TODO Auto-generated constructor stub
    }

    public int getBdTotalLiveBirth() {
        return bdTotalLiveBirth;
    }

    public void setBdTotalLiveBirth(int bdTotalLiveBirth) {
        this.bdTotalLiveBirth = bdTotalLiveBirth;
    }

    public int getBdtotalChildWithUnderWeight() {
        return bdtotalChildWithUnderWeight;
    }

    public void setBdtotalChildWithUnderWeight(int bdtotalChildWithUnderWeight) {
        this.bdtotalChildWithUnderWeight = bdtotalChildWithUnderWeight;
    }

    public int getBdTotalPrematureChild() {
        return bdTotalPrematureChild;
    }

    public void setBdTotalPrematureChild(int bdTotalPrematureChild) {
        this.bdTotalPrematureChild = bdTotalPrematureChild;
    }

    public int getBdStillBirthCount() {
        return bdStillBirthCount;
    }

    public void setBdStillBirthCount(int bdStillBirthCount) {
        this.bdStillBirthCount = bdStillBirthCount;
    }

    public int getBdDeathLessThan7Days() {
        return bdDeathLessThan7Days;
    }

    public void setBdDeathLessThan7Days(int bdDeathLessThan7Days) {
        this.bdDeathLessThan7Days = bdDeathLessThan7Days;
    }

    public int getBdDeathLessThan28Days() {
        return bdDeathLessThan28Days;
    }

    public void setBdDeathLessThan28Days(int bdDeathLessThan28Days) {
        this.bdDeathLessThan28Days = bdDeathLessThan28Days;
    }

    public int getBdDeathLessThan1Yr() {
        return bdDeathLessThan1Yr;
    }

    public void setBdDeathLessThan1Yr(int bdDeathLessThan1Yr) {
        this.bdDeathLessThan1Yr = bdDeathLessThan1Yr;
    }

    public int getBdTotalDeathLessThan1Yr() {
        return bdTotalDeathLessThan1Yr;
    }

    public void setBdTotalDeathLessThan1Yr(int bdTotalDeathLessThan1Yr) {
        this.bdTotalDeathLessThan1Yr = bdTotalDeathLessThan1Yr;
    }

    public int getBdDeathLessThan5Yr() {
        return bdDeathLessThan5Yr;
    }

    public void setBdDeathLessThan5Yr(int bdDeathLessThan5Yr) {
        this.bdDeathLessThan5Yr = bdDeathLessThan5Yr;
    }

    public int getBdDeathOfMother() {
        return bdDeathOfMother;
    }

    public void setBdDeathOfMother(int bdDeathOfMother) {
        this.bdDeathOfMother = bdDeathOfMother;
    }

    public int getBdDeathOfOther() {
        return bdDeathOfOther;
    }

    public void setBdDeathOfOther(int bdDeathOfOther) {
        this.bdDeathOfOther = bdDeathOfOther;
    }

    public int getBdTotalDeathCount() {
        return bdTotalDeathCount;
    }

    public void setBdTotalDeathCount(int bdTotalDeathCount) {
        this.bdTotalDeathCount = bdTotalDeathCount;
    }

}
