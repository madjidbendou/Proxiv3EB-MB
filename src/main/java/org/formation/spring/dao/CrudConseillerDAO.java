package org.formation.spring.dao;


import org.formation.spring.model.Conseiller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudConseillerDao extends JpaRepository<Conseiller, Long> {

}
