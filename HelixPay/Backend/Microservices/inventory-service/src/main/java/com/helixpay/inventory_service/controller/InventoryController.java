package com.helixpay.inventory_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.helixpay.inventory_service.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
	
	private final InventoryService inventoryService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public boolean isInStock(@RequestParam("skuCode") String skuCode, @RequestParam("quantity") Integer quantity) {
		return inventoryService.isInStock(skuCode, quantity);
	}
	

}
