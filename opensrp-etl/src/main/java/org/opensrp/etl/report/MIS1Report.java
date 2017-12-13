package org.opensrp.etl.report;

public class MIS1Report {

    private int division;
    private int district;
    private int upazilla;
    private int ward;
    private int union;
    private int unit;
	private FamilyPlanningReport familyPlanningReport;
    //private MaternityCareReport maternityCareReport;
    //private BirthAndDeathReport birthAndDeathReport;
    //private ChildCareReport childCareReport;
    //private NutritionReport nutritionReport;

	public MIS1Report() {
		// TODO Auto-generated constructor stub
	}

	public FamilyPlanningReport getFamilyPlanningReport() {
		return familyPlanningReport;
	}

	public void setFamilyPlanningReport(FamilyPlanningReport familyPlanningReport) {
		this.familyPlanningReport = familyPlanningReport;
	}

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public int getUpazilla() {
        return upazilla;
    }

    public void setUpazilla(int upazilla) {
        this.upazilla = upazilla;
    }

    public int getWard() {
        return ward;
    }

    public void setWard(int ward) {
        this.ward = ward;
    }

    public int getUnion() {
        return union;
    }

    public void setUnion(int union) {
        this.union = union;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

}
