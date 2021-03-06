package com.devanand.cardgame.model;

import java.util.*;

public class SortBySuitAscFaceDescComparator implements Comparator<Card> {

	@Override
	public int compare(Card o1, Card o2) {
		if (o1.getSuit().compareTo(o2.getSuit()) == 0) {
			return o2.getFace().compareTo(o1.getFace());
		} else {
			return o1.getSuit().compareTo(o2.getSuit());
		}
	}

}
