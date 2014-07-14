package com.cabatuan.cpeprog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * An action listener that prints a message.
 */

public class ClickListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		System.out.println("Hello!");
	}

}
