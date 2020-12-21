package com.devanand.cardgame;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardGameController {
	
	@RequestMapping("cardgame")
	public String getGames() {
		return "hello Card Game";
	}

}
