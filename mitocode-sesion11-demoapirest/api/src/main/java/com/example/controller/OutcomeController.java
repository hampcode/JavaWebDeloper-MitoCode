package com.example.controller;


import com.example.converter.OutcomeConverter;
import com.example.dto.OutcomeRequestCreate;
import com.example.dto.OutcomeRequestUpdate;
import com.example.dto.OutcomeResponse;
import com.example.entities.Outcome;
import com.example.service.OutcomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Api
@RestController
@RequestMapping("/outcomes")
public class OutcomeController {

    @Autowired
    private OutcomeService outcomeService;

    @Autowired
    private OutcomeConverter outcomeConverter;

    @ApiOperation(value = "Retrieve all existed outcomes", notes = "This Operation returns all outcomes.")
    @GetMapping
    public ResponseEntity<List<OutcomeResponse>> findAllOutcomes() {
        List<Outcome> outcomes = outcomeService.findAllOutcomes();
        return new ResponseEntity<List<OutcomeResponse>>(outcomeConverter.convertEntityToDto(outcomes), HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieve an outcome based on Id ", notes = "This Operation returns an outcome by Outcome Id")
    @GetMapping(value = "/{outcomeId}")
    public ResponseEntity<OutcomeResponse> findOutcomeById(@PathVariable Long outcomeId) {
        Outcome outcome= outcomeService.findOutcomeById(outcomeId);
        return new ResponseEntity<OutcomeResponse>(outcomeConverter.convertEntityToDto(outcome), HttpStatus.OK);
    }

    @ApiOperation(value = "Creates an outcome", notes = "This Operation creates a new outcome.")
    @PostMapping
    public ResponseEntity<OutcomeResponse> createOutcome(@RequestBody OutcomeRequestCreate outcomeRequest) {
        Outcome outcome = outcomeService.createOutcome(outcomeRequest);
        return new ResponseEntity<OutcomeResponse>(outcomeConverter.convertEntityToDto(outcome), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update an outcome", notes = "This Operation update a outcome.")
    @PutMapping
    public ResponseEntity<OutcomeResponse> updateOutcome(@RequestBody OutcomeRequestUpdate outcomeRequestUpdate) {
        Outcome outcome = outcomeService.updateOutcome(outcomeRequestUpdate);
        return new ResponseEntity<OutcomeResponse>(outcomeConverter.convertEntityToDto(outcome), HttpStatus.CREATED);
    }


    @ApiOperation(value = "Delete an outcome", notes = "This Operation delete a outcome.")
    @DeleteMapping(value = "/{outcomeId}")
    public ResponseEntity<?> deleteOutcome(@PathVariable Long outcomeId) {
        outcomeService.deleteOutcome(outcomeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}

