import javax.swing.*;
import java.awt.*;
import java.util.*;


public class HighScoreDisplay extends JFrame {

   public HighScoreDisplay(ArrayList<HighScore> scores){

         DefaultListModel<HighScore> dlm = new DefaultListModel<>();

         /// Add High scores to model
         for(int i = 0; i < scores.size(); i++ ){
             dlm.addElement(scores.get(i));
         }

         /// Create list
         JList<HighScore> highScoreList = new JList<>(dlm);
         JScrollPane scrollpane = new JScrollPane(highScoreList);
         getContentPane().add(scrollpane, BorderLayout.CENTER);
         //add(scrollpane);

         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setTitle("High Scores");
         this.setSize(640, 480);
         this.setLocationRelativeTo(null);
         this.setVisible(true);     
   }
}
