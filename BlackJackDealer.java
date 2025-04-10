/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;


/**
 *
 * @author manav
 */
public class BlackJackDealer  extends BlackJackPlayer{

    private final BlackJackGame game;
    
    public BlackJackDealer(String name, BlackJackGame game) {
        super(name);
        this.game = game;
    }

    @Override
    public void play(BlackJackDeck deck, Scanner scanner) {
        // Dealer's logic to play until their hand value is 17 or higher
        while (getHandValue() < 17) {
            BlackJackCard card = deck.dealCard();
            addCardToHand(card);
            System.out.println(getName() + " hits and draws: " + card);
        }
        System.out.println(getName() + " stands with hand: " + getHand() + " total value: " + getHandValue());
    }

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}