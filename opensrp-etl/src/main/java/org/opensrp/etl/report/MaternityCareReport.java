package org.opensrp.etl.report;

import org.hibernate.annotations.ColumnDefault;

public class MaternityCareReport {
    @ColumnDefault("0")
    private int mcCurrentNewPregnantCount;
    @ColumnDefault("0")
    private int mcCurrentOldPregnantCount;
    @ColumnDefault("0")
    private int mcCurrentTotalPregnantCount;
    @ColumnDefault("0")
    private int mcPrevPregnantCount;
    @ColumnDefault("0")
    private int mcTotalPregnantCount;
    @ColumnDefault("0")
    private int mcANCVisit1;
    @ColumnDefault("0")
    private int mcANCVisit2;
    @ColumnDefault("0")
    private int mcANCVisit3;
    @ColumnDefault("0")
    private int mcANCVisit4;
    @ColumnDefault("0")
    private int mcBirthAtHomeWithTrainedPerson;
    @ColumnDefault("0")
    private int mcBirthAtHomeWithUntrainedPerson;
    @ColumnDefault("0")
    private int mcNormalBirthAtHospitalOrClinic;
    @ColumnDefault("0")
    private int mcCesareanBirthAtHospitalOrClinic;
    @ColumnDefault("0")
    private int mcIsDelivered;
    @ColumnDefault("0")
    private int mcAMTSL;
    @ColumnDefault("0")
    private int mcNoOxytocinAndMisoprostolgiven;
    @ColumnDefault("0")
    private int mcMotherPNCVisit1;
    @ColumnDefault("0")
    private int mcMotherPNCVisit2;
    @ColumnDefault("0")
    private int mcMotherPNCVisit3;
    @ColumnDefault("0")
    private int mcMotherPNCVisit4;
    @ColumnDefault("0")
    private int mcPNCCounselling;
    @ColumnDefault("0")
    private int mcChildPNCVisit1;
    @ColumnDefault("0")
    private int mcChildPNCVisit2;
    @ColumnDefault("0")
    private int mcChildPNCVisit3;
    @ColumnDefault("0")
    private int mcChildPNCVisit4;
    @ColumnDefault("0")
    private int mcReferredComplexPregnant;
    @ColumnDefault("0")
    private int mcReferredTotalComplexityCount;
    @ColumnDefault("0")
    private int mcReferredMgSO4Count;
    @ColumnDefault("0")
    private int mcReferredChildComplexityCount;
    @ColumnDefault("0")
    private int mcTTDoseOne;
    @ColumnDefault("0")
    private int mcTTDoseTwo;
    @ColumnDefault("0")
    private int mcTTDoseThree;
    @ColumnDefault("0")
    private int mcTTDoseFour;
    @ColumnDefault("0")
    private int mcTTDoseFive;
    @ColumnDefault("0")
    private int mcECPReceivedCount;
    @ColumnDefault("0")
    private int mcMisoprostolReceivedCount;
    @ColumnDefault("0")
    private int mcAdvisedIncompatibleCouple;
    @ColumnDefault("0")
    private int mcReferredIncompatibleCouple;
    @ColumnDefault("0")
    private int mcCounsellingOnChangesOfAdolescent;
    @ColumnDefault("0")
    private int mcCounsellingBadEffectOnChildMarriageAndTeenPregnancy;
    @ColumnDefault("0")
    private int mcCounsellingTeenagersOnTakingIronAndFolicAcid;
    @ColumnDefault("0")
    private int mcCounsellingOnInfectionOfDiseases;
    @ColumnDefault("0")
    private int mcSatelliteClinicPresence;
    @ColumnDefault("0")
    private int mcEPISessionPresence;
    @ColumnDefault("0")
    private int mcCommunityClinicPresence;

    public MaternityCareReport() {
        // TODO Auto-generated constructor stub
    }

    public int getMcCurrentNewPregnantCount() {
        return mcCurrentNewPregnantCount;
    }

    public void setMcCurrentNewPregnantCount(int mcCurrentNewPregnantCount) {
        this.mcCurrentNewPregnantCount = mcCurrentNewPregnantCount;
    }

