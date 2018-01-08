package org.opensrp.etl.report;

import org.hibernate.annotations.ColumnDefault;

public class FamilyPlanningReport {
	@ColumnDefault("0")
    private int oldPillUsages;
	@ColumnDefault("0")
    private int newPillUsages;
	@ColumnDefault("0")
    private int currentTotalPillUsages;
	@ColumnDefault("0")
    private int previousTotalPillUsages;
	@ColumnDefault("0")
    private int totalPillUsages;
	@ColumnDefault("0")
    private int oldCondomUsages;
	@ColumnDefault("0")
    private int newCondomUsages;
	@ColumnDefault("0")
    private int currentTotalCondomUsages;
	@ColumnDefault("0")
    private int previousTotalCondomUsages;
	@ColumnDefault("0")
    private int totalCondomUsages;
	@ColumnDefault("0")
    private int oldInjectableUsages;
	@ColumnDefault("0")
    private int newInjectableUsages;
	@ColumnDefault("0")
    private int currentTotalInjectableUsages;
	@ColumnDefault("0")
    private int previousTotalInjectableUsages;
	@ColumnDefault("0")
    private int totalInjectableUsages;
	@ColumnDefault("0")
    private int oldIUDUsages;
	@ColumnDefault("0")
    private int newIUDUsages;
	@ColumnDefault("0")
    private int currentTotalIUDUsages;
	@ColumnDefault("0")
    private int previousTotalIUDUsages;
	@ColumnDefault("0")
    private int totalIUDUsages;
	@ColumnDefault("0")
    private int oldImplantUsages;
	@ColumnDefault("0")
    private int newImplantUsages;
	@ColumnDefault("0")
    private int currentTotalImplantUsages;
	@ColumnDefault("0")
    private int previousTotalImplantUsages;
	@ColumnDefault("0")
    private int totalImplantUsages;
	@ColumnDefault("0")
    private int oldMalePermanentMethodUsages;
	@ColumnDefault("0")
    private int newMalePermanentMethodUsages;
	@ColumnDefault("0")
    private int currentTotalMalePermanentUsages;
	@ColumnDefault("0")
    private int previousTotalMalePermanentUsages;
	@ColumnDefault("0")
    private int totalMalePermanentMethodUsages;
	@ColumnDefault("0")
    private int oldFemalePermanentMethodUsages;
	@ColumnDefault("0")
    private int newFemalePermanentMethodUsages;
	@ColumnDefault("0")
    private int currentTotalFemalePermanentUsages;
	@ColumnDefault("0")
    private int previousTotalFemalePermanentUsages;
	@ColumnDefault("0")
    private int totalFemalePermanentMethodUsages;
	@ColumnDefault("0")
    private int leftPillAndStartedNone;
	@ColumnDefault("0")
    private int leftPillAndStartedOtherMethod;
	@ColumnDefault("0")
    private int leftCondomAndStartedNone;
	@ColumnDefault("0")
    private int leftCondomAndStartedOtherMethod;
	@ColumnDefault("0")
    private int leftInjectableAndStartedNone;
    @ColumnDefault("0")
    private int leftInjectableAndStartedOtherMethod;
    @ColumnDefault("0")
    private int leftIUDAndStartedNone;
    @ColumnDefault("0")
    private int leftIUDAndStartedOtherMethod;
    @ColumnDefault("0")
    private int leftImplantAndStartedNone;
    @ColumnDefault("0")
    private int leftImplantAndStartedOtherMethod;

    // private int EligibleCoupleCountCalculator;
    // private CondomMethodUsagesCalculator condomUsagesCalculator;
    // private IUDUsagesCalculator iudUsagesCalculator;
    // private InjectableUsagesCalculator injectableUsagesCalculator;
    // private ImplantUsagesCalculator implantUsagesCalculator;
    // private MalePermanentMethodUsagesCalculator
    // malePermanentMethodUsagesCalculator;
    // private FemalePermanentMethodUsagesCalculator
    // femalePermanentMethodUsagesCalculator;

