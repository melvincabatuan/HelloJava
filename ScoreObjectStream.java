import java.io.*;
import java.util.*;


public class ScoreObjectStream {
 public static void main(String[] args)
 throws ClassNotFoundException, IOException {

 int[] numbers = {200, 90, 90, 180, 210};
 String[] strings = {"Pico", "John", "Susan", "Kim", "Shin"};

 ArrayList<HighScore> hs = new ArrayList<HighScore>();
 ArrayList<HighScore> newHs = new ArrayList<HighScore>();

 for (int i = 0; i < 5; i++){
   hs.add(new HighScore(strings[i], numbers[i]));
}


 //System.out.println(hs.toString());
 
 // Create an output stream for file array.dat
 ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("array.dat",true));

 // Write arrays to the object output stream
 output.writeObject(numbers);
 output.writeObject(strings);
 output.writeObject(hs);
 

 // Close the stream
 output.close();

 // Create an input stream for file array.dat
 ObjectInputStream input = new ObjectInputStream(new FileInputStream("array.dat"));

 int[] newNumbers = (int[])(input.readObject());
 String[] newStrings = (String[])(input.readObject());

try {
  newHs = (ArrayList<HighScore>)(input.readObject());
}       catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } 
 

 // Display arrays
 System.out.println(Arrays.toString(newNumbers)); 
 System.out.println(Arrays.toString(newStrings));
 System.out.println(newHs.toString());

 input.close();
 }
}
