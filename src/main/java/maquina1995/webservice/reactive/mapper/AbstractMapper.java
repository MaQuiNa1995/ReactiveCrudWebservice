package maquina1995.webservice.reactive.mapper;

public interface AbstractMapper<T, D> {

	abstract D entityToDto(T entity);

	abstract T dtoToEntity(D dto);

}
