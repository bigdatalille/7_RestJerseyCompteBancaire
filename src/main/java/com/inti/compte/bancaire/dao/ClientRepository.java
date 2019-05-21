package com.inti.compte.bancaire.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inti.compte.bancaire.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	@Query("select c from Client c  where c.nom like :x")
	  public Page<Client> listClients(@Param("x")String motCle,Pageable page);
	
	//List<Client> findByNom(String nom);
	
}
