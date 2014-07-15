import java.awt.*;
import java.util.Calendar;

import javax.swing.*;

class ClockPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Calendar calendar = Calendar.getInstance();
		// calendar is an instance of java.util.GregorianCalendar
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		g.setFont(new Font("Monospaced", Font.BOLD, 132));
		g.setColor(Color.green);
		setBackground(Color.BLACK);
		String time = hour + ":" + minute / 10 + minute % 10 + ":" + second
				/ 10 + second % 10;
		g.drawString(time, 15, 160);
		//showStatus(time);
	}
}
