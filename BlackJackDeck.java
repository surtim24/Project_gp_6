/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author manav
 */
public class BlackJackDeck extends GroupOfCards {
    
    private ArrayList<BlackJackCard> deck;


    public BlackJackDeck() {
        super();  // Call the parent constructor to initialize cards
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11}; // Value of each card (Ace is 11)

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards.add(new BlackJackCard(ranks[i], suit, values[i]));
            }
        }
        shuffle();  // Shuffle the deck after creating it
    }

    // Shuffle the deck
    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    // Deal a card and remove it from the deck
    public BlackJackCard dealCard() {
        if (cards.isEmpty()) {
            System.out.println("Deck is empty! Shuffling a new deck.");
            shuffleDeck();  // Replenish and shuffle the deck if it's empty
        }
        return cards.isEmpty() ? null : (BlackJackCard) cards.remove(0); // Deal the first card
    }

    // Get the number of remaining cards in the deck
    public int remainingCards() {
        return cards.size();
    }
}

