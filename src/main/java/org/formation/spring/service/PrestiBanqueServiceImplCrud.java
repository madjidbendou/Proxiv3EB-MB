package org.formation.spring.service;

import java.util.List;
import java.util.Optional;

import org.formation.spring.dao.CrudClientDAO;
import org.formation.spring.model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class PrestiBanqueServiceImplCrud implements IPrestiBanqueService {
	private static final Logger LOGGER =  LoggerFactory.getLogger(PrestiBanqueServiceImplCrud.class);

	@Autowired
	private CrudClientDAO crudClientDAO;

	@Override
	public void addClient(Client c) {
		crudClientDAO.save(c);

	}

	@Override
	public List<Client> listClients() {
		LOGGER.debug("lister clients");
		LOGGER.info("information");

		return crudClientDAO.findAll();
	}

	@Override
	public void deleteClient(long idClient) {
		crudClientDAO.deleteById(idClient);

	}

	@Override
	public Client editClient(long idClient) {
		Optional<Client> optional = crudClientDAO.findById(idClient);
		return optional.get();
	}

	@Override
	public void updateClient(Client c) {
		crudClientDAO.save(c);

	}



	

}
