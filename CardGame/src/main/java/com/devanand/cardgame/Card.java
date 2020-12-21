package com.devanand.cardgame;

import java.util.ArrayList;
import java.util.List;

public class Card {
	
	public enum Suit {HEARTS, SPADES, CLUBS, DIAMONDS}
	public enum Face {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}
	
	private final Suit suit;
	private final Face face;
	private static final List<Card> deck = new ArrayList<Card>();
	
	static {
		for (Suit s: Suit.values()) {
			for (Face f: Face.values()) {
				deck.add(new Card(s, f));
			}
		}
	}
	
	private Card (Suit suit, Face face) {
		this.suit = suit;
		this.face = face;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public Face getFace() {
		return face;
	}
	
	public String toString() {
		return face + " of " + suit;
	}
	
	public static ArrayList<Card> getDeck() {
		return new ArrayList<Card>(deck); // make a copy we don't want sharing here.
	}
	

}
