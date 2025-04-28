package com.project.service;

import java.awt.Image;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;


import com.project.repository.*;

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

import com.project.entity.AlumniContributionEntity;
import com.project.entity.*;

@Service
public class mainRepoSer {
	@Autowired
	private compesaRepo compesaRepo;
	@Autowired
	private ExpLecRepo  ExpLecRepo;
	@Autowired
	private AlumniContributionRepo AlumniContributionRepo;
	@Autowired
	private FacultyPaparRepo FacultyPaparRepo;
	@Autowired
	private SponsoredProjectRepo SponsoredProjectRepo;

	public void exportJasperReport(HttpServletResponse response,LocalDate startDate, LocalDate endDate) throws JRException, IOException {
		Date startUtilDate = java.sql.Date.valueOf(startDate);
	    Date endUtilDate = java.sql.Date.valueOf(endDate);

		//for main report
		File mainFile = ResourceUtils.getFile("classpath:mainReport.jrxml");
		JasperReport mainReport = JasperCompileManager.compileReport(mainFile.getAbsolutePath());
		Map<String, Object> mainParams = new HashMap<>();
		//for compesa
//		List<CompesaCsi> repo1=compesaRepo.findAll();
		List<CompesaCsi> repo1 = compesaRepo.findByDateBetween(startUtilDate, endUtilDate);

		if (repo1.isEmpty()) {
		    System.out.println("No data found!");
		    response.getWriter().write("Report generation failed: No data found.");
		    return;
		}
		System.out.println("Data size: " + repo1.size());  // Debugging
		for (CompesaCsi c : repo1) {
		    System.out.println(c);  // Print each record to verify
		}
	
		
       //for compesa
		File subFile1 = ResourceUtils.getFile("classpath:compesaReport.jrxml");
		JasperReport compesaReport = JasperCompileManager.compileReport(subFile1.getAbsolutePath());
		
	     JRDataSource dataSource1=new JRBeanCollectionDataSource(repo1);
	
		Map<String, Object> subreportParams1 = new HashMap<>();
		
		
		subreportParams1.put("createdBy", "Shreya");
		Image image1 = repo1.get(0).getImage1AsAwt(); // If you are using image from the entity
		Image image2 = repo1.get(0).getImage2AsAwt();
		subreportParams1.put("image1Param", image1);
		subreportParams1.put("image2Param", image2);
		subreportParams1.put("SUBREPORT_DATASOURCE", dataSource1);
		mainParams.put("compesaReport", compesaReport);
//		mainParams.put("SUBREPORT_DATASOURCE", new JRBeanCollectionDataSource(Demo));
		mainParams.put("compesaMap", subreportParams1); // Proper separate sub-map

	
		//for Exp lec
//		List<ExpLecEntity> repo2=ExpertlecReport.findAll();
		List<ExpLecEntity> repo2 = ExpLecRepo.findByDateBetween(startUtilDate, endUtilDate);


	    
	File subFile2 = ResourceUtils.getFile("classpath:expReport.jrxml");
		JasperReport expReport = JasperCompileManager.compileReport(subFile2.getAbsolutePath());
		
	     JRDataSource dataSource2=new JRBeanCollectionDataSource(repo2);
	
	Map<String, Object> subreportParams2 = new HashMap<>();
	if (repo2.isEmpty()) {
	    System.out.println("No data found!");
	    response.getWriter().write("Report generation failed: No data found.");
	    return;
	}
	System.out.println("Data size: " + repo2.size());  // Debugging
	for (ExpLecEntity c : repo2) {
	    System.out.println(c);  // Print each record to verify
	}

//		subreportParams1.put("createdBy", "Shreya");
		Image image3 = repo2.get(0).getImage1AsAwt(); // If you are using image from the entity
		Image image4 = repo2.get(0).getImage2AsAwt();
		subreportParams2.put("image3param", image3);
		subreportParams2.put("image4param", image4);
		subreportParams2.put("EXREPORT", dataSource2);
		mainParams.put("expReport", expReport);
//		mainParams.put("SUBREPORT_DATASOURCE", new JRBeanCollectionDataSource(Demo));
		mainParams.put("expMap", subreportParams2); // Proper separate sub-map

		//for Alumni Contribution
//		List<AlumniContributionEntity> repo3=AlumniContributionRepo.findAll();
	List<AlumniContributionEntity> repo3=AlumniContributionRepo.findByDateBetween(startUtilDate, endUtilDate);
		File subFile3 = ResourceUtils.getFile("classpath:alumniReport.jrxml");
			JasperReport alumniReport = JasperCompileManager.compileReport(subFile3.getAbsolutePath());
			
		     JRDataSource dataSource3=new JRBeanCollectionDataSource(repo3);
		
		Map<String, Object> subreportParams3 = new HashMap<>();
		if (repo3.isEmpty()) {
		    System.out.println("No data found!");
		    response.getWriter().write("Report generation failed: No data found.");
		    return;
		}
		System.out.println("Data size: " + repo3.size());  // Debugging
		for (AlumniContributionEntity c : repo3) {
		    System.out.println(c);  // Print each record to verify
		}


			Image image5 = repo3.get(0).getImage1AsAwt(); // If you are using image from the entity
			Image image6 = repo3.get(0).getImage2AsAwt();
			subreportParams3.put("image5param", image5);
			subreportParams3.put("image6param", image6);
			subreportParams3.put("ALMREPORT", dataSource3);
			mainParams.put("alumniReport", alumniReport);
			mainParams.put("alumniMap", subreportParams3); // Proper separate sub-map

		//for Faculty Paper Publication details reports
			List<FacultyPaparEntity> repo4=FacultyPaparRepo.findByDateBetween(startUtilDate, endUtilDate);
				File subFile4 = ResourceUtils.getFile("classpath:fapaReport.jrxml");
					JasperReport fapaReport = JasperCompileManager.compileReport(subFile4.getAbsolutePath());
					
				     JRDataSource dataSource4=new JRBeanCollectionDataSource(repo4);
				
				Map<String, Object> subreportParams4 = new HashMap<>();
				if (repo4.isEmpty()) {
				    System.out.println("No data found!");
				    response.getWriter().write("Report generation failed: No data found.");
				    return;
				}
				System.out.println("Data size: " + repo4.size());  // Debugging
				for (FacultyPaparEntity c : repo4) {
				    System.out.println(c);  // Print each record to verify
				}
				
					Image image7 = repo4.get(0).getImage1AsAwt(); // If you are using image from the entity
					Image image8 = repo4.get(0).getImage2AsAwt();
					subreportParams4.put("image7param", image7);
					subreportParams4.put("image8param", image8);
					subreportParams4.put("FAPAREPORT", dataSource4);
					mainParams.put("fapaReport", fapaReport);
					mainParams.put("fapaMap", subreportParams4); // Proper separate sub-map
					
//for Sponsored Project
					
					List<SponsoredProjectEntity> repo5=SponsoredProjectRepo.findByDateBetween(startUtilDate, endUtilDate);
					File subFile5 = ResourceUtils.getFile("classpath:sponpro.jrxml");
						JasperReport sopoReport = JasperCompileManager.compileReport(subFile5.getAbsolutePath());
						
					     JRDataSource dataSource5=new JRBeanCollectionDataSource(repo5);
					
					Map<String, Object> subreportParams5 = new HashMap<>();
					if (repo5.isEmpty()) {
					    System.out.println("No data found!");
					    response.getWriter().write("Report generation failed: No data found.");
					    return;
					}
					System.out.println("Data size: " + repo5.size());  // Debugging
					for (SponsoredProjectEntity c : repo5) {
					    System.out.println(c);  // Print each record to verify
					}
					
						Image image9 = repo5.get(0).getImage1AsAwt(); // If you are using image from the entity
						Image image10 = repo5.get(0).getImage2AsAwt();
						subreportParams5.put("image9param", image9);
						subreportParams5.put("image10param", image10);
						subreportParams5.put("SPONPROREPORT", dataSource5);
						mainParams.put("sopoReport", sopoReport);
						mainParams.put("sopoMap", subreportParams5); // Proper separate sub-map
		
		
		
//generating jasper pdf
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
