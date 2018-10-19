package org.formation.spring.model;

import javax.persistence.Embeddable;

/**
 * La classe Ce correspond au compte épargne, il est 'embeddable' car c'est un attribut de Client, il se trouvera dans la même table dans la BDD. 
 * @author Baggi/Bendou;
 *
 */
@Embeddable
public class Ce {
	private Long numeroCompteEpargne;
	private double soldeBancaireEpagne;
	
	public Ce() {
		super();
	}
	
	public Ce(Long numeroCompteEpargne, double soldeBancaireEpagne) {
		super();
		this.numeroCompteEpargne = numeroCompteEpargne;
		this.soldeBancaireEpagne = soldeBancaireEpagne;
	}

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
