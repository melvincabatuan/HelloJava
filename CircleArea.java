/**
* Compute Circle Area
* @author mkc
*/

import java.util.*;

class CircleArea{

  public static void main(String[] arguments){

    Scanner keyboard = new Scanner(System.in);

    System.out.print("Enter the radius: ");
    double radius = keyboard.nextDouble();

    if (radius >= 0){
        double area = Math.PI * radius * radius;
        System.out.println("The area of the circle of radius "+ radius+ " is " 
                            + String.format("%.2f", area) + ".");
    }
    else{
        System.out.println("Error: Radius must be greater or equal to zero.");   
    }

  }//ENDMAIN
}//ENDCLASS
