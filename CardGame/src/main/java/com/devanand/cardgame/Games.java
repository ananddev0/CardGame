package com.devanand.cardgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Games {
	
	private static final Games games = new Games();
	private static final HashMap<String, Game> gameMap = new HashMap<String, Game> ();
	
	private Games() {
		
	}
	
	public static Games getInstance() {
		return games;
	}
	
	public void addGame(Game game) {
		gameMap.put(game.getId(), game);
	}
	
	public List<Game> getGames() {
		return new ArrayList<Game>(gameMap.values());
	}
	
	public void deleteGame(String id) {
		gameMap.remove(id);
	}
	
	public Game getGame(String id) {
		return gameMap.get(id);
	}
}
