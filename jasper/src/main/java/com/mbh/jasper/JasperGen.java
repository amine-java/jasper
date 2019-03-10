package com.mbh.jasper;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

public class JasperGen {
	
	public static void generate(Collection<Map<String, ?>> params , String jasperFile , String resultFileName) throws JRException {
		 JasperReport jasperReport = JasperCompileManager
	               .compileReport("C:\\Users\\boufatah\\projets\\workspace\\jasper\\jasper\\src\\main\\resources\\reports\\"+jasperFile);
	 
	       JRDataSource dataSource = new JRMapCollectionDataSource(params);
	 
	       // Parameters for report
	       Map<String, Object> parameters = new HashMap<String, Object>();
	       parameters.put("auteur", "Amine BOUFATAH");
	       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
	    		   parameters, dataSource);
	       
	       exportToPdf(resultFileName, jasperPrint);
	}
	
	public static void generate(List<?> objects , String jasperFile , String resultFileName) throws JRException {
		 JasperReport jasperReport = JasperCompileManager
	               .compileReport("C:\\Users\\boufatah\\projets\\workspace\\jasper\\jasper\\src\\main\\resources\\reports\\"+jasperFile);
	 

	       JRDataSource dataSource = new JRBeanCollectionDataSource(objects);
	 
	       // Parameters for report
	       Map<String, Object> parameters = new HashMap<String, Object>();
	       parameters.put("auteur", "Amine BOUFATAH");
	       
	       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
	    		   parameters, dataSource);
	    
	      exportToPdf(resultFileName, jasperPrint);
	}
	
	private static void exportToPdf(String resultFileName , JasperPrint jasperPrint ) throws JRException {

	       // Make sure the output directory exists.
	       File outDir = new File("C:/jasperoutput");
	       outDir.mkdirs();
	       // Export to PDF
	       JasperExportManager.exportReportToPdfFile(jasperPrint,
	               "C:/jasperoutput/"+resultFileName+".pdf");
	}

}
