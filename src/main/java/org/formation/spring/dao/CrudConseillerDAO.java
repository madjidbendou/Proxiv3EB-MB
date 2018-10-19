package org.formation.spring.dao;

import org.formation.spring.model.Conseiller;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Le CrudConseiller est une interface qui étend JpaRepository. Une API
 * (Springadata) permet de bénéficier d'opérations CRUD de base de la classe
 * Conseiller.Spring Data s'interface avec plusieurs sources de données parmi
 * lesquelles JPA. Il suffit tout simplement d'étendre une interface de
 * JpaRepository pour y avoir accès.
 * 
 * @author BENDOU/BAGGI
 */
public interface CrudConseillerDao extends JpaRepository<Conseiller, Long> {

}
