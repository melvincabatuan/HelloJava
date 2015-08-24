import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

import acm.program.ConsoleProgram;

/* Code from CS106A Interactors and Searching Lecture
 * July 31, 2014 - Summer Quarter
 * Yves Lu
MKC with Ubuntu:

Compiling Java ACM 
javac -classpath .:acm.jar Interactors.java

Run:
java -classpath .:acm.jar Interactors
 */

public class Interactors extends ConsoleProgram {
	private JButton dontPush;
	private JButton pushMe;
	private JCheckBox isOn;
	private JRadioButton red;
	private JRadioButton blue;
	private JRadioButton green;
	private JComboBox<String> colorChooser;
	private JSlider size;
	private JTextField nameField;
	
	public void init() {
		/* So all y'argll can see! */
		setFont("CourierNew-BOLD-10");
		setSize(1500, 700);
		
		dontPush = new JButton("Do not push!");
		add(dontPush, SOUTH);
		pushMe = new JButton("Push me instead!");
		add(pushMe, SOUTH);
		
		isOn = new JCheckBox("Hoist the Jolly Roger");
		isOn.setSelected(true);
		add(isOn, SOUTH);
		
//		ButtonGroup colorGroup = new ButtonGroup();
//		red = new JRadioButton("RED");
//		blue = new JRadioButton("BLUE");
//		green = new JRadioButton("GREEN");
//		colorGroup.add(red);
//		colorGroup.add(blue);
//		colorGroup.add(green);
//		add(red, SOUTH);
//		add(blue, SOUTH);
//		add(green, SOUTH);
		colorChooser = new JComboBox<String>();
		colorChooser.addItem("Red");
		colorChooser.addItem("Blue");
		colorChooser.addItem("Green");
		colorChooser.addItem("Yellow");
		colorChooser.addItem("Black");
		colorChooser.addItem("Orange");
		colorChooser.setSelectedItem("Black");
		this.add(colorChooser, SOUTH);
	
		size = new JSlider(1, 25, 10);
		add(new JLabel("Itty"), SOUTH);
		add(size, SOUTH);
		add(new JLabel("HUGE"), SOUTH);
		addActionListeners();
		
		nameField = new JTextField(20);
		add(new JLabel("Name: "), SOUTH);
		add(nameField, SOUTH);
		nameField.addActionListener(this);
		
	}
	
	private Color getCurrentColor() {
		String curColor = (String)colorChooser.getSelectedItem();
		if(curColor.equals("Red")) return(Color.RED);
		if(curColor.equals("Blue")) return(Color.BLUE);
		if(curColor.equals("Black")) return(Color.BLACK);
		if(curColor.equals("Orange")) return(Color.ORANGE);
		if(curColor.equals("Green")) return(Color.GREEN);
		
		return(Color.BLACK);
	}
	
	public void actionPerformed(ActionEvent e) {
		String fontString = "CourierNew-BOLD-";
		fontString = fontString + size.getValue();
		setFont(fontString);
		
		getConsole().setForeground(getCurrentColor());
		
		
		
//		if(red.isSelected()) {
//			getConsole().setForeground(Color.red);
//		} else if(blue.isSelected()) {
//			getConsole().setForeground(Color.blue);
//		} else if(green.isSelected()) {
//			getConsole().setForeground(Color.green);
//		}
		
		if(e.getSource() == dontPush && isOn.isSelected()) {
			println(SKULL);
		} else if(e.getSource() == pushMe && isOn.isSelected()) {
			println(CHEST);
		} else if(e.getSource() == nameField && isOn.isSelected()) {
			println("Captain Tom says AHOY, " + nameField.getText());
		}
//		if(e.getActionCommand().equals("Do not push!")) {
//			println(SKULL);
//		} else if(e.getActionCommand().equals("Push me instead!")) {
//			println(CHEST);
//		}
	}
	
	
	
	
	
	
	
	
	
	
	private static String SKULL = "                 uuuuuuu\n             uu$$$$$$$$$$$uu\n          uu$$$$$$$$$$$$$$$$$uu\n         u$$$$$$$$$$$$$$$$$$$$$u\n        u$$$$$$$$$$$$$$$$$$$$$$$u\n       u$$$$$$$$$$$$$$$$$$$$$$$$$u\n       u$$$$$$$$$$$$$$$$$$$$$$$$$u\n       u$$$$$$\"   \"$$$\"   \"$$$$$$u\n       \"$$$$\"      u$u       $$$$\"\n        $$$u       u$u       u$$$\n        $$$u      u$$$u      u$$$\n         \"$$$$uu$$$   $$$uu$$$$\"\n          \"$$$$$$$\"   \"$$$$$$$\"\n            u$$$$$$$u$$$$$$$u\n             u$\"$\"$\"$\"$\"$\"$u\n  uuu        $$u$ $ $ $ $u$$       uuu\n u$$$$        $$$$$u$u$u$$$       u$$$$\n  $$$$$uu      \"$$$$$$$$$\"     uu$$$$$$\nu$$$$$$$$$$$uu    \"\"\"\"\"    uuuu$$$$$$$$$$\n$$$$\"\"\"$$$$$$$$$$uuu   uu$$$$$$$$$\"\"\"$$$\"\n \"\"\"      \"\"$$$$$$$$$$$uu \"\"$\"\"\"\n           uuuu \"\"$$$$$$$$$$uuu\n  u$$$uuu$$$$$$$$$uu \"\"$$$$$$$$$$$uuu$$$\n  $$$$$$$$$$\"\"\"\"           \"\"$$$$$$$$$$$\"\n   \"$$$$$\"                      \"\"$$$$\"\"\n     $$$\"                         $$$$\"\n";
	private static String CHEST = "                          _.=\"\"_;=.\n                       ,-\"_,=\"\"     `\"=.\n                       \"=._o`\"-._        `\"=.\n                           `\"=._o`\"=._      _`\"=._\n                               _:=._o \"=._.\"_.-=\"'\"=._\n                         __.--\" , ; `\"=._o.\" ,-\"\"\"-._ \".\n                      ._\"  ,. .` ` `` ,  `\"-._\"-._   \". '\n                      |o`\"=._` , \"` `; .\". ,  \"-._\"-._; ;\n                      | ;`-.o`\"=._; .\" ` '`.\"\\` . \"-._ /\n                      |o;    `\"-.o`\"=._``  '` \" ,__.--o;\n                      | ;     (#) `-.o `\"=.`_.--\"_o.-; ;\n                      |o;._    \"      `\".o|o_.--\"    ;o;\n                       \"=._o--._        ; | ;        ; ;/\n                            \"=._o--._   ;o|o;     _._;o;\n                                 \"=._o._; | ;_.--\"o.--\"\n                                      \"=.o|o_.--\"\n";
}
