import java.awt.event.*;
import java.awt.FlowLayout;
import javax.swing.*;

public class GUIdemo extends JFrame{

     private JButton bReg;
     private JButton bCustom;

     public GUIdemo(){
        super("My GUI");
        setLayout(new FlowLayout());

        bReg = new JButton("Regular Button");
        add(bReg);

        Icon i1 = new ImageIcon(getClass().getResource("b.png"));
        Icon i2 = new ImageIcon(getClass().getResource("x.png"));

        bCustom = new JButton("Custom Button", i1);
        custom.setRolloverIcon(i2);
        add(bCustom);

        HandlerClass handler = new HandlerClass();
        bReg.addActionListener(handler);  
        bCustom.addActionListener(handler);
        }

        private class HandlerClass implements ActionListener{
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, String.format("%s", e.getActionCommand()));
            }
        }
       
     

}
