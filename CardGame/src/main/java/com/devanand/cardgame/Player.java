package com.devanand.cardgame;

public class Player {
	
	private String id = null;
	private String name = null;
	
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
	
	

}
