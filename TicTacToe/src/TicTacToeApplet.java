import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class TicTacToeApplet extends JApplet implements MouseListener
{
    private static final String PLAYERX = "Player X";
    private static final String PLAYERO = "Player O";
	
    private String playerName = PLAYERX;
	
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    private javax.swing.JButton button5;
    private javax.swing.JButton button6;
    private javax.swing.JButton button7;
    private javax.swing.JButton button8;
    private javax.swing.JButton button9;
    private javax.swing.JLabel playerNumber;
    private java.awt.Panel buttonsPanel;
    private int counter;

    public void init(){
        initComponents();
    }

    private void initComponents(){
        buttonsPanel = new java.awt.Panel();
        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        button5 = new javax.swing.JButton();
        button6 = new javax.swing.JButton();
        button7 = new javax.swing.JButton();
        button8 = new javax.swing.JButton();
        button9 = new javax.swing.JButton();
        playerNumber = new javax.swing.JLabel(playerName, SwingConstants.RIGHT);
	    
        button1.addMouseListener(this);
        button2.addMouseListener(this);
        button3.addMouseListener(this);
        button4.addMouseListener(this);
        button5.addMouseListener(this);
        button6.addMouseListener(this);
        button7.addMouseListener(this);
        button8.addMouseListener(this);
        button9.addMouseListener(this);
    
        Font buttonFont = new Font("Times New Roman", Font.PLAIN, 50);
	    
        button1.setFont(buttonFont);
        button2.setFont(buttonFont);
        button3.setFont(buttonFont);
        button4.setFont(buttonFont);
        button5.setFont(buttonFont);
        button6.setFont(buttonFont);
        button7.setFont(buttonFont);
        button8.setFont(buttonFont);
        button9.setFont(buttonFont);
	    
        buttonsPanel.setLayout(new java.awt.GridLayout(4, 3));
        
        buttonsPanel.add(button1);
        buttonsPanel.add(button2);
        buttonsPanel.add(button3);
        buttonsPanel.add(button4);
        buttonsPanel.add(button5);
        buttonsPanel.add(button6);
        buttonsPanel.add(button7);
        buttonsPanel.add(button8);
        buttonsPanel.add(button9);
        
        setPlayerName(PLAYERX);   
        buttonsPanel.add(playerNumber);
        add(buttonsPanel);
        counter = 0;
    }
	
    private void setPlayerName(String playerName){
        this.playerName = playerName;
        playerNumber.setText( playerName  + " your turn.");
        System.out.println(playerNumber.getText());
    }
	
    private void reset(){
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        setPlayerName(PLAYERX);
        counter = 0;
    }
	
   public void checkForWinner(){
        String [] str = {"OK"};
        
        if(findThreeInARow()){
            String winnerName = (playerName == PLAYERX)?PLAYERO:PLAYERX;
        
            JOptionPane.showOptionDialog(this, winnerName.concat(" won!!! Congratulations!!!"),
        		"Congratulations!", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, str, "OK");
            reset();
        }  
        else if (counter == 9){
        	JOptionPane.showOptionDialog(this, "It's a DRAW!",
            		"Please try again!", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, str, "OK");
                reset();
        }
        
    }
    
	
    public void mouseClicked(MouseEvent e) {
        javax.swing.JButton currentButton = (JButton)e.getComponent();
        if (currentButton.getText() == ""){
            if (playerName == PLAYERX) {
                currentButton.setText("X");
                setPlayerName(PLAYERO);
            } 
            else if (playerName == PLAYERO){
                currentButton.setText("O");
                setPlayerName(PLAYERX);
            }
            counter++;
        }
        
        checkForWinner();        
    }

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
	
	private boolean findThreeInARow(){
	    if ((button1.getText() == button2.getText() && button2.getText() == button3.getText() && button1.getText() != "") ||
	    	(button4.getText() == button5.getText() && button5.getText() == button6.getText() && button4.getText() != "") || 
	        (button7.getText() == button8.getText() && button8.getText() == button9.getText() && button7.getText() != "") ||
            (button1.getText() == button4.getText() && button4.getText() == button7.getText() && button1.getText() != "") ||
            (button2.getText() == button5.getText() && button5.getText() == button8.getText() && button2.getText() != "") ||
            (button3.getText() == button6.getText() && button6.getText() == button9.getText() && button3.getText() != "") ||
            (button1.getText() == button5.getText() && button5.getText() == button9.getText() && button1.getText() != "") ||
            (button3.getText() == button5.getText() && button5.getText() == button7.getText() && button3.getText() != "")
        )
	        return true;
	    else
	        return false;
    }
}