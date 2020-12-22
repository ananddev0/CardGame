package com.devanand.cardgame.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class GameNotFoundException extends NotFoundException {
	
	String id = null;

	public GameNotFoundException(String id) {
		this.id = id;
	}
	
	public String getMessage() {
		return "Game with id " + this.id + " not found";
	}

}