    public FamilyPlanningReport() {
        // TODO Auto-generated constructor stub
    }

    public int getOldPillUsages() {
        return oldPillUsages;
    }

    public void setOldPillUsages(int oldPillUsages) {
        this.oldPillUsages = oldPillUsages;
    }

    public int getNewPillUsages() {
        return newPillUsages;
    }

    public void setNewPillUsages(int newPillUsages) {
        this.newPillUsages = newPillUsages;
    }

    public int getCurrentTotalPillUsages() {
        return currentTotalPillUsages;
    }

    public void setCurrentTotalPillUsages(int currentTotalPillUsages) {
        this.currentTotalPillUsages = currentTotalPillUsages;
    }

    public int getPreviousTotalPillUsages() {
        return previousTotalPillUsages;
    }

    public void setPreviousTotalPillUsages(int previousTotalPillUsages) {
        this.previousTotalPillUsages = previousTotalPillUsages;
    }

    public int getTotalPillUsages() {
        return totalPillUsages;
    }

    public void setTotalPillUsages(int totalPillUsages) {
        this.totalPillUsages = totalPillUsages;
    }

    public int getOldCondomUsages() {
        return oldCondomUsages;
    }

    public void setOldCondomUsages(int oldCondomUsages) {
        this.oldCondomUsages = oldCondomUsages;
    }

    public int getNewCondomUsages() {
        return newCondomUsages;
    }

    public void setNewCondomUsages(int newCondomUsages) {
        this.newCondomUsages = newCondomUsages;
    }

    public int getCurrentTotalCondomUsages() {
        return currentTotalCondomUsages;
    }

    public void setCurrentTotalCondomUsages(int currentTotalCondomUsages) {
        this.currentTotalCondomUsages = currentTotalCondomUsages;
    }

    public int getPreviousTotalCondomUsages() {
        return previousTotalCondomUsages;
    }

    public void setPreviousTotalCondomUsages(int previousTotalCondomUsages) {
        this.previousTotalCondomUsages = previousTotalCondomUsages;
    }

    public int getTotalCondomUsages() {
        return totalCondomUsages;
    }

    public void setTotalCondomUsages(int totalCondomUsages) {
        this.totalCondomUsages = totalCondomUsages;
    }

    public int getOldInjectableUsages() {
        return oldInjectableUsages;
    }

    public void setOldInjectableUsages(int oldInjectableUsages) {
        this.oldInjectableUsages = oldInjectableUsages;
    }

    public int getNewInjectableUsages() {
        return newInjectableUsages;
    }

    public void setNewInjectableUsages(int newInjectableUsages) {
        this.newInjectableUsages = newInjectableUsages;
    }

    public int getCurrentTotalInjectableUsages() {
        return currentTotalInjectableUsages;
    }

    public void setCurrentTotalInjectableUsages(int currentTotalInjectableUsages) {
        this.currentTotalInjectableUsages = currentTotalInjectableUsages;
    }

    public int getPreviousTotalInjectableUsages() {
        return previousTotalInjectableUsages;
    }

    public void setPreviousTotalInjectableUsages(
            int previousTotalInjectableUsages) {
        this.previousTotalInjectableUsages = previousTotalInjectableUsages;
    }

    public int getTotalInjectableUsages() {
        return totalInjectableUsages;
    }

    public void setTotalInjectableUsages(int totalInjectableUsages) {
        this.totalInjectableUsages = totalInjectableUsages;
    }

    public int getOldIUDUsages() {
        return oldIUDUsages;
    }

    public void setOldIUDUsages(int oldIUDUsages) {
        this.oldIUDUsages = oldIUDUsages;
    }

    public int getNewIUDUsages() {
        return newIUDUsages;
    }

    public void setNewIUDUsages(int newIUDUsages) {
        this.newIUDUsages = newIUDUsages;
    }

