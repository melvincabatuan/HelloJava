import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;


public class SortArrayList{

   public static void main(String[] args){
       int[] numbers = {200, 90, 90, 180, 210};
       String[] strings = {"Pico", "John", "Susan", "Kim", "Shin"};

      ArrayList<HighScore> hs = new ArrayList<HighScore>();

     for (int i = 0; i < 5; i++){
       hs.add(new HighScore(strings[i], numbers[i]));
     }
      sort(hs);
      System.out.println(hs);
}


   public static void sort(ArrayList<HighScore> scores) {
                int i, j; 
                HighScore temp;             
                for(i = 1; i < scores.size(); i++){
                   temp = scores.get(i);
                   System.out.println(temp);                  
                   j = i - 1; // index of previous element 
                    System.out.println(scores.get(j).getHighScore());
                    System.out.println(temp.getHighScore());
                   while(j > -1 && scores.get(j).getHighScore() < temp.getHighScore()){
                        scores.set(j+1, scores.get(j));
                        j--; 
                   }
                   scores.set(j+1, temp);            
                }
	}

}
