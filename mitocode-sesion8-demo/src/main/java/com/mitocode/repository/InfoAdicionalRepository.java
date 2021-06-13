package com.mitocode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.entities.InfoAdicional;

@Repository
public interface InfoAdicionalRepository extends JpaRepository<InfoAdicional, Integer> {

}