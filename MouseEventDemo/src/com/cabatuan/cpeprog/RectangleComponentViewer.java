package com.cabatuan.cpeprog;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

/**
 * This program displays a RectangleComponent.
 */
public class RectangleComponentViewer {
	private static final int FRAME_WIDTH = 320;
	private static final int FRAME_HEIGHT = 480;

	public static void main(String[] args) {
		final RectangleComponent component = new RectangleComponent();

		// Add mouse press listener
		class MousePressListener implements MouseListener {
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				component.moveTo(x, y);
			}

			// Do-nothing methods
			public void mouseReleased(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}
		}

		MouseListener listener = new MousePressListener();
		component.addMouseListener(listener);

		JFrame frame = new JFrame();
		frame.add(component);

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}