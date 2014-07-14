package com.cabatuan.cpeprog;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * This program demonstrates how to install an action listener.
 */
public class ButtonViewer {
	private static final int FRAME_WIDTH = 120;
	private static final int FRAME_HEIGHT = 64;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JButton button = new JButton("Say Hello!");
		frame.add(button);

		ActionListener listener = new ClickListener();
		button.addActionListener(listener);

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
