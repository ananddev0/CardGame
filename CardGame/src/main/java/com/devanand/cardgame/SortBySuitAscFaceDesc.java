package com.devanand.cardgame;

import java.util.*;

public class SortBySuitAscFaceDesc implements Comparator<Card> {

	@Override
	public int compare(Card o1, Card o2) {
		if (o1.getSuit().compareTo(o2.getSuit()) == 0) {
			return o2.getFace().compareTo(o1.getFace());
		} else {
			return o1.getSuit().compareTo(o2.getSuit());
		}
	}

}
