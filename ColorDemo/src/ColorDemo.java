/* A simple applet that sets the foreground and background colors and outputs a string. */

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/*
 <applet code="ColorDemo" width=320 height=64>
 </applet>
 */
public class ColorDemo extends Applet {
	String msg;

	public void init() {
		setBackground(Color.green);
		setForeground(Color.red);
		msg = "Inside init() method +";
	}

	// Initialize the string to be displayed.
	public void start() {
		msg += " Inside start() method +";
	}

	// Display msg in applet window.
	public void paint(Graphics g) {
		msg += " Inside paint( ) method.";
		g.drawString(msg, 10, 30);
	}
}
