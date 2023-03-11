package maquina1995.webservice.reactive.mapper;

public interface AbstractMapper<T, D> {

	D entityToDto(T entity);

	T dtoToEntity(D dto);

}
