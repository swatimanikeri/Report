package com.project.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.service.demoSer;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;

@RestController
public class demoCont {
	@Autowired
	private demoSer demoSer;
	
//	@GetMapping("/report/{format}")
//public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
//	return demoSer.exportReport(format);
//}
	@GetMapping("/jasperpdf/export")
	public void createPDF(HttpServletResponse response) throws JRException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");

		String currentDateTime =dateformatter.format(new Date());
		String headerKey = "Content-Disposition";

		String headerValue ="attachment;filename=pdf_"+ currentDateTime + ".pdf";
				response.setHeader(headerKey, headerValue);
				demoSer.exportJasperReport(response);
		
	}
}
