import java.io.*;
import java.util.*;


public class HighScoreManager{

 /// Constant number of high scores limit
 public static final int N_HIGH_SCORES = 10;
 /// Instance Variable
 private ArrayList<HighScore> scores;
 private int minScore; 
 private int maxScore;
 

 /// Constructors
   public HighScoreManager(){
      scores = new ArrayList<HighScore>();
  }


  public HighScoreManager(ArrayList<HighScore> highScores){
      scores = new ArrayList<HighScore>();
      for (int i = 0; i < highScores.size(); i++ )
         scores.add(highScores.get(i)); 
  }

 /// Load High scores from file
@SuppressWarnings("unchecked") /// suppresses unchecked warning
 public void loadHighScores() throws ClassNotFoundException, IOException{
   ObjectInputStream input = new ObjectInputStream(new FileInputStream("highScore.dat"));   
   scores = (ArrayList<HighScore>)(input.readObject());
   input.close();
 }

/// Write High scores to file highScore.dat
  public void writeHighScores() throws ClassNotFoundException, IOException{ 
   ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("highScore.dat",true));
   output.writeObject(scores);
   output.close();
}


/// Insert new high score


/// Sort high scores
public void sort() {
                int i, j; 
                HighScore temp;             
                for(i = 1; i < scores.size(); i++){
                   temp = scores.get(i);
                   j = i - 1; // index of previous element 
                   while(j > -1 && scores.get(j).getHighScore() < temp.getHighScore()){
                        scores.set(j+1, scores.get(j));
                        j--; 
                   }
                   scores.set(j+1, temp);            
                }
	}


/// Show high scores
   public void showHighScores(){
     HighScoreDisplay hsd = new HighScoreDisplay(scores);
   }

}
