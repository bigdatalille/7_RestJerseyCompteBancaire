package com.inti.compte.bancaire.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OP",discriminatorType=DiscriminatorType.STRING,length=1)
public abstract class Operation implements Serializable {
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long numero ;
	private Date dateOp;
    private double montant;
    @ManyToOne
    @JoinColumn(name="CODE_CPT")
    private Compte compte;
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operation(Long numero, Date dateOp, double montant, Compte compte) {
		super();
		this.numero = numero;
		this.dateOp = dateOp;
		this.montant = montant;
		this.compte = compte;
	}
	
	
	public Operation(Date dateOp, double montant, Compte compte) {
		super();
		this.dateOp = dateOp;
		this.montant = montant;
		this.compte = compte;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Date getDateOp() {
		return dateOp;
	}
	public void setDateOp(Date dateOp) {
		this.dateOp = dateOp;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
    
    
	
}
