//package maquina1995.webservice.controller;
//
//import maquina1995.webservice.reactive.controller.ArmaLv2Controller;
//import maquina1995.webservice.reactive.dominio.Arma;
//import maquina1995.webservice.reactive.dto.ArmaDto;
//import maquina1995.webservice.reactive.service.ArmaService;
//
//class ArmaLv2ControllerTest
//        extends AbstractGenericWebServiceLv2ControllerTest<ArmaLv2Controller, Arma, Long, ArmaDto, ArmaService> {
//
//	@Override
//	protected ArmaDto createDto() {
//		return ArmaDto.builder()
//		        .id(1L)
//		        .elemento(300)
//		        .elementoActivado(Boolean.FALSE)
//		        .nombre("Lanza De Huesos Dto")
//		        .tipo("Lanza-Pistola Dto")
//		        .build();
//	}
//
//	@Override
//	protected Arma createEntity() {
//		return Arma.builder()
//		        .elemento(100)
//		        .elementoActivado(Boolean.TRUE)
//		        .nombre("Lanza De Huesos")
//		        .tipo("Lanza-Pistola")
//		        .build();
//	}
//
//}
