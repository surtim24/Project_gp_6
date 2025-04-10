/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author manav
 */
public class BlackJackCard extends Card {
    
    private String rank;
    private String suite;
    private int value;

    /**
     *
     * @param rank
     * @param suite
     * @param value
     */
    public BlackJackCard(String rank,String suite, int value) {
        this.rank = rank;
        this.suite=suite;
        this.value = value;
}
    
    @Override
    public String toString() {
        return rank + " of value " + value;
    }

    public int getValue() {
        return value;
    }

    public String getRank() {
        return rank;
    }
    
    
    
}
