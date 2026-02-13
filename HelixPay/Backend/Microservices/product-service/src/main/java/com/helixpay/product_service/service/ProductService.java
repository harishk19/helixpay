package com.helixpay.product_service.service;

import org.springframework.stereotype.Service;

import java.util.List;
import com.helixpay.product_service.dto.ProductRequest;
import com.helixpay.product_service.dto.ProductResponse;
import com.helixpay.product_service.model.Product;
import com.helixpay.product_service.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	
	private final ProductRepository productRepository;
	
	
	public ProductResponse createProduct(ProductRequest productRequest) {
		Product product = Product.builder()
				.name(productRequest.name())
				.description(productRequest.description())
				.price(productRequest.price())
				.build();
		productRepository.save(product);
		log.info("Product successfuly created with name:{}", productRequest.name());
		return new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice());
	}
	
	public List<ProductResponse> getAllProducts(){
		return productRepository.findAll()
				.stream()
				.map(product -> new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice())).toList();
	}
	
	

}
