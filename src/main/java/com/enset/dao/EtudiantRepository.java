package com.enset.dao;




import org.springframework.data.jpa.repository.JpaRepository;

import com.enset.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{

	
	
}

