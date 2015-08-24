/*
* HelloACM
* $ javac -classpath .:acm.jar HelloACM.java 
* $ java -classpath .:acm.jar HelloACM 
*/

import acm.graphics.*;
import acm.program.*;

public class HelloACM extends GraphicsProgram{
   public void run(){
      add(new GLabel("Hello ACM!"), 100, 100);
   }
}
