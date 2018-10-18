package org.formation.spring.service;

import java.util.List;

import org.formation.spring.model.Client;

public interface IPrestiBanqueService {
	public void addClient(Client c); 
	public List<Client> listClients();
	public void	deleteClient(long idClient);
	public Client editClient(long idClient);
	public void	updateClient(Client c);
	//public List<Client>	chercherClients(String	motCle);

}
