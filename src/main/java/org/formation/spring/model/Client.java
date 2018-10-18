package org.formation.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE })
	@JoinColumn(name = "id_Conseiller")
	private Conseiller conseiller;
	@Embedded
	private Ce compteEpargne;
	@Embedded
	private Ccp compteCourant;

	public Client() {
		super();
	}

	public Client(String nom, String prenom, String email, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
	}

	public Client(String nom, String prenom, String email, String adresse, Conseiller conseiller, Ce compteEpargne,
			Ccp compteCourant) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.conseiller = conseiller;
		this.compteEpargne = compteEpargne;
		this.compteCourant = compteCourant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public Ce getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(Ce compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	public Ccp getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(Ccp compteCourant) {
		this.compteCourant = compteCourant;
	}

}
