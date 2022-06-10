package com.dsic.FicheInfo.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dsic.FicheInfo.dao.FicheRepository;
import com.dsic.FicheInfo.entities.Fiche;
import com.dsic.FicheInfo.services.ReportService;

import net.sf.jasperreports.engine.JRException;

@CrossOrigin("*")
@RestController
public class FicheController {

	@Autowired
	FicheRepository ficheRepository;
	@Autowired
	ReportService reportService;
//	@GetMapping("/report/{format}")
//	public String generateReport(@PathVariable String format) throws JRException, IOException  {
//		return reportService.exportReport(format);
//	}
	@GetMapping("/report/{format}")
	public String generateReport(@PathVariable String format) throws JRException, IOException  {
		return reportService.exportReport(format,"C:\\allProjets.jrxml","\\allFichess.pdf");
	}
	
	@GetMapping(path="photoFiche/{id}",produces=org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	public byte[] getPhoto(@PathVariable("id") int id) throws IOException {
		Fiche f = ficheRepository.findById(id).get();
		return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ficheInfo/"+f.getPhoto()));
	}
	@PostMapping("/uploadPhoto/{id}")
	public void handleFileUpload(MultipartFile file,@PathVariable("id") int id) throws IOException {
		Fiche f = ficheRepository.findById(id).get();
		f.setPhoto(id+".jpg");
		Files.write(Paths.get(System.getProperty("user.home")+"/ficheInfo/"+f.getPhoto()),file.getBytes());
		ficheRepository.save(f);
	}
	@PostMapping("/fiches2")
	public Fiche saveFile(@RequestBody Fiche fiche) {
		fiche.setPhoto("unknown.jpeg");
		return ficheRepository.save(fiche);
	}
}