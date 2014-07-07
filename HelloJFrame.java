import javax.swing.*;

public class HelloJFrame
{
   public static void main(String[] args)
   {
      JFrame f = new JFrame();
      JLabel hello = new JLabel("Hello, World!");      
      f.add(hello);
      f.setSize(200,100); // (Width, Height)
      f.setVisible(true);
   }
}
