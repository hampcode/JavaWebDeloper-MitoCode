package com.example.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dto.OutcomeRequestCreate;
import com.example.dto.OutcomeResponse;
import com.example.entities.Outcome;

@Component
public class OutcomeConverter {

	@Autowired
	private ModelMapper modelMapper;
	
	public OutcomeResponse convertEntityToDto(Outcome outcome) {
		return modelMapper.map(outcome, OutcomeResponse.class);
	}
	
	public Outcome convertDtoToEntity(OutcomeRequestCreate outcomeRequest) {
		return modelMapper.map(outcomeRequest,Outcome.class);
	}
	
	public List<OutcomeResponse> convertEntityToDto(List<Outcome> outcomes){
		return outcomes.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}
}
