/**
* A Simple Java Program to illustrate Scanner input.
* @author mkc
*/

import java.util.Scanner;

public class Input{

     public static void main(String []args){
        System.out.println("Hello World");
        
        Scanner user_input = new Scanner(System.in);
        
        String first_name;
        System.out.println("Enter your name: ");
        first_name = user_input.nextLine();
        
        int age;
        System.out.println("Enter your age: ");
        age = user_input.nextInt();

        double weight;
        System.out.println("Enter your weight (in kg): ");
        weight = user_input.nextDouble();

        System.out.println("You are "+ first_name);
        System.out.println("You are "+ age + " years old.");
        System.out.println("You weigh "+ weight + " kg.");
     }
}
