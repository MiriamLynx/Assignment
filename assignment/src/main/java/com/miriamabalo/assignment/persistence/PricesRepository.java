package com.miriamabalo.assignment.persistence;

import java.util.Date;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.miriamabalo.assignment.model.Prices;

public interface PricesRepository extends JpaRepository<Prices, Long> {

	@EntityGraph(value = "Prices.brand")
	@Query("select p from Prices p where p.priority = (select max(p.priority) from Prices p where p.startDate < :applicationDate and p.endDate > :applicationDate and p.productId = :productId and p.brand.id = :brandId) and p.startDate < :applicationDate and p.endDate > :applicationDate and p.productId = :productId and p.brand.id = :brandId")
	Prices findOne(Date applicationDate, Long productId, Long brandId);
	
}
