package com.project.service;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.project.repository.compesaRepo;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.project.entity.CompesaCsi;

@Service
public class demoSer {
	@Autowired
	private compesaRepo repository;

	public void exportJasperReport(HttpServletResponse response) throws JRException, IOException {
		List<CompesaCsi> Demo=repository.findAll();
		if (Demo.isEmpty()) {
		    System.out.println("No data found!");
		    response.getWriter().write("Report generation failed: No data found.");
		    return;
		}

		System.out.println("Data size: " + Demo.size());  // Debugging
		for (CompesaCsi c : Demo) {
		    System.out.println(c);  // Print each record to verify
		}
		
		File mainFile = ResourceUtils.getFile("classpath:mainReport.jrxml");
		JasperReport mainReport = JasperCompileManager.compileReport(mainFile.getAbsolutePath());

		File subFile = ResourceUtils.getFile("classpath:compesaReport.jrxml");
		JasperReport compesaReport = JasperCompileManager.compileReport(subFile.getAbsolutePath());

		JRDataSource dataSource=new JRBeanCollectionDataSource(Demo);
		Map<String, Object> mainParams = new HashMap<>();


		Map<String, Object> subreportParams = new HashMap<>();
		subreportParams.put("createdBy", "Shreya");

		Image image1 = Demo.get(0).getImage1AsAwt(); // If you are using image from the entity
		Image image2 = Demo.get(0).getImage2AsAwt();
		subreportParams.put("image1Param", image1);
		subreportParams.put("image2Param", image2);
		mainParams.put("compesaReport", compesaReport);
//		mainParams.put("SUBREPORT_DATASOURCE", new JRBeanCollectionDataSource(Demo));
		
		
		mainParams.put("compesaMap", subreportParams); // Proper separate sub-map
		subreportParams.put("SUBREPORT_DATASOURCE", dataSource);

		JasperPrint jasperPrint = JasperFillManager.fillReport(mainReport, mainParams, new JREmptyDataSource());

//		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
		
		if (jasperPrint.getPages().isEmpty()) {
		    response.getWriter().write("Report was generated but contains no pages.");
		    return;
		} else {
		    System.out.println("✅ Report generated successfully with " + jasperPrint.getPages().size() + " pages.");
		}

	}

}
