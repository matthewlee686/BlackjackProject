package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
  private List<Card> cards;

  public Deck() {
	  cards = new ArrayList<>(52);
	    for(Suit suit : Suit.values()) {
	      for(Rank rank : Rank.values()) {
	    	 Card card = new Card(rank, suit);
	        cards.add(card);
	      }
	    }
  }
  
  public int checkDeckSize() {
	  
	  if(cards == null) {
		  return -1; 
	  }
	  
    return cards.size();
  }
  
  public void shuffle() {
    Collections.shuffle(cards);
  }
  
  public Card dealCard() {
    return cards.remove(0);
  }

	@Override
	public String toString() {
		return "Dealer Hand: " + cards;
	}
	  
  
  
}
