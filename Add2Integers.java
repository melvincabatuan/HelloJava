/*
$ javac -classpath .:acm.jar Add2Integers.java 
$ java -classpath .:acm.jar Add2Integers
*/

import acm.program.*;

public class Add2Integers extends ConsoleProgram {
   public void run() {
        println("This program adds two integers.");
        int n1 = readInt("Enter n1: ");
        int n2 = readInt("Enter n2: ");
        int total = n1 + n2;
   println("The total is " + total + ".");
   }
}
