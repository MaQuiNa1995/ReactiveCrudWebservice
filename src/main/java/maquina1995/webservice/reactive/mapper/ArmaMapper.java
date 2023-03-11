package maquina1995.webservice.reactive.mapper;

import org.mapstruct.Mapper;

import maquina1995.webservice.reactive.dominio.Arma;
import maquina1995.webservice.reactive.dto.ArmaDto;

@Mapper
public interface ArmaMapper extends AbstractMapper<Arma, ArmaDto> {

}
