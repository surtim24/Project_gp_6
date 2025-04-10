/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author manav
 */
public abstract class BlackJackPlayer extends Player {
    
    private ArrayList<BlackJackCard> hand;
    private int handValue;
    private boolean hasStood;
    private int betAmount;

    public BlackJackPlayer(String name) {
        super(name);
        this.hand = new ArrayList<>();
        this.hasStood = false;
    }

    public void addCardToHand(BlackJackCard card) {
        hand.add(card);
    }

    public int getHandValue() {
        int value = 0;
        for (BlackJackCard card : hand) {
            value += card.getValue();
        }
        return value;
    }

    public ArrayList<BlackJackCard> getHand() {
        return hand;
    }

    public boolean hasStood() {
        return hasStood;
    }

    public void stand() {
        hasStood = true;
    }

    public void hit(BlackJackDeck deck) {
        BlackJackCard card = deck.dealCard();
        addCardToHand(card);
        System.out.println(getName() + " hits and draws: " + card);
    }

    public void clearHand() {
        hand.clear();
    }

    public void resetStandStatus() {
        hasStood = false;
    }

    public void play(BlackJackDeck deck, Scanner scanner) {
        String action;
        OUTER:
        while (true) {
            System.out.println(getName() + "'s current hand: " + getHand() + " total value: " + getHandValue());
            if (getHandValue() >= 21) {
                break; // End turn if the player already has a winning or bust hand
            }
            System.out.print("Do you want to (h)it or (s)tand? ");
            action = scanner.nextLine().toLowerCase();
            switch (action) {
                case "h":
                    // Hit
                    Card card = deck.dealCard();
                    addCardToHand((BlackJackCard) card);
                    System.out.println(getName() + " hits and draws: " + card);
                    if (getHandValue() > 21) {
                        System.out.println(getName() + " busted!");
                        break OUTER; // End turn if player busts
                    }
                    break;
                case "s":
                    // Stand
                    break OUTER; // End turn if player stands
                default:
                    System.out.println("###############Invalid input, please enter 'h' to hit or 's' to stand.");
                    break;
            }
        }
    }

    public int getBetAmount(){
        return betAmount;
        
    }
    public void setBetAmount(int betAmount){
        this.betAmount=betAmount;
    }
}
