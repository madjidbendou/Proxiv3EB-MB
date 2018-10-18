package org.formation.spring.dao;

import java.util.List;

import org.formation.spring.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * The implementation of  interface is not required It is generated
 * by Spring Data JPA Framework This interface is responsible for CRUD + custom
 * queries based on query methods and parameter name and types
 */
// public interface CrudClientDAO extends CrudRepository<Client, Integer>{
public interface CrudClientDAO extends JpaRepository<Client, Long> {

	
	
	
	
	
	
	
	
	
	
	
	
	
	// customized methods here

//	List<Client> findAllClientByNom(String nom);
//
//	List<Client> findAllClientByLogin(String login);

}
