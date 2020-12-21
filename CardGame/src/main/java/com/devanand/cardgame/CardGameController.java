package com.devanand.cardgame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Player> addPlayers(@PathVariable("game-id") String id, @RequestBody List<Player> players) {
		if (games.getGame(id) == null) 
			throw new GameNotFoundException(id); 
		
		for (Player player: players) {
			if (player.getId() == null) {
				player.setId(RandomStringUtils.randomAlphanumeric(8));
			}
			(games.getGame(id)).addPlayer(player);
		}
		
		return new ArrayList<Player>(games.getGame(id).getPlayers().values());
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
	
	@GetMapping("games/{game-id}/decks/count/{groupby}")
	public LinkedHashMap<String, Integer> getUndealtCardsInShoe(@PathVariable("game-id") String id, @PathVariable("groupby") String groupBy) {
		if (games.getGame(id) == null) 
			throw new GameNotFoundException(id);
		
		List<Card> shoe = games.getGame(id).getShoe();
		LinkedHashMap<String, Integer> result = new LinkedHashMap<String, Integer>();
		switch(groupBy) {
		case "suits":
			countBySuit(shoe, result);
			break;
		case "cards":
			countByCards(shoe, result);
			break;
			default: throw new InvalidOptionException(groupBy);
		}
		return result;
	}

	private void countByCards(List<Card> shoe, LinkedHashMap<String, Integer> result) {
		List<Card> copyOfShoe = new ArrayList<Card>(shoe);
		Collections.sort(copyOfShoe, new SortBySuitAscFaceDesc());
		
		for (Card c: copyOfShoe) {
			
			if (result.get(c.toString())==null) {
				result.put(c.toString(), 1);
			} else {
				result.put(c.toString(), result.get(c.toString())+1);
			}
		
		}
	}

	private void countBySuit(List<Card> shoe, LinkedHashMap<String, Integer> result) {
		
		
		for (Card c: shoe) {
			
			if (result.get(c.getSuit().toString())==null) {
				result.put(c.getSuit().toString(), 1);
			} else {
				result.put(c.getSuit().toString(), result.get(c.getSuit().toString())+1);
			}
		}
	}	
	
	@PutMapping ("games/{game-id}/players/{player-id}/deal/{number-of-cards-per-hand}")
	public void dealCards(@PathVariable("game-id") String gameId, 
			@PathVariable("player-id") String playerId,
			@PathVariable("number-of-cards-per-hand") int numOfCards) {
		
			if (games.getGame(gameId) == null) 
				throw new GameNotFoundException(gameId);
			if (games.getGame(gameId).getPlayer(playerId) == null) 
				throw new PlayerNotFoundException(playerId);
		
			List<Card> shoe = games.getGame(gameId).getShoe();
			List<Card> hand = null;
			if (shoe.size()> numOfCards)
				hand = shoe.subList(0, numOfCards);
			else
				hand = shoe;
			
			if (hand.size()> 0) {
				games.getGame(gameId).getPlayer(playerId).addCards(new ArrayList<Card>(hand));	
				games.getGame(gameId).getShoe().removeAll(hand);
			}
	}
	
	@GetMapping("games/{game-id}/players/{player-id}/cards")
	public List<Card> getPlayerCards(@PathVariable("game-id") String gameId, 
			@PathVariable("player-id") String playerId) {
		return games.getGame(gameId).getPlayer(playerId).getCards();
	}
}
