import javax.swing.JFrame;
import javax.swing.JButton;

public class HelloWorldJframeB extends JFrame {

    public HelloWorldJframeB(){
    	setSize(240,360);
    	setTitle("Hello World");
    	setVisible(true);
    	
    	// Adding a button
    	JButton myButton = new JButton ("Click me");
        add(myButton); 
        pack();
    }
	public static void main(String[] args) {
	    new HelloWorldJframeB();
	}

}
