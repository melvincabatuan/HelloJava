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

//public class NameSurfer extends ConsoleProgram implements NameSurferConstants {
public class NameSurfer extends Program implements NameSurferConstants {

/* The region along the NORTH edge of the window
contains several interactors: a JLabel, a JTextField, and two JButtons.
*/
	private JTextField textField;
	private JButton button1;
	private JButton button2;
        private NameSurferDataBase dataBase; // milestone 3
	private NameSurferGraph graph;   // milestone 4
	
	/* Method: init() */
	/**
	 * This method has the responsibility for reading in the data base
	 * and initializing the interactors at the top of the window.
	 */
	public void init() {
	    // You fill this in, along with any helper methods //
             
            /// 1. Initialize and add interactors with their listeners
		JLabel name = new JLabel("Name:");
		textField = new JTextField(30);
		button1 = new JButton("Graph");
		button2 = new JButton("Clear");

		textField.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		
                //Add to the region along the NORTH edge of the window
		add(name, NORTH);
		add(textField, NORTH);
		add(button1, NORTH);
		add(button2, NORTH);

            /// 2. Initialize database
                dataBase = new NameSurferDataBase(NAMES_DATA_FILE);

            /// 3. Initialize and add graph 
                graph = new NameSurferGraph();
                add(graph);
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
        String nameEntry = textField.getText();	
        if (source == button1 || source == textField){   	
        	// println("Graph: " + textField.getText()); // milestone 1
                NameSurferEntry temp = dataBase.findEntry(nameEntry); 
                if(temp != null){
                  println("Graph: " + temp); // milestone 3
                  graph.addEntry(dataBase.findEntry(nameEntry));
                  graph.update();
                  }
                else {
                  graph.update();
                  graph.notFound(nameEntry);
                  }
  		}
        else if (source == button2){
        	 // println("Clear"); // milestone 1
                  graph.clear();
                  graph.update();
		}
	}
}
