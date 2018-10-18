package org.formation.spring.model;

import javax.persistence.Embeddable;

/**
 * 
 * La classe Ccp correspond au compte courant
 * 
 * @author Baggi/Bendou
 *
 */
@Embeddable
public class Ccp {
	private Long numeroCompteCourant;
	private double soldeBancaireCourant;

	public Ccp() {
		super();
	}

	public Ccp(Long numeroCompteCourant, double soldeBancaireCourant) {
		super();
		this.numeroCompteCourant = numeroCompteCourant;
		this.soldeBancaireCourant = soldeBancaireCourant;
	}

	public Long getNumeroCompteCourant() {
		return numeroCompteCourant;
	}

	public void setNumeroCompteCourant(Long numeroCompteCourant) {
		this.numeroCompteCourant = numeroCompteCourant;
	}

	public double getSoldeBancaireCourant() {
		return soldeBancaireCourant;
	}

	public void setSoldeBancaireCourant(double soldeBancaireCourant) {
		this.soldeBancaireCourant = soldeBancaireCourant;
	}

}
