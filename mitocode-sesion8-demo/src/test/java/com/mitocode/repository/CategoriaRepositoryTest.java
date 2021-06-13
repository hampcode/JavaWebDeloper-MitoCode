package com.mitocode.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;
import com.mitocode.entities.Categoria;

import lombok.extern.slf4j.Slf4j;

@DataJpaTest
@DBRider
@Slf4j
@DisplayName("Junit Test unitario repositorio Categoria")
public class CategoriaRepositoryTest {
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Test
	@DataSet(value="categorias.yml",cleanBefore = true, cleanAfter = true)
	@DisplayName("Test unitario buscar todos")
	public void testFindAll() {
		List<Categoria> categoria=categoriaRepository.findAll();
		assertEquals(categoria.size(), 11);
	}
	
	
	@Test
	@DataSet(value="categorias.yml, libros.yml")
	@DisplayName("Test unitario buscar por id")
	public void testFindById() {
		Optional<Categoria> categoria=categoriaRepository.findById(3);
		
		assertEquals(categoria.isPresent(), true);
		assertEquals(categoria.get().getNombre(),"Terror");
		//assertEquals(categoria.get().getLibros().size(),3);
		//log.debug("Libros de terror"+categoria.get().getLibros().size());
		
	}

}
