package maquina1995.webservice.reactive.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import maquina1995.webservice.reactive.dominio.Persistible;
import maquina1995.webservice.reactive.dto.PersistibleDto;
import maquina1995.webservice.reactive.service.AbstractGenericService;
import reactor.core.publisher.Mono;

/**
 * Clase abstracta para la creación de webservices de nivel 2
 * 
 * @author MaQuiNa1995
 *
 * @param <E> entity
 * @param <K> clave primaria de la entity
 * @param <D> dto
 */
public abstract class AbstractWebserviceLv2Controller<E extends Persistible<K>,
        K extends Serializable,
        D extends PersistibleDto<K>> {

	@Autowired
	protected AbstractGenericService<E, K, D> service;

	@PostMapping(path = "/create")
	public Mono<ResponseEntity<E>> create(@RequestBody D dto) {

		return service.create(dto)
		        .map(ResponseEntity::ok);

	}

	@GetMapping
	public Mono<ResponseEntity<List<D>>> find(@RequestParam(required = false) K id) {

		Mono<List<D>> dtos = (id == null) ? service.findAll()
		        : service.find(id)
		                .map(Arrays::asList);

		return dtos.map(ResponseEntity::ok);
	}

	@PostMapping
	public Mono<ResponseEntity<E>> update(@RequestBody D dto) {
		return service.update(dto)
		        .map(ResponseEntity::ok);
	}

	@DeleteMapping
	public Mono<ResponseEntity<Void>> delete(@RequestParam K id) {
		return service.delete(id)
		        .map(ResponseEntity::ok);
	}

}
