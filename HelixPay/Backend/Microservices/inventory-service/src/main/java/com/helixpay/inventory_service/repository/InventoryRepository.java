package com.helixpay.inventory_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helixpay.inventory_service.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>{

	boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);

}
