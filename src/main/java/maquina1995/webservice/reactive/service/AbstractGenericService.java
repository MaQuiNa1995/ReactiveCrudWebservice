package maquina1995.webservice.reactive.service;

import java.io.Serializable;
import java.util.List;

import maquina1995.webservice.reactive.dominio.Persistible;
import maquina1995.webservice.reactive.dto.PersistibleDto;
import reactor.core.publisher.Mono;

/**
 * 
 * @author MaQuiNa1995
 *
 * @param <T> entidad
 * @param <K> id de la entidad
 * @param <D> dto
 */
public interface AbstractGenericService<T extends Persistible<K>, K extends Serializable, D extends PersistibleDto<K>> {

	Mono<T> create(D dto);

	Mono<D> find(K id);

	Mono<List<D>> findAll();

	Mono<T> update(D dto);

	Mono<Void> delete(K id);

}