package com.enset;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.enset.dao.EtudiantRepository;
import com.enset.entities.Etudiant;

/*
 * login:admin
 * pwd:1964
 * 
 * http://localhost:8080/listEtudiants.html
 * https://localhost:8080/etudiants?page=1&size=3
 * http://localhost:8080/saveEtudiant?nom=mpassy&prenom=andre
 */

@SpringBootApplication
public class SpringSecuriteApplication {

	public static void main(String[] args) throws ParseException {
		//SpringApplication.run(SpringSecuriteApplication.class, args);
		ApplicationContext ctx = SpringApplication.run(SpringSecuriteApplication.class, args);
		EtudiantRepository etudiantRepository = ctx.getBean(EtudiantRepository.class);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		etudiantRepository.save(new Etudiant("mpassy", "roger", df.parse("1964-03-02")));
		etudiantRepository.save(new Etudiant("mpassy", "eliane", df.parse("1965-11-27")));
		etudiantRepository.save(new Etudiant("mpassy", "myriam", df.parse("1994-08-28")));
		etudiantRepository.save(new Etudiant("mpassy", "william", df.parse("1998-07-25")));
		
		List <Etudiant> etds = etudiantRepository.findAll();
		etds.forEach(e->System.out.println(e.getNom()));
	}

}
