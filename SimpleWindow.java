//Simple Java program to create a window.

import javax.swing.*;
import java.awt.*;

public class SimpleWindow extends JFrame
{
	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;

	/// Constructor
	public SimpleWindow() 
	{
	   setTitle("This is my window");
	   setSize(WIDTH, HEIGHT);
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   setVisible(true);
	}

	public static void main(String[] args)
	{
	   SimpleWindow rectProg = new SimpleWindow();
           JLabel lengthL;
           lengthL = new JLabel("Enter the length:", SwingConstants.RIGHT);
	}//ENDMAIN 
}//ENDCLASS
