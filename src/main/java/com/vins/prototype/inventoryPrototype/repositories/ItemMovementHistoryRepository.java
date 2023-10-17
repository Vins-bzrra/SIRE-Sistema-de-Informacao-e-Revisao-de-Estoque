package com.vins.prototype.inventoryPrototype.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vins.prototype.inventoryPrototype.entities.ItemMovementHistory;

@Repository
public interface ItemMovementHistoryRepository extends JpaRepository<ItemMovementHistory, Long> {
	List<ItemMovementHistory> findByMovementDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
}
