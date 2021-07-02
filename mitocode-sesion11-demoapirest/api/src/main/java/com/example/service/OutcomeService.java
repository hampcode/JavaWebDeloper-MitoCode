package com.example.service;

import com.example.converter.OutcomeConverter;
import com.example.dto.OutcomeRequestCreate;
import com.example.dto.OutcomeRequestUpdate;
import com.example.entities.Outcome;
import com.example.exception.OutcomeNotFoundException;
import com.example.repository.OutcomeRepository;
import com.example.util.OutcomeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class OutcomeService {
    @Autowired
    private OutcomeRepository outcomeRepository;

    @Autowired
    private OutcomeConverter outcomeConverter;

    @Transactional
    public Outcome createOutcome(OutcomeRequestCreate outcomeRequestCreate) {
        OutcomeValidator.validateOutcome(outcomeRequestCreate);
        Outcome outcome = outcomeConverter.convertDtoToEntity(outcomeRequestCreate);
        return outcomeRepository.save(outcome);
    }

    @Transactional(readOnly = true)
    public List<Outcome> findAllOutcomes() {
        return outcomeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Outcome findOutcomeById(Long outcomeId) {
        return outcomeRepository.findById(outcomeId)
                .orElseThrow(() -> new OutcomeNotFoundException("Outcome not found"));
    }

    @Transactional
    public void deleteOutcome(Long outcomeId) {
        Outcome outcome = outcomeRepository.findById(outcomeId)
                .orElseThrow(() -> new OutcomeNotFoundException("Outcome not found"));
        outcomeRepository.delete(outcome);
    }

    @Transactional
    public Outcome updateOutcome(OutcomeRequestUpdate outcomeRequestUpdate) {
        Outcome outcome = outcomeRepository.findById(outcomeRequestUpdate
        		.getOutcomeId())
                .orElseThrow(() -> new OutcomeNotFoundException("Outcome not found"));

        outcome.setAmount(outcomeRequestUpdate.getAmount());
        outcome.setDetail(outcomeRequestUpdate.getDetail());
        return outcomeRepository.save(outcome);
    }

}


