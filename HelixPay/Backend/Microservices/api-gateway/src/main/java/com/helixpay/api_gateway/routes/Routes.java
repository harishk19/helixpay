package com.helixpay.api_gateway.routes;
import java.net.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.HandlerFunction;
import org.springframework.web.servlet.function.RequestPredicate;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {

  

    @Bean
    public RouterFunction<ServerResponse> productServiceRoutes() {

 
        return GatewayRouterFunctions.route("product_service")
                .route(RequestPredicates.path("/api/product"),HandlerFunctions
                .http(URI.create("http://localhost:8080")))
                .build();
    }
    
    
    @Bean
    public RouterFunction<ServerResponse> orderServiceRoutes(){
    	
    	return GatewayRouterFunctions.route("order_service")
    			.route(RequestPredicates.path("/api/order"),HandlerFunctions
    			.http(URI.create("http://localhost:8081")))
    			.build();
    }
    
    @Bean
    public RouterFunction<ServerResponse> inventoryService(){
    	return GatewayRouterFunctions.route("inventory_service")
    			.route(RequestPredicates.path("/api/inventory"), HandlerFunctions
    			.http(URI.create("http://localhost:8083")))
    			.build();
    }
    
    
    
    
}

