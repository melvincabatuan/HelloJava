import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class Flower extends Applet {
	public static int Offset = 200;
	public static double scale = 200.0;
	public static double dTheta = 0.02;
	public static int n = 2;
	public static double TwoPI = 2 * Math.PI;
	
	

	public void paint(Graphics g) {
		int oldX = 2 * Offset, oldY = Offset;
		g.setColor(Color.RED);
		setBackground(Color.WHITE);

		for (double theta = dTheta; theta <= TwoPI; theta += dTheta) {
			double radius = Math.cos(n * theta);
			double a = scale * radius;
			double x = a * Math.cos(theta);
			double y = a * Math.sin(theta);
			int newX = Offset + (int) Math.round(x);
			int newY = Offset + (int) Math.round(y);
			g.drawLine(oldX, oldY, newX, newY);
			oldX = newX;
			oldY = newY;
		}

	}
}
