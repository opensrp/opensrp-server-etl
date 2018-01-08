package org.opensrp.etl.report;

import org.hibernate.annotations.ColumnDefault;

public class NutritionReport {
    @ColumnDefault("0")
    private int wnCounsellingIronForPregWoman;
    @ColumnDefault("0")
    private int wnCounsellingIronForMother;
    @ColumnDefault("0")
    private int wnDistributionIronForPregWoman;
    @ColumnDefault("0")
    private int wnDistributionIronForMother;
    @ColumnDefault("0")
    private int wnCounsellingOnBreastMilkForPregWoman;
    @ColumnDefault("0")
    private int wnCounsellingOnBreastMilkForMother;
    @ColumnDefault("0")
    private int wnCounsellingOnFeedingMNP;
    @ColumnDefault("0")
    private int cnBreastFeedingWithin1Hour;
    @ColumnDefault("0")
    private int cnBreastFeedingUntill6Month;
    @ColumnDefault("0")
    private int cnComplementaryFoodForChild6TO23;
    @ColumnDefault("0")
    private int cnComplementaryFoodForChild24to59;
    @ColumnDefault("0")
    private int cnReceivedMNP;
    @ColumnDefault("0")
    private int cnContractedMAMChildZeroToSix;
    @ColumnDefault("0")
    private int cnContractedMAMChild6TO23;
    @ColumnDefault("0")
    private int cnContractedMAMChild24to59;
    @ColumnDefault("0")
    private int cnContractedSAMChildZeroToSix;
    @ColumnDefault("0")
    private int cnContractedSAMChild6TO23;
    @ColumnDefault("0")
    private int cnContractedSAMChild24to59;

    public NutritionReport() {
        // TODO Auto-generated constructor stub
    }

    public int getWnCounsellingIronForPregWoman() {
        return wnCounsellingIronForPregWoman;
    }

    public void setWnCounsellingIronForPregWoman(
            int wnCounsellingIronForPregWoman) {
        this.wnCounsellingIronForPregWoman = wnCounsellingIronForPregWoman;
    }

    public int getWnCounsellingIronForMother() {
        return wnCounsellingIronForMother;
    }

    public void setWnCounsellingIronForMother(int wnCounsellingIronForMother) {
        this.wnCounsellingIronForMother = wnCounsellingIronForMother;
    }

    public int getWnDistributionIronForPregWoman() {
        return wnDistributionIronForPregWoman;
    }

    public void setWnDistributionIronForPregWoman(
            int wnDistributionIronForPregWoman) {
        this.wnDistributionIronForPregWoman = wnDistributionIronForPregWoman;
    }

    public int getWnDistributionIronForMother() {
        return wnDistributionIronForMother;
    }

    public void setWnDistributionIronForMother(int wnDistributionIronForMother) {
        this.wnDistributionIronForMother = wnDistributionIronForMother;
    }

    public int getWnCounsellingOnBreastMilkForPregWoman() {
        return wnCounsellingOnBreastMilkForPregWoman;
    }

    public void setWnCounsellingOnBreastMilkForPregWoman(
            int wnCounsellingOnBreastMilkForPregWoman) {
        this.wnCounsellingOnBreastMilkForPregWoman = wnCounsellingOnBreastMilkForPregWoman;
    }

    public int getWnCounsellingOnBreastMilkForMother() {
        return wnCounsellingOnBreastMilkForMother;
    }

    public void setWnCounsellingOnBreastMilkForMother(
            int wnCounsellingOnBreastMilkForMother) {
        this.wnCounsellingOnBreastMilkForMother = wnCounsellingOnBreastMilkForMother;
    }

    public int getWnCounsellingOnFeedingMNP() {
        return wnCounsellingOnFeedingMNP;
    }

    public void setWnCounsellingOnFeedingMNP(int wnCounsellingOnFeedingMNP) {
        this.wnCounsellingOnFeedingMNP = wnCounsellingOnFeedingMNP;
    }

    public int getCnBreastFeedingWithin1Hour() {
        return cnBreastFeedingWithin1Hour;
    }

    public void setCnBreastFeedingWithin1Hour(int cnBreastFeedingWithin1Hour) {
        this.cnBreastFeedingWithin1Hour = cnBreastFeedingWithin1Hour;
    }

    public int getCnBreastFeedingUntill6Month() {
        return cnBreastFeedingUntill6Month;
    }

    public void setCnBreastFeedingUntill6Month(int cnBreastFeedingUntill6Month) {
        this.cnBreastFeedingUntill6Month = cnBreastFeedingUntill6Month;
    }

    public int getCnComplementaryFoodForChild6TO23() {
        return cnComplementaryFoodForChild6TO23;
    }

    public void setCnComplementaryFoodForChild6TO23(
            int cnComplementaryFoodForChild6TO23) {
        this.cnComplementaryFoodForChild6TO23 = cnComplementaryFoodForChild6TO23;
    }

    public int getCnComplementaryFoodForChild24to59() {
        return cnComplementaryFoodForChild24to59;
    }

    public void setCnComplementaryFoodForChild24to59(
            int cnComplementaryFoodForChild24to59) {
        this.cnComplementaryFoodForChild24to59 = cnComplementaryFoodForChild24to59;
    }

    public int getCnReceivedMNP() {
        return cnReceivedMNP;
    }

    public void setCnReceivedMNP(int cnReceivedMNP) {
        this.cnReceivedMNP = cnReceivedMNP;
    }

    public int getCnContractedMAMChildZeroToSix() {
        return cnContractedMAMChildZeroToSix;
    }

    public void setCnContractedMAMChildZeroToSix(
            int cnContractedMAMChildZeroToSix) {
        this.cnContractedMAMChildZeroToSix = cnContractedMAMChildZeroToSix;
    }

    public int getCnContractedMAMChild6TO23() {
        return cnContractedMAMChild6TO23;
    }

    public void setCnContractedMAMChild6TO23(int cnContractedMAMChild6TO23) {
        this.cnContractedMAMChild6TO23 = cnContractedMAMChild6TO23;
    }

    public int getCnContractedMAMChild24to59() {
        return cnContractedMAMChild24to59;
    }

    public void setCnContractedMAMChild24to59(int cnContractedMAMChild24to59) {
        this.cnContractedMAMChild24to59 = cnContractedMAMChild24to59;
    }

    public int getCnContractedSAMChildZeroToSix() {
        return cnContractedSAMChildZeroToSix;
    }

    public void setCnContractedSAMChildZeroToSix(
            int cnContractedSAMChildZeroToSix) {
        this.cnContractedSAMChildZeroToSix = cnContractedSAMChildZeroToSix;
    }

    public int getCnContractedSAMChild6TO23() {
        return cnContractedSAMChild6TO23;
    }

    public void setCnContractedSAMChild6TO23(int cnContractedSAMChild6TO23) {
        this.cnContractedSAMChild6TO23 = cnContractedSAMChild6TO23;
    }

    public int getCnContractedSAMChild24to59() {
        return cnContractedSAMChild24to59;
    }

    public void setCnContractedSAMChild24to59(int cnContractedSAMChild24to59) {
        this.cnContractedSAMChild24to59 = cnContractedSAMChild24to59;
    }

}
