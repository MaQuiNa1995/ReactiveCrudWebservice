package maquina1995.webservice.reactive.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import maquina1995.webservice.reactive.dominio.Arma;

public interface ArmaRepository extends R2dbcRepository<Arma, Long> {

}
