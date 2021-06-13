package com.mitocode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.mitocode.entities.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer>, JpaSpecificationExecutor<Autor> {

}