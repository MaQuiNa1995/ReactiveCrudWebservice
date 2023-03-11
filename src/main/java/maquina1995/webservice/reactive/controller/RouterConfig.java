package maquina1995.webservice.reactive.controller;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

	@Bean
	public RouterFunction<ServerResponse> routes(ArmaHandler handler) {

		String armaPath = "/arma/handler/";

		return route(GET(armaPath).and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
				.andRoute(GET(armaPath).and(contentType(MediaType.APPLICATION_JSON)), handler::findById)
				.andRoute(POST(armaPath).and(accept(MediaType.APPLICATION_JSON)), handler::create)
				.andRoute(PUT(armaPath).and(contentType(MediaType.APPLICATION_JSON)), handler::update)
				.andRoute(DELETE(armaPath).and(accept(MediaType.APPLICATION_JSON)), handler::delete);
	}
}
