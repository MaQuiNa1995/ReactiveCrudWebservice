package maquina1995.webservice.reactive.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import maquina1995.webservice.reactive.dominio.Arma;
import maquina1995.webservice.reactive.dto.ArmaDto;
import maquina1995.webservice.reactive.mapper.ArmaMapper;
import maquina1995.webservice.reactive.repository.ArmaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@RequiredArgsConstructor
public class ArmaService {

	private final ArmaRepository armaRepository;
	private final ArmaMapper armaMapper;

	public Mono<Void> create(ArmaDto dto) {
		Arma entity = armaMapper.dtoToEntity(dto);
		return armaRepository.save(entity)
				.then();
	}

	public Flux<ArmaDto> findAll() {
		return armaRepository.findAll()
				.map(armaMapper::entityToDto);
	}

	public Mono<ArmaDto> findById(Long id) {
		return armaRepository.findById(id)
				.map(armaMapper::entityToDto);
	}

	public Mono<Void> update(ArmaDto arma, Long id) {
		return armaRepository.findById(id)
				.flatMap(armaDb -> {
					armaDb.setNombre(arma.getNombre());
					armaDb.setTipo(arma.getTipo());
					return armaRepository.save(armaDb);
				})
				.then();
	}

	public Mono<Void> delete(Long id) {
		return armaRepository.findById(id)
				.flatMap(armaRepository::delete)
				.onErrorComplete();

	}
}
