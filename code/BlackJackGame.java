/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author manav
 */



import java.util.Scanner;

public class BlackJackGame extends Game {
    private BlackJackPlayer player;
    private BlackJackDealer dealer;
    private BlackJackDeck deck;
    private int rounds;
    private int dealerWins;
    private int playerWins;
    private int playerBalance; // Player's balance for betting
    private Scanner scanner;

    public BlackJackGame(String name) {
        super(name);
        this.dealer = new BlackJackDealer("Dealer", this);
        this.deck = new BlackJackDeck(); // Create a new deck
        this.dealerWins = 0;
        this.playerWins = 0;
        this.playerBalance = 1000; // Initial balance
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void play() {
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        player = new BlackJackPlayer(playerName) {
            @Override
            public void play() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };  

//        System.out.print("Enter number of rounds (1-5): ");
        rounds = 5;
//        if (rounds < 1 || rounds > 5) {
//            rounds = 5; 
//            System.out.println("Invalid number of rounds. Defaulting to 5 rounds.");
//        }

        System.out.println("Game Starting with " + playerName + " and Dealer!");
        
//        for (int round = 1; round <= rounds; round++) {
            System.out.println("-- Round " + rounds + " --");
            System.out.println("Your current balance: $" + playerBalance);
//            if (playerBalance==0){
//                    System.out.println(" Insufficent balance. Game will be Terminated");
//                 break;       
//                }
            placeBet(); // Allow player to place a bet
            
            playRound(rounds);  
        
        declareWinner();  
    }

    private void placeBet() {
        int betAmount = 0;
        while (true) {
            System.out.print("Place your bet (Available balance: $" + playerBalance + "): ");
            try {
                betAmount = Integer.parseInt(scanner.nextLine());
                if (betAmount > 0 && betAmount <= playerBalance) {
                    break;
                
                } else {
                    
                    System.out.println("Invalid bet amount. Please bet within your available balance.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
        player.setBetAmount(betAmount); // Store the player's bet amount
    }

    public void playRound(int roundNumber) {
        deck.shuffle();
        dealer.clearHand();
        player.clearHand();

        player.addCardToHand(deck.dealCard());
        player.addCardToHand(deck.dealCard());
        dealer.addCardToHand(deck.dealCard());
        dealer.addCardToHand(deck.dealCard());

        System.out.println(player.getName() + "'s turn:");
        player.play(deck, scanner);

        System.out.println("Dealer's turn:");
        while (dealer.getHandValue() < 17) {
            dealer.hit(deck);
        }
        System.out.println("Dealer stands with hand: " + dealer.getHand() + " total value: " + dealer.getHandValue());

        determineRoundWinner(roundNumber);
    }

    private void determineRoundWinner(int roundNumber) {
        System.out.println("----- Round Results -----");
        int dealerScore = dealer.getHandValue();
        System.out.println("Dealer's final hand: " + dealer.getHand() + " value: " + dealerScore);
        int playerScore = player.getHandValue();
        System.out.println(player.getName() + "'s final hand: " + player.getHand() + " value: " + playerScore);

        if (playerScore > 21) {
            System.out.println(player.getName() + " busted!");
            playerBalance -= player.getBetAmount();  // Deduct bet if player busts
        } else if (dealerScore > 21 || playerScore > dealerScore) {
            System.out.println(player.getName() + " wins this round!");
            playerBalance += player.getBetAmount();  // Add bet to player balance
            playerWins++;
        } else if (playerScore < dealerScore) {
            System.out.println(player.getName() + " loses this round!");
            playerBalance -= player.getBetAmount();  // Deduct bet if player loses
            dealerWins++;
        } else {
            System.out.println(player.getName() + " ties with the dealer!");
        }
    }

    @Override
    public void declareWinner() {
        System.out.println("----- Overall Game Results -----");
        System.out.println("Dealer won " + dealerWins + " rounds.");
        System.out.println(player.getName() + " won " + playerWins + " rounds.");

        if (playerWins > dealerWins) {
            System.out.println(player.getName() + " wins the game!");
        } else if (playerWins < dealerWins) {
            System.out.println("Dealer wins the game!");
        } else {
            System.out.println("The game is a tie!");
        }

        System.out.println("Your final balance: $" + playerBalance);
    }
}
