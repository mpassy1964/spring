package com.enset.service;

import java.util.List;

import com.enset.dao.EtudiantRepository;
import com.enset.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EtudiantRestService {
	
	
	@Autowired
	private EtudiantRepository etudiantRepository;	
	@Secured(value= {"ROLE_ADMIN","ROLE_SCOLARITE"})
	@RequestMapping(value="/saveEtudiant", method=RequestMethod.GET)
	public Etudiant SaveEtudiant(Etudiant e) {
		return etudiantRepository.save(e);
		
	}
	@Secured(value= {"ROLE_ADMIN","ROLE_SCOLARITE","ROLE_PROF","ROLE_ETUDIANT"})
	@RequestMapping(value="/etudiants")
	public List<Etudiant> listEtudiants(int page, int size){
		return etudiantRepository.findAll();
		
	}
	
}
