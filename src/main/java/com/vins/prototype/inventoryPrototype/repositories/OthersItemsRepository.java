package com.vins.prototype.inventoryPrototype.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.vins.prototype.inventoryPrototype.entities.ITItems;
import com.vins.prototype.inventoryPrototype.entities.OthersItems;

@Repository
public interface OthersItemsRepository extends JpaRepository<OthersItems, Long>, JpaSpecificationExecutor<OthersItems>{
	
	Optional<OthersItems> findById(Long id);
	
	Optional<OthersItems> findByPatrimony(String patrimony);
	
	Optional<ITItems> findBySerialNumber(String serialNumber);
	
	boolean existsByPatrimonyAndIdNot(String patrimony, Long id);
}
