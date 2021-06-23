//package maquina1995.webservice.service;
//
//import java.io.Serializable;
//import java.util.Arrays;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//
//import maquina1995.webservice.reactive.dominio.Persistible;
//import maquina1995.webservice.reactive.dto.PersistibleDto;
//import maquina1995.webservice.reactive.mapper.AbstractMapper;
//import maquina1995.webservice.reactive.service.AbstractGenericService;
//
//@Rollback
//@SpringBootTest(value = "maquina1995.webservice")
//abstract class AbstractGenericServiceTest<E extends Persistible<K>,
//        K extends Serializable,
//        D extends PersistibleDto<K>> {
//
//	@PersistenceContext
//	protected EntityManager entityManager;
//	@Autowired
//	protected AbstractGenericService<E, K, D> sut;
//	@Autowired
//	protected AbstractMapper<E, D> mapper;
//
//	protected abstract D createDto();
//
//	protected abstract E createEntity();
//
//	@Test
//	@Transactional
//	void createTest() {
//		// given
//		D dto = this.createDto();
//
//		// when
//		E entity = sut.create(dto);
//
//		// then
//		Assertions.assertAll(() -> Assertions.assertEquals(mapper.dtoToEntity(dto), entity),
//		        () -> Assertions.assertNotNull(entity.getId()));
//	}
//
//	@Test
//	@Transactional
//	void findTest() {
//		// given
//		E entity = this.createEntity();
//		entityManager.persist(entity);
//
//		// when
//		D dto = sut.find(entity.getId());
//
//		// then
//		Assertions.assertEquals(mapper.dtoToEntity(dto), entity);
//	}
//
//	@Test
//	@Transactional
//	void findAllTest() {
//		// given
//		Arrays.asList(this.createEntity(), this.createEntity())
//		        .forEach(entityManager::persist);
//
//		// when
//		List<D> dtos = sut.findAll();
//
//		// then
//		Assertions.assertEquals(2, dtos.size());
//	}
//
//	@Test
//	@Transactional
//	void updateTest() {
//		// given
//		E entity = this.createEntity();
//		entityManager.persist(entity);
//
//		D dto = this.createDto();
//		dto.setId(entity.getId());
//
//		// when
//		E entityUpdated = sut.update(dto);
//
//		// then
//		Assertions.assertAll(() -> Assertions.assertEquals(mapper.dtoToEntity(dto), entityUpdated),
//		        () -> Assertions.assertEquals(dto.getId(), entityUpdated.getId()));
//	}
//
//	@Test
//	@Transactional
//	void deleteTest() {
//		// given
//		E entity = this.createEntity();
//		entityManager.persist(entity);
//
//		// when
//		sut.delete(entity.getId());
//
//		// then
//		Assertions.assertTrue(sut.findAll()
//		        .isEmpty());
//	}
//
//}
