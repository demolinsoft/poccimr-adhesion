package atos.cimr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import atos.cimr.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
}
