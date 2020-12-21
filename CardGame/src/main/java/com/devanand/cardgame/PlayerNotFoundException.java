package com.devanand.cardgame;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PlayerNotFoundException extends RuntimeException {
	
	public PlayerNotFoundException (String id) {
		throw new ResponseStatusException(
		           HttpStatus.NOT_FOUND, "Player with id " + id + "not found");
	}

}
