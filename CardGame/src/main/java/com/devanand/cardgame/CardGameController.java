package com.devanand.cardgame;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CardGameController {
	Games games = Games.getInstance();
	
	@GetMapping("games")
	public List<Game> getGames() {
		
		return games.getGames();
		
	}
	
	@PostMapping("games")
	public Game createGame() {
		
		String random = RandomStringUtils.randomAlphanumeric(8);
		Game game = new Game(random);
		
		games.addGame(game);
		return game;
	}
	
	@DeleteMapping("games/{game-id}")
	public void deleteGame(@PathVariable("game-id") String id) {
		games.deleteGame(id);	
	}
	
	@PostMapping("games/{game-id}/decks")
	public void addGameDeck (@PathVariable("game-id") String id) {
		if (games.getGame(id) == null) 
			throw new GameNotFoundException(id);
		
		games.getGame(id).addDeck(Card.getDeck());
	}
	
	@PostMapping("games/{game-id}/players")
	public void addPlayers(@PathVariable("game-id") String id, @RequestBody List<Player> players) {
		if (games.getGame(id) == null) 
			throw new GameNotFoundException(id); 
		
		for (Player player: players) {
			if (player.getId() == null) {
				player.setId(RandomStringUtils.randomAlphanumeric(8));
			}
			(games.getGame(id)).addPlayer(player);
		}
	}
	
	@DeleteMapping("games/{game-id}/players/{player-id}")
	public void deletePlayer(@PathVariable("game-id") String gameId, @PathVariable("player-id") String playerId) {
		if (games.getGame(gameId) == null) 
			throw new GameNotFoundException(gameId);
		
		games.getGame(gameId).deletePlayer(playerId);
	}
	
	@PutMapping("games/{game-id}/decks/shuffle")
	public void shuffleGameDecks (@PathVariable("game-id") String id) {
		if (games.getGame(id) == null) 
			throw new GameNotFoundException(id);
		
		games.getGame(id).shuffle();
	}
}
