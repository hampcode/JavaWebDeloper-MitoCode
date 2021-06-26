package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.converter.OutcomeConverter;
import com.example.dto.OutcomeRequestCreate;
import com.example.dto.OutcomeResponse;
import com.example.entities.Outcome;
import com.example.service.OutcomeService;

@RestController
@RequestMapping("/outcomes")
public class OutcomeController {

	@Autowired
	private OutcomeService outcomeService;
	
	@Autowired
	private OutcomeConverter outcomeConverte;
	
	@GetMapping
	public ResponseEntity<List<OutcomeResponse>> findAllOutcomes(){
		List<Outcome> outcomes=outcomeService.findAllOutcomes();
		return new ResponseEntity<List<OutcomeResponse>>(
				outcomeConverte.convertEntityToDto(outcomes),
				HttpStatus.OK
		);
	}
	
	@PostMapping
	public ResponseEntity<OutcomeResponse> createOutcome(@RequestBody 
			OutcomeRequestCreate outcomeRequestCreate){
		Outcome outcome=outcomeService.createOutcome(outcomeRequestCreate);
		return new ResponseEntity<OutcomeResponse>(
				outcomeConverte.convertEntityToDto(outcome),
				HttpStatus.CREATED
		);
	}
}
