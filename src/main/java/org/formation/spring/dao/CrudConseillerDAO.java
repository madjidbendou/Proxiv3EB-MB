package org.formation.spring.dao;

import org.formation.spring.model.Conseiller;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The implementation of  interface is not required It is generated
 * by Spring Data JPA Framework This interface is responsible for CRUD + custom
 * queries based on query methods and parameter name and types
 */
// public interface CrudClientDAO extends CrudRepository<Client, Integer>{
public interface CrudConseillerDAO extends JpaRepository<Conseiller, Long> {

	
	
	
	
	
	
	
	
	
	
	
	
	
	// customized methods here

//	List<Client> findAllClientByNom(String nom);
//
//	List<Client> findAllClientByLogin(String login);

}
