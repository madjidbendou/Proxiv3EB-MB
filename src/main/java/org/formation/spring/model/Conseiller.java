package org.formation.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * 
 * Ceci est la classe Conseiller, elle aura sa propre table dans la base de
 * données. Les clients ne sont pas encore reliés au conseiller, cela est en
 * cours dans une autre branche de Git 'clientrelieconseiller'.
 * 
 * @author Baggi/Bendou;
 *
 */
@XmlRootElement
@Entity
public class Conseiller {

	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	private String login;
	private String password;


	// Constructeurs

	public Conseiller(String nom, String prenom, String login, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}

	public Conseiller() {
		super();
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
