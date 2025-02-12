package ca.sheridancollege.project;

public class BlackjackCard extends Card {
    private String rank; // Rank of the card (e.g., "Ace", "2", "King")
    private String suit; // Suit of the card (e.g., "Hearts", "Spades")

    public BlackjackCard(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
