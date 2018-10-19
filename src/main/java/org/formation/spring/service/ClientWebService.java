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
import org.formation.spring.model.Conseiller;

/**
 * L'interface ClientWebService définit les méthodes que l'on va utiliser en
 * Rest sur un pluggin Rest de notre navigateur. Les'annotations @ GET,@
 * POST,etc sont les verbes utilisés avec le pluggin : Par exemple Post
 * correpond à une création, Put à un update, Deleter à une suppression et Get à
 * une lecture. @ Path (/clientservice) définit une uri unique, le chemin par
 * lequel on va accéder via le pluggin.
 * http://localhost:8080/clientws/services/clientservice Pour accéder aux
 * différentes méthodes, on rajout le @ Path à l'url ex:
 * http://localhost:8080/clientws/services/clientservice/clients/ Les paramètres
 * définis entre accolades sont les paramètres qui vont être extraits de notre
 * uri uniques pour être utilisés dans notre méthode
 * 
 * @author BENDOU/BAGGI
 *
 */
@Produces({ "application/json", "application/xml" })
@Consumes({ "application/json", "application/xml" })
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
	@Path("/clients/virement/{id1}/{id2}/{montant}/")
	Response faireVirment(@PathParam("id1") String id1, @PathParam("id2") String id2,
			@PathParam("montant") String montant);

	@PUT
	@Path("/clients/virementce/{id1}/{id2}/{montant}/")
	Response faireVirmentce(@PathParam("id1") String id1, @PathParam("id2") String id2,
			@PathParam("montant") String montant);

}
