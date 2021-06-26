package com.example.util;

import com.example.dto.OutcomeRequestCreate;
import com.example.exception.IncorrectOutcomeRequestException;

public class OutcomeValidator {

	public static void validateOutcome(OutcomeRequestCreate outcomeRequest) {
		if(outcomeRequest.getDetail()==null || outcomeRequest.getDetail().trim().isEmpty()) {
			throw new IncorrectOutcomeRequestException(
					ExceptionMessageEnum.INCORRECT_REQUEST_EMPTY_ITEMS_OUTCOME.getValue()
			);
		}
		
		if(outcomeRequest.getAmount()==null) {
			throw new IncorrectOutcomeRequestException(
					ExceptionMessageEnum.INCORRECT_REQUEST_EMPTY_ITEMS_OUTCOME.getValue()
			);
		}
	}
}
