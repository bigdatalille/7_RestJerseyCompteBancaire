package com.inti.compte.bancaire;

import java.util.Date;

import com.inti.compte.bancaire.dao.ClientRepository;
import com.inti.compte.bancaire.dao.CompteRepository;
import com.inti.compte.bancaire.dao.OperationRepository;
import com.inti.compte.bancaire.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.inti.compte.bancaire.entities.Client;
import com.inti.compte.bancaire.entities.Compte;
import com.inti.compte.bancaire.entities.CompteCourant;
import com.inti.compte.bancaire.entities.CompteEpargne;
import com.inti.compte.bancaire.entities.Operation;
import com.inti.compte.bancaire.entities.Retrait;
import com.inti.compte.bancaire.entities.Versement;


@SpringBootApplication
public class Application implements CommandLineRunner {

	
	
	@Autowired
	private  ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private  IBanqueMetier iBanqueMetier;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Client c1=clientRepository.save(new Client("Alaoui1",null));
		Client c2=clientRepository.save(new Client("Mahdoui",null));
	
		Compte cp1=compteRepository.save(new CompteCourant("cp1", 2000, new Date(), c1,100));
		Compte cp2=compteRepository.save(new CompteEpargne("cp2", 12000, new Date(), c1,100));
		Compte cp3=compteRepository.save(new CompteCourant("cp3", 45000, new Date(), c2,100));
		Compte cp4=compteRepository.save(new CompteEpargne("cp4", 98000, new Date(), c2,100));
		
		Operation op1=operationRepository.save(new Retrait(new Date(), 100, cp1));
		Operation op2=operationRepository.save(new Versement(new Date(), 200, cp1));
		Operation op3=operationRepository.save(new Retrait(new Date(), 300, cp2));
		Operation op4=operationRepository.save(new Versement(new Date(), 600, cp2));
		Operation op5=operationRepository.save(new Retrait(new Date(), 200, cp3));
		Operation op6=operationRepository.save(new Versement(new Date(), 300, cp4));
		
		iBanqueMetier.verser("cp1", 5455555);
		iBanqueMetier.verser("cp2", 555); 
		
		System.out.println("Hello app HAL jersey ");
	}
}