    public int getCurrentTotalIUDUsages() {
        return currentTotalIUDUsages;
    }

    public void setCurrentTotalIUDUsages(int currentTotalIUDUsages) {
        this.currentTotalIUDUsages = currentTotalIUDUsages;
    }

    public int getPreviousTotalIUDUsages() {
        return previousTotalIUDUsages;
    }

    public void setPreviousTotalIUDUsages(int previousTotalIUDUsages) {
        this.previousTotalIUDUsages = previousTotalIUDUsages;
    }

    public int getTotalIUDUsages() {
        return totalIUDUsages;
    }

    public void setTotalIUDUsages(int totalIUDUsages) {
        this.totalIUDUsages = totalIUDUsages;
    }

    public int getOldImplantUsages() {
        return oldImplantUsages;
    }

    public void setOldImplantUsages(int oldImplantUsages) {
        this.oldImplantUsages = oldImplantUsages;
    }

    public int getNewImplantUsages() {
        return newImplantUsages;
    }

    public void setNewImplantUsages(int newImplantUsages) {
        this.newImplantUsages = newImplantUsages;
    }

    public int getCurrentTotalImplantUsages() {
        return currentTotalImplantUsages;
    }

    public void setCurrentTotalImplantUsages(int currentTotalImplantUsages) {
        this.currentTotalImplantUsages = currentTotalImplantUsages;
    }

    public int getPreviousTotalImplantUsages() {
        return previousTotalImplantUsages;
    }

    public void setPreviousTotalImplantUsages(int previousTotalImplantUsages) {
        this.previousTotalImplantUsages = previousTotalImplantUsages;
    }

    public int getTotalImplantUsages() {
        return totalImplantUsages;
    }

    public void setTotalImplantUsages(int totalImplantUsages) {
        this.totalImplantUsages = totalImplantUsages;
    }

    public int getOldMalePermanentMethodUsages() {
        return oldMalePermanentMethodUsages;
    }

    public void setOldMalePermanentMethodUsages(int oldMalePermanentMethodUsages) {
        this.oldMalePermanentMethodUsages = oldMalePermanentMethodUsages;
    }

    public int getNewMalePermanentMethodUsages() {
        return newMalePermanentMethodUsages;
    }

    public void setNewMalePermanentMethodUsages(int newMalePermanentMethodUsages) {
        this.newMalePermanentMethodUsages = newMalePermanentMethodUsages;
    }

    public int getCurrentTotalMalePermanentUsages() {
        return currentTotalMalePermanentUsages;
    }

    public void setCurrentTotalMalePermanentUsages(
            int currentTotalMalePermanentUsages) {
        this.currentTotalMalePermanentUsages = currentTotalMalePermanentUsages;
    }

    public int getPreviousTotalMalePermanentUsages() {
        return previousTotalMalePermanentUsages;
    }

    public void setPreviousTotalMalePermanentUsages(
            int previousTotalMalePermanentUsages) {
        this.previousTotalMalePermanentUsages = previousTotalMalePermanentUsages;
    }

    public int getTotalMalePermanentMethodUsages() {
        return totalMalePermanentMethodUsages;
    }

    public void setTotalMalePermanentMethodUsages(
            int totalMalePermanentMethodUsages) {
        this.totalMalePermanentMethodUsages = totalMalePermanentMethodUsages;
    }

    public int getOldFemalePermanentMethodUsages() {
        return oldFemalePermanentMethodUsages;
    }

    public void setOldFemalePermanentMethodUsages(
            int oldFemalePermanentMethodUsages) {
        this.oldFemalePermanentMethodUsages = oldFemalePermanentMethodUsages;
    }

    public int getNewFemalePermanentMethodUsages() {
        return newFemalePermanentMethodUsages;
    }

    public void setNewFemalePermanentMethodUsages(
            int newFemalePermanentMethodUsages) {
        this.newFemalePermanentMethodUsages = newFemalePermanentMethodUsages;
    }

