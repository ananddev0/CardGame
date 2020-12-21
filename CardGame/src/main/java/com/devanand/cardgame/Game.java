package com.devanand.cardgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
	
	String id = null;
	List<Card> shoe = new ArrayList<>();
	HashMap<String, Player> players = new HashMap<String, Player>();
	
	public Game(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void addDeck(List<Card> deck) {
		shoe.addAll(deck);
	}
	
	public void addPlayer(Player player) {
		players.put(player.getId(), player);
	}
	
	public void shuffle() {
		//TODO Shuffle
	}
	
}
