package maquina1995.webservice.reactive.service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import maquina1995.webservice.reactive.dominio.Persistible;
import maquina1995.webservice.reactive.dto.PersistibleDto;
import maquina1995.webservice.reactive.mapper.AbstractMapper;
import reactor.core.publisher.Mono;

/**
 * 
 * @author MaQuiNa1995
 * 
 * @param <E> entidad
 * @param <K> clave primaria entidad
 * @param <D> dto
 */
public abstract class AbstractGenericServiceImpl<E extends Persistible<K>,
        K extends Serializable,
        D extends PersistibleDto<K>> implements AbstractGenericService<E, K, D> {

	@Autowired
	protected R2dbcRepository<E, K> repository;
	@Autowired
	protected AbstractMapper<E, D> mapper;

	// TODO actualmente es igual al de updatear pero hay que cambiar el Dto
	@Override
	public Mono<E> create(D dto) {

		E entity = mapper.dtoToEntity(dto);

		return repository.save(entity);
	}

	@Override
	public Mono<D> find(K id) {

		return repository.findById(id)
		        .map(mapper::entityToDto);
	}

	@Override
	public Mono<List<D>> findAll() {

		return repository.findAll()
		        .map(mapper::entityToDto)
		        .collect(Collectors.toList());
	}

	@Override
	public Mono<E> update(D dto) {

		E entity = mapper.dtoToEntity(dto);

		return repository.save(entity);
	}

	@Override
	public Mono<Void> delete(K id) {

		return repository.deleteById(id);
	}

}