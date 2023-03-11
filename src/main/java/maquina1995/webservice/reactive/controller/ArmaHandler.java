package maquina1995.webservice.reactive.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.RequiredArgsConstructor;
import maquina1995.webservice.reactive.dto.ArmaDto;
import maquina1995.webservice.reactive.service.ArmaService;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@RequestMapping("/arma/handler/")
public class ArmaHandler {

	private final ArmaService armaService;

	public Mono<ServerResponse> findAll(ServerRequest request) {
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(armaService.findAll(), ArmaDto.class);
	}

	public Mono<ServerResponse> findById(ServerRequest request) {

		String id = request.queryParam("id")
				.get();

		return armaService.findById(Long.valueOf(id))
				.flatMap(user -> ServerResponse.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.body(user, ArmaDto.class))
				.switchIfEmpty(ServerResponse.notFound()
						.build());
	}

	public Mono<ServerResponse> create(ServerRequest request) {

		return request.bodyToMono(ArmaDto.class)
				.flatMap(arma -> ServerResponse.status(HttpStatus.CREATED)
						.body(armaService.create(arma), ArmaDto.class));
	}

	public Mono<ServerResponse> update(ServerRequest request) {

		String id = request.queryParam("id")
				.get();
		Mono<ArmaDto> updatedArmaDto = request.bodyToMono(ArmaDto.class);

		return updatedArmaDto.flatMap(arma -> ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(armaService.update(arma, Long.valueOf(id)), ArmaDto.class));
	}

	public Mono<ServerResponse> delete(ServerRequest request) {
		String id = request.queryParam("id")
				.get();

		return armaService.delete(Long.valueOf(id))
				.flatMap(u -> ServerResponse.ok()
						.body(u, ArmaDto.class))
				.switchIfEmpty(ServerResponse.notFound()
						.build());
	}
}
