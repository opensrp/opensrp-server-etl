package org.mcare.reports;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import javax.transaction.Transactional;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

import org.mcare.common.repository.impl.DatabaseRepositoryImpl;
import org.mcare.etl.entity.MotherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotherReport {

	@Autowired
	private DatabaseRepositoryImpl databaseRepositoryImpl;

	public MotherReport() {
		// TODO Auto-generated constructor stub
	}

	public void createReport() {

		JasperReportBuilder report = DynamicReports.report();

		Columns.column("Mother Id", "id", DataTypes.integerType());

		List<MotherEntity> mothers = findAllMother();
		report
		.columns(
				Columns.column("Mother Id", "id", DataTypes.integerType()),
				Columns.column("First Name", "firstName", DataTypes.stringType()),
				Columns.column("GOB HHID","motherGOBHHID", DataTypes.stringType()))
				.title(//title of the report
						Components.text("SimpleReportExample")
						.setHorizontalAlignment(HorizontalAlignment.CENTER))
						.pageFooter(Components.pageXofY())//show page number on the page footer
						.setDataSource(mothers);



		try {
			//show the report
			report.show();

			//export the report to a pdf file
			report.toPdf(new FileOutputStream("/home/asha/Downloads/report.pdf"));
		} catch (DRException e) {
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	@Transactional
	public List<MotherEntity> findAllMother() {
		return databaseRepositoryImpl.findAll("mother");
	}

}
