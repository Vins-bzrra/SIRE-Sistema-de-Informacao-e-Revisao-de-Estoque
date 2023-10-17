package com.vins.prototype.inventoryPrototype.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vins.prototype.inventoryPrototype.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByRegistrationNumber(String email);

	Optional<User> findById(Long id);
	
}
