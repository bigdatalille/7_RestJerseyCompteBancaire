package com.inti.compte.bancaire.metier;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.inti.compte.bancaire.dao.ClientRepository;
import com.inti.compte.bancaire.dao.CompteRepository;
import com.inti.compte.bancaire.entities.Client;
import com.inti.compte.bancaire.entities.Compte;

@Service
@Transactional
public class ClientMetierImpl implements IClientMetier {

	@Autowired
	ClientRepository clientRepository;
	@Autowired
	CompteRepository compteRepository;
	
	@Override
	public Client consulterClient(Long codeClt) {
		//return clientRepository.findOne(codeClt);
		return clientRepository.findById(codeClt).get();
	}

	@Override
	public void supprimerClient(Long codeClt) {
	//	clientRepository.delete(codeClt);
		clientRepository.deleteById(codeClt);
		
	}

	@Override
	public Client ajouter(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public Page<Compte> listComptes(Long codeClt,int page, int size) {	
		return compteRepository.listComptes(codeClt, new PageRequest(page, size)) ;
	}

	@Override
	public Page<Client> listClients(String motCle, int page, int size) {	
		return clientRepository.listClients(motCle, new PageRequest(page, size));
	}

	@Override
	public List<Compte> listComptes() {
		// TODO Auto-generated method stub
		return compteRepository.findAll();
	}

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

}
