import java.util.*;

public class FindMaxWithDuplicates{

  private static ArrayList<Integer> winners = new ArrayList<Integer>();

  public static void main(String[] args){
       String [] playerNames = {"Nano", "Pico", "Kilo", "Giga"};
       //int [] scores = {300, 300, 150, 150}; // Congratulations!  Nano and Pico are the winners with scores tied at 300
       // int [] scores = {300, 300, 450, 150}; // Congratulations!  Kilo is the winner with a score of 450
      // int [] scores = {300, 300, 450, 450}; //Congratulations!  Kilo and Giga are the winners with scores tied at 450
      //int [] scores = {300, 500, 500, 500}; // Congratulations!  Pico, Kilo and Giga are the winners with scores tied at 500
       int [] scores = {500, 500, 500, 500};
       /// Congratulations!  Nano, Pico, Kilo and Giga are the winners with scores tied at 500
       String winnerNames = " ";

       findWinners(scores);
       System.out.println(winners);

       for (int i = 0; i < winners.size(); i++){
           winnerNames = winnerNames + playerNames[winners.get(i)];
           if (i < winners.size() - 2)
              winnerNames += ", ";
           else if (i == winners.size() - 2)
              winnerNames += " and ";
       }

       if ( winners.size() == 1)
            System.out.println("Congratulations! " + winnerNames + " is the winner with a score of " + scores[winners.get(0)]);
       else
            System.out.println("Congratulations! " + winnerNames + " are the winners with scores tied at " + scores[winners.get(0)]);
  }

  public static void findWinners(int[] arr){
      int max = arr[0];     /// Initialize first score as minimum   
      for (int i = 1; i < arr.length; i++ ){
           if(arr[i] > max){
              max = arr[i];
           }
      }
      /// Check for duplicates
      for (int i = 0; i < arr.length; i++ ){
          if (max == arr[i])
              winners.add(i);
      }
  } 

}
