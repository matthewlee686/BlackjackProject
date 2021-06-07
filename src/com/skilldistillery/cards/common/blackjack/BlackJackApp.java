package com.skilldistillery.cards.common.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;
import com.skilldistillery.cards.common.Hand;

public class BlackJackApp {
	
	//Instance Deck
	private Deck deck;

	public static void main(String[] args) {
	
		//Make Scanner
		Scanner input = new Scanner(System.in);
		
		//Make Launch
		
		//Instance Class to Main
		BlackJackApp app = new BlackJackApp(); 
		app.launch(input);
		
		//Close Scanner
		input.close();
		
	}
	
	public void launch(Scanner input) {
		
		//Create new Deck 
		deck = new Deck(); 
		
		String choice = ""; 
		
		//Boolean to Determine Winner
		boolean player_win = false; 
		boolean dealer_win = false;
		
		System.out.println("Welcome to Blackjack!");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~\n");
	
			//Initial deal
			System.out.println("Dealing Cards...\n");
			
			//Instance Player and Dealer Hand
			//Instance new Card to add to respective lists
			Hand player_hand = new BlackJackHand(); 
			Hand dealer_hand = new BlackJackHand(); 
			Card card = null;
			
			//Tracking Winner Starts Here
			while(player_win == false && dealer_win == false) {
			
			//Initial Player deal and Check for Winner
			for(int i = 0; i < 2; i++) {
			deck.shuffle();
			card = deck.dealCard();
			player_hand.addCard(card);
				if(player_hand.isBlackJack()) {
					System.out.println("\nPlayer gets Blackjack!\n");
					player_win = true;
					break;
				} else if(player_hand.isBust()) {
					System.out.println("\nPlayer Busts!\n");
					dealer_win = true;
					break;
				}
			}
			
			//Initial Dealer deal and Check for Winner
			for(int i = 0; i < 2; i++) {
			deck.shuffle();
			card = deck.dealCard();
			dealer_hand.addCard(card);
				if(dealer_hand.isBlackJack()) {
					System.out.println("\nDealer gets Blackjack\n");
					dealer_win = true;
					break;
				} else if(dealer_hand.isBust()) {
					System.out.println("\nDealer Busts\n");
					player_win = true;
					break;
				}
			}
			
			
			
			//Show initial hand
			System.out.println("=====================================================================");
			System.out.println("Player " + player_hand.toString() + " - Value: " + player_hand.getHandValue());
			
			System.out.println("Dealer " + dealer_hand.toString_Dealer() + " Value: " + dealer_hand.getHandValue());
			System.out.println("=====================================================================");
			
			//Check for Winner
			if(dealer_win == true) {
				break;
			} else if(player_win == true) {
				break;
			}

			
			//Hit or Stand
			do {
				System.out.println("\nHit or Stand?");
				choice = input.next().toUpperCase();
			
			if(choice.equals("HIT")) {
				card = deck.dealCard();
				player_hand.addCard(card);
				System.out.println("Player " + player_hand.toString() + " - Value: " + player_hand.getHandValue());
				
				if(player_hand.isBust()) {
					System.out.println("\nPlayer Bust!");
					dealer_win = true;
					break;
				
				}  else if (player_hand.isBlackJack()) {
					System.out.println("\nPlayer gets Blackjack!");
					player_win = true;
					break;
					}
				
				} 
			
			} while(!choice.equals("STAND")); //While for Hit or Stand
			
			//Check for Winner
			if(dealer_win == true) {
				break;
			} else if(player_win == true) {
				break;
			}
			
			if(dealer_hand.getHandValue() < 17) {
				
				while(dealer_hand.getHandValue() < 17) {
					card = deck.dealCard();
					dealer_hand.addCard(card);
					System.out.println("\nDealer Hits...");
					System.out.println("\nDealer " + dealer_hand.toString_Dealer() + card + " - Value: " + dealer_hand.getHandValue());
				
				if(dealer_hand.isBust()) {
					System.out.println("\nDealer Busts!\n");
					player_win = true;
					break;
				} else if(dealer_hand.isBlackJack()) {
					System.out.println("\nDealer gets Blackjack!\n");
					dealer_win = true; 
					break;
					} 
				}//while dealer
			}//If Dealer hand is less than 17
			
			else if(dealer_hand.getHandValue() >= 17 && dealer_hand.getHandValue() <= 21) {
				System.out.println("\nDealer Stands");
			}
			
			//Check for Winner
			System.out.println();
			if(dealer_hand.getHandValue() > player_hand.getHandValue()) {
				dealer_win = true;
			} else if (dealer_hand.getHandValue() < player_hand.getHandValue()){
				player_win = true;
			} else {
				System.out.println("Round is a Tie");
				break;
			}
			
		}//Boolean for Win
			
			//Show Final Hand
			System.out.println("\n                         Showing Hands: ");
			System.out.println("\n=====================================================================");
			System.out.println("Player " + player_hand.toString() + " - Value: " + player_hand.getHandValue());
			
			System.out.println("Dealer " + dealer_hand.toString() + " - Value: " + dealer_hand.getHandValue());
			System.out.println("=====================================================================");
			
			//Winner Output
			if(player_win == true) {
				System.out.println("\nPlayer Wins!");
			} else if(dealer_win == true) {
				System.out.println("\nDealer Wins!");
			} else {
				System.out.println();
			}
		
			//Clear Hands
			player_hand.clear();
			dealer_hand.clear();
			
	}//Launch Method
	
}//Class 
