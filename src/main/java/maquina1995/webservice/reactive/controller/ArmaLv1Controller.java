package maquina1995.webservice.reactive.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import maquina1995.webservice.reactive.dominio.Arma;
import maquina1995.webservice.reactive.dto.ArmaDto;

@RestController
@RequestMapping(path = "/arma/nivel1")
@Api(tags = "Ejemplo de webservice reactivo de Nivel 1")
public class ArmaLv1Controller extends AbstractWebserviceLv1Controller<Arma, Long, ArmaDto> {

}
