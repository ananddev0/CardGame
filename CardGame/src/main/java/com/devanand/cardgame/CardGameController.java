package com.devanand.cardgame;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardGameController {
	
	@GetMapping("games")
	public List<Game> getGames() {
		
		Games games = Games.getInstance();
		
		Game g1 = new Game("ABCDEF");
		Game g2 = new Game("GHIGKL");
		
		games.addGame(g1);
		games.addGame(g2);
		
		return games.getGames();
	}
	
	@PostMapping("games")
	public Game createGame() {
		Games games = Games.getInstance();
		
		String random = RandomStringUtils.randomAlphanumeric(8);
		Game game = new Game(random);
		
		games.addGame(game);
		return game;
	}

}