    public int getMcCurrentOldPregnantCount() {
        return mcCurrentOldPregnantCount;
    }

    public void setMcCurrentOldPregnantCount(int mcCurrentOldPregnantCount) {
        this.mcCurrentOldPregnantCount = mcCurrentOldPregnantCount;
    }

    public int getMcCurrentTotalPregnantCount() {
        return mcCurrentTotalPregnantCount;
    }

    public void setMcCurrentTotalPregnantCount(int mcCurrentTotalPregnantCount) {
        this.mcCurrentTotalPregnantCount = mcCurrentTotalPregnantCount;
    }

    public int getMcPrevPregnantCount() {
        return mcPrevPregnantCount;
    }

    public void setMcPrevPregnantCount(int mcPrevPregnantCount) {
        this.mcPrevPregnantCount = mcPrevPregnantCount;
    }

    public int getMcTotalPregnantCount() {
        return mcTotalPregnantCount;
    }

    public void setMcTotalPregnantCount(int mcTotalPregnantCount) {
        this.mcTotalPregnantCount = mcTotalPregnantCount;
    }

    public int getMcANCVisit1() {
        return mcANCVisit1;
    }

    public void setMcANCVisit1(int mcANCVisit1) {
        this.mcANCVisit1 = mcANCVisit1;
    }

    public int getMcANCVisit2() {
        return mcANCVisit2;
    }

    public void setMcANCVisit2(int mcANCVisit2) {
        this.mcANCVisit2 = mcANCVisit2;
    }

    public int getMcANCVisit3() {
        return mcANCVisit3;
    }

    public void setMcANCVisit3(int mcANCVisit3) {
        this.mcANCVisit3 = mcANCVisit3;
    }

    public int getMcANCVisit4() {
        return mcANCVisit4;
    }

    public void setMcANCVisit4(int mcANCVisit4) {
        this.mcANCVisit4 = mcANCVisit4;
    }

    public int getMcBirthAtHomeWithTrainedPerson() {
        return mcBirthAtHomeWithTrainedPerson;
    }

    public void setMcBirthAtHomeWithTrainedPerson(
            int mcBirthAtHomeWithTrainedPerson) {
        this.mcBirthAtHomeWithTrainedPerson = mcBirthAtHomeWithTrainedPerson;
    }

    public int getMcBirthAtHomeWithUntrainedPerson() {
        return mcBirthAtHomeWithUntrainedPerson;
    }

    public void setMcBirthAtHomeWithUntrainedPerson(
            int mcBirthAtHomeWithUntrainedPerson) {
        this.mcBirthAtHomeWithUntrainedPerson = mcBirthAtHomeWithUntrainedPerson;
    }

    public int getMcNormalBirthAtHospitalOrClinic() {
        return mcNormalBirthAtHospitalOrClinic;
    }

    public void setMcNormalBirthAtHospitalOrClinic(
            int mcNormalBirthAtHospitalOrClinic) {
        this.mcNormalBirthAtHospitalOrClinic = mcNormalBirthAtHospitalOrClinic;
    }

    public int getMcCesareanBirthAtHospitalOrClinic() {
        return mcCesareanBirthAtHospitalOrClinic;
    }

    public void setMcCesareanBirthAtHospitalOrClinic(
            int mcCesareanBirthAtHospitalOrClinic) {
        this.mcCesareanBirthAtHospitalOrClinic = mcCesareanBirthAtHospitalOrClinic;
    }

    public int getMcIsDelivered() {
        return mcIsDelivered;
    }

    public void setMcIsDelivered(int mcIsDelivered) {
        this.mcIsDelivered = mcIsDelivered;
    }

    public int getMcAMTSL() {
        return mcAMTSL;
    }

    public void setMcAMTSL(int mcAMTSL) {
        this.mcAMTSL = mcAMTSL;
    }

    public int getMcNoOxytocinAndMisoprostolgiven() {
        return mcNoOxytocinAndMisoprostolgiven;
    }

    public void setMcNoOxytocinAndMisoprostolgiven(
            int mcNoOxytocinAndMisoprostolgiven) {
        this.mcNoOxytocinAndMisoprostolgiven = mcNoOxytocinAndMisoprostolgiven;
    }

