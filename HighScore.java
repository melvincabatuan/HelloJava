import java.io.*;


public class HighScore implements Serializable {

    /// Instance Variable   
    private String playerName;
    private int highScore;

    /// Constructor
    public HighScore(String player, int score) {
        this.playerName = player;
        this.highScore = score;
    }

    /// get Player Name  
    public String getPlayerName() {
        return playerName;
    }

    /// get High Score
    public int getHighScore() {
        return highScore;
    }

    public String toString() {
        String text = " " + playerName+": " + highScore + " ";
        return text;
    }
}