    public int getCurrentTotalFemalePermanentUsages() {
        return currentTotalFemalePermanentUsages;
    }

    public void setCurrentTotalFemalePermanentUsages(
            int currentTotalFemalePermanentUsages) {
        this.currentTotalFemalePermanentUsages = currentTotalFemalePermanentUsages;
    }

    public int getPreviousTotalFemalePermanentUsages() {
        return previousTotalFemalePermanentUsages;
    }

    public void setPreviousTotalFemalePermanentUsages(
            int previousTotalFemalePermanentUsages) {
        this.previousTotalFemalePermanentUsages = previousTotalFemalePermanentUsages;
    }

    public int getTotalFemalePermanentMethodUsages() {
        return totalFemalePermanentMethodUsages;
    }

    public void setTotalFemalePermanentMethodUsages(
            int totalFemalePermanentMethodUsages) {
        this.totalFemalePermanentMethodUsages = totalFemalePermanentMethodUsages;
    }

    public int getLeftPillAndStartedNone() {
        return leftPillAndStartedNone;
    }

    public void setLeftPillAndStartedNone(int leftPillAndStartedNone) {
        this.leftPillAndStartedNone = leftPillAndStartedNone;
    }

    public int getLeftPillAndStartedOtherMethod() {
        return leftPillAndStartedOtherMethod;
    }

    public void setLeftPillAndStartedOtherMethod(
            int leftPillAndStartedOtherMethod) {
        this.leftPillAndStartedOtherMethod = leftPillAndStartedOtherMethod;
    }

    public int getLeftCondomAndStartedNone() {
        return leftCondomAndStartedNone;
    }

    public void setLeftCondomAndStartedNone(int leftCondomAndStartedNone) {
        this.leftCondomAndStartedNone = leftCondomAndStartedNone;
    }

    public int getLeftCondomAndStartedOtherMethod() {
        return leftCondomAndStartedOtherMethod;
    }

    public void setLeftCondomAndStartedOtherMethod(
            int leftCondomAndStartedOtherMethod) {
        this.leftCondomAndStartedOtherMethod = leftCondomAndStartedOtherMethod;
    }

    public int getLeftInjectableAndStartedNone() {
        return leftInjectableAndStartedNone;
    }

    public void setLeftInjectableAndStartedNone(int leftInjectableAndStartedNone) {
        this.leftInjectableAndStartedNone = leftInjectableAndStartedNone;
    }

    public int getLeftInjectableAndStartedOtherMethod() {
        return leftInjectableAndStartedOtherMethod;
    }

    public void setLeftInjectableAndStartedOtherMethod(
            int leftInjectableAndStartedOtherMethod) {
        this.leftInjectableAndStartedOtherMethod = leftInjectableAndStartedOtherMethod;
    }

    public int getLeftIUDAndStartedNone() {
        return leftIUDAndStartedNone;
    }

    public void setLeftIUDAndStartedNone(int leftIUDAndStartedNone) {
        this.leftIUDAndStartedNone = leftIUDAndStartedNone;
    }

    public int getLeftIUDAndStartedOtherMethod() {
        return leftIUDAndStartedOtherMethod;
    }

    public void setLeftIUDAndStartedOtherMethod(int leftIUDAndStartedOtherMethod) {
        this.leftIUDAndStartedOtherMethod = leftIUDAndStartedOtherMethod;
    }

    public int getLeftImplantAndStartedNone() {
        return leftImplantAndStartedNone;
    }

    public void setLeftImplantAndStartedNone(int leftImplantAndStartedNone) {
        this.leftImplantAndStartedNone = leftImplantAndStartedNone;
    }

    public int getLeftImplantAndStartedOtherMethod() {
        return leftImplantAndStartedOtherMethod;
    }

    public void setLeftImplantAndStartedOtherMethod(
            int leftImplantAndStartedOtherMethod) {
        this.leftImplantAndStartedOtherMethod = leftImplantAndStartedOtherMethod;
    }
}
