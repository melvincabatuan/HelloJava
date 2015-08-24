import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;


public class HighScoreManagerTest {


 public static void main(String[] args)
 throws ClassNotFoundException, IOException {

 int[] numbers = {200, 90, 90, 180, 210};
 String[] strings = {"Pico", "Nano", "Kilo", "Giga", "Shin"};

 ArrayList<HighScore> hs = new ArrayList<HighScore>();
ArrayList<HighScore> newHs = new ArrayList<HighScore>();

 for (int i = 0; i < 5; i++){
   hs.add(new HighScore(strings[i], numbers[i]));
}

 HighScoreManager hsm = new HighScoreManager(hs);
 hsm.sort();
 //hsm.showHighScores();
 hsm.writeHighScores();

try {
      hsm.loadHighScores();
}       catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

  HighScoreManager hsm = new HighScoreManager(hs); 
 
 }
}
