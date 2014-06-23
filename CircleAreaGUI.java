/**
* Compute Circle Area
* @author mkc
*/

import javax.swing.JOptionPane;

class CircleAreaGUI{

  public static void main(String[] arguments){

    String inputStr = JOptionPane.showInputDialog("Enter the radius: ", "0");

    /** Handles null input */
    if (inputStr == null)
        return;

    double radius = Double.parseDouble(inputStr);
    if (radius >= 0){
        double area = Math.PI * radius * radius;
        JOptionPane.showMessageDialog( null, "The area of the circle of radius "+ radius+ " is " 
                            + String.format("%.2f", area) + " sq. units.");
    }
    else{
        JOptionPane.showMessageDialog( null, "Error: Radius must be greater or equal to zero.");   
    }

  }//ENDMAIN
}//ENDCLASS
