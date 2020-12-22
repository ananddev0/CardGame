package com.devanand.cardgame.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PlayerNotFoundException extends NotFoundException {
	
	String id = null;
	
	public PlayerNotFoundException (String id) {
		this.id = id;
	}
	
	public String getMessage() {
		return "Player with id " + this.id + " not found";
	}

}
