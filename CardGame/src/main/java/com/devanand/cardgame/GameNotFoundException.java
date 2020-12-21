package com.devanand.cardgame;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class GameNotFoundException extends RuntimeException {
	
	public GameNotFoundException(String id) {
		throw new ResponseStatusException(
		           HttpStatus.NOT_FOUND, "Game with id " + id + "not found");
	}

}