    public int getMcMotherPNCVisit1() {
        return mcMotherPNCVisit1;
    }

    public void setMcMotherPNCVisit1(int mcMotherPNCVisit1) {
        this.mcMotherPNCVisit1 = mcMotherPNCVisit1;
    }

    public int getMcMotherPNCVisit2() {
        return mcMotherPNCVisit2;
    }

    public void setMcMotherPNCVisit2(int mcMotherPNCVisit2) {
        this.mcMotherPNCVisit2 = mcMotherPNCVisit2;
    }

    public int getMcMotherPNCVisit3() {
        return mcMotherPNCVisit3;
    }

    public void setMcMotherPNCVisit3(int mcMotherPNCVisit3) {
        this.mcMotherPNCVisit3 = mcMotherPNCVisit3;
    }

    public int getMcMotherPNCVisit4() {
        return mcMotherPNCVisit4;
    }

    public void setMcMotherPNCVisit4(int mcMotherPNCVisit4) {
        this.mcMotherPNCVisit4 = mcMotherPNCVisit4;
    }

    public int getMcPNCCounselling() {
        return mcPNCCounselling;
    }

    public void setMcPNCCounselling(int mcPNCCounselling) {
        this.mcPNCCounselling = mcPNCCounselling;
    }

    public int getMcChildPNCVisit1() {
        return mcChildPNCVisit1;
    }

    public void setMcChildPNCVisit1(int mcChildPNCVisit1) {
        this.mcChildPNCVisit1 = mcChildPNCVisit1;
    }

    public int getMcChildPNCVisit2() {
        return mcChildPNCVisit2;
    }

    public void setMcChildPNCVisit2(int mcChildPNCVisit2) {
        this.mcChildPNCVisit2 = mcChildPNCVisit2;
    }

    public int getMcChildPNCVisit3() {
        return mcChildPNCVisit3;
    }

    public void setMcChildPNCVisit3(int mcChildPNCVisit3) {
        this.mcChildPNCVisit3 = mcChildPNCVisit3;
    }

    public int getMcChildPNCVisit4() {
        return mcChildPNCVisit4;
    }

    public void setMcChildPNCVisit4(int mcChildPNCVisit4) {
        this.mcChildPNCVisit4 = mcChildPNCVisit4;
    }

    public int getMcReferredComplexPregnant() {
        return mcReferredComplexPregnant;
    }

    public void setMcReferredComplexPregnant(int mcReferredComplexPregnant) {
        this.mcReferredComplexPregnant = mcReferredComplexPregnant;
    }

    public int getMcReferredTotalComplexityCount() {
        return mcReferredTotalComplexityCount;
    }

    public void setMcReferredTotalComplexityCount(
            int mcReferredTotalComplexityCount) {
        this.mcReferredTotalComplexityCount = mcReferredTotalComplexityCount;
    }

    public int getMcReferredMgSO4Count() {
        return mcReferredMgSO4Count;
    }

    public void setMcReferredMgSO4Count(int mcReferredMgSO4Count) {
        this.mcReferredMgSO4Count = mcReferredMgSO4Count;
    }

    public int getMcReferredChildComplexityCount() {
        return mcReferredChildComplexityCount;
    }

    public void setMcReferredChildComplexityCount(
            int mcReferredChildComplexityCount) {
        this.mcReferredChildComplexityCount = mcReferredChildComplexityCount;
    }

    public int getMcTTDoseOne() {
        return mcTTDoseOne;
    }

    public void setMcTTDoseOne(int mcTTDoseOne) {
        this.mcTTDoseOne = mcTTDoseOne;
    }

    public int getMcTTDoseTwo() {
        return mcTTDoseTwo;
    }

    public void setMcTTDoseTwo(int mcTTDoseTwo) {
        this.mcTTDoseTwo = mcTTDoseTwo;
    }

    public int getMcTTDoseThree() {
        return mcTTDoseThree;
    }

    public void setMcTTDoseThree(int mcTTDoseThree) {
        this.mcTTDoseThree = mcTTDoseThree;
    }

