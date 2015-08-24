/* 
 * File: FacePamphlet.java
 * -----------------------
 * When it is finished, this program will implement a basic social network
 * management system.
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;
import javax.swing.*;

//public class FacePamphlet extends Program implements FacePamphletConstants {
public class FacePamphlet extends ConsoleProgram implements FacePamphletConstants {

       	private JTextField textFieldName;
        private JTextField textFieldStatus;
        private JTextField textFieldPicture;
        private JTextField textFieldAddFriend;
	private JButton buttonAdd;
	private JButton buttonDelete;
        private JButton buttonLookup;
        private JButton buttonStatus;
        private JButton buttonPicture;
        private JButton buttonAddFriend;
 
	/**
	 * This method has the responsibility for initializing the 
	 * interactors in the application, and taking care of any other 
	 * initialization that needs to be performed.
	 */
	public void init() {
		// You fill this in
                /// 1. Initialize and add interactors with their listeners
		JLabel name = new JLabel("Name:");

		textFieldName = new JTextField(TEXT_FIELD_SIZE);
                textFieldStatus = new JTextField(TEXT_FIELD_SIZE);
                textFieldStatus.addActionListener(this);
                textFieldPicture = new JTextField(TEXT_FIELD_SIZE);
                textFieldPicture.addActionListener(this);
                textFieldAddFriend = new JTextField(TEXT_FIELD_SIZE);
                textFieldAddFriend.addActionListener(this);

		buttonAdd = new JButton("Add");
		buttonDelete = new JButton("Delete");
                buttonLookup = new JButton("Lookup");	
                buttonStatus = new JButton("Change Status");	
                buttonPicture = new JButton("Change Picture");
                buttonAddFriend = new JButton("Add Friend");
		
                /// Add to the region along the NORTH and WEST edge of the window
		add(name, NORTH);
		add(textFieldName, NORTH);
		add(buttonAdd, NORTH);
		add(buttonDelete, NORTH);
                add(buttonLookup, NORTH);

                add(textFieldStatus, WEST);
                add(buttonStatus, WEST);
                add(new JLabel(EMPTY_LABEL_TEXT), WEST);
                add(textFieldPicture, WEST);                 
                add(buttonPicture, WEST);
                add(new JLabel(EMPTY_LABEL_TEXT), WEST);
                add(textFieldAddFriend, WEST);
                add(buttonAddFriend, WEST);

                addActionListeners();
    }
    
  
    /**
     * This class is responsible for detecting when the buttons are
     * clicked or interactors are used, so you will have to add code
     * to respond to these actions.
     */
    public void actionPerformed(ActionEvent e) {
		// You fill this in as well as add any additional methods
              Object source = e.getSource(); 
	
              String nameEntry = textFieldName.getText();
              String statusEntry = textFieldStatus.getText();
              String pictureEntry = textFieldPicture.getText();
              String friendEntry = textFieldAddFriend.getText();
	
              if (source == buttonAdd && !nameEntry.isEmpty()){
                 println("Add: " + nameEntry);
              }
              else if (source == buttonDelete && !nameEntry.isEmpty()){
                 println("Delete: " + nameEntry);
              } 
              else if (source == buttonLookup && !nameEntry.isEmpty()){
                 println("Lookup: " + nameEntry);
              }
              else if ((source == buttonStatus || source == textFieldStatus) && !statusEntry.isEmpty()){
                 println("Change Status: " + statusEntry);
              }
              else if ((source == buttonPicture || source == textFieldPicture) && !pictureEntry.isEmpty()){
                 println("Change Picture: " + pictureEntry);
              }
              else if ((source == buttonAddFriend || source == textFieldAddFriend) && !friendEntry.isEmpty()){
                 println("Add Friend: " + friendEntry);
              }
    }

}
