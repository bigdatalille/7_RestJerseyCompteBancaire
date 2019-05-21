package com.inti.compte.bancaire.metier;

import java.util.List;

import org.springframework.data.domain.Page;

import com.inti.compte.bancaire.entities.Compte;
import com.inti.compte.bancaire.entities.Operation;

public interface IBanqueMetier {

	public Compte consulterCompte(String codeCte);
	public Compte ajouterCompte(Compte compte);
	public void verser(String codeCte,double montant);
	public void retirer(String codeCte,double montant);
	public void virement(String codeCte1,String codeCte2,double montant);
	public Page<Operation> listOperation(String codeCte,int page,int size);
	public List<Operation> listOperation();
	
}
