package com.dsic.FicheInfo.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.dsic.FicheInfo.dao.FicheRepository;
import com.dsic.FicheInfo.entities.Fiche;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {
	
	@Autowired
	private FicheRepository ficheRepository;
	@Autowired
	private ResourceLoader resourceLoader;
//	public String exportReport(String reportFormat,String fileInput,String fileOutput) throws JRException, IOException {
//		//Sort.by(Sort.Direction.DESC, "province"
//		List<Fiche> projets = ficheRepository.findAll();
//		String path = "C:\\report";
//		//File file =ResourceUtils.getFile("claasspath:projets.jrxml");
//	
//		final org.springframework.core.io.Resource fileResource = resourceLoader.getResource("classpath:allProjects.jrxml");
//		File file = fileResource.getFile();
//		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//
//		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(projets);
//		Map<String, Object> map = new HashMap<>();
//		map.put("CreatdBy", "Java techi");
//		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map,dataSource);
//		
//		 if(reportFormat.equalsIgnoreCase("pdf")){
//			
//			JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\projets4.pdf");
//		}
//		return "";
//	}
	public String exportReport(String reportFormat,String fileInput,String fileOutput) throws JRException, IOException {
		List<Fiche> projets = ficheRepository.findAll();
		String path = "C:\\report";
	//"C:\\allProjects.jrxml")
		JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(fileInput));

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(projets);
		Map<String, Object> map = new HashMap<>();
		map.put("CreatdBy", "Java techi");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map,dataSource);
		
		 if(reportFormat.equalsIgnoreCase("pdf")){
			// "\\allProjects.pdf"
			JasperExportManager.exportReportToPdfFile(jasperPrint,path+fileOutput);
		}
		return "";
	}


}
