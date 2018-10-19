package org.formation.spring.service;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.formation.spring.dao.CrudClientDAO;
import org.formation.spring.dao.CrudConseillerDAO;
import org.formation.spring.model.Ccp;
import org.formation.spring.model.Ce;
import org.formation.spring.model.Client;
import org.formation.spring.model.Conseiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * La classe ClientWebServiceImpl implémente l'interface ClientWebService avec toutes les méthodes du CRUD pour les classes Client et Conseiller, et également de pouvoir effectuer des virements, de compte courant à compte courant.
 * Les méthodes définies ici permettront l'utilisation en Webservice de l'application. Cela sera possible grace à un pluggin Rest sur notre navigateur.
 * 
 * @author Baggi/Bendou;
 *
 */
@Service("clientWebService")
public class CilentWebServiceImpl implements ClientWebService {

	// L'annotation @Autowired permet de laisser Spring créer des instances dont on a besoin, elle nous serviront notamment pour le CrudClientDAO et le CrudConseillerDAO pour pouvoir invoquer les méthodes de JPA Repository.
	@Autowired								
	private CrudClientDAO crudClientDAO;

	@Autowired
	private CrudConseillerDAO crudConseillerDAO;

	
	
	// ***********************************************************************
	// ***********************************************************************
	// METHODES DU CLIENT
	// ***********************************************************************
	// ***********************************************************************
	
	// Cette méthode getClient() permet de récupérer un client par son id via le pluggin Rest de notre navigateur.
	@Override
	public Client getClient(String id) {
		Long longId = Long.valueOf(id);
		Optional<Client> optional = crudClientDAO.findById(longId);

		return optional.get();
	}

	//Cette méthode permet de récupérer la liste de tous les clients.
	@Override
	public List<Client> getClients() {
		return crudClientDAO.findAll();
	}

	//Cette méthode mettra à jour Le client en renseignant les nouvelles infos à la place des anciennes.
	@Override
	public Response updateClient(Client client) {
		Client customerToUpdate = crudClientDAO.getOne(client.getId());
		Response response;
		if (customerToUpdate != null) {
			crudClientDAO.save(client);
			response = Response.ok(client).build();
		} else {
			response = Response.notModified("client non trouvé").build();
		}
		return response;
	}

	//Cette méthode sert à créer un client il suffit de renseigner tous les champs nécessaires et le message "Le client a bien été créé" s'affiche.
	@Override
	public Response addClient(Client client) {
		crudClientDAO.save(client);
		return Response.ok("Le client a bien été créé").build();
	}

	//Cette méthode permet de supprimer un client existant en renseignant son id dans l'url.
	@Override
	public Response deleteClientById(String id) {
		Long longId = Long.valueOf(id);

		crudClientDAO.deleteById(longId);

		return Response.ok("le client a été supprimé").build();
	}

	// ***********************************************************************
	// ***********************************************************************
	// METHODES DU CONSEILLER
	// ***********************************************************************
	// ***********************************************************************
	
	
	
	//Cette méthode permet de récupérer les infos d'un conseiller en renseignant sont id dans l'url.
	@Override
	public Conseiller getConseiller(String id) {
		Long longId = Long.valueOf(id);
		Optional<Conseiller> optional = crudConseillerDAO.findById(longId);
		return optional.get();
	}

	//Cette méthode permet de récupérer la liste de tous les conseillers. 
	@Override
	public List<Conseiller> getConseillers() {
		return crudConseillerDAO.findAll();
	}

	
	//Cette méthode permettra de mettre à jour un conseiller si besoin en renseignant ses nouvelles infos à la place des anciennes.
	@Override
	public Response updateConseiller(Conseiller conseiller) {

		Conseiller advisorToUpdate = crudConseillerDAO.getOne(conseiller.getId());
		Response response = null;
		if (advisorToUpdate != null) {
			crudConseillerDAO.save(conseiller);
			response = Response.ok(conseiller).build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	//Cette méthode permet d'ajouter un nouveau conseiller, une fois l'opération réussie, le message "Le conseiller a bien été créé" s'affiche.
	@Override
	public Response addConseiller(Conseiller conseiller) {
		crudConseillerDAO.save(conseiller);
		return Response.ok("Le conseiller a bien été créé").build();
	}

	//Cette méthode permet de supprimer un conseiller de la liste en renseignant son id dans l'url.
	@Override
	public Response deleteConseillers(String id) {
		Long longId = Long.valueOf(id);
		Conseiller conseillerAtrouver = crudConseillerDAO.getOne(longId);
		Response response = null;
		if (conseillerAtrouver != null) {
			crudConseillerDAO.deleteById(longId);
			response = Response.ok("le conseiller a été supprimé").build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	//Cette méthode permet de faire un virement du compte courant du client 1 (id1) au compte courant du client 2 (id2), il suffira de renseigner l'id1, l'id2 et le montant dans l'url.
	// Une fois le virement effectué, le message suivant s'affiche : ("Le virement de " + montant + " euros a bien été effectué").
	@Override
	public Response faireVirment(String id1, String id2, String montant) {

		Long longId = Long.valueOf(id1);
		Optional<Client> optional = crudClientDAO.findById(longId);
		Client a = optional.get();
		System.out.println(a.getCompteCourant().getSoldeBancaireCourant());
		Long longId2 = Long.valueOf(id2);
		Optional<Client> optional2 = crudClientDAO.findById(longId2);
		Client b = optional2.get();
		double montant2 = Double.valueOf(montant);
		Ccp cc = a.getCompteCourant();
		cc.setSoldeBancaireCourant(cc.getSoldeBancaireCourant() - montant2);
		Ccp ccp2 = b.getCompteCourant();
		ccp2.setSoldeBancaireCourant(ccp2.getSoldeBancaireCourant() + montant2);

		crudClientDAO.save(a);
		crudClientDAO.save(b);
		return Response.ok("Le virement de " + montant + " euros a bien été effectué").build();
	}

	@Override
	public Response faireVirmentce(String id1, String id2, String montant) {
		Long longId = Long.valueOf(id1);
		Optional<Client> optional = crudClientDAO.findById(longId);
		Client a = optional.get();
		System.out.println(a.getCompteEpargne().getSoldeBancaireEpagne());
		Long longId2 = Long.valueOf(id2);
		Optional<Client> optional2 = crudClientDAO.findById(longId2);
		Client b = optional2.get();
		double montant2 = Double.valueOf(montant);
		Ce cc = a.getCompteEpargne();
		cc.setSoldeBancaireEpagne(cc.getSoldeBancaireEpagne() - montant2);;
		Ce ccp2 = b.getCompteEpargne();
		ccp2.setSoldeBancaireEpagne(ccp2.getSoldeBancaireEpagne() + montant2);

		crudClientDAO.save(a);
		crudClientDAO.save(b);
		return Response.ok("Le virement de " + montant + " euros a bien été effectué").build();
	}

}
