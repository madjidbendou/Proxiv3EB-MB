package org.formation.spring.model;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * 
 * Ceci est la classe Client elle permet d'instancier des clients et de pouvoir
 * leur attribuer un compte courant et un compte epargne lors de la création.
 * Les comptes seront supprimés si le client est supprimé.
 * 
 * @author Baggi/Bendou;
 *
 */
@XmlRootElement
@Entity
public class Client {
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;


// Les comptes ne pourront pas exister sans le client en base de donnée. Il seront dans la même table.

	@Embedded
	private Ce compteEpargne;
	@Embedded
	private Ccp compteCourant;

	// Constructeurs
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

	public Client(String nom, String prenom, String email, String adresse, Ce compteEpargne, Ccp compteCourant) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.compteEpargne = compteEpargne;
		this.compteCourant = compteCourant;
	}

	// Getters & setters
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
