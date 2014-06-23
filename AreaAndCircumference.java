/** 
Program to determine the area and circumference of a circle
@author mkc
*/

import javax.swing.JOptionPane;

public class AreaAndCircumference{
                 
   public static void main(String[] arguments) {
   
    double radius; 
    double area; 
    double circumference; 
    String radiusString;                                  
    String outputStr; 

    /** Get the radius. */
    radiusString =JOptionPane.showInputDialog ("Enter the radius: ");
    radius = Double.parseDouble(radiusString); 
           
    /** Compute area and circumference. */
    area = Math.PI * radius * radius;
    circumference = 2 * Math.PI * radius; 

    /** Format String. */ 
    outputStr = "Radius: " + radius + " units" + "\n" +"Area: " + String.format("%.2f", area) + 
                " square units\n" + "Circumference: " + 
                String.format("%.2f", circumference)  + " units";   
    
    /** Display area and circumference. */		
    JOptionPane.showMessageDialog(null, outputStr, "Circle",              
                                JOptionPane.INFORMATION_MESSAGE); 
    System.exit(0);   
                                    	
  }//ENDMAIN
}//ENDCLASS

