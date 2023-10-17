package com.vins.prototype.inventoryPrototype.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vins.prototype.inventoryPrototype.entities.ItemAcquisition;

@Repository
public interface ItemAcquisitionRepository extends JpaRepository<ItemAcquisition, Long>{
	
}
