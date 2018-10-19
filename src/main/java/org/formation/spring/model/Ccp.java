package org.formation.spring.model;

import javax.persistence.Embeddable;

/**
 * 
 * La classe Ccp correspond au compte courant, il est 'embeddable' car c'est un attribut de Client, il se trouvera dans la même table dans la BDD.
 * 
 * @author Baggi/Bendou;
 *
 */
@Embeddable
public class Ccp {
	//Attributs
	private Long numeroCompteCourant;
	private double soldeBancaireCourant;

	//Constructeurs
	public Ccp() {
		super();
	}

	public Ccp(Long numeroCompteCourant, double soldeBancaireCourant) {
		super();
		this.numeroCompteCourant = numeroCompteCourant;
		this.soldeBancaireCourant = soldeBancaireCourant;
	}

	//Getters & setters
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
