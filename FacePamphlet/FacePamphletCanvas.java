/*
 * File: FacePamphletCanvas.java
 * -----------------------------
 * This class represents the canvas on which the profiles in the social
 * network are displayed.  NOTE: This class does NOT need to update the
 * display when the window is resized.
 */


import acm.graphics.*;
import java.awt.*;
import java.util.*;

public class FacePamphletCanvas extends GCanvas implements FacePamphletConstants {

         private GLabel appMessage;
         private GLabel profileName;
         private GLabel profileStatus;
         private GLabel profileFriendsHeader;
         private GRect rectImage;
         private GLabel noImage;

         private double namebaselineY;        

	/** 
	 * Constructor
	 * This method takes care of any initialization needed for 
	 * the display
	 */ 
	public FacePamphletCanvas() {              
         
          /// Set profile name
              profileName = new GLabel("");
              profileName.setFont(PROFILE_NAME_FONT);
              profileName.setColor(Color.BLUE);           

          /// Set application message 
              appMessage = new GLabel("");
              appMessage.setFont(MESSAGE_FONT);             

          /// Set profile status  
              profileStatus = new GLabel("");
              profileStatus.setFont(PROFILE_STATUS_FONT);              

          /// Set friends header
              profileFriendsHeader = new GLabel("Friends:"); 
              profileFriendsHeader.setFont(PROFILE_FRIEND_LABEL_FONT);              

          /// Set rectangle for no image 
              rectImage = new GRect(IMAGE_WIDTH, IMAGE_HEIGHT);              

          /// Set label for no image
              noImage = new GLabel("No Image");   
              noImage.setFont(PROFILE_IMAGE_FONT); 
       	}
 
	
	/** 
	 * This method displays a message string near the bottom of the 
	 * canvas.  Every time this method is called, the previously 
	 * displayed message (if any) is replaced by the new message text 
	 * passed in.
	 */
	public void showMessage(String msg) {
              appMessage.setLabel(msg);  
              double app_x = (getWidth() - appMessage.getWidth())/2.0; 
              double app_y = getHeight() - BOTTOM_MESSAGE_MARGIN;                            
              add(appMessage, app_x, app_y);
	}
	
	
	/** 
	 * This method displays the given profile on the canvas.  The 
	 * canvas is first cleared of all existing items (including 
	 * messages displayed near the bottom of the screen) and then the 
	 * given profile is displayed.  The profile display includes the 
	 * name of the user from the profile, the corresponding image 
	 * (or an indication that an image does not exist), the status of
	 * the user, and a list of the user's friends in the social network.
	 */
	public void displayProfile(FacePamphletProfile profile) {

          removeAll();

          if (profile != null){
              displayName(profile.getName());
              displayImage(profile.getImage());
              displayStatus(profile.getName(), profile.getStatus());
              displayFriends(profile.getFriends());
             } 
	}


         private void displayName(String name){
            profileName.setLabel(name);
            namebaselineY = TOP_MARGIN + profileName.getHeight(); 
            add(profileName, LEFT_MARGIN, namebaselineY);
         }


         private void displayImage(GImage img){
             if (img != null){
                img.scale( IMAGE_WIDTH/img.getSize().getWidth(), IMAGE_HEIGHT/img.getSize().getHeight());
                add(img, LEFT_MARGIN, namebaselineY + IMAGE_MARGIN);
             }   

             else { 
               
                add(rectImage, LEFT_MARGIN, namebaselineY + IMAGE_MARGIN); 

              double noImg_x = LEFT_MARGIN + IMAGE_WIDTH/2 - noImage.getWidth()/2;
              double noImg_y = namebaselineY + IMAGE_MARGIN + IMAGE_HEIGHT/2 + noImage.getHeight()/2;                               
                add(noImage, noImg_x, noImg_y);
             }
         }


         private void displayStatus(String name, String status){
            if (status == null || status == ""){ 
               profileStatus.setLabel("No current status");                 
            }
            else {
               profileStatus.setLabel(name + " is " + status);
            }   
            add(profileStatus, LEFT_MARGIN, namebaselineY + IMAGE_MARGIN + IMAGE_HEIGHT + STATUS_MARGIN + profileStatus.getHeight());            
         }


         private void displayFriends(Iterator<String> friends){              
              add(profileFriendsHeader, getWidth()/2, namebaselineY + IMAGE_MARGIN);
              int counter = 1; 
              double offset = 5;            
              while (friends.hasNext()) {
                  GLabel f = new GLabel(friends.next());
                  f.setFont(PROFILE_FRIEND_FONT);
                  add(f, getWidth()/2, namebaselineY + IMAGE_MARGIN + counter * (f.getHeight() + offset)); 
                  counter++;           
              }              
         }
}
