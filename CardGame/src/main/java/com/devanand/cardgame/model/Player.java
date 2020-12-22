package com.devanand.cardgame.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String id = null;
	private String name = null;
	private List<Card> cards = new ArrayList<Card>();
	
	public Player (String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Player(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void addCards(List<Card> cards) {
		this.cards.addAll(cards);
	}
	
	public List<Card> getCards() {
		return this.cards;
	}
	
	public int getFaceCardValue() {
		return cards.stream().mapToInt(x -> x.getFace().ordinal()+1).sum();
	}
	
	public String toString() {
		return this.id + ", " + this.name + ", " + getFaceCardValue();
	}

}
