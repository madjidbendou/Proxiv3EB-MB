package org.formation.spring.dao;

import java.util.List;

import org.formation.spring.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Le CrudClient Dao est une interface qui étend JpaRepository. Une API
 * (Springadata) permet de bénéficier d'opérations CRUD de base de la classe
 * COnseiller.Spring Data s'interface avec plusieurs sources de données parmi
 * lesquelles JPA. Il suffit tout simplement d'étendre une interface de
 * JpaRepository pour y avoir accès.
 * 
 * @author BENDOU/BAGGI
 */
public interface CrudClientDAO extends JpaRepository<Client, Long> {

}
