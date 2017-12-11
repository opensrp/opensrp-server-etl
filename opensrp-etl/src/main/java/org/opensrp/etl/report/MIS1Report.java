package org.opensrp.etl.report;

public class MIS1Report {

	private FamilyPlanningReport familyPlanningReport;
    private MaternityCareReport maternityCareReport;
    private BirthAndDeathReport birthAndDeathReport;
    private ChildCareReport childCareReport;
    private NutritionReport nutritionReport;

	public MIS1Report() {
		// TODO Auto-generated constructor stub
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

}
