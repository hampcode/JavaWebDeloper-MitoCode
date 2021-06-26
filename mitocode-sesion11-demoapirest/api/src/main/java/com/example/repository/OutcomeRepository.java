package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Outcome;

@Repository
public interface OutcomeRepository extends JpaRepository<Outcome, Long>{

}
