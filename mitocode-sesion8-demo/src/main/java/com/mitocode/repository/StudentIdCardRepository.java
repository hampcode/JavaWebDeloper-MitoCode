package com.mitocode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.entities.StudentIdCard;

@Repository
public interface StudentIdCardRepository
        extends JpaRepository<StudentIdCard, Long> {
}