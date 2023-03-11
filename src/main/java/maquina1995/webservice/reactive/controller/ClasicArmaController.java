package maquina1995.webservice.reactive.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import maquina1995.webservice.reactive.dto.ArmaDto;
import maquina1995.webservice.reactive.service.ArmaService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/armas")
public class ClasicArmaController {

	private final ArmaService armaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Void> create(@RequestBody ArmaDto dto) {
		return armaService.create(dto);
	}

	@GetMapping("/all")
	public Flux<ArmaDto> findAll() {
		return armaService.findAll();
	}

	@GetMapping
	public Mono<ResponseEntity<ArmaDto>> find(@RequestParam(required = false) Long id) {
		return armaService.findById(id)
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound()
						.build());
	}

	@PutMapping
	public Mono<ResponseEntity<Void>> update(@RequestBody ArmaDto dto, @RequestParam Long id) {
		return armaService.update(dto, id)
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.badRequest()
						.build());
	}

	@DeleteMapping
	public Mono<ResponseEntity<Void>> delete(@RequestParam Long armaId) {
		return armaService.delete(armaId)
				.map(r -> ResponseEntity.noContent()
						.<Void>build())
				.defaultIfEmpty(ResponseEntity.notFound()
						.build());
	}
}
