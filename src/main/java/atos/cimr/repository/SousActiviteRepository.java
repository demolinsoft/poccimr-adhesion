package atos.cimr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import atos.cimr.entity.SousActivite;

@Repository
public interface SousActiviteRepository extends JpaRepository<SousActivite, Long>{

	
}
