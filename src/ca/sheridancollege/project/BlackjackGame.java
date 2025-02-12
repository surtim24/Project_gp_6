package ca.sheridancollege.project;

import java.util.ArrayList;

public class BlackjackGame extends Game {

    private GroupOfCards deck;

    public BlackjackGame(String name) {
        super(name);
        this.deck = new GroupOfCards(52); // A deck of 52 cards
        // Initialize deck with Blackjack cards (to be implemented later)
    }

    @Override
    public void play() {
        // Game play logic (to be implemented later)
    }

    @Override
    public void declareWinner() {
        // Declare winner based on scores (to be implemented later)
    }

    public GroupOfCards getDeck() {
        return deck;
    }

    public void setDeck(GroupOfCards deck) {
        this.deck = deck;
    }
}
