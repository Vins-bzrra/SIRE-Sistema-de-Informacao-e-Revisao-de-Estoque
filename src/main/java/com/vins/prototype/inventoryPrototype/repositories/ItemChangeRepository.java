package com.vins.prototype.inventoryPrototype.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vins.prototype.inventoryPrototype.entities.ItemChange;

@Repository
public interface ItemChangeRepository extends JpaRepository<ItemChange, Long> {
	List<ItemChange> findByChangeDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
}
