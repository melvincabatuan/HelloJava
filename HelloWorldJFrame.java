//Simple Java program to create a window.

import javax.swing.JFrame;

public class HelloWorldJFrame extends JFrame
{
	 int WIDTH = 200;
	 int HEIGHT = 100;

	/// Constructor
	public HelloWorldJFrame() 
	{
	   setTitle("Hello, World!");
	   setSize(WIDTH, HEIGHT);
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   setVisible(true);
	}

	public static void main(String[] args)
	{
	   HelloWorldJFrame test = new HelloWorldJFrame();
	}//ENDMAIN 
}//ENDCLASS
