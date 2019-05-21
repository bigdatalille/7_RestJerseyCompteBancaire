package com.inti.compte.bancaire.entities;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double decouvert;
	
	public CompteCourant() {
		super();
	}

	public CompteCourant(String code, double solde, Date dateCreation, Client client,
			double decouvert) {
		super(code, solde, dateCreation, client);
		this.decouvert = decouvert;
	}
	public CompteCourant(double solde, Date dateCreation, Client client,
			double decouvert) {
		super(solde, dateCreation, client);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	
	
	
	

	
}
