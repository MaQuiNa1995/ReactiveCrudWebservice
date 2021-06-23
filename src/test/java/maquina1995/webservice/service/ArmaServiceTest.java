//package maquina1995.webservice.service;
//
//import maquina1995.webservice.reactive.dominio.Arma;
//import maquina1995.webservice.reactive.dto.ArmaDto;
//import maquina1995.webservice.reactive.mapper.ArmaMapper;
//import maquina1995.webservice.reactive.service.ArmaService;
//
//class ArmaServiceTest extends AbstractGenericServiceTest<Arma, Long, ArmaDto, ArmaService, ArmaMapper> {
//
//	@Override
//	protected ArmaDto createDto() {
//		return ArmaDto.builder()
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
