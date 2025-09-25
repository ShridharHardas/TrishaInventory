package org.stock;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

	
	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder)
	{
		return builder.routes()
				.route("production_route",r->r.path("stock/inventory/**")
						.uri("http://localhost:8084"))
				.route("supplier_service", r->r.path("/stock/inventory/supplier/**").uri("http://localhost:8082"))
						.build();
	}
}
