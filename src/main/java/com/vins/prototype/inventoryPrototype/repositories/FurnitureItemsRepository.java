package com.vins.prototype.inventoryPrototype.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.vins.prototype.inventoryPrototype.entities.FurnitureItems;

@Repository
public interface FurnitureItemsRepository extends JpaRepository<FurnitureItems, Long>, JpaSpecificationExecutor<FurnitureItems>{
	
	Optional<FurnitureItems> findById(Long id);
	
	Optional<FurnitureItems> findByPatrimony(String patrimony);
	
	boolean existsByPatrimonyAndIdNot(String patrimony, Long id);
}
