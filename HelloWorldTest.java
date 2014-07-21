import javax.swing.*;

public class HelloWorldTest extends JFrame
{
    HelloWorldTest(){       
       setTitle("Hello, World!");
       setSize(200,100);
       setVisible(true);
      }

   public static void main(String[] args)
   {
      new HelloWorldTest();
      }
}
