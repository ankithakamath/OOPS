package com.yml.deckofcards;

import java.util.*;

public class DeckOfCards {
	 public static void main(String args[]) {
	       
	        DeckOfCards.run();
	    }
	

    public static void run() {
        Cards deck = new Cards();
        deck.init();
        
		String playersArray[][] = deck.shuffle();
		deck.printDeck(playersArray);
    }
}
