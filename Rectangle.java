// This Java Program determines the area and
// perimeter of a rectangle.

import javax.swing.JOptionPane;

public class Rectangle
{
	public static void main(String[] args)
	{
	double width, length, area, perimeter; 
	String lengthStr, widthStr, outputStr; 

        /// Prompt the user for input and convert the string to double
	lengthStr = JOptionPane.showInputDialog("Enter the length: ");  
	length = Double.parseDouble(lengthStr);  

	widthStr = JOptionPane.showInputDialog("Enter the width: ");  
	width = Double.parseDouble(widthStr); 

	/// Compute the area and perimeter of rectange
	area = length * width;  
	perimeter = 2 * (length + width);  

        /// Format the output string
	outputStr = "Length: " + length + "\n" +
	"Width: " + width + "\n" +
	"Area: " + area + " square units\n" +
	"Perimeter: " + perimeter + " units\n"; 

        /// Output GUI
	JOptionPane.showMessageDialog(null, outputStr,"Rectangle", JOptionPane.INFORMATION_MESSAGE);  
	System.exit(0);  
	} //ENDMAIN
}//ENDCLASS
