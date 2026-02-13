package com.helixpay.product_service;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;

import io.restassured.RestAssured;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {
	

	
	@ServiceConnection
	@Container
    static MongoDBContainer mongoDBContainer = 
        new MongoDBContainer("mongodb/mongodb-community-server:7.0.5-ubi8");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

	@LocalServerPort
	private Integer port;
	
	@BeforeEach
	void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}
	
	static {
		mongoDBContainer.start();
	}
	
	
	@Test
	void shouldCreateProduct() {
		String requestBody = """
				
				{
				  "name": "Iphone 12 Pro",
				  "description": "Blue",
				  "price": 160
						}
				""";
		
		RestAssured.given()
			.contentType("applicatrion/json")
			.body(requestBody)
			.when()
			.post("/api/product")
			.then()
			.statusCode(201)
			.body("id", Matchers.notNullValue())
			.body("name", Matchers.equalTo("Iphone 12 Pro"))
			.body("description", Matchers.equalTo("Blue"))
			.body("price", Matchers.equalTo(160));
			
			
		
	}

}
