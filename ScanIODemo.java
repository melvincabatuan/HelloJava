/**
* A Simple Java Program
* @author mkc
*/

import java.util.Scanner;

class ScanIODemo{

  public static void main(String[] arguments){

    Scanner keyboard = new Scanner(System.in);

    String name;
    int age;
    double weight;
 
    System.out.print("Enter your name (string): ");
    name = keyboard.nextLine();
 
    System.out.print("Enter your age (integer): ");
    age = keyboard.nextInt();

    System.out.print("Enter your weight (double): ");
    weight = keyboard.nextDouble();

    System.out.println("Greetings " + name + ". You are " + age +
                     " years old. You weigh "+ weight + " kilograms.");
  }// ENDMAIN 
}//ENDCLASS
