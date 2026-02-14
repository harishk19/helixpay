package com.helixpay.order_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helixpay.order_service.dto.OrderRequest;
import com.helixpay.order_service.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderService orderService;
	
	@PostMapping
	public String placeOrder(@RequestBody OrderRequest orderRequest) {
		orderService.placeOrder(orderRequest);
		return "Order placed succesfully";
		
	}

}
