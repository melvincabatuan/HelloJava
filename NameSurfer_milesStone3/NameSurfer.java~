/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

/* 
* Milestone 1: Add the interactors to the window and create an implementation for the actionPerformed method
* that allows you to check whether you can detect button clicks and read what’s in the text field. 
*
* $ javac -classpath .:acm.jar NameSurfer.java
* $ java -cp .:acm.jar NameSurfer
*/



import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends ConsoleProgram implements NameSurferConstants {
//public class NameSurfer extends Program implements NameSurferConstants {

/* The region along the NORTH edge of the window
contains several interactors: a JLabel, a JTextField, and two JButtons.
*/
	
	private JLabel name;
	private JTextField textField;
	private JButton button1;
	private JButton button2;
        private NameSurferDataBase dataBase;
	private NameSurferGraph graph;
	
	/* Method: init() */
	/**
	 * This method has the responsibility for reading in the data base
	 * and initializing the interactors at the top of the window.
	 */
	public void init() {
	    // You fill this in, along with any helper methods //
		name = new JLabel("Name:");
		textField = new JTextField(30);
		textField.addActionListener(this);
		button1 = new JButton("Graph");
		button1.addActionListener(this);
		button2 = new JButton("Clear");
		button2.addActionListener(this);
		    	
		
		add(name, NORTH);
		add(textField, NORTH);
		add(button1, NORTH);
		add(button2, NORTH);

            /// Initialize database
                dataBase = new NameSurferDataBase("names-data.txt");
	}

	/* Method: actionPerformed(e) */
	/**
	 * This class is responsible for detecting when the buttons are
	 * clicked, so you will have to define a method to respond to
	 * button actions.
	 */
	public void actionPerformed(ActionEvent e) {
		// You fill this in //
		Object source = e.getSource();
		
        if (source == button1 || source == textField){        	
        	// println("Graph: " + textField.getText());
                   println("Graph: " + dataBase.findEntry(textField.getText()));
		}
        else if (source == button2){
        	   println("Clear");
		}
        repaint();
	}
}
