import java.awt.Color;
import java.awt.Font;

import javax.swing.JApplet;

public class DigitalClock extends JApplet implements Runnable {
	private Thread clockThread = null;
	private Color color = Color.green;
	private ClockPanel clockPanel;

	public void init() {
		clockPanel = new ClockPanel();
		getContentPane().add(clockPanel);
		clockPanel.setBackground(Color.cyan);
		String param = getParameter("color");

		if ("red".equals(param))
			color = Color.red;
		else if ("blue".equals(param))
			color = Color.blue;
		else if ("yellow".equals(param))
			color = Color.yellow;
		else if ("orange".equals(param))
			color = Color.orange;
		else
			color = Color.green;
	}

	public void start() {
		if (clockThread == null) {
			clockThread = new Thread(this);
			clockThread.start();
		}
	}

	public void stop() {
		clockThread = null;
	}

	public void run() {
		while (Thread.currentThread() == clockThread) {
			clockPanel.repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
		}
	}
}
