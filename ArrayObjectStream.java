import java.io.*;
import java.util.*;


public class ArrayObjectStream {
 public static void main(String[] args)
 throws ClassNotFoundException, IOException {

 int[] numbers = {200, 90, 90, 180, 210};
 String[] strings = {"Pico", "John", "Susan", "Kim", "Shin"};

 Map<Integer, String> treeMap = new TreeMap<>();

 for (int i = 0; i < numbers.length; i++ ){
     treeMap.put(numbers[i], strings[i]);
 }

 System.out.println("treeMap = "+ treeMap);
 
 // Create an output stream for file array.dat
 ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("array.dat",true));

 // Write arrays to the object output stream
 output.writeObject(numbers);
 output.writeObject(strings);
 

 // Close the stream
 output.close();

 // Create an input stream for file array.dat
 ObjectInputStream input = new ObjectInputStream(new FileInputStream("array.dat"));

 int[] newNumbers = (int[])(input.readObject());
 String[] newStrings = (String[])(input.readObject());
 

 // Display arrays
 System.out.println(Arrays.toString(newNumbers)); 
 System.out.println(Arrays.toString(newStrings));


 input.close();
 }
}
