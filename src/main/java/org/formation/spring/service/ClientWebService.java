package org.formation.spring.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.formation.spring.model.Client;
//import org.formation.spring.model.Conseiller;
import org.formation.spring.model.Conseiller;

@Produces({"application/json","application/xml"})
@Consumes({"application/json","application/xml"})
@Path("/clientservice")
public interface ClientWebService {

	@GET
	@Path("/clients/{id}/")
	Client getClient(@PathParam("id") String id);

	@GET
	@Path("/clients/")
	List<Client> getClients();

	@PUT
	@Path("/clients/")
	Response updateClient(Client client);

	@POST
	@Path("/clients/")
	Response addClient(Client client);

	@DELETE
	@Path("/clients/{id}/")
	Response deleteClientById(@PathParam("id") String id);
	
	@GET
	@Path("/conseillers/{id}/")
	Conseiller getConseiller(@PathParam("id") String id);

	@GET
	@Path("/conseillers/")
	List<Conseiller> getConseillers();

	@PUT
	@Path("/conseillers/")
	Response updateConseiller(Conseiller conseiller);

	@POST
	@Path("/conseillers/")
	Response addConseiller(Conseiller conseiller);

	@DELETE
	@Path("/conseillers/{id}/")
	Response deleteConseillers(@PathParam("id") String id);
	
	@PUT
    @Path("/fairevirement/{id1}/{id2}/{montant}/")
    Response faireVirment(@PathParam("id1") String id1,@PathParam("id2") String id2,@PathParam("montant") String montant);

}
