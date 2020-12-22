package com.devanand.cardgame.model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
	
	String id = null;
	Deque<Card> shoe = new ArrayDeque<>();
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
	
	public Player getPlayer(String id) {
		return players.get(id);
	}
	
	public Deque<Card> getShoe() {
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
		List<Card> shoeForShuffle = new ArrayList<Card>(shoe);
		for (int i = 0; i < shoeForShuffle.size()/2; i++) {
			if (shoe.size()>0) {
				int index1 = ThreadLocalRandom.current().nextInt(0, shoeForShuffle.size());
				int index2 = ThreadLocalRandom.current().nextInt(0, shoeForShuffle.size());
				swapCards (shoeForShuffle, index1, index2);	
			}
		}
		shoe = new ArrayDeque<Card>(shoeForShuffle);
	}
	
	private void swapCards (List<Card> forShuffle, int index1, int index2) {
		Card card1 = forShuffle.get(index1);
		Card card2 = forShuffle.get(index2);
		
		Card temp = card1;
		forShuffle.set(index1, card2);
		forShuffle.set(index2, temp);
	}
}
