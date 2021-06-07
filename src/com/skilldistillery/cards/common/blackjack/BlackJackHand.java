package com.skilldistillery.cards.common.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackJackHand extends Hand{

	public BlackJackHand() {
		super();
	}
	
	public int getHandValue() {
		int value = 0; 
		
		for (Card card : cards) {
			value += card.getValue();
		}
		
		return value; 
	}
	
	public boolean isBust() {
		
		if (getHandValue() > 21) {
			return true; 
		} else {
			return false; 
		}
		
	}
	
	public boolean isBlackJack() {
		
		if (getHandValue() == 21) {
			return true; 
		} else {
			return false;
		}
	}

	public String toString_Dealer() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("Hand: Face Down Card, ");
		builder.append(cards.get(1));
		builder.append(" - ");
		
		return builder.toString();
		
	}
	
	public String toString() {
		return "Hand: " + cards;
	}
	
	
}
