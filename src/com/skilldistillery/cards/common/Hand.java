package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {

	protected List<Card> cards; 
	
	public Hand() {
		cards = new ArrayList<>();
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void clear() {
		cards.removeAll(cards);
	}
		
	public abstract int getHandValue();
	
	public abstract boolean isBust(); 
	
	public abstract boolean isBlackJack();
	
	public abstract String toString_Dealer();
	
	public abstract String toString();
	
}

