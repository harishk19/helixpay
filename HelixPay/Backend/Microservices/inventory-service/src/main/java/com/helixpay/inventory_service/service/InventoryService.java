package com.helixpay.inventory_service.service;

import org.springframework.stereotype.Service;

import com.helixpay.inventory_service.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {
	
	private final InventoryRepository inventoryRepository;
	
	public boolean isInStock(String skuCode, Integer quantity) {
		//find a inventory for a given sku code where quanitty is > = 0
		 boolean isInStock = inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
		 return isInStock;
	}

}
