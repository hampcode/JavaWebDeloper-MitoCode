package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.converter.OutcomeConverter;
import com.example.dto.OutcomeRequestCreate;
import com.example.entities.Outcome;
import com.example.repository.OutcomeRepository;
import com.example.util.OutcomeValidator;

@Service
public class OutcomeService {
	
	@Autowired
	private OutcomeRepository outcomeRepository;
	
	@Autowired
	private OutcomeConverter outcomeConverter;
	
	@Transactional
	public Outcome createOutcome(OutcomeRequestCreate outcomeRequestCreate) {
		OutcomeValidator.validateOutcome(outcomeRequestCreate);
		Outcome outcome=outcomeConverter.convertDtoToEntity(outcomeRequestCreate);
		return outcomeRepository.save(outcome);
	}

	public List<Outcome> findAllOutcomes(){
		return outcomeRepository.findAll();
	}
}



