import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;


public class HighScoreManagerTest {


 public static void main(String[] args)
 throws ClassNotFoundException, IOException {

 int[] numbers = {180, 80, 90, 180, 210};
 String[] strings = {"Pico", "Nano", "Kilo", "Giga", "Shin"};

 ArrayList<HighScore> hs = new ArrayList<HighScore>();
ArrayList<HighScore> newHs = new ArrayList<HighScore>();

 for (int i = 0; i < 5; i++){
   hs.add(new HighScore(strings[i], numbers[i]));
}

 HighScoreManager hsm = new HighScoreManager(hs);
 hsm.sort();
 hsm.showHighScores();

 System.out.println("Min score = " + hsm.getMinScore());
 System.out.println("Max score = " + hsm.getMaxScore());

 hsm.insertHighScore(new HighScore("Melvin", 500));
 hsm.insertHighScore(new HighScore("Kong", 50));

 System.out.println("New min score = " + hsm.getMinScore());
 System.out.println("New max score = " + hsm.getMaxScore());

// hsm.writeHighScores();

/// 
try {
      hsm.loadHighScores();
}       catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


  hsm.showHighScores();
 }
}
