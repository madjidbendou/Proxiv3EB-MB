package org.formation.spring.service;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.formation.spring.dao.CrudClientDAO;
import org.formation.spring.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clientWebService")
public class CilentWebServiceImpl implements ClientWebService {

	@Autowired
	private CrudClientDAO crudClientDAO;

	@Override
	public Client getClient(String id) {
		
		Optional<Client> optional = crudClientDAO.findById(Long.valueOf(id));
		return optional.get();
	}

	@Override
	public List<Client> getClients() {
		return crudClientDAO.findAll();
	}

	@Override
	public Response updateClient(Client client) {
//		Client customerToUpdate = crudClientDAO.getOne(client.getId());
		crudClientDAO.save(client);
		return Response.ok().build();
	}

	@Override
	public Response addClient(Client client) {
		crudClientDAO.save(client);
		return Response.ok().build();
	}

	@Override
	public Response deleteClients(String id) {
		crudClientDAO.deleteById(Long.valueOf(id));;
		return Response.ok().build();
	}

}
