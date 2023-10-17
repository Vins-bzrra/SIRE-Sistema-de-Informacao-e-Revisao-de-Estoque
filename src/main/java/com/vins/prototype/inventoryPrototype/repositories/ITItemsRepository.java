package com.vins.prototype.inventoryPrototype.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.vins.prototype.inventoryPrototype.entities.ITItems;

@Repository
public interface ITItemsRepository extends JpaRepository<ITItems, Long>, JpaSpecificationExecutor<ITItems>{
	
	Optional<ITItems> findById(Long id);
	
	Optional<ITItems> findByPatrimony(String patrimony);
	
	Optional<ITItems> findBySerialNumber(String serialNumber);
	
	boolean existsByPatrimonyAndIdNot(String patrimony, Long id);
}
