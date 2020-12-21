package com.devanand.cardgame;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidOptionException extends RuntimeException {

	public InvalidOptionException (String option) {
		throw new ResponseStatusException(
		           HttpStatus.BAD_REQUEST, "This option is invalid: " + option);
	}
}
