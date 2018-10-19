package org.formation.spring.service;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.formation.spring.dao.CrudClientDAO;
import org.formation.spring.dao.CrudConseillerDAO;
import org.formation.spring.model.Ccp;
import org.formation.spring.model.Client;
import org.formation.spring.model.Conseiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clientWebService")
public class CilentWebServiceImpl implements ClientWebService {

	@Autowired
	private CrudClientDAO crudClientDAO;

	@Autowired
	private CrudConseillerDAO crudConseillerDAO;

	@Override
	public Client getClient(String id) {
		Long longId = Long.valueOf(id);
		Optional<Client> optional = crudClientDAO.findById(longId);

		return optional.get();
	}

	@Override
	public List<Client> getClients() {
		return crudClientDAO.findAll();
	}

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

	@Override
	public Response addClient(Client client) {
		crudClientDAO.save(client);
		return Response.ok("Le client a bien été créé").build();
	}

	@Override
	public Response deleteClientById(String id) {
		Long longId = Long.valueOf(id);

		crudClientDAO.deleteById(longId);

		return Response.ok("le client a été supprimé").build();
	}

// **********************************************************************
	// ***********************************************************************
	// Conseiller méthodes
	@Override
	public Conseiller getConseiller(String id) {
		Long longId = Long.valueOf(id);
		Optional<Conseiller> optional = crudConseillerDAO.findById(longId);
		return optional.get();
	}

	@Override
	public List<Conseiller> getConseillers() {
		return crudConseillerDAO.findAll();
	}

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

	@Override
	public Response addConseiller(Conseiller conseiller) {
		crudConseillerDAO.save(conseiller);
		return Response.ok("Le conseiller a bien été créé").build();
	}

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

	@Override
	public Response faireVirment(String id1, String id2, String montant) {
		
		Long longId = Long.valueOf(id1);
		Optional<Client> optional = crudClientDAO.findById(longId);
		Client a= optional.get();
		System.out.println(a.getCompteCourant().getSoldeBancaireCourant());
		Long longId2 = Long.valueOf(id2);
		Optional<Client> optional2 = crudClientDAO.findById(longId2);
		Client b= optional2.get();
		double montant2 = Double.valueOf(montant);
		Ccp cc = a.getCompteCourant();
		cc.setSoldeBancaireCourant(cc.getSoldeBancaireCourant() - montant2);
		Ccp ccp2 = b.getCompteCourant();
		ccp2.setSoldeBancaireCourant(ccp2.getSoldeBancaireCourant() + montant2);

		crudClientDAO.save(a);
		crudClientDAO.save(b);
		return Response.ok("Le virement de "+montant+" euros a bien été effectué").build();
	}

}
