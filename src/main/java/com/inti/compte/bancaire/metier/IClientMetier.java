package com.inti.compte.bancaire.metier;

import java.util.List;

import org.springframework.data.domain.Page;

import com.inti.compte.bancaire.entities.Client;
import com.inti.compte.bancaire.entities.Compte;

public interface IClientMetier {

	public Client consulterClient(Long codeClt);
	public void supprimerClient(Long codeClt);
	public Client ajouter(Client c);
	//public Client modifier(Client c);
	public Page<Client> listClients(String motCle,int page,int size);
	public List<Client> getAllClients() ;
	public Page<Compte> listComptes(Long codeClt,int page,int size);
	public List<Compte> listComptes();
}
