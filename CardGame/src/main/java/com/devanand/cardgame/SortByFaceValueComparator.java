package com.devanand.cardgame;

import java.util.Comparator;

public class SortByFaceValueComparator implements Comparator<Player>{

	@Override
	public int compare(Player o1, Player o2) {
		if (o1.getFaceCardValue() > o2.getFaceCardValue()) 
			return -1;
		else if (o1.getFaceCardValue() == o2.getFaceCardValue())
			return 0;
		else 
			return 1;
	}
}
