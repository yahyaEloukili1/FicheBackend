package com.dsic.FicheInfo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dsic.FicheInfo.entities.Fiche;
@CrossOrigin(origins = "*")
public interface FicheRepository extends JpaRepository<Fiche, Integer> {

	@RestResource(path= "/byFiche")
	public List<Fiche> findByNomContainsIgnoreCase(@Param("mc") String pr);
	
	@RestResource(path= "/byFichePage")
	public Page<Fiche> findByNomContainsIgnoreCase(@Param("mc") String pr,Pageable peaPageable);



}
