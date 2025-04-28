package com.project.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.ExpLecEntity;
import com.project.service.ExpLecService;
import com.project.service.mainRepoSer;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;

@RestController
public class demoCont {
	@Autowired
	private mainRepoSer mainRepoSer;
	
//	@GetMapping("/report/{format}")
//public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
//	return demoSer.exportReport(format);
//}
	
	
	@GetMapping("/jasperpdf/export")
	public void createPDF( @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
	        @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
			HttpServletResponse response) throws JRException, IOException {
		
		response.setContentType("application/pdf");
		DateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");

		String currentDateTime =dateformatter.format(new Date());
		  // Content-Disposition set to 'attachment' for downloading
		String headerKey = "Content-Disposition";

		  String headerValue = "inline; filename=report_preview.pdf"; 
//		String headerValue ="attachment;filename=pdf_"+ currentDateTime + ".pdf"; // File will be downloaded
				response.setHeader(headerKey, headerValue);
//				mainRepoSer.exportJasperReport(response);
				
				  // Generate and send the PDF content
			    mainRepoSer.exportJasperReport(response, startDate, endDate); 
	}
	
	
}