    public int getMcTTDoseFour() {
        return mcTTDoseFour;
    }

    public void setMcTTDoseFour(int mcTTDoseFour) {
        this.mcTTDoseFour = mcTTDoseFour;
    }

    public int getMcTTDoseFive() {
        return mcTTDoseFive;
    }

    public void setMcTTDoseFive(int mcTTDoseFive) {
        this.mcTTDoseFive = mcTTDoseFive;
    }

    public int getMcECPReceivedCount() {
        return mcECPReceivedCount;
    }

    public void setMcECPReceivedCount(int mcECPReceivedCount) {
        this.mcECPReceivedCount = mcECPReceivedCount;
    }

    public int getMcMisoprostolReceivedCount() {
        return mcMisoprostolReceivedCount;
    }

    public void setMcMisoprostolReceivedCount(int mcMisoprostolReceivedCount) {
        this.mcMisoprostolReceivedCount = mcMisoprostolReceivedCount;
    }

    public int getMcAdvisedIncompatibleCouple() {
        return mcAdvisedIncompatibleCouple;
    }

    public void setMcAdvisedIncompatibleCouple(int mcAdvisedIncompatibleCouple) {
        this.mcAdvisedIncompatibleCouple = mcAdvisedIncompatibleCouple;
    }

    public int getMcReferredIncompatibleCouple() {
        return mcReferredIncompatibleCouple;
    }

    public void setMcReferredIncompatibleCouple(int mcReferredIncompatibleCouple) {
        this.mcReferredIncompatibleCouple = mcReferredIncompatibleCouple;
    }

    public int getMcCounsellingOnChangesOfAdolescent() {
        return mcCounsellingOnChangesOfAdolescent;
    }

    public void setMcCounsellingOnChangesOfAdolescent(
            int mcCounsellingOnChangesOfAdolescent) {
        this.mcCounsellingOnChangesOfAdolescent = mcCounsellingOnChangesOfAdolescent;
    }

    public int getMcCounsellingBadEffectOnChildMarriageAndTeenPregnancy() {
        return mcCounsellingBadEffectOnChildMarriageAndTeenPregnancy;
    }

    public void setMcCounsellingBadEffectOnChildMarriageAndTeenPregnancy(
            int mcCounsellingBadEffectOnChildMarriageAndTeenPregnancy) {
        this.mcCounsellingBadEffectOnChildMarriageAndTeenPregnancy = mcCounsellingBadEffectOnChildMarriageAndTeenPregnancy;
    }

    public int getMcCounsellingTeenagersOnTakingIronAndFolicAcid() {
        return mcCounsellingTeenagersOnTakingIronAndFolicAcid;
    }

    public void setMcCounsellingTeenagersOnTakingIronAndFolicAcid(
            int mcCounsellingTeenagersOnTakingIronAndFolicAcid) {
        this.mcCounsellingTeenagersOnTakingIronAndFolicAcid = mcCounsellingTeenagersOnTakingIronAndFolicAcid;
    }

    public int getMcCounsellingOnInfectionOfDiseases() {
        return mcCounsellingOnInfectionOfDiseases;
    }

    public void setMcCounsellingOnInfectionOfDiseases(
            int mcCounsellingOnInfectionOfDiseases) {
        this.mcCounsellingOnInfectionOfDiseases = mcCounsellingOnInfectionOfDiseases;
    }

    public int getMcSatelliteClinicPresence() {
        return mcSatelliteClinicPresence;
    }

    public void setMcSatelliteClinicPresence(int mcSatelliteClinicPresence) {
        this.mcSatelliteClinicPresence = mcSatelliteClinicPresence;
    }

    public int getMcEPISessionPresence() {
        return mcEPISessionPresence;
    }

    public void setMcEPISessionPresence(int mcEPISessionPresence) {
        this.mcEPISessionPresence = mcEPISessionPresence;
    }

    public int getMcCommunityClinicPresence() {
        return mcCommunityClinicPresence;
    }

    public void setMcCommunityClinicPresence(int mcCommunityClinicPresence) {
        this.mcCommunityClinicPresence = mcCommunityClinicPresence;
    }

}
