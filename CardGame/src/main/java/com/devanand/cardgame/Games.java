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
	
	public static void addGame(Game game) {
		gameMap.put(game.getId(), game);
	}
	
	public static List<Game> getGames() {
		return new ArrayList<Game>(gameMap.values());
	}

}
