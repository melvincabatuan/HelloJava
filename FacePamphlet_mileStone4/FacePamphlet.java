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

        // Interactors
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

        // Database
        private FacePamphletDatabase faceDatabase; //milestone3

        // Current profile
        private FacePamphletProfile currentProfile; // milesStone4

 
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

                /// Initialize faceDatabase
                faceDatabase = new FacePamphletDatabase(); //milestone3

                ///
                currentProfile = null;
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

              boolean existing = faceDatabase.containsProfile(nameEntry);              
            

              /// Handles the Add button
              if (source == buttonAdd && !nameEntry.isEmpty()){
                 // println("Add: " + nameEntry); // milesStone1
                 if(existing){
                    println("Add: profile for " + nameEntry + " already exists: " + faceDatabase.getProfile(nameEntry));
                    currentProfile = faceDatabase.getProfile(nameEntry);                    
                 }
                 else{
                    currentProfile = new FacePamphletProfile(nameEntry);
                    faceDatabase.addProfile(currentProfile);
                    println("Add: new profile: " + faceDatabase.getProfile(nameEntry));                    
                 }
                  println("--> Current profile: " + currentProfile);
                    
              }


              /// Handles the Delete button
              else if (source == buttonDelete && !nameEntry.isEmpty()){
                 //println("Delete: " + nameEntry); // milesStone1
                  if(existing){ 
                      println("Delete: profile of " + faceDatabase.getProfile(nameEntry).getName() + " deleted"); 
                      faceDatabase.deleteProfile(nameEntry); 
                      /// Search all friends of nameEntry and remove him/her                      
                  }
                  else {
                      println("Delete: profile with name " + nameEntry + " does not exist");
                  }
                  currentProfile = null;
                  println("--> No current profile");
              } 


              /// Handles the Lookup button 
              else if (source == buttonLookup && !nameEntry.isEmpty()){
                 //println("Lookup: " + nameEntry); // milesStone1
                  if(existing){ 
                       println("Lookup: " + faceDatabase.getProfile(nameEntry));
                       currentProfile = faceDatabase.getProfile(nameEntry);
                       println("--> Current profile: " + currentProfile);
                  }
                  else {
                       println("Lookup: profile with name " + nameEntry + " does not exist");
                       currentProfile = null;
                       println("--> No current profile");
                  }
              }


              /// Handles Change Status
              else if ((source == buttonStatus || source == textFieldStatus) && !statusEntry.isEmpty()){
                 //println("Change Status: " + statusEntry); // milesStone1
                   if (currentProfile != null){
                        currentProfile.setStatus(statusEntry);
                        println("Status updated to " + currentProfile.getStatus());
                        println("--> Current profile: " + currentProfile);
                   }
                   else {
                        println("--> No current profile");
                        println("Select a profile to change the status");
                   }                   
              }


              /// Handle picture change
              else if ((source == buttonPicture || source == textFieldPicture) && !pictureEntry.isEmpty()){
                 //println("Change Picture: " + pictureEntry); // milestone1
                 if (currentProfile != null){
                    GImage picture = loadImage(pictureEntry);
                    if (picture != null){
                        currentProfile.setImage(picture);
                        println("Profile picture updated");
                        println("--> Current profile: " + currentProfile);
                    }
                    else {
                        println("Profile picture is not loaded successfully");
                    }
                }
                else {
                    println("--> No current profile");
                    println("Select a profile to change the picture");
                }
              }


              /// Handle add friend
              else if ((source == buttonAddFriend || source == textFieldAddFriend) && !friendEntry.isEmpty()){
                 // println("Add Friend: " + friendEntry); // milestone1
                 if (currentProfile != null){ 
                      boolean isAdded = currentProfile.addFriend(friendEntry);
                      if (isAdded) {
                          println(friendEntry + " was successfully added in the list of " + currentProfile.getName() + "'s friends."); 
                         FacePamphletProfile temp = (FacePamphletProfile) faceDatabase.getProfile(friendEntry);           
                         temp.addFriend(currentProfile.getName());
                      }
                      else {
                          println("The given friend name was already in the list of friends");  
                      }
                      println("--> Current profile: " + currentProfile);
                 }
                 else {
                    println("--> No current profile");
                    println("Select a profile for add friend");
                }
                 
              }
    }


     private GImage loadImage(String filename){
         GImage image = null;
          
         try {
             image = new GImage(filename);
          } catch (ErrorException ex) {
             ex.printStackTrace();
          }
       return image;
    }


       
      
             
    

}
