package com.devanand.cardgame.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GameExceptionHandler {

	@ExceptionHandler({GameNotFoundException.class, PlayerNotFoundException.class})
	public ResponseEntity<?> handleNotFoundException (NotFoundException exception, WebRequest request){
		
		Error error = new Error (new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleAllException (GameNotFoundException exception, WebRequest request){
		
		Error error = new Error (new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
