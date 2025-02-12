package ca.sheridancollege.project;

public class BlackjackPlayer extends Player {
    private int score; // Player's score in the game
    private boolean isBust; // Whether the player has busted

    public BlackjackPlayer(String name) {
        super(name);
        this.score = 0;
        this.isBust = false;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isBust() {
        return isBust;
    }

    public void setBust(boolean isBust) {
        this.isBust = isBust;
    }

    @Override
    public void play() {
        // Logic for player to take action (to be implemented later)
    }
}
