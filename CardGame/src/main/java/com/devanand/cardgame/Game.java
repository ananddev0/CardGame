package com.devanand.cardgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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
	
	public List<Card> getShoe() {
		return shoe;
	}

	public HashMap<String, Player> getPlayers() {
		return players;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void deletePlayer(String id) {
		players.remove(id);
	}

	public void shuffle() {
		for (int i = 0; i < shoe.size()/2; i++) {
			if (shoe.size()>0) {
				int index1 = ThreadLocalRandom.current().nextInt(0, shoe.size());
				int index2 = ThreadLocalRandom.current().nextInt(0, shoe.size());
				swapCards (index1, index2);
			}
		}
	}
	
	private void swapCards (int index1, int index2) {
		Card card1 = shoe.get(index1);
		Card card2 = shoe.get(index2);
		
		Card temp = card1;
		shoe.set(index1, card2);
		shoe.set(index2, temp);
	}
}
