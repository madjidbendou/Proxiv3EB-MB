package org.formation.spring.model;

import javax.persistence.Embeddable;

/**
 * La classe Ce correspond au compte épargne, il est 'embeddable' car c'est un attribut de Client, il se trouvera dans la même table dans la BDD. 
 * @author Baggi/Bendou;
 *
 */
@Embeddable
public class Ce {
	//Attributs
	private Long numeroCompteEpargne;
	private double soldeBancaireEpagne;
	
	//Constructeurs
	public Ce() {
		super();
	}
	
	public Ce(Long numeroCompteEpargne, double soldeBancaireEpagne) {
		super();
		this.numeroCompteEpargne = numeroCompteEpargne;
		this.soldeBancaireEpagne = soldeBancaireEpagne;
	}

	//Getters & setters
	public Long getNumeroCompteEpargne() {
		return numeroCompteEpargne;
	}
	public void setNumeroCompteEpargne(Long numeroCompteEpargne) {
		this.numeroCompteEpargne = numeroCompteEpargne;
	}
	public double getSoldeBancaireEpagne() {
		return soldeBancaireEpagne;
	}
	public void setSoldeBancaireEpagne(double soldeBancaireEpagne) {
		this.soldeBancaireEpagne = soldeBancaireEpagne;
	}
	
}
